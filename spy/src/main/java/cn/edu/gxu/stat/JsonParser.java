package cn.edu.gxu.stat;

import cn.edu.gxu.constant.enums;
import cn.edu.gxu.pojo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.stat
 * @date 2021/3/13 21:58
 * @Description
 */
public class JsonParser extends Parser {

    public JSONObject getDate(String text) {
        JSONObject content = JSONObject.parseObject(text);
        System.out.println(content);
        return content;
    }

    @Override
    public List<Advert> parseAd(String text) {
        JSONObject data = getDate(text);
        JSONArray datas = data.getJSONArray("groups");
        return datas.parallelStream().map(g -> JSONObject.toJavaObject((JSON) g, Advert.class)).collect(Collectors.toList());
    }

    @Override
    public SpyDao parseSpy(String text) {
        JSONObject data = getDate(text);
        JSONArray datas = data.getJSONArray("busInfos");
        JSONObject content = (JSONObject) datas.get(0);
        SpyDao spy = new SpyDao();
        spy.setGroupName(content.getString("groupName"));
        int cash = content.getInteger("cash") + NumberUtils.toInt(String.valueOf(content.get("receivable")));
        spy.setCash(cash);
//        spy.setLongtermLoan(0);
//        spy.setShorttemLoan(0);
        spy.setLongtermLoan(((BigDecimal) content.get("longtermLoan")).intValue());
        spy.setShorttemLoan(((BigDecimal) content.get("shorttemLoan")).intValue());
        spy.formatFactory(content.getString("factory"));
        spy.formatProduct(content.getString("product"));

        spy.setCertificate(new Certificate().format(content.getString("certificate")));
        spy.formatProductLine(content.getString("prodLine"));
        return spy;
    }

    @Override
    public List<GroupScores> parseScore(String text) {
        JSONObject data = getDate(text);
        JSONArray datas = data.getJSONArray("groups");
        return datas.parallelStream().map(g -> JSONObject.toJavaObject((JSON) g, GroupScores.class)).collect(Collectors.toList());
    }

    @Override
    public List<Order> parseOrder(String text) {
        JSONObject data = getDate(text);
        JSONArray datas = data.getJSONArray("orderResults");
        return datas.parallelStream().map(o -> JSONObject.toJavaObject((JSON) o, Order.class)).peek(order -> {
            order.setpSysId(StringUtils.upperCase(order.getpSysId()));
            order.setOrderResult(order.getOrderResult().split("_")[0]);
            order.setpPerFee(order.getpPerFee().split("\\.")[0]);
            order.setsSysId(enums.Market.exchange(order.getsSysId()).marketName);
        }).collect(Collectors.toList());
    }
}
