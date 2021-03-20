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

    private JMenu menu1, adMenu, menu3, orderMenu, menu4;
    private JMenuItem ad1, ad2, ad3, ad4, ad5, ad6; // 广告
    private JMenuItem spy1, spy2, spy3, spy4, spy5, spy6; // 间谍
    private JMenuItem order1, order2, order3, order4, order5, order6; // 间谍
    private Panel contentPanel = new Panel();
    ; // 内容面板，其上用于添加其他待切换的面板

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
        JMenuItem item1, item2;
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.WHITE);
        menu1 = new JMenu("文件");
        menu1.setActionCommand("F");
        menu1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        item1 = new JMenuItem("加载");
        menu1.add(item1);
        item2 = new JMenuItem("初始化");
        menu1.add(item2);
//        menu1.setMnemonic('F');
        adMenu = new JMenu("广告");
        adMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        // 菜单项广告事件监听器
        adMenu.addActionListener(this);
        {
            ad1 = new JMenuItem("第一年");
            ad1.addActionListener(this);
            ad2 = new JMenuItem("第二年");
            ad2.addActionListener(this);
            ad3 = new JMenuItem("第三年");
            ad3.addActionListener(this);
            ad4 = new JMenuItem("第四年");
            ad4.addActionListener(this);
            ad5 = new JMenuItem("第五年");
            ad5.addActionListener(this);
            ad6 = new JMenuItem("第六年");
            ad6.addActionListener(this);
            adMenu.add(ad1);
            adMenu.add(ad2);
            adMenu.add(ad3);
            adMenu.add(ad4);
            adMenu.add(ad5);
            adMenu.add(ad6);
        }
        //        menu1.setActionCommand("E");
        menu3 = new JMenu("年末间谍");
        menu3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        {
            spy1 = new JMenuItem("第一年");
            spy1.addActionListener(this);
            menu3.add(spy1);
            spy2 = new JMenuItem("第二年");
            spy2.addActionListener(this);
            menu3.add(spy2);
            spy3 = new JMenuItem("第三年");
            spy3.addActionListener(this);
            menu3.add(spy3);
            spy4 = new JMenuItem("第四年");
            spy4.addActionListener(this);
            menu3.add(spy4);
            spy5 = new JMenuItem("第五年");
            spy5.addActionListener(this);
            menu3.add(spy5);
            spy6 = new JMenuItem("第六年");
            spy6.addActionListener(this);
            menu3.add(spy6);
        }

//        menu1.setActionCommand("V");
//        menu3.setMnemonic('V');
        orderMenu = new JMenu("订单分析");
        orderMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        {
            order1 = new JMenuItem("第一年");
            order1.addActionListener(this);
            orderMenu.add(order1);
            order2 = new JMenuItem("第二年");
            order2.addActionListener(this);
            orderMenu.add(order2);
            order3 = new JMenuItem("第三年");
            order3.addActionListener(this);
            orderMenu.add(order3);
            order4 = new JMenuItem("第四年");
            order4.addActionListener(this);
            orderMenu.add(order4);
            order5 = new JMenuItem("第五年");
            order5.addActionListener(this);
            orderMenu.add(order5);
            order6 = new JMenuItem("第六年");
            order6.addActionListener(this);
            orderMenu.add(order6);
        }

        menu4 = new JMenu("帮助");
        menu4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
//        menu4.setMnemonic('O');
        menubar.add(menu1);
        menubar.add(adMenu);
        menubar.add(menu3);
        menubar.add(orderMenu);
        menubar.add(menu4);
        this.setJMenuBar(menubar);

        this.getContentPane().setLayout(null);
        contentPanel.setBounds(0, 64, 1000, 700);
        contentPanel.setVisible(true);
        contentPanel.setLayout(null);
        getContentPane().add(contentPanel);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == ad1) {
            System.out.println("第一年广告");
            showSpecifiedPanel(contentPanel, new AdvertPanel());
        } else if (source == spy1) {
            System.out.println("第一年间谍");
            showSpecifiedPanel(contentPanel, new SpyPanel("第一年", this));
        } else if (source == order1) {
            System.out.println("第一年间谍");
            showSpecifiedPanel(contentPanel, new OrderListPanel());
        }

    }


    // 以contentPanel为底，其上覆盖想要展示的panel内容(切换panel)。
    private void showSpecifiedPanel(Panel contentPanel, JPanel showPanel) {
        contentPanel.removeAll();
        contentPanel.add(showPanel);
        contentPanel.validate();
        contentPanel.repaint();
    }

    /**
     * 显示对话框
     */

    public void showDialog() {
        this.setVisible(false);
        JDialog dialog = new JDialog(this, true);
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.setSize(300, 180);
        dialog.setTitle("DialogTest");
        dialog.add(new JLabel("这个是对话框"));
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true); //显示对话框，窗口阻塞，不往下执行，只有等到对话框关闭了才往下执行。
        //判断主窗口是否是隐藏的，如果是隐藏的就显示
        if (!this.isVisible()) {
            this.setVisible(true);
        }

    }

    public static void main(String[] args) {
        new MainFrame("ERP工具箱").init();
    }

}
