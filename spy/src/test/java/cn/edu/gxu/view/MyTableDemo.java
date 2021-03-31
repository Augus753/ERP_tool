package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/30 21:06
 * @Description
 */

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class MyTableDemo extends JPanel {
    private String[] columnNames = {"学号", "姓名", "年龄", "专业", "选取"};
    private Object[][] data = {{"001", "张三", new Integer(19), "计算机", new Boolean(true)},
            {"002", "李四", new Integer(20), "微电子", new Boolean(true)},
            {"003", "王五", new Integer(22), "数学", new Boolean(false)},
    };

    public MyTableDemo() {
        super(new GridLayout(1, 0));
        JTable table = new JTable(new MyTableModel(data, columnNames));
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        initColumnSizes(table);
        add(scrollPane);
    }

    private void initColumnSizes(JTable table) {
        MyTableModel model = (MyTableModel) table.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        Object[] longValues = model.longValues;
        TableCellRenderer headerRenderer =
                table.getTableHeader().getDefaultRenderer();
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            comp = headerRenderer.getTableCellRendererComponent(
                    null, column.getHeaderValue(),
                    false, false, 0, 0);
            headerWidth = comp.getPreferredSize().width;
            comp = table.getDefaultRenderer(
                    model.getColumnClass(i)).getTableCellRendererComponent(
                    table, longValues[i],
                    false, false, 0, i);
            cellWidth = comp.getPreferredSize().width;
            column.setPreferredWidth(Math.max(headerWidth, cellWidth));

        }
    }

    private static void CreateAndShowGUI() {
        JFrame frame = new JFrame("MyTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyTableDemo newContentPane = new MyTableDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAndShowGUI();
            }
        });
    }
}