package cn.edu.gxu.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
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

    boolean editable = false;

    public TableModel(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        setRowHeight(25);// 设置表格行高
        getTableHeader().setFont(new Font("Dialog", 0, 15));
        setFont(new Font("Menu.font", Font.PLAIN, 15));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class, r);

    }

    public TableModel(DefaultTableModel newTableModel) {
        super(newTableModel);
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
    public boolean isCellEditable(int row, int column) {
//        public boolean isCellEditable(int row, int column) {
//            return column==0?true:false;
//        }
        return editable;   //单元格不可修改
    }

    /**
     * 表格可编辑
     */
    public void setEditable() {
        editable = true;
        isCellEditable(0, 0);
    }

}
