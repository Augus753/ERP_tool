package cn.edu.gxu.stat;

import cn.edu.gxu.pojo.AdvertPo;
import cn.edu.gxu.pojo.GroupScoresPo;
import cn.edu.gxu.pojo.OrderPo;
import cn.edu.gxu.pojo.SpyPo;

import java.util.List;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu
 * @date 2021/3/13 21:54
 * @Description
 */
public abstract class Parser {
    public abstract List<AdvertPo> parseAd(String text);

    public abstract SpyPo parseSpy(String text);

    public abstract List<GroupScoresPo> parseScore(String text);

    public abstract List<OrderPo> parseOrder(String text);

}
