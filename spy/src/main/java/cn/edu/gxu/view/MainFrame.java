package cn.edu.gxu.view;

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.persist.CacheManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/17 21:58
 * @Description 主界面
 */
public class MainFrame extends JFrame implements ActionListener {

    private JMenu fileMenu, adMenu, spyMenu, orderMenu, forecastMenu, helpMenu;

    JMenuItem openFileItem, item2, clearItem, configMenuItem;

    private Map<String, JMenuItem> adMenuItem = new HashMap<>();
    private Map<String, JMenuItem> orderMenuItem = new HashMap<>();
    private Map<String, JMenuItem> spyMenuItem = new HashMap<>();
    private Map<String, JMenuItem> forecastMenuItem = new HashMap<>();

    private Panel contentPanel = new Panel();
    // 内容面板，其上用于添加其他待切换的面板
    private Font menuFont = new Font("微软雅黑", Font.PLAIN, 16);

    public MainFrame(String title) {
        super(title);
    }

    public void init() {
        commonStyle();
        //初始菜单栏
        addMenu();

        this.setSize(1200, 760);
        this.setBackground(Color.white);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void commonStyle() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void addMenu() {
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.WHITE);
        fileMenu = new JMenu("文件");
        fileMenu.setActionCommand("F");
        fileMenu.setFont(menuFont);

        {
            openFileItem = new JMenuItem("加载文件");
            openFileItem.setFont(menuFont);
            openFileItem.addActionListener(e -> {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(openFileItem) == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        if (!file.exists()) file.createNewFile();
                        CacheManager.reload(file);
                        JOptionPane.showMessageDialog(this, "加载完成");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        JOptionPane.showMessageDialog(this, "加载文件失败", "打开错误",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            fileMenu.add(openFileItem);
            item2 = new JMenuItem("保存");
            item2.setFont(menuFont);
            item2.addActionListener(e -> {
                try {
                    CacheManager.flush();
                    JOptionPane.showMessageDialog(this, "保存完成");
                } catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(this, "保存文件失败", "文件错误",
                            JOptionPane.ERROR_MESSAGE);
                }
            });
            fileMenu.add(item2);

            clearItem = new JMenuItem("初始化");
            clearItem.setFont(menuFont);
            clearItem.addActionListener(e -> {
                int opt = JOptionPane.showConfirmDialog(this,
                        "确认初始化数据?", "确认信息",
                        JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    //确认继续操作
                    try {
                        CacheManager.clear();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        JOptionPane.showMessageDialog(this, "初始化失败", "文件错误",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            fileMenu.add(clearItem);

            configMenuItem = new JMenuItem("参数配置");
            configMenuItem.setFont(menuFont);
            configMenuItem.addActionListener(this);
            fileMenu.add(configMenuItem);
        }

//        menu1.setMnemonic('F');
        adMenu = new JMenu("广告");
        adMenu.setFont(menuFont);
        {
            for (String year : Constant.RUN_YEAR) {
                JMenuItem ad = new JMenuItem(year);
                ad.addActionListener(this);
                ad.setFont(menuFont);
                adMenu.add(ad);
                adMenuItem.put(year, ad);
            }
        }
        //        menu1.setActionCommand("E");
        spyMenu = new JMenu("年末间谍");
        spyMenu.setFont(menuFont);
        {
            for (String year : Constant.RUN_YEAR) {
                JMenuItem spyMenu = new JMenuItem(year);
                spyMenu.addActionListener(this);
                spyMenu.setFont(menuFont);
                this.spyMenu.add(spyMenu);
                spyMenuItem.put(year, spyMenu);
            }
        }

        orderMenu = new JMenu("订单分析");
        orderMenu.setFont(menuFont);
        {
            for (String year : Constant.RUN_YEAR) {
                JMenuItem orderItem = new JMenuItem(year);
                orderItem.addActionListener(this);
                orderItem.setFont(menuFont);
                orderMenu.add(orderItem);
                orderMenuItem.put(year, orderItem);
            }
        }

        forecastMenu = new JMenu("经营预测");
        forecastMenu.setFont(menuFont);
        {
            for (int i = 1; i < Constant.RUN_YEAR.length; i++) {
                String year = Constant.RUN_YEAR[i];
                JMenuItem forecastItem = new JMenuItem(year);
                forecastItem.addActionListener(this);
                forecastItem.setFont(menuFont);
                forecastMenu.add(forecastItem);
                forecastMenuItem.put(year, forecastItem);
            }
        }

        helpMenu = new JMenu("关于");
        helpMenu.setFont(menuFont);
        helpMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new AboutDetailDialog(MainFrame.this).setVisible(true);
            }
        });


        menubar.add(fileMenu);
        menubar.add(adMenu);
        menubar.add(orderMenu);
        menubar.add(spyMenu);
        menubar.add(forecastMenu);
        menubar.add(helpMenu);
        this.setJMenuBar(menubar);

        this.getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 1200, 750);
        contentPanel.setVisible(false);
        contentPanel.setLayout(null);
        getContentPane().add(contentPanel);
        contentPanel.add(new ConfigPanel());
//        BlackPicPanel mainPanel = new BlackPicPanel("background.jpg");
//        mainPanel.setBounds(0, 0, 1200, 700);
//        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        contentPanel.setVisible(true);
        for (Map.Entry<String, JMenuItem> entry : adMenuItem.entrySet()) {
            if (source == entry.getValue()) {
                System.out.println(entry.getKey() + " 广告");
                showSpecifiedPanel(contentPanel, new AdvertPanel(entry.getKey()));
                return;
            }
        }
        for (Map.Entry<String, JMenuItem> entry : orderMenuItem.entrySet()) {
            if (source == entry.getValue()) {
                System.out.println(entry.getKey() + " 订单");
                showSpecifiedPanel(contentPanel, new OrderListPanel(entry.getKey()));
                return;
            }
        }
        for (Map.Entry<String, JMenuItem> entry : spyMenuItem.entrySet()) {
            if (source == entry.getValue()) {
                System.out.println(entry.getKey() + " 间谍");
                showSpecifiedPanel(contentPanel, new SpyPanel(entry.getKey(), this));
                return;
            }
        }

        for (Map.Entry<String, JMenuItem> entry : forecastMenuItem.entrySet()) {
            if (source == entry.getValue()) {
                System.out.println(entry.getKey() + " 经营预测");
                showSpecifiedPanel(contentPanel, new ForecastPanel(entry.getKey()));
                return;
            }
        }
        if (source == configMenuItem) {
            System.out.println(" 参数配置");
            showSpecifiedPanel(contentPanel, new ConfigPanel());
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
     * 自动保存
     */
    public static void flushTimer() {
        java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------延迟10分钟执行，每10分钟执行一次--------");
                try {
                    CacheManager.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000 * 60 * 10, 1000 * 60 * 10);
    }

    public static void main(String[] args) {
        new MainFrame("ERP对手分析").init();
        System.out.println("页面布局完成");
        CacheManager.reload();
        flushTimer();
        System.out.println("启动成功");
    }

}
