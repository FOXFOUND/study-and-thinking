package com.searchone.searcheye.service;

import com.searchone.searcheye.model.RequestObject;
import com.searchone.searcheye.model.ResponseObject;
import com.searchone.searcheye.util.HttpProxyUtil;
import com.searchone.searcheye.vo.ResultVO;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SearchServiceImpl implements SearchService {
    private static final String patternStr = "data-tools='\\{\"title\":\"(?<title>.*?)\",\"url\":\"(?<url>.*?)\"";
    private static final Set<String> valuableSet = new HashSet<>();

    static {
        valuableSet.add("n");
        valuableSet.add("r");
        valuableSet.add("en");
    }

    @Override
    public ResponseObject getResponseObject(RequestObject requestObject) {
        ResponseObject responseObject = new ResponseObject();
        initKeyWordsSet(requestObject);
        initSearchKeyWordsSet(requestObject);
        initBaiDuRequestList(requestObject);
        initResponseList(requestObject, responseObject);
        return responseObject;
    }

    private void initResponseList(RequestObject requestObject, ResponseObject responseObject) {
        List<String> requestUrlList = requestObject.getRequestUrlList();
        if (requestUrlList == null) {
            return;
        }
        CopyOnWriteArrayList<ResultVO> copyOnWriteArrayList = new CopyOnWriteArrayList();
        requestUrlList.parallelStream().forEach(requestUrl -> {
            byte[] bytes = HttpProxyUtil.get(requestUrl);
            if (bytes != null && bytes.length != 0) {
                String result = new String(bytes);
                ResultVO resultVO = new ResultVO();
                Pattern pattern = Pattern.compile(patternStr);
                Matcher matcher = pattern.matcher(result);
                if (matcher != null && matcher.find()) {
                    resultVO.setTitle(matcher.group("title"));
                    resultVO.setUrl(matcher.group("url"));
                    copyOnWriteArrayList.add(resultVO);
                }
                // System.out.println("result\t" + result);
            }
        });
        responseObject.setResultArrayList(copyOnWriteArrayList);
    }

    private void initBaiDuRequestList(RequestObject requestObject) {
        String baiDuUrl = "http://www.baidu.com/s?wd=";
        List<String> requestUrlList = new ArrayList();
        if (requestObject.getSearchKeyWordsSet() == null) {
            return;
        }
        Iterator<String> iterable = requestObject.getSearchKeyWordsSet().iterator();
        while (iterable.hasNext()) {
            String str = iterable.next();
            String searchUrl = baiDuUrl + str;
            requestUrlList.add(searchUrl);
            //System.out.println("searchUrl\t" + searchUrl);
        }
        requestObject.setRequestUrlList(requestUrlList);
    }

    private void initSearchKeyWordsSet(RequestObject requestObject) {
        ArrayList<String> arrayList = new ArrayList<>(requestObject.getKetWordsSet());
        ArrayList<ArrayList<String>> keyWordsSubList = getSubset(arrayList);
        if (keyWordsSubList == null) {
            return;
        }
        Set searchWordsSet = new HashSet();
        Map existKeyWordsMap = new HashMap();
        keyWordsSubList.parallelStream().forEach(eachKeyWordsSubList -> {
            StringBuilder stringBuilder = new StringBuilder();
            eachKeyWordsSubList.sort(String::compareToIgnoreCase);
            for (int i = 0; i < eachKeyWordsSubList.size(); i++) {
                stringBuilder.append(eachKeyWordsSubList.get(i));
            }
            String keyWords = stringBuilder.toString();
            if (existKeyWordsMap.get(keyWords) == null && !StringUtils.isEmpty(keyWords)) {
                searchWordsSet.add(keyWords);
                existKeyWordsMap.put(keyWords, "");
            }
        });
        requestObject.setSearchKeyWordsSet(searchWordsSet);
    }

    private void initKeyWordsSet(RequestObject requestObject) {
        Result result = BaseAnalysis.parse(requestObject.getText());
        Set keyWordsSet = new HashSet<>();
        for (Term term : result.getTerms()) {
            if (valuableSet.contains(term.getNatureStr())) {
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
