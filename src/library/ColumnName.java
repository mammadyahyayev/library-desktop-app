package library;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ColumnName {

    public ColumnName() {

    }

    public void authorColumns(DefaultTableModel table) {
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Ad");
        table.addColumn("Soyad");
        table.addColumn("Doğum Tarixi");
        table.addColumn("Ölüm Tarixi");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
    }

}
