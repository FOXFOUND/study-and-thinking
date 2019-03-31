package com.foxfound.log.sechanddetail;

import com.foxfound.log.vo.UserVO;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public class UserIdAppendTest {
    public static void main(String[] args) {
//        Map<Long, Long> longMap = new HashMap<>();
//        longMap.put(1L, 2L);
//        longMap.put(2L, 3L);
//        longMap.forEach((key, value) -> {
//        });
        UserVO userVO = new UserVO();
        Map<Long, UserVO> userVOMap = new HashMap<>();
        userVOMap.put(1L, userVO);
        userVO.setNickName("1111");

    }
}
