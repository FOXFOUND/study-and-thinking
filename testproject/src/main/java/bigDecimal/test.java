package bigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class test {
    public static void main(String[] args) {
        DecimalFormat df=new DecimalFormat("0.00");
        BigDecimal bigDecimalMinute = new BigDecimal(100);
        int value = 1000;
        //BigDecimal bigDecimalPriceVip = new BigDecimal(value).divide(bigDecimalMinute).setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal bigDecimalPriceVip = new BigDecimal(value);
        bigDecimalPriceVip =  bigDecimalPriceVip.divide(bigDecimalMinute,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimalPriceVip.doubleValue());
        System.out.println(df.format(bigDecimalPriceVip.doubleValue()));

//        BigDecimal bigDecimalPriceVip1 = new BigDecimal(bigDecimalPriceVip.doubleValue()).setScale(2, BigDecimal.ROUND_DOWN);
//        System.out.println(bigDecimalPriceVip1.doubleValue());

        BigDecimal a;
        BigDecimal b;
        a = new BigDecimal(3);
        b = new BigDecimal(81);
        System.out.print(a.divide(b, 2, RoundingMode.HALF_UP));
    }
}
