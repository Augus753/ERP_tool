package cn.edu.gxu.persist;

import cn.edu.gxu.pojo.AdvertPo;
import cn.edu.gxu.pojo.GroupScoresPo;
import cn.edu.gxu.pojo.OrderPo;
import cn.edu.gxu.pojo.SpyPo;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.persist
 * @date 2021/3/20 20:26
 * @Description
 */
public class CacheManager {
    private static final String DATA_PATH = "./data.json";
    private static final String DEFAULT_CHARSET = "utf-8";
    private static CacheManager instance = new CacheManager();
    //    单例
    private static CacheMoodle cache = new CacheMoodle();

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        return instance;
    }

    public void flush(CacheMoodle cache) {
        this.cache = cache;
        String cacheText = JSONObject.toJSONString(this.cache);
        try {
            System.out.println("保存：" + this.cache);
            FileUtils.write(new File(DATA_PATH), cacheText, DEFAULT_CHARSET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void flush() throws Exception {
        String cacheText = JSONObject.toJSONString(cache);
        System.out.println("保存配置");
        FileUtils.write(new File(DATA_PATH), cacheText, DEFAULT_CHARSET);
    }

    public static synchronized void clear() throws Exception {
        cache.getScoreCache().clear();
        cache.getAdCache().clear();
        cache.getSpyCache().clear();
        cache.getOrderCache().clear();
        flush();
    }

    public static synchronized void reload() {
        try {
            String text = FileUtils.readFileToString(new File(DATA_PATH), DEFAULT_CHARSET);
            cache = JSONObject.parseObject(text, CacheMoodle.class);
            System.out.println("读取到：" + cache);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void reload(File file) throws Exception {
        String text = FileUtils.readFileToString(file, DEFAULT_CHARSET);
        cache = JSONObject.parseObject(text, CacheMoodle.class);
        System.out.println("读取到：" + cache);
    }

    public static SpyPo getSpy(String groupName) {
        return cache.getSpyCache().get(groupName);
    }

    public static void setSpy(String groupName, SpyPo spy) {
        cache.getSpyCache().put(groupName, spy);
    }

    public static String generateGroupKey(String year, String groupName) {
        return year + "_" + groupName;
    }

    public static List<AdvertPo> getAd(String key) {
        return cache.getAdCache().get(key);
    }

    public static void setAd(String market, List<AdvertPo> ad) {
        cache.getAdCache().put(market, ad);
    }

    public static String generateMarketKey(String year, String market) {
        return year + "_" + market;
    }

    public static List<OrderPo> getOrder(String key) {
        return cache.getOrderCache().get(key);
    }

    public static List<GroupScoresPo> getScore(String year) {
        System.out.println("获取分数：" + year);
        return cache.getScoreCache().get(year);
    }

    public static void setScore(String year, List<GroupScoresPo> score) {
        System.out.println("增加分数：" + year);
        cache.getScoreCache().put(year, score);
    }

    public static void setOrder(String year, List<OrderPo> orderPos) {
        cache.getOrderCache().put(year, orderPos);
    }

    public static ErpConfig getConfig() {
        return cache.getConfig();
    }
}
