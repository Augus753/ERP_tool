package cn.edu.gxu.persist;

import com.alibaba.fastjson.JSONObject;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.persist
 * @date 2021/3/21 10:15
 * @Description
 */
public class ErpConfig {
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
    //组名，用,分割
    private String groupNames;
    //    贷款倍数
    private int loanTimes = 2;
    //生产时间
    public int sgxProductTimes = 100;
    public int qzdProductTimes = 60;
    public int rxProductTimes = 48;
    //折旧
    public int sgxDepreciation = 15;
    public int qzdDepreciation = 22;
    public int rxDepreciation = 30;
    //维修费
    public int sgxUpKeep = 5;
    public int qzdUpKeep = 15;
    public int rxUpKeep = 20;
    //管理费
    public int administration = 60;

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

    public String getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(String groupNames) {
        this.groupNames = groupNames;
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

    public int getSgxDepreciation() {
        return sgxDepreciation;
    }

    public void setSgxDepreciation(int sgxDepreciation) {
        this.sgxDepreciation = sgxDepreciation;
    }

    public int getQzdDepreciation() {
        return qzdDepreciation;
    }

    public void setQzdDepreciation(int qzdDepreciation) {
        this.qzdDepreciation = qzdDepreciation;
    }

    public int getRxDepreciation() {
        return rxDepreciation;
    }

    public void setRxDepreciation(int rxDepreciation) {
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

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
