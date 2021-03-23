package cn.edu.gxu.persist;

import cn.edu.gxu.pojo.AdvertPo;
import cn.edu.gxu.stat.JsonParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.persist
 * @date 2021/3/21 10:39
 * @Description
 */
public class TestCacheManager {

    @Test
    public void test_flush() {
//        CacheManager.getInstance()
        CacheMoodle cacheMoodle = new CacheMoodle();
        ErpConfig config = new ErpConfig();
//        config.setGroupNames("第1组，第2组，第3组");
        config.setShortTemLoanRate(0.05f);
        config.setLongTemLoanRate(0.1f);
        cacheMoodle.setConfig(config);

        String ad1 = "{\"code\":0,\"msg\":\"\",\"groups\":[{\"rightsTop\":\"\",\"groupName\":\"第18组\",\"knownTop\":1,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2222,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":40.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第20组\",\"knownTop\":2,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2224,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":35.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第11组\",\"knownTop\":3,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2215,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":33.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第9组\",\"knownTop\":4,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2213,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":31.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第15组\",\"knownTop\":5,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2219,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":30.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第16组\",\"knownTop\":6,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2220,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":25.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第4组\",\"knownTop\":7,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2208,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":20.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第1组\",\"knownTop\":8,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2205,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":15.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第13组\",\"knownTop\":9,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2217,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":12.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第14组\",\"knownTop\":10,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2218,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":10.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第7组\",\"knownTop\":11,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2211,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":4.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第3组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2207,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":1.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第2组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2206,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第5组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2209,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第6组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2210,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第8组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2212,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第10组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2214,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第12组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2216,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第17组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":1,\"groupId\":2221,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第19组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2223,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第21组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2225,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第22组\",\"knownTop\":13,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2226,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"}]}\n";
        String ad2 = "{\"code\":0,\"msg\":\"\",\"groups\":[{\"rightsTop\":\"\",\"groupName\":\"第2组\",\"knownTop\":1,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2206,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":2472.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第15组\",\"knownTop\":2,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2219,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":580.64,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第14组\",\"knownTop\":3,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2218,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":375.76,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第10组\",\"knownTop\":4,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2214,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":306.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第16组\",\"knownTop\":5,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2220,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":205.59,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第3组\",\"knownTop\":6,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2207,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":123.60,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第4组\",\"knownTop\":7,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2208,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":67.32,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第13组\",\"knownTop\":8,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2217,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":65.60,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第20组\",\"knownTop\":9,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2224,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":12.52,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第9组\",\"knownTop\":10,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2213,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":6.28,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第7组\",\"knownTop\":11,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2211,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":6.10,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第1组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2205,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第5组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2209,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第6组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2210,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第8组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2212,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第11组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2215,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第12组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2216,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第17组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":1,\"groupId\":2221,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第18组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2222,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第19组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2223,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第21组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2225,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第22组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2226,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":385.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"}]}\n";
        Map<String, List<AdvertPo>> adCache = new HashMap<>();
        adCache.put("第一年_本地", new JsonParser().parseAd(ad1));
        adCache.put("第二年_区域", new JsonParser().parseAd(ad2));
        cacheMoodle.setAdCache(adCache);
        CacheManager manager = CacheManager.getInstance();
        manager.flush(cacheMoodle);
        manager.reload();

    }
}
