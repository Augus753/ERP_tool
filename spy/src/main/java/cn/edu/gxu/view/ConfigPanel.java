package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 11:56
 * @Description
 */

import cn.edu.gxu.collect.CollectManager;
import cn.edu.gxu.constant.ResponseException;
import cn.edu.gxu.persist.CacheManager;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigPanel extends JPanel {

    private static Object[] productName = {"P1成本", "P2成本", "P3成本", "P4成本", "P5成本"};
    private static final boolean[] editable1 = new boolean[]{true, true, true, true, true};
    private Object[][] productData = new Object[1][productName.length];

    private static Object[] productLineName = {"费用名称", "手工线", "全自动", "柔线"};
    private static final boolean[] editable2 = new boolean[]{false, true, true, true};
    private Object[][] productLineData = new Object[3][productLineName.length];

    private static Object[] otherName = {"管理费(年)", "贷款倍数", "厂房租金"};
    private static final boolean[] editable3 = new boolean[]{true, true, true};
    private Object[][] otherData = new Object[1][otherName.length];

    private static String[] loginName = {"名称", "值"};
    private static final boolean[] editable4 = new boolean[]{false, true};
    private String[][] loginData = new String[3][groupName.length];

    private static String[] groupName = {"参赛组名", "参赛组名"};
    private static final boolean[] editable5 = new boolean[]{true, true};
    private String[][] groupData = new String[15][groupName.length];


    Font font = new Font("黑体", Font.PLAIN, 15);

    public ConfigPanel() {
        loadConfig();

        this.setBounds(100, 0, 900, 600);
        this.setLayout(null);
        showTable();
//        jp5.setBounds(20, 400, 300, 140);

        JButton loginButton = new JButton("登录测试");
        loginButton.setBounds(100, 530, 120, 40);
        loginButton.setFont(font);
        loginButton.addActionListener(e -> {
            try {
                CacheManager.getConfig().setLoginInfo(loginData[0][1]);
                CacheManager.getConfig().setUserName(loginData[1][1]);
                CacheManager.getConfig().setPassWord(loginData[2][1]);
                CollectManager.getInstance().login();
            } catch (ResponseException exception) {
                JOptionPane.showMessageDialog(this, exception.getErrMsg(), "登录失败",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "登录成功", "登录成功",
                    JOptionPane.PLAIN_MESSAGE);
        });

        JButton button = new JButton("修改");
        button.setBounds(600, 500, 100, 80);
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
            JOptionPane.showMessageDialog(this, "修改成功", "修改成功",
                    JOptionPane.PLAIN_MESSAGE);
        });


        this.add(loginButton);
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

        CacheManager.getConfig().setSgxDepreciation(Float.parseFloat(productLineData[1][1] + ""));
        CacheManager.getConfig().setQzdDepreciation(Float.parseFloat(productLineData[1][2] + ""));
        CacheManager.getConfig().setRxDepreciation(Float.parseFloat(productLineData[1][3] + ""));

        CacheManager.getConfig().setSgxUpKeep(Integer.parseInt(productLineData[2][1] + ""));
        CacheManager.getConfig().setQzdUpKeep(Integer.parseInt(productLineData[2][2] + ""));
        CacheManager.getConfig().setRxUpKeep(Integer.parseInt(productLineData[2][3] + ""));

        CacheManager.getConfig().setAdministration(Integer.parseInt(otherData[0][0] + ""));
        CacheManager.getConfig().setLoanTimes(Integer.parseInt(otherData[0][1] + ""));
        CacheManager.getConfig().setFactoryRent(Integer.parseInt(otherData[0][2] + ""));

        CacheManager.getConfig().setGroupNames(
                Stream.of(groupData)
                        .flatMap((Function<String[], Stream<?>>) strings -> Arrays.stream(strings.clone()))
                        .distinct()
                        .toArray(String[]::new));

        CacheManager.getConfig().setLoginInfo(loginData[0][1]);
        CacheManager.getConfig().setUserName(loginData[1][1]);
        CacheManager.getConfig().setPassWord(loginData[2][1]);
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
        otherData[0][2] = CacheManager.getConfig().getFactoryRent();

        for (int i = 0; i < CacheManager.getConfig().getGroupNames().length; i += 2) {
            groupData[i / 2][0] = CacheManager.getConfig().getGroupNames()[i];
            if (i < CacheManager.getConfig().getGroupNames().length - 1) {
                groupData[i / 2][1] = CacheManager.getConfig().getGroupNames()[i + 1];
            }
        }

        loginData[0][0] = "地址";
        loginData[1][0] = "账号";
        loginData[2][0] = "密码";
        loginData[0][1] = CacheManager.getConfig().getLoginInfo();
        loginData[1][1] = CacheManager.getConfig().getUserName();
        loginData[2][1] = CacheManager.getConfig().getPassWord();
    }

    private void showTable() {
        TableModel productTable = new TableModel(productData, productName, editable1);
//        productTable.setEditable();
        productTable.setRowHeight(40);
        JScrollPane jp = new JScrollPane(productTable);
        jp.setBounds(20, 20, 500, 80);
        add(jp);

        TableModel productLineTable = new TableModel(productLineData, productLineName, editable2);
        productLineTable.setRowHeight(40);
        JScrollPane jp2 = new JScrollPane(productLineTable);
        jp2.setBounds(20, 120, 500, 160);
        add(jp2);

        TableModel otherTable = new TableModel(otherData, otherName, editable3);
        otherTable.setRowHeight(40);
        JScrollPane jp3 = new JScrollPane(otherTable);
        jp3.setBounds(20, 300, 500, 80);
        add(jp3);

        TableModel loginTable = new TableModel(loginData, loginName, editable4);
        loginTable.setRowHeight(25);
        JScrollPane jp5 = new JScrollPane(loginTable);
        jp5.setBounds(20, 400, 300, 120);
        add(jp5);

        TableModel groupTable = new TableModel(groupData, groupName, editable5);
        groupTable.setRowHeight(25);
        JScrollPane jp4 = new JScrollPane(groupTable);
        jp4.setBounds(550, 20, 200, 410);
        add(jp4);


    }


}
