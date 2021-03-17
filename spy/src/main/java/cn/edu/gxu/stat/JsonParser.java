package cn.edu.gxu.stat;

import cn.edu.gxu.pojo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
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
        spy.setLongtermLoan(NumberUtils.toInt(String.valueOf(content.get("longtermLoan"))));
        spy.setShorttemLoan(NumberUtils.toInt(String.valueOf(content.get("shorttemLoan"))));
        spy.formatFactory(content.getString("factory"));
        spy.formatProduct(content.getString("product"));

        spy.setCertificate(new Certificate().format(content.getString("certificate")));
        spy.formatProductLine(content.getString("prodLine"));
        return spy;
    }

    @Override
    public List<GroupScores> parseScore(String text) {
        JSONObject data = getDate(text);
        JSONArray datas = data.getJSONArray("busInfos");
        return datas.parallelStream().map(g -> JSONObject.toJavaObject((JSON) g, GroupScores.class)).collect(Collectors.toList());
    }

    @Override
    public List<Order> parseOrder() {
        return null;
    }
}
