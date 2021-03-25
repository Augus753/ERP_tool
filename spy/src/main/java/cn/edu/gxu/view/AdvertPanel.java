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
import cn.edu.gxu.constant.enums;
import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.pojo.AdvertPo;
import cn.edu.gxu.stat.JsonParser;

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

    Font font = new Font("黑体", Font.PLAIN, 15);
    private static String year;

    public AdvertPanel(String year) {
        AdvertPanel.year = year;
        this.setBounds(100, 0, 900, 700);

        this.setLayout(null);

        button.setBounds(540, 10, 100, 40);

        button.setFont(font);

        tf.setBounds(100, 0, 250, 60);

        // 给文本框加上鼠标单击事件监听
        tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                tf.setText("");
            }
        });

        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem(enums.Market.LOCAL_MARKET_1.marketName);
        cmb.addItem(enums.Market.REGIONAL_MARKET_2.marketName);
        cmb.addItem(enums.Market.DOMESTIC_MARKET_3.marketName);
        cmb.addItem(enums.Market.ASIA_MARKET_4.marketName);
        cmb.addItem(enums.Market.GLOBAL_MARKET_5.marketName);
        cmb.setBounds(400, 10, 100, 40);

        for (int i = 0; i < data.length; i++) {
            data[i][0] = i + 1;
        }
        showAllData();
        // 给按钮加上监听
        button.addActionListener(e -> {
            String s = tf.getText().trim();
            showData(s);
        });

        this.add(cmb);
        this.add(tf);
        this.add(button);
        this.setVisible(true);
    }

    private void showAllData() {
        for (enums.Market market : enums.Market.values())
            loadAd(market.marketName);
        loadTable(data);
    }

    private void showData(String text) {

        //文本框输入
        String market = Objects.requireNonNull(cmb.getSelectedItem()).toString();
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
            CollectManager.record(year + "_" + market + "_广告", text);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "请输入广告数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
        }

        loadAd(market);
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
        jp.setBounds(0, 70, 800, 630);
        add(jp);
    }
}
