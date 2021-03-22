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
    private float shortTemLoanRate;
    //    长利率
    private float longTemLoanRate;
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


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
