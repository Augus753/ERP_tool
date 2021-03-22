package cn.edu.gxu.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 第九空间
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/13 21:52
 * @Description 广告
 * groupName	String		组名
 * knownTop	String		排名
 * isMyGroup			是否是自己	1：是，0：否
 * groupId			组ID
 * publicity			投资额
 */
public class AdvertPo {
    public String groupName;
    public String knownTop;
    public Integer isMyGroup;
    public Integer groupId;
    public Integer publicity;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getKnownTop() {
        return knownTop;
    }

    public void setKnownTop(String knownTop) {
        this.knownTop = knownTop;
    }

    public Integer getMyGroup() {
        return isMyGroup;
    }

    public void setMyGroup(Integer myGroup) {
        isMyGroup = myGroup;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPublicity() {
        return publicity;
    }

    public void setPublicity(Integer publicity) {
        this.publicity = publicity;
    }


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
