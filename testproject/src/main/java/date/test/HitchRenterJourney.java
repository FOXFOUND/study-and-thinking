package date.test;

import java.io.Serializable;
import java.util.Date;

public class HitchRenterJourney implements Serializable {
    /**
    * id
    */
    private Integer id;

    /**
    * 行程编号
    */
    private String journeyNumber;

    /**
    * 1.市内  2城际
    */
    private Integer journeyType;

    /**
    * 发布区域编码
    */
    private String publishCityCode;

    /**
    * 发布区域名称
    */
    private String publishCityName;

    /**
    * 发布来源  1.东风出行APP
    */
    private Integer publishSource;

    private String startPlace;

    private String endPlace;

    /**
    * 用户出行次数
    */
    private Integer finishOrderNum;

    /**
    * 乘客id
    */
    private Integer renterId;

    /**
    * 乘客姓名
    */
    private String renterFullName;

    /**
    * 乘客手机
    */
    private String renterMobile;

    /**
    * 乘客头像
    */
    private String renterHead;

    /**
    * 接单时间
    */
    private Date takeOrderTime;

    /**
    * 是否接受拼座：0、不接受 1、接受
    */
    private Integer isShareSeat;

    /**
    * 顺路度
    */
    private Double routeMatchGrade;

    /**
    * 状态 1. 已发布   2. 行程中   3.结束，4 已取消
    */
    private Integer state;

    /**
    * 订单流转状态：0-已下单，车主未接单、1-待乘客支付确认，车主已接单、2-待出发接乘客，乘客已支付、3-车主待到达约定地点，乘客待上车、4-车主待乘客上车，乘客待确认上车、5-行程中、6-车主到达目的地，乘客待确认到达、7-乘客确认到达，订单结束
    */
    private Integer orderState;

    /**
    * 预约最早出发时间
    */
    private Date earliestStartTime;

    /**
    * 预约最晚出发时间
    */
    private Date latestStartTime;

    /**
    * 预约出发位置纬度
    */
    private Double goOnLat;

    /**
    * 预约出发位置经度
    */
    private Double goOnLng;

    /**
    * 预约出发位置信息
    */
    private String goOnLocation;

    /**
    * 预约城市编码
    */
    private String goOnCityCode;

    /**
    * 预约城市名称
    */
    private String goOnCityName;

    /**
    * 预约目的地位置经度
    */
    private Double arriveLng;

    /**
    * 预约目的地位置纬度
    */
    private Double arriveLat;

    /**
    * 预约目的地位置信息
    */
    private String arriveLocation;

    /**
    * 预约目的地城市编码
    */
    private String arriveCityCode;

    /**
    * 预约目的地城市名称
    */
    private String arriveCityName;

    /**
    * 预估里程
    */
    private Integer mileageEstimate;

    /**
    * 预支付费用。单位：分
    */
    private Integer payEstimate;

    /**
    * 乘客实际支付费用。单位：分
    */
    private Integer renterRealPay;

    /**
    * 司机预计应收入金额。单位：分
    */
    private Integer driverIncomeEstimate;

    /**
    * 预计返还金额。单位：分
    */
    private Integer refoundAmountEstimate;

    /**
    * 0 未退款 ,1 已退款
    */
    private Integer refoundState;

    /**
    * 拼成折扣
    */
    private Double discount;

    /**
    * 基础里程费。单位：分
    */
    private Integer basicMileagePrice;

    /**
    * 里程费。单位：分
    */
    private Integer mileagePrice;

    /**
    * 总里程费。单位：分
    */
    private Integer totalMileagePrice;

    /**
    * 里程费用明细
    */
    private String mileagePriceDetail;

    /**
    * 服务费。单位：分
    */
    private Integer bookTip;

    /**
    * 服务费明细
    */
    private String bookTipDetail;

    /**
    * 坐车人数
    */
    private Integer renterNum;

    /**
    * 订单取消 1.用户取消 2.车主取消 3.系统取消
    */
    private Integer cancelType;

