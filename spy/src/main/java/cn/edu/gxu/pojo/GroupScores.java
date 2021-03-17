package cn.edu.gxu.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 第九空间
 * @version V1.0
 * @Package cn.edu.gxu
 * @date 2021/3/13 21:42
 * @Description 经营结果
 * groupId    int		组ID
 * groupName	String		组名
 * groupRights	int		权益
 * profitTop	String		利润排名
 * groupScore	int		分数
 * groupProfit	int		利润
 * scoreTop	String		分数排名
 * groupTop	int		排名
 * rightsTop	int		权益排名
 * isMyGroup	int		是否是自己	1：是，0：否
 */
public class GroupScores {
    public Integer groupId;
    public String groupName;
    public Integer groupRights;
    public Integer profitTop;
    public Integer groupScore;
    public Integer groupProfit;
    public Integer groupTop;
    public Integer rightsTop;
    public Integer isMyGroup;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupRights() {
        return groupRights;
    }

    public void setGroupRights(Integer groupRights) {
        this.groupRights = groupRights;
    }

    public Integer getProfitTop() {
        return profitTop;
    }

    public void setProfitTop(Integer profitTop) {
        this.profitTop = profitTop;
    }

    public Integer getGroupScore() {
        return groupScore;
    }

    public void setGroupScore(Integer groupScore) {
        this.groupScore = groupScore;
    }

    public Integer getGroupProfit() {
        return groupProfit;
    }

    public void setGroupProfit(Integer groupProfit) {
        this.groupProfit = groupProfit;
    }

    public Integer getGroupTop() {
        return groupTop;
    }

    public void setGroupTop(Integer groupTop) {
        this.groupTop = groupTop;
    }

    public Integer getRightsTop() {
        return rightsTop;
    }

    public void setRightsTop(Integer rightsTop) {
        this.rightsTop = rightsTop;
    }

    public Integer getIsMyGroup() {
        return isMyGroup;
    }

    public void setIsMyGroup(Integer isMyGroup) {
        this.isMyGroup = isMyGroup;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
