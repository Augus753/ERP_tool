package cn.edu.gxu.pojo;

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.persist.CacheManager;
import com.alibaba.fastjson.JSONObject;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/22 11:07
 * @Description
 */
public class ForecastPo {
    private String groupName;
    //    上一年权益
    private int lastYearRights;
    //    上一年现金
    private int lastYearCash;
    //      利润
    private int profit;
    //      剩余贷款额度
    private int remainTemLoan;
    //      剩余产品数
    private int remainProduct;
    //      在产品支出
    private int onLineProduct;
    //      财务支出
    private Finance finance;
    //      预计权益
    private int forecastRights;
    //      剩余最大资金
    private int remainMaxCash;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getLastYearRights() {
        return lastYearRights;
    }

    public void setLastYearRights(int lastYearRights) {
        this.lastYearRights = lastYearRights;
    }

    public int getLastYearCash() {
        return lastYearCash;
    }

    public void setLastYearCash(int lastYearCash) {
        this.lastYearCash = lastYearCash;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getRemainTemLoan() {
        return remainTemLoan;
    }

    public void setRemainTemLoan(int remainTemLoan) {
        this.remainTemLoan = remainTemLoan;
    }

    public int getRemainProduct() {
        return remainProduct;
    }

    public void setRemainProduct(int remainProduct) {
        this.remainProduct = remainProduct;
    }

    public int getOnLineProduct() {
        return onLineProduct;
    }

    public void setOnLineProduct(int onLineProduct) {
        this.onLineProduct = onLineProduct;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }

    public int getForecastRights() {
        return forecastRights;
    }

    public void setForecastRights(int forecastRights) {
        this.forecastRights = forecastRights;
    }

    public int getRemainMaxCash() {
        return remainMaxCash;
    }

    public void setRemainMaxCash(int remainMaxCash) {
        this.remainMaxCash = remainMaxCash;
    }

    public void calForecastRights() {
//        年末权益：去年权益+税后毛利-财务费用
        this.forecastRights = (int) (lastYearRights + profit * (1 - Constant.DefaultTax) - finance.sumRight()) - 100;
    }

    public void calRemainMaxCash() {
//        年末最大剩余现金：剩余现金+毛利+剩余贷款额度-(在制品价值+滞留产品价值)-维修费-管理费-租金
        this.remainMaxCash = lastYearCash + profit + remainTemLoan - (onLineProduct + remainProduct) * CacheManager.getConfig().getP3Cost() - finance.sumCash() - 100;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
