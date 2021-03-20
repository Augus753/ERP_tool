package cn.edu.gxu.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/13 21:58
 * @Description
 */
public class Order {
    private String sSysId;//市场	S1：本地，S2区域
    private String pOrderNum;//订单编号
    private String orderResult;//组
    private String pSysId;//产品类型
    private int myOrderCount;//数量
    private String pPerFee;//单价
    private int pDeliveryMonth;//交货月份
    private int pDeliveryDay;//交货日期
    private int pPaymentTerm;//账期

    public String getsSysId() {
        return sSysId;
    }

    public void setsSysId(String sSysId) {
        this.sSysId = sSysId;
    }

    public String getpOrderNum() {
        return pOrderNum;
    }

    public void setpOrderNum(String pOrderNum) {
        this.pOrderNum = pOrderNum;
    }

    public String getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(String orderResult) {
        this.orderResult = orderResult;
    }

    public String getpSysId() {
        return pSysId;
    }

    public void setpSysId(String pSysId) {
        this.pSysId = pSysId;
    }

    public int getMyOrderCount() {
        return myOrderCount;
    }

    public void setMyOrderCount(int myOrderCount) {
        this.myOrderCount = myOrderCount;
    }

    public String getpPerFee() {
        return pPerFee;
    }

    public void setpPerFee(String pPerFee) {
        this.pPerFee = pPerFee;
    }

    public int getpDeliveryMonth() {
        return pDeliveryMonth;
    }

    public void setpDeliveryMonth(int pDeliveryMonth) {
        this.pDeliveryMonth = pDeliveryMonth;
    }

    public int getpDeliveryDay() {
        return pDeliveryDay;
    }

    public void setpDeliveryDay(int pDeliveryDay) {
        this.pDeliveryDay = pDeliveryDay;
    }

    public int getpPaymentTerm() {
        return pPaymentTerm;
    }

    public void setpPaymentTerm(int pPaymentTerm) {
        this.pPaymentTerm = pPaymentTerm;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
