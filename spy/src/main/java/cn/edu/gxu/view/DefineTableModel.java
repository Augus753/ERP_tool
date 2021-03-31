package cn.edu.gxu.view;

import javax.swing.table.AbstractTableModel;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/30 21:17
 * @Description
 */
public class DefineTableModel extends AbstractTableModel {
    private String[] columnNames;
    private Object[][] data;
    public final Object[] longValues;

    public DefineTableModel(Object[][] tableDate, String[] tableTitle) {
        columnNames = new String[tableTitle.length];
        columnNames = tableTitle;
        data = new Object[tableDate.length][tableTitle.length];
        data = tableDate;
        longValues = new Object[tableTitle.length];
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
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
