package cn.edu.gxu.view;

import org.junit.Test;

import java.awt.*;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/17 21:59
 * @Description
 */
public class MainFrameTest {

    @Test
    public void test_mainFrame() throws InterruptedException {
        MainFrame fr = new MainFrame("ERP工具箱");
        fr.init();

//        AdvertContainer adTabe = new AdvertContainer();
//        fr.add(adTabe);
//        Thread.sleep(100000);
//        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
