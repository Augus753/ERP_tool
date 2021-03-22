package cn.edu.gxu.persist;

import cn.edu.gxu.pojo.Advert;
import cn.edu.gxu.pojo.GroupScores;
import cn.edu.gxu.pojo.Order;
import cn.edu.gxu.pojo.SpyDao;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.persist
 * @date 2021/3/20 20:26
 * @Description 记录保存到文件的数据
 */
public class CacheMoodle {
    //    间谍
    private ErpConfig config;
    //    间谍
    private Map<String, SpyDao> spyCache = new HashMap<>();
    //    广告
    private Map<String, List<Advert>> adCache = new HashMap<>();
    //    评分
    private Map<String, List<GroupScores>> scoreCache = new HashMap<>();
    //    订单
    private Map<String, List<Order>> orderCache = new HashMap<>();

    public ErpConfig getConfig() {
        return config;
    }

    public void setConfig(ErpConfig config) {
        this.config = config;
    }

    public Map<String, SpyDao> getSpyCache() {
        return spyCache;
    }

    public void setSpyCache(Map<String, SpyDao> spyCache) {
        this.spyCache = spyCache;
    }

    public Map<String, List<Advert>> getAdCache() {
        return adCache;
    }

    public void setAdCache(Map<String, List<Advert>> adCache) {
        this.adCache = adCache;
    }

    public Map<String, List<GroupScores>> getScoreCache() {
        return scoreCache;
    }

    public void setScoreCache(Map<String, List<GroupScores>> scoreCache) {
        this.scoreCache = scoreCache;
    }

    public Map<String, List<Order>> getOrderCache() {
        return orderCache;
    }

    public void setOrderCache(Map<String, List<Order>> orderCache) {
        this.orderCache = orderCache;
    }


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
