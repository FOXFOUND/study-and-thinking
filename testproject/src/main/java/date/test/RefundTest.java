package date.test;

import com.alibaba.fastjson.JSON;

public class RefundTest {
    public static void main(String[] args) {
        String json = "{\n" +
                "\t\"arriveCityCode\": \"110100\",\n" +
                "\t\"arriveCityName\": \"北京市\",\n" +
                "\t\"arriveLat\": 40.058873,\n" +
                "\t\"arriveLng\": 116.422078,\n" +
                "\t\"arriveLocation\": \"天通苑老三区(东1门)\",\n" +
                "\t\"basicMileagePrice\": 4000,\n" +
                "\t\"bookTip\": 1000,\n" +
                "\t\"bookTipDetail\": \"{\\\"bookTipRemain\\\":0.0,\\\"hitchBookRule\\\":{\\\"baseMileagePrice\\\":{\\\"baseCharge\\\":10.0,\\\"baseMile\\\":10.0},\\\"confineOutPriceMileage\\\":{\\\"milePrice\\\":1.0,\\\"mileage\\\":1.0},\\\"maxPrice\\\":2000},\\\"mileageRemain\\\":0.0}\",\n" +
                "\t\"cancelType\": 0,\n" +
                "\t\"createTime\": 1582448315000,\n" +
                "\t\"delState\": 0,\n" +
                "\t\"discount\": 80.0,\n" +
                "\t\"driverFreeState\": 0,\n" +
                "\t\"driverId\": 1465393637,\n" +
                "\t\"driverIncome\": 0,\n" +
                "\t\"driverIncomeEstimate\": 4000,\n" +
                "\t\"driverJourneyNo\": \"PX20200200100502\",\n" +
                "\t\"driverMobile\": \"15600000000\",\n" +
                "\t\"driverName\": \"呵呵\",\n" +
                "\t\"earliestStartTime\": 1582452000000,\n" +
                "\t\"finishOrderNum\": 3,\n" +
                "\t\"goOnCityCode\": \"110100\",\n" +
                "\t\"goOnCityName\": \"北京市\",\n" +
                "\t\"goOnLat\": 40.052758,\n" +
                "\t\"goOnLng\": 116.412368,\n" +
                "\t\"goOnLocation\": \"立水桥地铁站B2东南口\",\n" +
                "\t\"id\": 882,\n" +
                "\t\"isShareSeat\": 0,\n" +
                "\t\"journeyNumber\": \"PD20200200000976\",\n" +
                "\t\"journeyType\": 1,\n" +
                "\t\"latestStartTime\": 1582452000000,\n" +
                "\t\"mileageEstimate\": 3096,\n" +
                "\t\"mileagePrice\": 0,\n" +
                "\t\"mileagePriceDetail\": \"{\\\"baseMileCharge\\\":{\\\"baseCharge\\\":40.0,\\\"baseMile\\\":10.0}}\",\n" +
                "\t\"orderId\": \"20200200000511\",\n" +
                "\t\"orderState\": 2,\n" +
                "\t\"payEstimate\": 5000,\n" +
                "\t\"payNumber\": \"HP202002000250\",\n" +
                "\t\"payState\": 1,\n" +
                "\t\"payTime\": 1582448527000,\n" +
                "\t\"payType\": 1,\n" +
                "\t\"publishCityCode\": \"110100\",\n" +
                "\t\"publishCityName\": \"北京市\",\n" +
                "\t\"publishSource\": 1,\n" +
                "\t\"refoundAmountEstimate\": 1000,\n" +
                "\t\"refoundState\": 0,\n" +
                "\t\"remark\": \"\",\n" +
                "\t\"renterFullName\": \"\",\n" +
                "\t\"renterHead\": \"\",\n" +
                "\t\"renterId\": 1465393657,\n" +
                "\t\"renterMobile\": \"18800000000\",\n" +
                "\t\"renterNum\": 1,\n" +
                "\t\"renterRealPay\": 5000,\n" +
                "\t\"routeMatchGrade\": 100.0,\n" +
                "\t\"shareResult\": 0,\n" +
                "\t\"state\": 2,\n" +
                "\t\"takeOrderTime\": 1582448327000,\n" +
                "\t\"totalMileagePrice\": 4000,\n" +
                "\t\"updateTime\": 1582448527000,\n" +
                "\t\"vehicleBrand\": \"起亚\",\n" +
                "\t\"vehicleColor\": \"黑\",\n" +
                "\t\"vehiclePalte\": \"鲁13346885\",\n" +
                "\t\"vehicleSeries\": \"E30\"\n" +
                "}";
        HitchRenterJourney hitchRenterJourney = JSON.parseObject(json, HitchRenterJourney.class);
        System.out.println(JSON.toJSONString(hitchRenterJourney));
        if (hitchRenterJourney.getState().equals(HitchCommonConst.RenterJourneyState.STATE_GOING) &&
                (hitchRenterJourney.getOrderState().equals(HitchCommonConst.OrderState.TO_BE_START_OFF)
                        || hitchRenterJourney.getOrderState().equals(HitchCommonConst.OrderState.HAS_SET_OFF))) {
            System.out.println("ok");
        }else {
            System.out.println("fail");
        }
    }
}
