package library;

import javax.swing.JFrame;
import javax.swing.JTable;

public class ColumnSize extends JFrame {

    public ColumnSize() {

    }

    public void advancedBookTableColumnSize(JTable advancedBookTable) {
        advancedBookTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        advancedBookTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        advancedBookTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        advancedBookTable.getColumnModel().getColumn(4).setPreferredWidth(25);
        advancedBookTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        advancedBookTable.getColumnModel().getColumn(6).setPreferredWidth(20);
        advancedBookTable.getColumnModel().getColumn(7).setPreferredWidth(20);
        advancedBookTable.getColumnModel().getColumn(8).setPreferredWidth(40);
        advancedBookTable.getColumnModel().getColumn(9).setPreferredWidth(20);
        advancedBookTable.getColumnModel().getColumn(10).setPreferredWidth(20);
        advancedBookTable.getColumnModel().getColumn(11).setPreferredWidth(20);
        advancedBookTable.getColumnModel().getColumn(12).setPreferredWidth(25);
    }

    public void authorTableColumnSize(JTable authorTable) {
        authorTable.getColumnModel().getColumn(1).setPreferredWidth(5);
        authorTable.getColumnModel().getColumn(6).setPreferredWidth(20);
        authorTable.getColumnModel().getColumn(7).setPreferredWidth(20);
        authorTable.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    public void studentsTableColumnSize(JTable studentsTable) {
        studentsTable.getColumnModel().getColumn(1).setPreferredWidth(5);
        studentsTable.getColumnModel().getColumn(2).setPreferredWidth(25);
        studentsTable.getColumnModel().getColumn(3).setPreferredWidth(25);
        studentsTable.getColumnModel().getColumn(4).setPreferredWidth(25);
        studentsTable.getColumnModel().getColumn(5).setPreferredWidth(15);
        studentsTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        studentsTable.getColumnModel().getColumn(7).setPreferredWidth(20);
        studentsTable.getColumnModel().getColumn(8).setPreferredWidth(30);
        studentsTable.getColumnModel().getColumn(9).setPreferredWidth(20);
        studentsTable.getColumnModel().getColumn(10).setPreferredWidth(20);
    }

    public void employeeTableColumnSize(JTable employeeTable) {
        employeeTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        employeeTable.getColumnModel().getColumn(7).setPreferredWidth(30);
        employeeTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        employeeTable.getColumnModel().getColumn(9).setPreferredWidth(20);
        employeeTable.getColumnModel().getColumn(10).setPreferredWidth(20);
        employeeTable.getColumnModel().getColumn(11).setPreferredWidth(20);
    }

    public void bookTableColumnSize(JTable bookTable) {
        bookTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        bookTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        bookTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        bookTable.getColumnModel().getColumn(4).setPreferredWidth(25);
        bookTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        bookTable.getColumnModel().getColumn(6).setPreferredWidth(20);
        bookTable.getColumnModel().getColumn(7).setPreferredWidth(20);
        bookTable.getColumnModel().getColumn(8).setPreferredWidth(40);
        bookTable.getColumnModel().getColumn(9).setPreferredWidth(20);
        bookTable.getColumnModel().getColumn(10).setPreferredWidth(20);
        bookTable.getColumnModel().getColumn(11).setPreferredWidth(20);
        bookTable.getColumnModel().getColumn(12).setPreferredWidth(25);
    }

    public void sendEmailTableColumnSize(JTable sendEmailTable) {
        sendEmailTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        sendEmailTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        sendEmailTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        sendEmailTable.getColumnModel().getColumn(6).setPreferredWidth(20);
        sendEmailTable.getColumnModel().getColumn(7).setPreferredWidth(20);
        sendEmailTable.getColumnModel().getColumn(8).setPreferredWidth(20);
    }
}
