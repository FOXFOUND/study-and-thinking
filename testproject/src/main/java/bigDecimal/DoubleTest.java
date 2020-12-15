package bigDecimal;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
public class DoubleTest {
    public static void main(String[] args) {
        //double value = 105.667;  //105.67
        double value = 105.664;     //105.66

        BigDecimal bigDecimalPriceVip = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimalPriceVip.doubleValue());
    }
}
