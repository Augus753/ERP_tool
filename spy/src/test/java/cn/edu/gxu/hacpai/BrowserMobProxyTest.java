package cn.edu.gxu.hacpai;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.hacpai
 * @date 2021/3/29 11:06
 * @Description
 */

import cn.edu.gxu.constant.Constant;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class BrowserMobProxyTest {

    public void tearDown(WebDriver driver, BrowserMobProxy proxy) {
        if (proxy.isStarted()) {
            proxy.stop();
        }
        // 关闭当前窗口
        driver.close();
    }

    public static void main(String[] args) throws Exception {
        BrowserMobProxyTest browserMobProxyTest = new BrowserMobProxyTest();
        BrowserProxy browserProxy = BrowserProxy.getInstance();

        WebDriver driver = browserProxy.getDriver();
        BrowserMobProxy proxy = browserProxy.getProxy();

//        browserMobProxyTest.testMethod(driver, proxy);
        browserMobProxyTest.testLogin(driver);

//        browserMobProxyTest.testScore(driver, proxy,"第一年");
//        browserMobProxyTest.testAd(driver, proxy);
        browserMobProxyTest.testSpy(driver, proxy);


    }

    private void testAd(WebDriver webDriver, BrowserMobProxy proxy) throws Exception {
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]/a[8]")).click();
        Thread.sleep(1000);
//        本地
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[6]/div/div[2]/div/a[1]")).click();
        Thread.sleep(1000);
        List<WebElement> element = webDriver.findElements(By.xpath("//*[@id=\"scrollViewone\"]"));

        System.out.println("清理日志");
        proxy.getHar().setLog(new HarLog());
//通过for循环获得list中的所有元素，再调用getAttribute()方法得到元素的属性
        for (int i = 0; i < element.size(); i++) {
            //市场名称
            String key = element.get(i).getText();
            element.get(i).click();
            List<String> result = collectLog("getGroups3", proxy);

        }
    }

    private void testSpy(WebDriver webDriver, BrowserMobProxy proxy) throws Exception {
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]/a[6]")).click();


        Thread.sleep(2000);
    }

    private void testLogin(WebDriver webDriver) {
        webDriver.get("http://47.93.62.250:3003/login");

        webDriver.findElement(By.id("userName")).sendKeys("u6678224");
        // 输入账号 密码并登陆系统
        webDriver.findElement(By.id("password")).sendKeys("583601");
//        登录
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/button")).click();

        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/button")).click();


        String b1 = webDriver.getWindowHandle();
        //得到所有窗口的句柄
        Set<String> bs = webDriver.getWindowHandles();
        //飞哥说这个是迭代器
        for (String he : bs) {
            if (b1.equals(he)) continue;
            webDriver.switchTo().window(he);
            System.out.println("当前页面title为：" + webDriver.getTitle());
        }

        //        城镇
        webDriver.findElement(By.xpath("/html/body/div/div/div/map/area[1]")).click();
//         办公室
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/a[1]")).click();
    }

    private void testScore(WebDriver webDriver, BrowserMobProxy proxy, String year) throws Exception {


//        年度经营结果
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/a[3]")).click();
//        System.out.println(webDriver.getPageSource());
        Thread.sleep(2000);
//        各年度经营结果
        System.out.println("清理日志");
        proxy.getHar().setLog(new HarLog());
        for (int i = 0; i < Constant.RUN_YEAR.length - 2; i++) {
            if (year.equals(Constant.RUN_YEAR[i])) {
                System.out.println("查看" + Constant.RUN_YEAR[i] + "经营结果");
                webDriver.findElement(By.xpath("//*[@id=\"scrollViewGameResult\"]/a[" + (i + 1) + "]")).click();
                List<String> result = collectLog("getGroups4", proxy);
            }
        }

    }

    private List<String> collectLog(String filterKey, BrowserMobProxy proxy) throws Exception {
        Thread.sleep(2000);

        Har har = proxy.getHar();
//        System.out.println(har);
//        System.out.println("har.getLog():" + har.getLog());
//        System.out.println("har.getLog().getBrowser().getComment():" + har.getLog().getComment());
        List<HarEntry> list = har.getLog().getEntries();
        List<String> results = new ArrayList<>();
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
            results.add(responseBody);
            System.out.println("\n\n\n");
        }
        har.setLog(new HarLog());
        return results;

    }
}
