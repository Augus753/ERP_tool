package cn.edu.gxu.persist;

import cn.edu.gxu.pojo.SpyDao;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.persist
 * @date 2021/3/20 20:26
 * @Description
 */
public class CacheManager {
    //    单例
    private static CacheMoodle cache = new CacheMoodle();

    public static SpyDao getByGroupName(String groupName) {
        return cache.getSpyCache().get(groupName);
    }

    public static SpyDao setByGroupName(String groupName, SpyDao spy) {
        return cache.getSpyCache().put(groupName, spy);
    }

    public static String generateGroupKey(String year, String groupName) {
        return year + "_" + groupName;
    }
}
