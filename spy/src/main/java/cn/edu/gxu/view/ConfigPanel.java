package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 11:56
 * @Description
 */

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.constant.enums;
import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.pojo.Advert;
import cn.edu.gxu.stat.JsonParser;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

public class ConfigPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JComboBox cmb = new JComboBox();    //下拉列表
    private Object[][] data = new Object[Constant.MAX_AD_NUM][enums.Market.values().length + 1];

    private Object[] vName = {"排名",
            enums.Market.LOCAL_MARKET.marketName,
            enums.Market.REGIONAL_MARKET.marketName,
            enums.Market.DOMESTIC_MARKET.marketName,
            enums.Market.ASIA_MARKET.marketName,
            enums.Market.GLOBAL_MARKET.marketName};

    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();
    JTextField tf5 = new JTextField();

    JButton button = new JButton("修改");

    Font font = new Font("黑体", Font.PLAIN, 15);
    private static String year;

    public ConfigPanel(String year) {
        ConfigPanel.year = year;
        this.setBounds(100, 0, 900, 460);
        this.setLayout(null);

        button.setBounds(540, 10, 100, 30);
        button.setFont(font);

//        CacheManager.getAd();
        JLabel l1 = new JLabel("P1 成本：");
        l1.setFont(font);
        l1.setBounds(100, 50, 50, 30);
        add(l1);
        tf1.setBounds(200, 50, 100, 30);

        JLabel l2 = new JLabel("P2 成本：");
        l2.setFont(font);
        l2.setBounds(100, 90, 50, 30);
        add(l2);
        tf2.setBounds(200, 90, 100, 30);

        JLabel l3 = new JLabel("P3 成本：");
        l3.setFont(font);
        l3.setBounds(100, 130, 50, 30);
        add(l3);
        tf3.setBounds(200, 130, 100, 30);


        JLabel l4 = new JLabel("P4 成本：");
        l4.setFont(font);
        l4.setBounds(100, 170, 50, 30);
        add(l4);
        tf4.setBounds(200, 170, 100, 30);


        JLabel l5 = new JLabel("P5 成本：");
        l5.setFont(font);
        l5.setBounds(100, 210, 50, 30);
        add(l5);
        tf5.setBounds(200, 210, 100, 30);


        showAllData();
        // 给按钮加上监听
        button.addActionListener(e -> {
            String s = tf1.getText().trim();
            showData(s);
        });

        this.add(cmb);
        this.add(tf1);
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
        String value = Objects.requireNonNull(cmb.getSelectedItem()).toString();
        System.out.println("下拉列表：" + value);
        System.out.println("输入框：" + text);

        if ("--请选择--".equals(value)) {
            JOptionPane.showMessageDialog(cmb, "请选择市场", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            List<Advert> ads = new JsonParser().parseAd(text);
            String key = CacheManager.generateMarketKey(year, value);
            CacheManager.setAd(key, ads);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "请输入广告数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
        }

        loadAd(value);
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
        List<Advert> ads = CacheManager.getAd(key);
        if (ads == null || ads.size() == 0) return;
        int endNum = Math.min(ads.size(), Constant.MAX_AD_NUM);
        for (int j = 0; j < endNum; j++) {
            Advert ad = ads.get(j);
            String group = "  (" + ad.getGroupName().substring(1, ad.getGroupName().length() - 1) + " ";
            if (group.length() < 6) group = "  " + group;
            data[j][i] = ad.getPublicity() + group;
        }
    }

    private void loadTable(Object[][] data) {
        if (data == null) return;

        JTable table = new JTable(data, vName);

        table.setEnabled(false);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.RIGHT);
        table.setDefaultRenderer(Object.class, r);
        table.setRowHeight(25);// 设置表格行高
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getTableHeader().setFont(new Font("Dialog", 0, 14));
        table.setFont(new Font("Menu.font", Font.PLAIN, 15));

        for (int i = 1; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(130);
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 60, 800, 400);
        // 匿名内部类调用this 需要类名的this
        ConfigPanel.this.add(jp);
    }
}
