package com.searchone.searcheye;

import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchEyeApplicationTests {

    @Test
    public void contextLoads() {
        Result result = BaseAnalysis.parse("what is you name ");
        System.out.println(result);
    }




}
