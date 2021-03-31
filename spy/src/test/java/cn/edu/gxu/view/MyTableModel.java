package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/30 21:06
 * @Description
 */

import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
    private String[] columnNames;
    private Object[][] data;
    public final Object[] longValues;

    public MyTableModel(Object[][] Tabledate, String[] Tabletitle) {
        columnNames = new String[Tabletitle.length];
        columnNames = Tabletitle;
        data = new Object[Tabledate.length][Tabledate[0].length];
        data = Tabledate;
        longValues = new Object[Tabletitle.length];
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        System.out.println("value:" + value);
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}