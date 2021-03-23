package cn.edu.gxu.stat;

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.pojo.OrderPo;
import cn.edu.gxu.pojo.ProfitDao;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.stat
 * @date 2021/3/22 10:47
 * @Description
 */
public class orderStat {

    public static Map<String, ProfitDao> calProfit(String year) {
        List<OrderPo> orderPos = CacheManager.getOrder(year);
        if (orderPos == null || orderPos.size() == 0) return null;
        Map<String, ProfitDao> result = new HashMap<>();
        for (OrderPo o : orderPos) {
            ProfitDao profit = result.getOrDefault(o.getOrderResult(), new ProfitDao());
            int num = NumberUtils.toInt(o.getMyOrderCount() + "");
            int price = NumberUtils.toInt(o.getpPerFee() + "");
//            profit.setSales(profit.getSales() + num * price);
            profit.setProfit(profit.getProfit() + (price - Constant.getCost(o.getpSysId() + "")) * num);
            profit.setGroupName(o.getOrderResult());
            profit.setNum(profit.getNum() + o.getMyOrderCount());
            result.put(o.getOrderResult(), profit);
        }
        return result;
    }

}
