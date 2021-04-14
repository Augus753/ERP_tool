package cn.edu.gxu.collect;

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.constant.ResponseException;
import cn.edu.gxu.constant.enums;
import cn.edu.gxu.persist.CacheManager;
import com.alibaba.fastjson.JSONObject;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.collect
 * @date 2021/3/24 15:51
 * @Description 不想使用spider框架了，做简单一些
 */
public class CollectManager {

    private static final CollectManager manager = new CollectManager();

    private CollectManager() {
    }

    public static CollectManager getInstance() {
        return manager;
    }

//    private static String userName = "u6678224";
//    private static String passWord = "583601";
//    private static String sampleUrl = "47.93.62.250:3004";
//    private static String loginUrl = "47.93.62.250:3003";
//    private static String userToken = "2442ADEA1784B892416B547C39746254";

    public void record(String flag, String text) {
        try {
            text = flag + "\n" + text + "\n\n\n\n";
            FileUtils.write(new File("input.text"), text, "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