    /**
    * 取消时间
    */
    private Date cancelTime;

    /**
    * 备注
    */
    private String remark;

    /**
    * 创建行程时间
    */
    private Date createTime;

    /**
    * 车主行程编号
    */
    private String driverJourneyNo;

    /**
    * 车主id
    */
    private Integer driverId;

    /**
    * 订单编号
    */
    private String orderId;

    /**
    * 车主本单收入
    */
    private Integer driverIncome;

    /**
    * 顺风车车主姓名
    */
    private String driverName;

    /**
    * 顺风车车主手机号
    */
    private String driverMobile;

    /**
    * 车牌号
    */
    private String vehiclePalte;

    /**
    * 车辆品牌
    */
    private String vehicleBrand;

    /**
    * 车辆型号
    */
    private String vehicleSeries;

    /**
    * 车辆颜色
    */
    private String vehicleColor;

    /**
    * 支付时间
    */
    private Date payTime;

    /**
    * 支付方式 1、微信 2、支付宝 3、余额
    */
    private Integer payType;

    /**
    * 交易流水号
    */
    private String payNumber;

    /**
    * 支付状态 0、未支付 1、已支付
    */
    private Integer payState;

    /**
    * 拼单结果：0-未拼成，1-拼成
    */
    private Integer shareResult;

    /**
    * 乘客实际上车地点经度
    */
    private Double realStartLng;

    /**
    * 乘客实际上车地点纬度
    */
    private Double realStartLat;

    /**
    * 乘客实际上车地点位置信息
    */
    private String realStartLocation;

    /**
    * 乘客实际上车时间
    */
    private Date realStartTime;

    /**
    * 乘客实际下车地点经度
    */
    private Double realEndLng;

    /**
    * 乘客实际下车地点纬度
    */
    private Double realEndLat;

    /**
    * 乘客实际下车地点位置信息
    */
    private String realEndLocation;

    /**
    * 乘客实际下车时间
    */
    private Date realEndTime;

    /**
    * 车主免单：0-不免单，1-免单（免里程费）
    */
    private Integer driverFreeState;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 备用1
    */
    private String field1;

    /**
    * 备用2
    */
    private String fieid2;

    /**
    * 备用3
    */
    private String field3;

    /**
    * 备用4
    */
    private String field4;

    /**
    * 备用5
    */
    private String field5;

    /**
    * 删除状态 0 正常 1删除
    */
    private Integer delState;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJourneyNumber() {
        return journeyNumber;
    }

    public void setJourneyNumber(String journeyNumber) {
        this.journeyNumber = journeyNumber;
    }

    public Integer getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(Integer journeyType) {
        this.journeyType = journeyType;
    }

    public String getPublishCityCode() {
        return publishCityCode;
    }

    public void setPublishCityCode(String publishCityCode) {
        this.publishCityCode = publishCityCode;
    }

    public String getPublishCityName() {
        return publishCityName;
    }

    public void setPublishCityName(String publishCityName) {
        this.publishCityName = publishCityName;
    }

    public Integer getPublishSource() {
        return publishSource;
    }

