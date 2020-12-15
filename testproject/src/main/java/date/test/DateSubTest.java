package date.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

public class DateSubTest {
    public static void main(String[] args) {
        DateTime minTableSuffixDateTime = cn.hutool.core.date.DateUtil.parse("202012", "yyyyMM");
        DateTime maxTableSuffixDateTime = cn.hutool.core.date.DateUtil.parse("202010", "yyyyMM");
        //long plus = DateUtil.betweenMonth(minTableSuffixDateTime, maxTableSuffixDateTime, true);
        long plusTry = DateUtil.betweenMonth(maxTableSuffixDateTime,minTableSuffixDateTime, false);
       // System.out.println(plus);
        System.out.println(plusTry);
        System.out.println("ok");
    }
}
