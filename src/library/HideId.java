package library;

import javax.swing.JTable;

public class HideId {

    public HideId() {

    }

    public void hideId(JTable tableName) {
        tableName.getColumnModel().getColumn(0).setMinWidth(0);
        tableName.getColumnModel().getColumn(0).setMaxWidth(0);
        tableName.getColumnModel().getColumn(0).setWidth(0);
    }

}
