package cn.edu.gxu.persist;

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.constant.enums;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.persist
 * @date 2021/3/21 10:15
 * @Description
 */
public class ErpConfig {
    //    短贷利率
    private float breachRate = (float) 0.2;
    //    短贷利率
    private float shortTemLoanRate = (float) 0.05;
    //    长利率
    private float longTemLoanRate = (float) 0.1;
    //    P1成本
    private int P1Cost;
    //    P2成本
    private int P2Cost;
    //    P3成本
    private int P3Cost;
    //    P4成本
    private int P4Cost;
    //    P5成本
    private int P5Cost;
    //    贷款倍数
    private int loanTimes = 2;
    //生产时间
    public int sgxProductTimes = 100;
    public int qzdProductTimes = 60;
    public int rxProductTimes = 48;
    //折旧
    public float sgxDepreciation = 15;
    public float qzdDepreciation = (float) 22.5;
    public float rxDepreciation = 30;
    //维修费
    public int sgxUpKeep = 5;
    public int qzdUpKeep = 15;
    public int rxUpKeep = 20;
    //管理费
    public int administration = 60;

    //厂房租金
    public int factoryRent = 60;

    public String[] groupNames = Constant.GROUP_NAME;

    public float getBreachRate() {
        return breachRate;
    }

    public void setBreachRate(float breachRate) {
        this.breachRate = breachRate;
    }

    public float getShortTemLoanRate() {
        return shortTemLoanRate;
    }

    public void setShortTemLoanRate(float shortTemLoanRate) {
        this.shortTemLoanRate = shortTemLoanRate;
    }

    public float getLongTemLoanRate() {
        return longTemLoanRate;
    }

    public void setLongTemLoanRate(float longTemLoanRate) {
        this.longTemLoanRate = longTemLoanRate;
    }

    public int getP1Cost() {
        return P1Cost;
    }

    public void setP1Cost(int p1Cost) {
        P1Cost = p1Cost;
    }

    public int getP2Cost() {
        return P2Cost;
    }

    public void setP2Cost(int p2Cost) {
        P2Cost = p2Cost;
    }

    public int getP3Cost() {
        return P3Cost;
    }

    public void setP3Cost(int p3Cost) {
        P3Cost = p3Cost;
    }

    public int getP4Cost() {
        return P4Cost;
    }

    public void setP4Cost(int p4Cost) {
        P4Cost = p4Cost;
    }

    public int getP5Cost() {
        return P5Cost;
    }

    public void setP5Cost(int p5Cost) {
        P5Cost = p5Cost;
    }

    public int getLoanTimes() {
        return loanTimes;
    }

    public void setLoanTimes(int loanTimes) {
        this.loanTimes = loanTimes;
    }

    public int getSgxProductTimes() {
        return sgxProductTimes;
    }

    public void setSgxProductTimes(int sgxProductTimes) {
        this.sgxProductTimes = sgxProductTimes;
    }

    public int getQzdProductTimes() {
        return qzdProductTimes;
    }

    public void setQzdProductTimes(int qzdProductTimes) {
        this.qzdProductTimes = qzdProductTimes;
    }

    public int getRxProductTimes() {
        return rxProductTimes;
    }

    public void setRxProductTimes(int rxProductTimes) {
        this.rxProductTimes = rxProductTimes;
    }

    public float getSgxDepreciation() {
        return sgxDepreciation;
    }

    public void setSgxDepreciation(float sgxDepreciation) {
        this.sgxDepreciation = sgxDepreciation;
    }

    public float getQzdDepreciation() {
        return qzdDepreciation;
    }

    public void setQzdDepreciation(float qzdDepreciation) {
        this.qzdDepreciation = qzdDepreciation;
    }

    public float getRxDepreciation() {
        return rxDepreciation;
    }

    public void setRxDepreciation(float rxDepreciation) {
        this.rxDepreciation = rxDepreciation;
    }

    public int getSgxUpKeep() {
        return sgxUpKeep;
    }

    public void setSgxUpKeep(int sgxUpKeep) {
        this.sgxUpKeep = sgxUpKeep;
    }

    public int getQzdUpKeep() {
        return qzdUpKeep;
    }

    public void setQzdUpKeep(int qzdUpKeep) {
        this.qzdUpKeep = qzdUpKeep;
    }

    public int getRxUpKeep() {
        return rxUpKeep;
    }

    public void setRxUpKeep(int rxUpKeep) {
        this.rxUpKeep = rxUpKeep;
    }

    public int getAdministration() {
        return administration;
    }

    public void setAdministration(int administration) {
        this.administration = administration;
    }

    public int getFactoryRent() {
        return factoryRent;
    }

    public void setFactoryRent(int factoryRent) {
        this.factoryRent = factoryRent;
    }

    public String[] getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(String[] groupName) {
        this.groupNames = groupName;
    }

    public int getCost(String productName) {
        if (StringUtils.isBlank(productName)) return 0;
        productName = productName.toUpperCase();
        if (enums.Product.P1.product.equals(productName)) {
            return P1Cost;
        } else if (enums.Product.P2.product.equals(productName)) {
            return P2Cost;
        } else if (enums.Product.P3.product.equals(productName)) {
            return P3Cost;
        } else if (enums.Product.P4.product.equals(productName)) {
            return P4Cost;
        } else if (enums.Product.P5.product.equals(productName)) {
            return P5Cost;
        }
        return 0;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
