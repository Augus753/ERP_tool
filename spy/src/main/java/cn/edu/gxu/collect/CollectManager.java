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

    private static CollectManager manager = new CollectManager();
    private BrowserMobProxy proxy;
    private WebDriver driver;
    private static final String FILTER_KEY_SCORE = "getGroups4";
    private static final String FILTER_KEY_AD = "getGroups3";


    private CollectManager() {
        BrowserProxy browserProxy = BrowserProxy.getInstance();
        WebDriver driver = browserProxy.getDriver();
        BrowserMobProxy proxy = browserProxy.getProxy();
        this.driver = driver;
        this.proxy = proxy;
    }

    public static CollectManager getInstance() {
        return manager;
    }

//    public void init() {
//        BrowserProxy browserProxy = BrowserProxy.getInstance();
//        WebDriver driver = browserProxy.getDriver();
//        BrowserMobProxy proxy = browserProxy.getProxy();
//        this.driver = driver;
//        this.proxy = proxy;
//    }

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


    public void login() throws ResponseException {
        if (StringUtils.isAllBlank(CacheManager.getConfig().getLoginInfo(), CacheManager.getConfig().getUserName(), CacheManager.getConfig().getPassWord())) {
            throw new ResponseException(enums.defineException.CONFIG_ACCOUNT_ERROR);
        }
        try {
            driver.get("http://" + CacheManager.getConfig().getLoginInfo() + "/login");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseException(enums.defineException.LOGIN_ERROR);
        }

        try {
            // 输入账号 密码并登陆系统
            driver.findElement(By.id("userName")).sendKeys(CacheManager.getConfig().getUserName());
            driver.findElement(By.id("password")).sendKeys(CacheManager.getConfig().getPassWord());
            //        登录
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/button")).click();
            //        进入比赛
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/button")).click();
            String b1 = driver.getWindowHandle();
            //得到所有窗口的句柄
            Set<String> bs = driver.getWindowHandles();
            //飞哥说这个是迭代器
            for (String he : bs) {
                if (b1.equals(he)) continue;
                driver.switchTo().window(he);
                System.out.println("当前页面title为：" + driver.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseException(enums.defineException.CONFIG_LOGIN_ERROR);
        }
        try {
            //        城镇
            driver.findElement(By.xpath("/html/body/div/div/div/map/area[1]")).click();
            //        办公室
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/a[1]")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getGroupInfo() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]/a[6]")).click();
        List<WebElement> groups = driver.findElements(By.xpath("//*[@id=\"scrollViewIntelligence\"]"));
        System.out.println("清理日志");
        proxy.getHar().setLog(new HarLog());
        List<String> result = new ArrayList<>();
        for (WebElement group : groups) {
            group.click();
            result.add(collectLog(FILTER_KEY_AD));
        }
        return result;
    }

    public JSONObject getAdInfo() {
        JSONObject result = new JSONObject();
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]/a[8]")).click();
            Thread.sleep(1000);
//        本地
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[6]/div/div[2]/div/a[1]")).click();
            Thread.sleep(1000);
            List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"scrollViewone\"]"));

            System.out.println("清理日志");
            proxy.getHar().setLog(new HarLog());
//通过for循环获得list中的所有元素，再调用getAttribute()方法得到元素的属性
            for (int i = 0; i < element.size(); i++) {
                //市场名称
                String key = element.get(i).getText();
                element.get(i).click();
                result.put(key, collectLog(FILTER_KEY_AD));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getGroupScores(String year) throws Exception {
//        年度经营结果
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/a[3]")).click();
//        System.out.println(driver.getPageSource());
        Thread.sleep(2000);
//        各年度经营结果
        System.out.println("清理日志");
        proxy.getHar().setLog(new HarLog());
        for (int i = 0; i < Constant.RUN_YEAR.length - 2; i++) {
            if (year.equals(Constant.RUN_YEAR[i])) {
                Thread.sleep(1000);
                WebElement element = driver.findElement(By.xpath("//*[@id=\"scrollViewGameResult\"]/a[" + (i + 1) + "]"));
//                JavascriptExecutor executor = (JavascriptExecutor) driver;
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//                driver.findElement(By.xpath("//*[@id=\"scrollViewGameResult\"]/a[" + (i + 1) + "]")).click();
                return collectLog(FILTER_KEY_SCORE);
            }
        }
        return null;
    }

    private String collectLog(String filterKey) {
        try {
            Thread.sleep(1000);
            Har har = proxy.getHar();
            List<HarEntry> list = har.getLog().getEntries();
            for (HarEntry harEntry : list) {
                // 请求的详细信息。
                HarRequest harRequest = harEntry.getRequest();
                // 请求地址
                String reqUrl = harRequest.getUrl();
                if (filterKey != null && !reqUrl.contains(filterKey)) continue;
                System.out.println("reqUrl:" + reqUrl);
//            harRequest.getMethod()
                System.out.println(harEntry.getResponse().getStatusText() + "------------" + harEntry.getResponse().getContent().getSize());
                HarResponse harResponse = harEntry.getResponse();
                String responseBody = harResponse.getContent().getText();
                System.out.println("responseBody:" + responseBody);
                System.out.println("\n\n\n");
                return responseBody;
            }
            har.setLog(new HarLog());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOrderInfo() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]/a[8]")).click();
        Thread.sleep(1000);
//        本地
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[6]/div/div[2]/div/a[1]")).click();
        Thread.sleep(1000);
//        List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"scrollViewone\"]"));
        System.out.println("清理日志");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[6]/div[2]/div[1]/div/div[2]/div[3]/div[3]/button[2]")).click();
        proxy.getHar().setLog(new HarLog());
        return collectLog(FILTER_KEY_SCORE);
    }
}
