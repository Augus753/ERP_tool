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
import cn.edu.gxu.pojo.Advert;
import cn.edu.gxu.stat.JsonParser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class AdvertPanel extends JPanel {

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

    JTextField tf = new JTextField("请输入广告json报文");

    JButton button = new JButton("添加");

    Font font = new Font("黑体", Font.PLAIN, 15);

    public AdvertPanel() {

        this.setBounds(100, 0, 738, 514);

        this.setLayout(null);

        button.setBounds(540, 10, 100, 30);

        button.setFont(font);

        tf.setBounds(100, 0, 250, 50);

        // 给文本框加上鼠标单击事件监听
        tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                tf.setText("");
            }
        });

        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem(enums.Market.LOCAL_MARKET.marketName);
        cmb.addItem(enums.Market.REGIONAL_MARKET.marketName);
        cmb.addItem(enums.Market.DOMESTIC_MARKET.marketName);
        cmb.addItem(enums.Market.ASIA_MARKET.marketName);
        cmb.addItem(enums.Market.GLOBAL_MARKET.marketName);
        cmb.setBounds(400, 10, 100, 30);

        for (int i = 0; i < data.length; i++) {
            data[i][0] = i + 1;
        }
        showData("", true);
        // 给按钮加上监听
        button.addActionListener(e -> {
            String s = tf.getText().trim();
            showData(s, false);

        });

        this.add(cmb);
        this.add(tf);
        this.add(button);
        this.setVisible(true);
    }

    private void showData(String text, boolean reload) {

        if (reload) {
            //加载文件
        } else {
            //文本框输入
            String value = Objects.requireNonNull(cmb.getSelectedItem()).toString();
            System.out.println("下拉列表：" + value);
            System.out.println("输入框：" + text);

            if ("--请选择--".equals(value)) {
                JOptionPane.showMessageDialog(cmb, "请选择市场", "输入错误",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int i = 0;
            for (; i < vName.length; i++) {
                if (vName[i].equals(value)) {
                    break;
                }
            }
            List<Advert> ads = new JsonParser().parseAd(text);
            int endNum = Math.min(ads.size(), Constant.MAX_AD_NUM);
            for (int j = 0; j < endNum; j++) {
                Advert ad = ads.get(j);
                String group = "  (" + ad.getGroupName().substring(1, ad.getGroupName().length() - 1) + " ";
                if (group.length() < 6) group = "  " + group;
                data[j][i] = ad.getPublicity() + group;
            }
        }
        if (data == null) return;
        loadTable(data);
    }

    private void loadTable(Object[][] data) {
        JTable table = new JTable(data, vName);

        table.setEnabled(false);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.RIGHT);
        table.setDefaultRenderer(Object.class, r);
        table.setRowHeight(25);// 设置表格行高
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getTableHeader().setFont(new Font("Dialog", 0, 14));
        table.setFont(new Font("Menu.font", Font.PLAIN, 14));


        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 60, 738, 514);
        // 匿名内部类调用this 需要类名的this
        AdvertPanel.this.add(jp);
    }
}
