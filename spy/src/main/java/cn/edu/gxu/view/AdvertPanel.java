package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 11:56
 * @Description
 */

import cn.edu.gxu.collect.CollectManager;
import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.constant.ResponseException;
import cn.edu.gxu.constant.enums;
import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.pojo.AdvertPo;
import cn.edu.gxu.stat.JsonParser;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

public class AdvertPanel extends JPanel {

    /**
     *
     */
    private JComboBox cmb = new JComboBox();    //下拉列表
    private Object[][] data = new Object[Constant.MAX_AD_NUM][enums.Market.values().length + 1];

    private Object[] vName = {"排名",
            enums.Market.LOCAL_MARKET_1.marketName,
            enums.Market.REGIONAL_MARKET_2.marketName,
            enums.Market.DOMESTIC_MARKET_3.marketName,
            enums.Market.ASIA_MARKET_4.marketName,
            enums.Market.GLOBAL_MARKET_5.marketName};

    JTextField tf = new JTextField("请输入广告json报文");
    JButton button = new JButton("添加");
    JButton collectButton = new JButton("自动获取广告");
    JButton finishButton = new JButton("结束获取");

    Font font = new Font("黑体", Font.PLAIN, 15);
    private static String year;

    public AdvertPanel(String year) {
        AdvertPanel.year = year;
        this.setBounds(50, 0, 1050, 700);
        this.setLayout(null);

        JLabel yearLabel = new JLabel(year);
        yearLabel.setFont(new Font("黑体", Font.PLAIN, 26));
        yearLabel.setBounds(30, 0, 100, 60);

        tf.setBounds(150, 0, 250, 60);
        // 给文本框加上鼠标单击事件监听
        tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                tf.setText("");
            }
        });

        button.setBounds(530, 10, 100, 40);
        button.setFont(font);


        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem(enums.Market.LOCAL_MARKET_1.marketName);
        cmb.addItem(enums.Market.REGIONAL_MARKET_2.marketName);
        cmb.addItem(enums.Market.DOMESTIC_MARKET_3.marketName);
        cmb.addItem(enums.Market.ASIA_MARKET_4.marketName);
        cmb.addItem(enums.Market.GLOBAL_MARKET_5.marketName);
        cmb.setBounds(410, 10, 100, 40);

        for (int i = 0; i < data.length; i++) {
            data[i][0] = i + 1;
        }
        showAllData();
        // 给按钮加上监听
        button.addActionListener(e -> {
            String s = tf.getText().trim();
            showData(s);
        });


        collectButton.setBounds(670, 10, 120, 40);
        collectButton.setFont(font);
        collectButton.addActionListener(e -> {
            try {
                collectAndShow();
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "自动获取广告信息失败", "自动获取数据失败",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "获取中", "自动获取数据",
                    JOptionPane.PLAIN_MESSAGE);
        });

        finishButton.setBounds(800, 10, 100, 40);
        finishButton.setFont(font);
        finishButton.addActionListener(e -> {
            try {
                CacheManager.getInstance().getAutoCollectAd().interrupted();
//                Thread.activeCount()
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "停止自动获取广告失败", "自动获取数据失败",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "停止自动获取广告成功", "自动获取数据成功",
                    JOptionPane.PLAIN_MESSAGE);
        });

        this.add(yearLabel);
        this.add(cmb);
        this.add(tf);
        this.add(button);
        this.add(collectButton);
        this.add(finishButton);
        this.setVisible(true);

        CacheManager.getInstance().setAutoCollectAd(new Thread(() -> {
            try {
                JSONObject result = CollectManager.getInstance().getAdInfo();
                for (enums.Market m : enums.Market.values()) {
                    System.out.println("添加" + m.marketName);
                    Object data = result.get(m.marketName + "市场");
                    if (data != null) {
                        showData((String) data, m.marketName, false);
                    }
                }
                loadTable(data);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("添加获取广告线程");
        }));
    }

    private void collectAndShow() throws Exception {
        CollectManager.getInstance().login();
        CacheManager.getInstance().getAutoCollectAd().start();
    }

    private void showAllData() {
        for (enums.Market market : enums.Market.values())
            loadAd(market.marketName);
        loadTable(data);
    }

    private void showData(String text) {

        //文本框输入
        String market = Objects.requireNonNull(cmb.getSelectedItem()).toString();
        showData(text, market, true);
    }

    private void showData(String text, String market, boolean load) {
//        System.out.println("下拉列表：" + value);
//        System.out.println("输入框：" + text);

        if ("--请选择--".equals(market)) {
            JOptionPane.showMessageDialog(cmb, "请选择市场", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            List<AdvertPo> ads = new JsonParser().parseAd(text);
            String key = CacheManager.generateMarketKey(year, market);
            CacheManager.setAd(key, ads);

//            年_市场
            CollectManager.getInstance().record(year + "_" + market + "_广告", text);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "请输入广告数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
        }

        loadAd(market);
        if (load)
            loadTable(data);
    }

    private void loadAd(String market) {
        int i = 0;
        for (; i < vName.length; i++) {
            if (vName[i].equals(market)) {
                break;
            }
        }
        String key = CacheManager.generateMarketKey(year, market);
        List<AdvertPo> ads = CacheManager.getAd(key);
        if (ads == null || ads.size() == 0) return;
        int endNum = Math.min(ads.size(), Constant.MAX_AD_NUM);
        for (int j = 0; j < endNum; j++) {
            AdvertPo ad = ads.get(j);
            String group = "  (" + ad.getGroupName().substring(1, ad.getGroupName().length() - 1) + " ";
            if (group.length() < 6) group = "  " + group;
            data[j][i] = ad.getPublicity() + group;
        }
    }

    private void loadTable(Object[][] data) {
        if (data == null) return;


        TableModel table = new TableModel(data, vName);

//        JTable table = new JTable(data, vName);
//        table.setEnabled(false);
//        DefaultTableColumnModel thr = new DefaultTableColumnModel();
//        thr.setColumnSelectionAllowed(JLabel.CENTER);
//        table.getTableHeader().setDefaultRenderer(thr);

//        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
//        r.setHorizontalAlignment(JLabel.RIGHT);
//        table.setDefaultRenderer(Object.class, r);
//        table.setRowHeight(25);// 设置表格行高
////        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        table.getTableHeader().setFont(new Font("Dialog", 0, 14));
//        table.setFont(new Font("Menu.font", Font.PLAIN, 15));

        for (int i = 1; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(130);
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(50, 70, 850, 630);
        add(jp);
    }
}
