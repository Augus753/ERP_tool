package cn.edu.gxu.collect;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.collect
 * @date 2021/3/27 19:36
 * @Description
 */
public class TestCollectManager {

    @Test
    public void test_login() throws IOException {
//        CollectManager.login();
//        CollectManager.getGroupInfo();
    }

    @Test
    public void test_getAdInfo() {
//        CollectManager.getAdInfo();
    }

    @Test
    public void test_getGroupScores() {
//        CollectManager.login();
//        CollectManager.getGroupScores();
    }

    @Test
    public void test_HtmlUnitTest() throws IOException {
        System.setProperty(
                "webdriver.chrome.driver",
                "F:\\ERP_tool\\res\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
        System.out.println(webDriver.getTitle());

    }


}
