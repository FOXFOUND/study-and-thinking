package com.searchone.searcheye.service;

import com.searchone.searcheye.model.RequestObject;
import com.searchone.searcheye.model.ResponseObject;
import com.searchone.searcheye.util.HttpProxyUtil;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public ResponseObject getResponseObject(RequestObject requestObject) {
        ResponseObject responseObject = new ResponseObject();
        initKeyWordsSet(requestObject);
        initSearchKeyWordsSet(requestObject);
        initBaiduRequestList(requestObject);
        initResPonseObject(requestObject, responseObject);
        return responseObject;
    }

    private void initResPonseObject(RequestObject requestObject, ResponseObject responseObject) {
        List<String> requestUrlList = requestObject.getRequestUrlList();
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        requestUrlList.parallelStream().forEach(requestUrl -> {
            byte[] bytes = HttpProxyUtil.get(requestUrl);
            if (bytes != null && bytes.length != 0) {
                String result = new String(bytes);
                System.out.println("result\t" + result);
                copyOnWriteArrayList.add(result);
            }
        });
        responseObject.setResultArrayList(copyOnWriteArrayList);
    }

    private void initBaiduRequestList(RequestObject requestObject) {
        String baiduUrl = "http://www.baidu.com/s?wd=";
        List<String> requestUrlList = new ArrayList();
        Iterator<String> iterable = requestObject.getSearchKeyWordsSet().iterator();
        while (iterable.hasNext()) {
            String str = iterable.next();
            String searchUrl = baiduUrl + str;
            requestUrlList.add(searchUrl);
            //System.out.println("searchUrl\t" + searchUrl);

        }
        requestObject.setRequestUrlList(requestUrlList);
    }

    private void initSearchKeyWordsSet(RequestObject requestObject) {
        ArrayList<String> arrayList = new ArrayList<>(requestObject.getKetWordsSet());
        ArrayList<ArrayList<String>> keyWordsSubList = getSubset(arrayList);
        Set searchWordsSet = new HashSet();
        keyWordsSubList.parallelStream().forEach(eachkeyWordsSubList -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < eachkeyWordsSubList.size(); i++) {
                stringBuilder.append(eachkeyWordsSubList.get(i));
            }
            searchWordsSet.add(stringBuilder.toString());
        });
        requestObject.setSearchKeyWordsSet(searchWordsSet);
    }

    private void initKeyWordsSet(RequestObject requestObject) {
        Result result = BaseAnalysis.parse(requestObject.getText());
        Set keyWordsSet = new HashSet<>();
        for (Term term : result.getTerms()) {
            if (term.getNatureStr().equals("n") || term.getNatureStr().equals("r")) {
                if (term.getName().length() >= 2 && term.getName().length() <= 5) {

                    keyWordsSet.add(term.getName());
                }
            }
        }
        requestObject.setKetWordsSet(keyWordsSet);
    }

    private ArrayList<ArrayList<String>> getSubset(ArrayList L) {
        if (L.size() > 0) {
            ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
            for (int i = 0; i < Math.pow(2, L.size()); i++) {// 集合子集个数=2的该集合长度的乘方
                ArrayList<String> subSet = new ArrayList<String>();
                int index = i;// 索引从0一直到2的集合长度的乘方-1
                for (int j = 0; j < L.size(); j++) {
                    // 通过逐一位移，判断索引那一位是1，如果是，再添加此项
                    if ((index & 1) == 1) {// 位与运算，判断最后一位是否为1
                        subSet.add(String.valueOf(L.get(j)));
                    }
                    index >>= 1;// 索引右移一位
                }
                result.add(subSet); // 把子集存储起来
            }
            return result;
        } else {
            return null;
        }

    }
}
