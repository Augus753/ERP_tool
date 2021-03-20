package cn.edu.gxu.persist;

import cn.edu.gxu.pojo.SpyDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.persist
 * @date 2021/3/20 20:26
 * @Description
 */
public class CacheMoodle {

    //    间谍
    private Map<String, SpyDao> spyCache = new HashMap<>();

    public Map<String, SpyDao> getSpyCache() {
        return spyCache;
    }

    public void setSpyCache(Map<String, SpyDao> spyCache) {
        this.spyCache = spyCache;
    }
}
