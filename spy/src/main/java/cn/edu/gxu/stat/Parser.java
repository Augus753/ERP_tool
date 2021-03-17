package cn.edu.gxu.stat;

import cn.edu.gxu.pojo.Advert;
import cn.edu.gxu.pojo.GroupScores;
import cn.edu.gxu.pojo.Order;
import cn.edu.gxu.pojo.SpyDao;

import java.util.List;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu
 * @date 2021/3/13 21:54
 * @Description
 */
public abstract class Parser {
    public abstract List<Advert> parseAd(String text);

    public abstract SpyDao parseSpy(String text);

    public abstract List<GroupScores> parseScore(String text);

    public abstract List<Order> parseOrder();

}
