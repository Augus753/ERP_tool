package cn.edu.gxu.pojo;

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

    public int sum() {
        return upkeep + interest + administration + depreciation;
    }
}
