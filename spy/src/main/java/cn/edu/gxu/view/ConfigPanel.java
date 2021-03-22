package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 11:56
 * @Description
 */

import cn.edu.gxu.persist.CacheManager;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {

    private static Object[] productName = {"P1成本", "P2成本", "P3成本", "P4成本", "P5成本"};
    private Object[][] productData = new Object[1][productName.length];

    private static Object[] productLineName = {"费用名称", "手工线", "全自动", "柔线"};
    private Object[][] productLineData = new Object[3][productLineName.length];

    private static Object[] otherName = {"管理费(年)", "贷款倍数"};
    private Object[][] otherData = new Object[1][otherName.length];


    Font font = new Font("黑体", Font.PLAIN, 15);

    public ConfigPanel() {
        loadConfig();

        this.setBounds(100, 0, 900, 600);
        this.setLayout(null);
//        data[0][1] = 20;
//        产品成本配置
        showTable();

        JButton button = new JButton("修改");
        button.setBounds(540, 300, 100, 80);
        button.setFont(font);

        button.addActionListener(e -> {
            try {
                save();
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "修改失败", "修改失败",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            showTable();
        });

        this.add(button);
        this.setVisible(true);
    }

    private void save() {
        CacheManager.getConfig().setP1Cost(Integer.parseInt(productData[0][0] + ""));
        CacheManager.getConfig().setP2Cost(Integer.parseInt(productData[0][1] + ""));
        CacheManager.getConfig().setP3Cost(Integer.parseInt(productData[0][2] + ""));
        CacheManager.getConfig().setP4Cost(Integer.parseInt(productData[0][3] + ""));
        CacheManager.getConfig().setP5Cost(Integer.parseInt(productData[0][4] + ""));

        CacheManager.getConfig().setSgxProductTimes(Integer.parseInt(productLineData[0][1] + ""));
        CacheManager.getConfig().setQzdProductTimes(Integer.parseInt(productLineData[0][2] + ""));
        CacheManager.getConfig().setRxProductTimes(Integer.parseInt(productLineData[0][3] + ""));

        CacheManager.getConfig().setSgxDepreciation(Integer.parseInt(productLineData[1][1] + ""));
        CacheManager.getConfig().setQzdDepreciation(Integer.parseInt(productLineData[1][2] + ""));
        CacheManager.getConfig().setRxDepreciation(Integer.parseInt(productLineData[1][3] + ""));

        CacheManager.getConfig().setSgxUpKeep(Integer.parseInt(productLineData[2][1] + ""));
        CacheManager.getConfig().setQzdUpKeep(Integer.parseInt(productLineData[2][2] + ""));
        CacheManager.getConfig().setRxUpKeep(Integer.parseInt(productLineData[2][3] + ""));

        CacheManager.getConfig().setAdministration(Integer.parseInt(otherData[0][0] + ""));
        CacheManager.getConfig().setLoanTimes(Integer.parseInt(otherData[0][1] + ""));
    }

    private void loadConfig() {
        productData[0][0] = CacheManager.getConfig().getP1Cost();
        productData[0][1] = CacheManager.getConfig().getP2Cost();
        productData[0][2] = CacheManager.getConfig().getP3Cost();
        productData[0][3] = CacheManager.getConfig().getP4Cost();
        productData[0][4] = CacheManager.getConfig().getP5Cost();

        productLineData[0][0] = "生产时间(天)";
        productLineData[1][0] = "折旧";
        productLineData[2][0] = "维修费";
        productLineData[0][1] = CacheManager.getConfig().getSgxProductTimes();
        productLineData[0][2] = CacheManager.getConfig().getQzdProductTimes();
        productLineData[0][3] = CacheManager.getConfig().getRxProductTimes();
        productLineData[1][1] = CacheManager.getConfig().getSgxDepreciation();
        productLineData[1][2] = CacheManager.getConfig().getQzdDepreciation();
        productLineData[1][3] = CacheManager.getConfig().getRxDepreciation();
        productLineData[2][1] = CacheManager.getConfig().getSgxUpKeep();
        productLineData[2][2] = CacheManager.getConfig().getQzdUpKeep();
        productLineData[2][3] = CacheManager.getConfig().getRxUpKeep();

        otherData[0][0] = CacheManager.getConfig().getAdministration();
        otherData[0][1] = CacheManager.getConfig().getLoanTimes();
    }

    private void showTable() {
        TableModel productTable = new TableModel(productData, productName);
        productTable.setEditable();
        productTable.setRowHeight(40);
        JScrollPane jp = new JScrollPane(productTable);
        jp.setBounds(20, 20, 500, 80);
        add(jp);

        TableModel productLineTable = new TableModel(productLineData, productLineName);
        productLineTable.setEditable();
        productLineTable.setRowHeight(40);
        JScrollPane jp2 = new JScrollPane(productLineTable);
        jp2.setBounds(20, 120, 500, 160);
        add(jp2);

        TableModel otherTable = new TableModel(otherData, otherName);
        otherTable.setEditable();
        otherTable.setRowHeight(40);
        JScrollPane jp3 = new JScrollPane(otherTable);
        jp3.setBounds(20, 300, 500, 80);
        add(jp3);
    }


}
