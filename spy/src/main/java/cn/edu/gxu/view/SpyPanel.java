package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 11:56
 * @Description 间谍
 */

import cn.edu.gxu.collect.CollectManager;
import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.pojo.GroupScoresPo;
import cn.edu.gxu.pojo.SpyPo;
import cn.edu.gxu.stat.JsonParser;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class SpyPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Object[][] data;
//    private Object[][] data = new Object[Constant.MAX_SCORE_NUM][10];

    private Object[] vName = {"组名", "利润", "权益", "OID", "现金", "贷款", "库存", "市场", "生产线", "排名"};

    JTextField scoreTf = new JTextField("请输入年末排名json报文");
    JTextField spyTf = new JTextField("请输入间谍结果json报文");

    JButton scoreButton = new JButton("添加经营结果");
    JButton spyButton = new JButton("添加间牒结果");

    Font font = new Font("黑体", Font.PLAIN, 15);
    //    private JTable table;
    private static MainFrame mainFrame;
    private static String year;

    public SpyPanel(String year, MainFrame mainFrame) {
        SpyPanel.mainFrame = mainFrame;
        SpyPanel.year = year;

        this.setBounds(0, 0, 1200, 700);
        this.setLayout(null);

        {//年末经营结果
            scoreTf.setBounds(50, 0, 220, 80);
            // 给文本框加上鼠标单击事件监听
            scoreTf.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    scoreTf.setText("");
                }
            });
            scoreButton.setBounds(80, 80, 150, 30);
            scoreButton.setFont(font);
            // 给按钮加上监听
            scoreButton.addActionListener(e -> {
                String s = scoreTf.getText().trim();
                showScoreData(s);
            });
        }

        {//间谍
            spyTf.setBounds(420, 0, 350, 80);
            // 给文本框加上鼠标单击事件监听
            spyTf.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    spyTf.setText("");
                }
            });
            spyButton.setBounds(520, 80, 150, 30);
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
        List<GroupScoresPo> scores;
        try {
            scores = new JsonParser().parseScore(text);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "请重新输入经营结果数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
//        年
        CollectManager.record(year + "_经营结果", text);

        CacheManager.setScore(year, scores);

        System.out.println("输入框：" + text);
        loadScore(scores);
        loadTable(data);
    }

    private void reloadData() {
        List<GroupScoresPo> scores = CacheManager.getScore(year);
        if (scores == null || scores.size() == 0) return;

        loadScore(scores);
        for (GroupScoresPo groupScoresPo : scores)
            loadSpy(groupScoresPo.getGroupName());

        //加载表格
        loadTable(data);
    }

    private void loadScore(List<GroupScoresPo> scores) {
//        data = new Object[scores.size()][vName.length];
        AtomicInteger i = new AtomicInteger();
        data = scores.stream().map(score -> {
            Object[] raw = new Object[vName.length];
            raw[0] = score.getGroupName();
            raw[1] = score.getGroupProfit();
            raw[2] = score.getGroupRights();
            raw[3] = String.format("%.2f", (score.getGroupScore() / (float) score.getGroupRights()));
            raw[vName.length - 1] = i.incrementAndGet();//排名
            return raw;
        }).toArray(Object[][]::new);
//        for (int i = 0; i < scores.size(); i++) {
//            GroupScoresPo score = scores.get(i);
//            data[i][0] = score.getGroupName();
//            data[i][1] = score.getGroupProfit();
//            data[i][2] = score.getGroupRights();
//            data[i][3] = String.format("%.2f", (score.getGroupScore() / (float) score.getGroupRights()));
//            data[i][vName.length - 1] = i + 1;//排名
//        }
    }

    private void showSpyData(String text) {
        if (Objects.isNull(data[0][0])) {
            JOptionPane.showMessageDialog(null, "请先输入经营结果数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        //文本框输入
        System.out.println("间谍输入框：" + text);
        SpyPo spyPo;
        try {
            spyPo = new JsonParser().parseSpy(text);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "请重新输入间谍结果数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        CollectManager.record(year + "_" + spyPo.getGroupName() + "_间谍", text);

        CacheManager.setSpy(CacheManager.generateGroupKey(year, spyPo.getGroupName()), spyPo);
        loadSpy(spyPo.getGroupName());
        loadTable(data);
    }

    private void loadSpy(String groupName) {
        SpyPo spyPo = CacheManager.getSpy(CacheManager.generateGroupKey(year, groupName));
        if (spyPo == null) return;
        int i = 0;
        for (; i < data.length; i++) {
            if (spyPo.getGroupName().equals(data[i][0])) {
                break;
            }
        }
        data[i][4] = spyPo.getCash();
        int loan = spyPo.getLongtermLoan() + spyPo.getShorttemLoan();
        data[i][5] = loan;
        data[i][6] = spyPo.getProduct() == null ? "-" : spyPo.getProduct().show();
        data[i][7] = spyPo.getCertificate() == null ? "-" : spyPo.getCertificate().showMarket();
        data[i][8] = spyPo.getProdLine() == null ? "-" : spyPo.getProdLine().show();
    }

    private void loadTable(Object[][] data) {

        TableModel table = new TableModel(data, vName);

//        table.setEnabled(false);
//        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
//        r.setHorizontalAlignment(JLabel.CENTER);
//        table.setDefaultRenderer(Object.class, r);
//        table.setRowHeight(25);// 设置表格行高
//        table.getTableHeader().setFont(new Font("Dialog", 0, 14));
//        table.setFont(new Font("Menu.font", Font.PLAIN, 14));

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 120, 1100, 580);
        add(jp);
//        table.setSelectionBackground(new Color(0));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int rowI = table.rowAtPoint(e.getPoint());// 得到table的行号
                    int columnI = table.columnAtPoint(e.getPoint());// 得到table的列号
                    String msg = "单击鼠标 " + rowI + "行" + columnI + "列" + (table.getModel()).getValueAt(rowI, columnI);
                    System.out.println(msg);
                    String key = CacheManager.generateGroupKey(year, data[rowI][0] + "");
                    SpyPo spyPo = CacheManager.getSpy(key);
                    if (spyPo != null) {
                        int groupRights = NumberUtils.toInt(data[rowI][2] + "");
                        int rank = NumberUtils.toInt(data[rowI][9] + "");
                        JSONObject content = new JSONObject();
                        content.put("groupRights", groupRights);
                        content.put("rank", rank);
                        new SpyDetailDialog(SpyPanel.mainFrame, spyPo, content).setVisible(true);
                    }
//                    JOptionPane.showMessageDialog(null, msg, "数据", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }


}
