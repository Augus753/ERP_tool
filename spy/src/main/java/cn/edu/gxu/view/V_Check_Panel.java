package cn.edu.gxu.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 9:42
 * @Description
 */
public class V_Check_Panel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Object[] v_name = {"序号", "姓名", "性别", "年龄", "学校"};
    private Object[][] data = {{1, "名字", "M", "11", "学校"}};

    JTable table = null;

    public V_Check_Panel() {

        this.setBounds(0, 64, 722, 361);

        this.setLayout(null);

        //传入一个二维数组，传入一个一维数组
        table = new JTable(data, v_name);
        table.setEnabled(false);
        table.setFont(new Font("Menu.font", Font.PLAIN, 15));

        table.setRowHeight(20);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 702, 341);

        this.add(scrollPane);
        this.setVisible(true);
    }

}

