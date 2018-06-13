package com.CaseFormatTest;

import com.google.common.base.CaseFormat;

public class GuavaTester {
   public static void main(String args[]){
      GuavaTester tester = new GuavaTester();
      tester.testCaseFormat();
   }

   private void testCaseFormat(){
      String data = "test__DAta";
      System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
      System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
      System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
   }
}