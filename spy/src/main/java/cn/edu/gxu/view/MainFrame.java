package cn.edu.gxu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/17 21:58
 * @Description 主界面
 */
public class MainFrame extends JFrame implements ActionListener {
    private JTabbedPane mainTab = new JTabbedPane();

    private Menu menu1, adMenu, menu3, menu4;
    private MenuItem ad1, ad2, ad3, ad4, ad5, ad6; // 菜单项
    private Panel contentPanel; // 内容面板，其上用于添加其他待切换的面板

    public MainFrame(String title) {
        super(title);
    }

//    private String name;


    public void init() {
        //初始菜单栏
        addMenu();
        this.setSize(1200, 700);
        this.setBackground(Color.white);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //初始化广告解析
//        addAd();
        //初始化年末间谍
    }

    private void addMenu() {
        MenuItem item1, item2;
        MenuBar menubar = new MenuBar();
        menu1 = new Menu("文件");
        menu1.setActionCommand("F");

        item1 = new MenuItem("加载");
        menu1.add(item1);
        item2 = new MenuItem("初始化");
        menu1.add(item2);
//        menu1.setMnemonic('F');
        adMenu = new Menu("广告");
        // 菜单项广告事件监听器
        adMenu.addActionListener(this);
        {
            ad1 = new MenuItem("第一年");
            ad1.addActionListener(this);
            ad2 = new MenuItem("第二年");
            ad2.addActionListener(this);

            adMenu.add(ad1);
            adMenu.add(ad2);
        }
//        menu1.setActionCommand("E");
//        menu2.setMnemonic('F');
        menu3 = new Menu("年末间谍");
//        menu1.setActionCommand("V");

//        menu3.setMnemonic('V');

        menu4 = new Menu("帮助");
//        menu4.setMnemonic('O');
        menubar.add(menu1);
        menubar.add(adMenu);
        menubar.add(menu3);
        menubar.add(menu4);
        this.setMenuBar(menubar);


        contentPanel = new Panel();
        // 设置布局为边界布局管理器。将contentPanel添加到窗口中心位置。
        setLayout(new BorderLayout());
        contentPanel.add(new Label("欢迎使用ERP工具箱"));    // 欢迎页消息
        add(contentPanel, BorderLayout.CENTER);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == ad1) {
            System.out.println("第一年");
            showSpecifiedPanel(contentPanel, new AdvertPanel(1));
        } else if (source == ad2) {
            System.out.println("第二年");
            showSpecifiedPanel(contentPanel, new AdvertPanel(2));
        }
    }


    // 以contentPanel为底，其上覆盖想要展示的panel内容(切换panel)。
    private void showSpecifiedPanel(Panel contentPanel, JPanel showPanel) {
        contentPanel.removeAll();
        contentPanel.add(showPanel);
        contentPanel.validate();
        contentPanel.repaint();
    }

    // 简易地获取所需的面板(使用时需自定义)
    class MyPanel extends Panel {
        public MyPanel(String msg) {
            this.add(new Label(msg));
        }
    }


    public static void main(String[] args) {
        new MainFrame("ERP工具箱").init();
    }

}
