package model;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;

    public TableModel() {

    }

    public TableModel(Object[][] data, String[] columnName) {
        this.columns = columnName;
        this.rows = data;
    }
    
    public Class getColumnClass(int column){
        if(column == 7){
            return Icon.class;
        }else{
            return getValueAt(0, column).getClass();
        }
    }

    @Override
    public int getRowCount() {
        return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    
    public String getColumnName(int col){
        return this.columns[col];
    }

}
