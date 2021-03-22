package cn.edu.gxu.persist;

import cn.edu.gxu.pojo.AdvertPo;
import cn.edu.gxu.pojo.GroupScoresPo;
import cn.edu.gxu.pojo.OrderPo;
import cn.edu.gxu.pojo.SpyPo;
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
    private ErpConfig config = new ErpConfig();
    //    间谍
    private Map<String, SpyPo> spyCache = new HashMap<>();
    //    广告
    private Map<String, List<AdvertPo>> adCache = new HashMap<>();
    //    评分
    private Map<String, List<GroupScoresPo>> scoreCache = new HashMap<>();
    //    订单
    private Map<String, List<OrderPo>> orderCache = new HashMap<>();

    public ErpConfig getConfig() {
        return config;
    }

    public void setConfig(ErpConfig config) {
        this.config = config;
    }

    public Map<String, SpyPo> getSpyCache() {
        return spyCache;
    }

    public void setSpyCache(Map<String, SpyPo> spyCache) {
        this.spyCache = spyCache;
    }

    public Map<String, List<AdvertPo>> getAdCache() {
        return adCache;
    }

    public void setAdCache(Map<String, List<AdvertPo>> adCache) {
        this.adCache = adCache;
    }

    public Map<String, List<GroupScoresPo>> getScoreCache() {
        return scoreCache;
    }

    public void setScoreCache(Map<String, List<GroupScoresPo>> scoreCache) {
        this.scoreCache = scoreCache;
    }

    public Map<String, List<OrderPo>> getOrderCache() {
        return orderCache;
    }

    public void setOrderCache(Map<String, List<OrderPo>> orderCache) {
        this.orderCache = orderCache;
    }


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
