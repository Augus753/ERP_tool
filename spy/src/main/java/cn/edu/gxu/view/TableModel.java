package cn.edu.gxu.view;

import javax.swing.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Vector;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/22 15:10
 * @Description
 */
public class TableModel extends JTable {

    //    boolean editable = false;
    boolean[] editables;

    public TableModel(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        defaultTable();
    }

    public TableModel(Object[][] rowData, Object[] columnNames, boolean[] editable) {
        super(rowData, columnNames);
        this.editables = editable;
        defaultTable();
    }


    private void defaultTable() {
        setRowHeight(25);// 设置表格行高
        getTableHeader().setFont(new Font("Dialog", 0, 15));
        setFont(new Font("Menu.font", Font.PLAIN, 15));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class, r);
        adjustTableColumnWidths(this);
    }

    private static void adjustTableColumnWidths(JTable table) {
        JTableHeader header = table.getTableHeader();   //表头
        int rowCount = table.getRowCount();   //表格的行数
        TableColumnModel cm = table.getColumnModel();   //表格的列模型

        for (int i = 0; i < cm.getColumnCount(); i++) {   //循环处理每一列
            TableColumn column = cm.getColumn(i);           //第i个列对象
            int width = (int) header.getDefaultRenderer().getTableCellRendererComponent(table, column.getIdentifier(), false, false, -1, i).getPreferredSize().getWidth();   //用表头的绘制器计算第i列表头的宽度
            for (int row = 0; row < rowCount; row++) {   //循环处理第i列的每一行，用单元格绘制器计算第i列第row行的单元格宽度
                int preferedWidth = (int) table.getCellRenderer(row, i).getTableCellRendererComponent(table, table.getValueAt(row, i), false, false, row, i).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);   //取最大的宽度
            }
            column.setPreferredWidth(width + table.getIntercellSpacing().width);   //设置第i列的首选宽度
        }

        table.doLayout();    //按照刚才设置的宽度重新布局各个列
    }

    public TableModel(AbstractTableModel newTableModel) {
        super(newTableModel);
        defaultTable();
    }

    public TableModel(AbstractTableModel newTableModel, boolean[] editable) {
        super(newTableModel);
        this.editables = editable;
        defaultTable();
    }

    /**
     * @Override
     */
    public JTableHeader getTableHeader() {
        JTableHeader tableHeader = super.getTableHeader();
        tableHeader.setReorderingAllowed(false);   //设置表格列不可重排
        DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();  //获得表格头的单元格对象
        hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);  //列名居中
        return tableHeader;

    }

    /**
     * @Override
    //     */
//    public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
//        DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass);
//        cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);  //单元格内容居中
//        return cr;
//    }

    /**
     * @Override
     */
    public boolean isCellEditable(int row, int col) {
//        public boolean isCellEditable(int row, int column) {
//            return column==0?true:false;
//        }
//        return editable;   //单元格不可修改
        return editables != null && editables.length > col && editables[col];
    }

    /**
     * 表格可编辑
     */
//    public void setEditable() {
//        editable = true;
//        isCellEditable(0, 0);
//    }

}
