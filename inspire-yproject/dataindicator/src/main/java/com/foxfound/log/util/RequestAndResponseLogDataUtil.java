package com.foxfound.log.util;

import com.foxfound.log.constant.RecordRequestAndResponseMap;
import com.foxfound.log.constant.SqlConstant;
import com.foxfound.log.vo.SecHandInfoDataVO;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public class RequestAndResponseLogDataUtil {
    public static List<String> getSecHandInfoDetailByRequestAndResponse(List<SecHandInfoDataVO> secHandInfoDataLogVOList) {
        Map<Long, SecHandInfoDataVO> requestAndResponseLogMap = new HashMap<>();
        //1.通过 old_record 日志 map 初始化
        initMap(requestAndResponseLogMap);
        //2.读取 mysql 设置detail 和评论数量
        List<SecHandInfoDataVO> secHandInfoDataVOList = getSecHandInfoDataVOFromDB();
        //3.将两组数据融合
        combineLogDataAndSqlData(requestAndResponseLogMap, secHandInfoDataVOList);
        combineLogDataAndSqlData(requestAndResponseLogMap, secHandInfoDataLogVOList);
        //4.以 mysql 的数据为准筛选数据
        List<SecHandInfoDataVO> resultSecHandInfoDataVOList = filterDataByMap(requestAndResponseLogMap);
        //5.解析 list 生成表格数据
        List<String> resultRowList = getRowData(resultSecHandInfoDataVOList);
        return resultRowList;
    }

    private static List<String> getRowData(List<SecHandInfoDataVO> resultSecHandInfoDataVOList) {
        List<String> resultRowList = new ArrayList<>();
        resultSecHandInfoDataVOList.forEach(secHandInfoDataVO -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<tr><td class=\"confluenceTd\">");
            stringBuilder.append(secHandInfoDataVO.getSecHandInfoId());
            stringBuilder.append("</td><td class=\"confluenceTd\">");
            stringBuilder.append(secHandInfoDataVO.getDetail());
            stringBuilder.append("</td><td class=\"confluenceTd\">");
            stringBuilder.append(secHandInfoDataVO.getVisitedCount());
            stringBuilder.append("</td><td class=\"confluenceTd\">");
            stringBuilder.append(secHandInfoDataVO.getCommentCount());
            stringBuilder.append("</td></tr>");
            resultRowList.add(stringBuilder.toString());
        });
        return resultRowList;
    }

    private static List<SecHandInfoDataVO> filterDataByMap(Map<Long, SecHandInfoDataVO> requestAndResponseLogMap) {
        List<SecHandInfoDataVO> resultSecHandInfoDataVOList = new ArrayList<>();
        requestAndResponseLogMap.forEach((key, value) -> {
            if (StringUtils.isNotBlank(value.getDetail())) {
                resultSecHandInfoDataVOList.add(value);
            }
        });
        return resultSecHandInfoDataVOList;
    }

    private static void combineLogDataAndSqlData(Map<Long, SecHandInfoDataVO> requestAndResponseLogMap, List<SecHandInfoDataVO> secHandInfoDataVOList) {
        secHandInfoDataVOList.stream().forEach(secHandInfoDataVO -> {
            Long key = secHandInfoDataVO.getSecHandInfoId();
            SecHandInfoDataVO secHandInfoData = requestAndResponseLogMap.get(key);
            if (secHandInfoData == null) {
                requestAndResponseLogMap.put(key, secHandInfoDataVO);
            } else {
                //引用类型,不需要再次 put
                if (secHandInfoData.getCommentCount() == 0) {
                    secHandInfoData.setCommentCount(secHandInfoDataVO.getCommentCount());

                }
                if (StringUtils.isBlank(secHandInfoData.getDetail())) {
                    secHandInfoData.setDetail(secHandInfoDataVO.getDetail());
                }
                if (secHandInfoData.getVisitedCount() == 0) {
                    secHandInfoData.setVisitedCount(secHandInfoDataVO.getVisitedCount());
                }
            }
        });
    }

    private static void initMap(Map<Long, SecHandInfoDataVO> requestAndResponseLogMap) {
        Map<Long, Long> oldRequestAndResponseMap = RecordRequestAndResponseMap.recordRequestAndResponseMap;
        oldRequestAndResponseMap.forEach((key, value) -> {
            if (value == null) {
                SecHandInfoDataVO secHandInfoDataVO = new SecHandInfoDataVO();
                secHandInfoDataVO.setVisitedCount(oldRequestAndResponseMap.get(key));
                secHandInfoDataVO.setSecHandInfoId(key);
                requestAndResponseLogMap.put(key, secHandInfoDataVO);
            }
        });
    }

    public static List<SecHandInfoDataVO> getSecHandInfoDataVOFromDB() {
        List<SecHandInfoDataVO> secHandInfoDataVOList = new ArrayList<>();
        String sql = SqlConstant.selectSecHandInfoDetailAndCommentCount;
        ResultSet resultSet = DBUtil.executeQuery(sql);
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }

            } catch (SQLException e) {
            }
            Long secHandInfoId = null;
            String detail = null;
            Long commentCount = null;
            try {
                secHandInfoId = resultSet.getLong(1);
                detail = resultSet.getString(2);
                commentCount = resultSet.getLong(3);
            } catch (Exception e) {
            }
            SecHandInfoDataVO secHandInfoDataVO = new SecHandInfoDataVO();
            secHandInfoDataVO.setDetail(detail);
            secHandInfoDataVO.setCommentCount(commentCount);
            secHandInfoDataVO.setSecHandInfoId(secHandInfoId);
            secHandInfoDataVOList.add(secHandInfoDataVO);
        }
        return secHandInfoDataVOList;
    }
}
