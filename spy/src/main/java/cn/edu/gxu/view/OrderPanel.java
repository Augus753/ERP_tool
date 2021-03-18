package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 11:56
 * @Description 间谍
 */

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.pojo.Advert;
import cn.edu.gxu.stat.JsonParser;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class OrderPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Object[][] data = new Object[Constant.MAX_SCORE_NUM][10];

    private Object[] vName = {"组名", "利润", "权益", "OID", "毛利", "现金", "贷款", "库存", "市场", "生产线"};

    JTextField scoreTf = new JTextField("请输入年末排名json报文");
    JTextField spyTf = new JTextField("请输入间谍结果json报文");

    JButton scoreButton = new JButton("添加经营结果");
    JButton spyButton = new JButton("添加间牒结果");

    Font font = new Font("黑体", Font.PLAIN, 15);

    public OrderPanel() {

        this.setBounds(100, 0, 800, 514);

        this.setLayout(null);

        {//年末经营结果
            scoreTf.setBounds(50, 0, 200, 80);
            // 给文本框加上鼠标单击事件监听
            scoreTf.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    scoreTf.setText("");
                }
            });
            scoreButton.setBounds(80, 90, 150, 20);
            scoreButton.setFont(font);
        }

        {//间谍
            spyTf.setBounds(320, 0, 350, 80);
            // 给文本框加上鼠标单击事件监听
            spyTf.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    scoreTf.setText("");
                }
            });
            spyButton.setBounds(400, 90, 150, 20);
            spyButton.setFont(font);
        }


        showData("", true);
        // 给按钮加上监听
        scoreButton.addActionListener(e -> {
            String s = scoreTf.getText().trim();
            showData(s, false);

        });

        this.add(scoreTf);
        this.add(spyTf);
        this.add(scoreButton);
        this.add(spyButton);
        this.setVisible(true);
    }

    private void showData(String text, boolean reload) {

        if (reload) {
            //加载文件
        } else {
            //文本框输入
            System.out.println("输入框：" + text);

//            if ("--请选择--".equals(value)) {
//                JOptionPane.showMessageDialog(cmb, "请选择市场", "输入错误",
//                        JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            int i = 0;
//            for (; i < vName.length; i++) {
//                if (vName[i].equals(value)) {
//                    break;
//                }
//            }
            List<Advert> ads = new JsonParser().parseAd(text);
            int endNum = Math.min(ads.size(), Constant.MAX_AD_NUM);
            for (int j = 0; j < endNum; j++) {
                Advert ad = ads.get(j);
                String group = "  (" + ad.getGroupName().substring(1, ad.getGroupName().length() - 1) + " ";
                if (group.length() < 6) group = "  " + group;
//                data[j][i] = ad.getPublicity() + group;
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
        table.getTableHeader().setFont(new Font("Dialog", 0, 14));
        table.setFont(new Font("Menu.font", Font.PLAIN, 14));


        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 120, 738, 514);
        // 匿名内部类调用this 需要类名的this
        OrderPanel.this.add(jp);
    }
}