    public void setPublishSource(Integer publishSource) {
        this.publishSource = publishSource;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public Integer getFinishOrderNum() {
        return finishOrderNum;
    }

    public void setFinishOrderNum(Integer finishOrderNum) {
        this.finishOrderNum = finishOrderNum;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public String getRenterFullName() {
        return renterFullName;
    }

    public void setRenterFullName(String renterFullName) {
        this.renterFullName = renterFullName;
    }

    public String getRenterMobile() {
        return renterMobile;
    }

    public void setRenterMobile(String renterMobile) {
        this.renterMobile = renterMobile;
    }

    public String getRenterHead() {
        return renterHead;
    }

    public void setRenterHead(String renterHead) {
        this.renterHead = renterHead;
    }

    public Date getTakeOrderTime() {
        return takeOrderTime;
    }

    public void setTakeOrderTime(Date takeOrderTime) {
        this.takeOrderTime = takeOrderTime;
    }

    public Integer getIsShareSeat() {
        return isShareSeat;
    }

    public void setIsShareSeat(Integer isShareSeat) {
        this.isShareSeat = isShareSeat;
    }

    public Double getRouteMatchGrade() {
        return routeMatchGrade;
    }

    public void setRouteMatchGrade(Double routeMatchGrade) {
        this.routeMatchGrade = routeMatchGrade;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getEarliestStartTime() {
        return earliestStartTime;
    }

    public void setEarliestStartTime(Date earliestStartTime) {
        this.earliestStartTime = earliestStartTime;
    }

    public Date getLatestStartTime() {
        return latestStartTime;
    }

    public void setLatestStartTime(Date latestStartTime) {
        this.latestStartTime = latestStartTime;
    }

    public Double getGoOnLat() {
        return goOnLat;
    }

    public void setGoOnLat(Double goOnLat) {
        this.goOnLat = goOnLat;
    }

    public Double getGoOnLng() {
        return goOnLng;
    }

    public void setGoOnLng(Double goOnLng) {
        this.goOnLng = goOnLng;
    }

    public String getGoOnLocation() {
        return goOnLocation;
    }

    public void setGoOnLocation(String goOnLocation) {
        this.goOnLocation = goOnLocation;
    }

    public String getGoOnCityCode() {
        return goOnCityCode;
    }

    public void setGoOnCityCode(String goOnCityCode) {
        this.goOnCityCode = goOnCityCode;
    }

    public String getGoOnCityName() {
        return goOnCityName;
    }

    public void setGoOnCityName(String goOnCityName) {
        this.goOnCityName = goOnCityName;
    }

    public Double getArriveLng() {
        return arriveLng;
    }

    public void setArriveLng(Double arriveLng) {
        this.arriveLng = arriveLng;
    }

    public Double getArriveLat() {
        return arriveLat;
    }

    public void setArriveLat(Double arriveLat) {
        this.arriveLat = arriveLat;
    }

    public String getArriveLocation() {
        return arriveLocation;
    }

    public void setArriveLocation(String arriveLocation) {
        this.arriveLocation = arriveLocation;
    }

    public String getArriveCityCode() {
        return arriveCityCode;
    }

    public void setArriveCityCode(String arriveCityCode) {
        this.arriveCityCode = arriveCityCode;
    }

    public String getArriveCityName() {
        return arriveCityName;
    }

    public void setArriveCityName(String arriveCityName) {
        this.arriveCityName = arriveCityName;
    }

    public Integer getMileageEstimate() {
        return mileageEstimate;
    }

    public void setMileageEstimate(Integer mileageEstimate) {
        this.mileageEstimate = mileageEstimate;
    }

    public Integer getPayEstimate() {
        return payEstimate;
    }

    public void setPayEstimate(Integer payEstimate) {
        this.payEstimate = payEstimate;
    }

    public Integer getRenterRealPay() {
        return renterRealPay;
    }

    public void setRenterRealPay(Integer renterRealPay) {
        this.renterRealPay = renterRealPay;
    }

    public Integer getDriverIncomeEstimate() {
        return driverIncomeEstimate;
    }

    public void setDriverIncomeEstimate(Integer driverIncomeEstimate) {
        this.driverIncomeEstimate = driverIncomeEstimate;
    }

    public Integer getRefoundAmountEstimate() {
        return refoundAmountEstimate;
    }

    public void setRefoundAmountEstimate(Integer refoundAmountEstimate) {
        this.refoundAmountEstimate = refoundAmountEstimate;
    }

    public Integer getRefoundState() {
        return refoundState;
    }

    public void setRefoundState(Integer refoundState) {
        this.refoundState = refoundState;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getBasicMileagePrice() {
        return basicMileagePrice;
    }

    public void setBasicMileagePrice(Integer basicMileagePrice) {
        this.basicMileagePrice = basicMileagePrice;
    }

    public Integer getMileagePrice() {
        return mileagePrice;
    }

    public void setMileagePrice(Integer mileagePrice) {
        this.mileagePrice = mileagePrice;
    }

    public Integer getTotalMileagePrice() {
        return totalMileagePrice;
    }

    public void setTotalMileagePrice(Integer totalMileagePrice) {
        this.totalMileagePrice = totalMileagePrice;
    }

    public String getMileagePriceDetail() {
        return mileagePriceDetail;
    }

    public void setMileagePriceDetail(String mileagePriceDetail) {
        this.mileagePriceDetail = mileagePriceDetail;
    }

    public Integer getBookTip() {
        return bookTip;
    }

    public void setBookTip(Integer bookTip) {
        this.bookTip = bookTip;
    }

    public String getBookTipDetail() {
        return bookTipDetail;
    }

    public void setBookTipDetail(String bookTipDetail) {
        this.bookTipDetail = bookTipDetail;
    }

    public Integer getRenterNum() {
        return renterNum;
    }

    public void setRenterNum(Integer renterNum) {
        this.renterNum = renterNum;
    }

    public Integer getCancelType() {
        return cancelType;
    }

    public void setCancelType(Integer cancelType) {
        this.cancelType = cancelType;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDriverJourneyNo() {
        return driverJourneyNo;
    }

    public void setDriverJourneyNo(String driverJourneyNo) {
        this.driverJourneyNo = driverJourneyNo;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getDriverIncome() {
        return driverIncome;
    }

    public void setDriverIncome(Integer driverIncome) {
        this.driverIncome = driverIncome;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }

    public String getVehiclePalte() {
        return vehiclePalte;
    }

    public void setVehiclePalte(String vehiclePalte) {
        this.vehiclePalte = vehiclePalte;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleSeries() {
        return vehicleSeries;
    }

    public void setVehicleSeries(String vehicleSeries) {
        this.vehicleSeries = vehicleSeries;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(String payNumber) {
        this.payNumber = payNumber;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getShareResult() {
        return shareResult;
    }

    public void setShareResult(Integer shareResult) {
        this.shareResult = shareResult;
    }

    public Double getRealStartLng() {
        return realStartLng;
    }

    public void setRealStartLng(Double realStartLng) {
        this.realStartLng = realStartLng;
    }

    public Double getRealStartLat() {
        return realStartLat;
    }

    public void setRealStartLat(Double realStartLat) {
        this.realStartLat = realStartLat;
    }

    public String getRealStartLocation() {
        return realStartLocation;
    }

    public void setRealStartLocation(String realStartLocation) {
        this.realStartLocation = realStartLocation;
    }

    public Date getRealStartTime() {
        return realStartTime;
    }

    public void setRealStartTime(Date realStartTime) {
        this.realStartTime = realStartTime;
    }

    public Double getRealEndLng() {
        return realEndLng;
    }

    public void setRealEndLng(Double realEndLng) {
        this.realEndLng = realEndLng;
    }

    public Double getRealEndLat() {
        return realEndLat;
    }

    public void setRealEndLat(Double realEndLat) {
        this.realEndLat = realEndLat;
    }

    public String getRealEndLocation() {
        return realEndLocation;
    }

    public void setRealEndLocation(String realEndLocation) {
        this.realEndLocation = realEndLocation;
    }

    public Date getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    public Integer getDriverFreeState() {
        return driverFreeState;
    }

    public void setDriverFreeState(Integer driverFreeState) {
        this.driverFreeState = driverFreeState;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getFieid2() {
        return fieid2;
    }

    public void setFieid2(String fieid2) {
        this.fieid2 = fieid2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public Integer getDelState() {
        return delState;
    }

    public void setDelState(Integer delState) {
        this.delState = delState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", journeyNumber=").append(journeyNumber);
        sb.append(", journeyType=").append(journeyType);
        sb.append(", publishCityCode=").append(publishCityCode);
        sb.append(", publishCityName=").append(publishCityName);
        sb.append(", publishSource=").append(publishSource);
        sb.append(", startPlace=").append(startPlace);
        sb.append(", endPlace=").append(endPlace);
        sb.append(", finishOrderNum=").append(finishOrderNum);
        sb.append(", renterId=").append(renterId);
        sb.append(", renterFullName=").append(renterFullName);
        sb.append(", renterMobile=").append(renterMobile);
        sb.append(", renterHead=").append(renterHead);
        sb.append(", takeOrderTime=").append(takeOrderTime);
        sb.append(", isShareSeat=").append(isShareSeat);
        sb.append(", routeMatchGrade=").append(routeMatchGrade);
        sb.append(", state=").append(state);
        sb.append(", orderState=").append(orderState);
        sb.append(", earliestStartTime=").append(earliestStartTime);
        sb.append(", latestStartTime=").append(latestStartTime);
        sb.append(", goOnLat=").append(goOnLat);
        sb.append(", goOnLng=").append(goOnLng);
        sb.append(", goOnLocation=").append(goOnLocation);
        sb.append(", goOnCityCode=").append(goOnCityCode);
        sb.append(", goOnCityName=").append(goOnCityName);
        sb.append(", arriveLng=").append(arriveLng);
        sb.append(", arriveLat=").append(arriveLat);
        sb.append(", arriveLocation=").append(arriveLocation);
        sb.append(", arriveCityCode=").append(arriveCityCode);
        sb.append(", arriveCityName=").append(arriveCityName);
        sb.append(", mileageEstimate=").append(mileageEstimate);
        sb.append(", payEstimate=").append(payEstimate);
        sb.append(", renterRealPay=").append(renterRealPay);
        sb.append(", driverIncomeEstimate=").append(driverIncomeEstimate);
        sb.append(", refoundAmountEstimate=").append(refoundAmountEstimate);
        sb.append(", refoundState=").append(refoundState);
        sb.append(", discount=").append(discount);
        sb.append(", basicMileagePrice=").append(basicMileagePrice);
        sb.append(", mileagePrice=").append(mileagePrice);
        sb.append(", totalMileagePrice=").append(totalMileagePrice);
        sb.append(", mileagePriceDetail=").append(mileagePriceDetail);
        sb.append(", bookTip=").append(bookTip);
        sb.append(", bookTipDetail=").append(bookTipDetail);
        sb.append(", renterNum=").append(renterNum);
        sb.append(", cancelType=").append(cancelType);
        sb.append(", cancelTime=").append(cancelTime);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", driverJourneyNo=").append(driverJourneyNo);
        sb.append(", driverId=").append(driverId);
        sb.append(", orderId=").append(orderId);
        sb.append(", driverIncome=").append(driverIncome);
        sb.append(", driverName=").append(driverName);
        sb.append(", driverMobile=").append(driverMobile);
        sb.append(", vehiclePalte=").append(vehiclePalte);
        sb.append(", vehicleBrand=").append(vehicleBrand);
        sb.append(", vehicleSeries=").append(vehicleSeries);
        sb.append(", vehicleColor=").append(vehicleColor);
        sb.append(", payTime=").append(payTime);
        sb.append(", payType=").append(payType);
        sb.append(", payNumber=").append(payNumber);
        sb.append(", payState=").append(payState);
        sb.append(", shareResult=").append(shareResult);
        sb.append(", realStartLng=").append(realStartLng);
        sb.append(", realStartLat=").append(realStartLat);
        sb.append(", realStartLocation=").append(realStartLocation);
        sb.append(", realStartTime=").append(realStartTime);
        sb.append(", realEndLng=").append(realEndLng);
        sb.append(", realEndLat=").append(realEndLat);
        sb.append(", realEndLocation=").append(realEndLocation);
        sb.append(", realEndTime=").append(realEndTime);
        sb.append(", driverFreeState=").append(driverFreeState);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", field1=").append(field1);
        sb.append(", fieid2=").append(fieid2);
        sb.append(", field3=").append(field3);
        sb.append(", field4=").append(field4);
        sb.append(", field5=").append(field5);
        sb.append(", delState=").append(delState);
        sb.append("]");
        return sb.toString();
    }
}