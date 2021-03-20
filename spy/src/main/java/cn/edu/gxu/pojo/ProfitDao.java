package cn.edu.gxu.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/20 10:59
 * @Description
 */
public class ProfitDao {
    private String groupName;
    private String marketName;
    private String productName;
    private int sales;
    private int profit;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
