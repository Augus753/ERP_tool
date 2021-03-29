package cn.edu.gxu.collect;

import cn.edu.gxu.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.collect
 * @date 2021/3/27 21:59
 * @Description http://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
 */
public class Testselenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(
                "webdriver.chrome.driver",
                "./lib//chromedriver.exe");
//        WebDriver webDriver = new ChromeDriver();
        {
            //        不显示浏览器
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("-headless");
//            WebDriver webDriver = new ChromeDriver(chromeOptions);
        }
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        WebDriver webDriver = new ChromeDriver(caps);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 打开目标地址
        webDriver.get("http://47.93.62.250:3003/login");

//        System.out.println(webDriver.getPageSource());
        webDriver.findElement(By.id("userName")).sendKeys("u6678224");
        // 输入账号 密码并登陆系统
        webDriver.findElement(By.id("password")).sendKeys("583601");
//        登录
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/button")).click();

//        进入游戏
//        webDriver.get("http://47.93.62.250:3004/Companyout");
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/button")).click();


//        Thread.sleep(20000);
//        webDriver.get("http://47.93.62.250:3004/Manager");
//        webDriver.get("http://47.93.62.250:3004/CompanyInner#");


        //切换页面
        //得到当前窗口的句柄
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
//        年度经营结果
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/a[3]")).click();
//        System.out.println(webDriver.getPageSource());

//        各年度经营结果
        for (int i = 0; i < Constant.RUN_YEAR.length; i++) {
            if ("第一年".equals(Constant.RUN_YEAR[i])) {
                webDriver.findElement(By.xpath("//*[@id=\"scrollViewGameResult\"]/a[" + (i + 1) + "]")).click();
            }
        }


        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[6]/div/div[2]/div"));

        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println("返回响应报文：" + new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }

//        System.out.println(webDriver.getPageSource());
        //*[@id="scrollViewGameResult"]/a[2]
        // 暂停五秒钟后关闭
        System.out.println("加载完毕.");
        Thread.sleep(500000);
        webDriver.quit();
    }
}
