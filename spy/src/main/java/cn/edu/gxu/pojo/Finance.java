package cn.edu.gxu.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/22 11:20
 * @Description
 */
public class Finance {
    //    维修费
    private int upkeep;
    //贷款利息
    private int interest;
    //管理费
    private int administration;
    //折旧费
    private int depreciation;
    //厂房租金
    private int factoryRent;
    //订单违约金，已经算在毛利里面
    private int breach;

    public int getUpkeep() {
        return upkeep;
    }

    public void setUpkeep(int upkeep) {
        this.upkeep = upkeep;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getAdministration() {
        return administration;
    }

    public void setAdministration(int administration) {
        this.administration = administration;
    }

    public int getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(int depreciation) {
        this.depreciation = depreciation;
    }

    public int getFactoryRent() {
        return factoryRent;
    }

    public void setFactoryRent(int factoryRent) {
        this.factoryRent = factoryRent;
    }

    public int getBreach() {
        return breach;
    }

    public void setBreach(int breach) {
        this.breach = breach;
    }

    public int sumRight() {
        //   （权益） 维修费+贷款利息+管理费+折旧费+厂房租金
        return upkeep + interest + administration + depreciation + factoryRent + breach;
    }

    public int sumCash() {
        //    （现金）    维修费+贷款利息+管理费+厂房租金
        return upkeep + interest + administration + factoryRent + breach;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
