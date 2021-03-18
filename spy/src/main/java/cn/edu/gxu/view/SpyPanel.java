package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 11:56
 * @Description 间谍
 */

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.constant.enums;
import cn.edu.gxu.pojo.Advert;
import cn.edu.gxu.pojo.GroupScores;
import cn.edu.gxu.pojo.SpyDao;
import cn.edu.gxu.stat.JsonParser;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

public class SpyPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Object[][] data = new Object[Constant.MAX_SCORE_NUM][10];

    private Object[] vName = {"组名", "利润", "权益", "OID", "现金", "贷款", "库存", "市场", "生产线", "排名"};

    JTextField scoreTf = new JTextField("请输入年末排名json报文");
    JTextField spyTf = new JTextField("请输入间谍结果json报文");

    JButton scoreButton = new JButton("添加经营结果");
    JButton spyButton = new JButton("添加间牒结果");

    Font font = new Font("黑体", Font.PLAIN, 15);


    public SpyPanel() {

        this.setBounds(100, 0, 900, 700);

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
            // 给按钮加上监听
            scoreButton.addActionListener(e -> {
                String s = scoreTf.getText().trim();
                showScoreData(s);
            });
        }

        {//间谍
            spyTf.setBounds(320, 0, 350, 80);
            // 给文本框加上鼠标单击事件监听
            spyTf.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    spyTf.setText("");
                }
            });
            spyButton.setBounds(400, 90, 150, 20);
            spyButton.setFont(font);
            // 给按钮加上监听
            spyButton.addActionListener(e -> {
                String s = spyTf.getText().trim();
                showSpyData(s);
            });
        }


        reloadData();


        this.add(scoreTf);
        this.add(spyTf);
        this.add(scoreButton);
        this.add(spyButton);
        this.setVisible(true);
    }

    private void showScoreData(String text) {
        List<GroupScores> scores;
        try {
            scores = new JsonParser().parseScore(text);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "请重新输入经营结果数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("输入框：" + text);
        for (int i = 0; i < scores.size(); i++) {
            GroupScores score = scores.get(i);
            data[i][0] = score.getGroupName();
            data[i][1] = score.getGroupProfit();
            data[i][2] = score.getGroupRights();
            data[i][3] = String.format("%.2f", (score.getGroupScore() / (float) score.getGroupRights()));
            data[i][vName.length - 1] = i;
        }
        //加载文件
        loadTable(data);
    }

    private void reloadData() {
        //加载文件
        loadTable(data);
    }

    private void showSpyData(String text) {
        if (Objects.isNull(data[0][0])) {
            JOptionPane.showMessageDialog(null, "请先输入经营结果数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        //文本框输入
        System.out.println("间谍输入框：" + text);
        SpyDao spyDao;
        try {
            spyDao = new JsonParser().parseSpy(text);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "请重新输入间谍结果数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int i = 0;
        for (; i < data.length; i++) {
            if (spyDao.getGroupName().equals(data[i][0])) {
                break;
            }
        }
        data[i][4] = spyDao.getCash();
        int loan = spyDao.getLongtermLoan() + spyDao.getShorttemLoan();
        System.out.println(spyDao.getLongtermLoan() + "---" + spyDao.getShorttemLoan() + "---loan:" + loan);
        data[i][5] = loan;
        data[i][6] = spyDao.getProduct().show();
        data[i][7] = spyDao.getCertificate().show();
        data[i][8] = spyDao.getProdLine().show();
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
        jp.setBounds(0, 120, 900, 700);
        // 匿名内部类调用this 需要类名的this
        SpyPanel.this.add(jp);
    }
}
