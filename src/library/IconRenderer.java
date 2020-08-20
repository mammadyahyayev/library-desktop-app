/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author MamedYahyayev
 */
public class IconRenderer {

    public IconRenderer() {
    }

    public JLabel view() {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        return view;
    }

    public JLabel update() {
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        return update;
    }

    public JLabel delete() {
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        return delete;
    }

    public JLabel shoppingCartIcon() {
        JLabel orderBook = new JLabel();
        orderBook.setIcon(new ImageIcon("Add Shopping Cart_30px.png"));
        return orderBook;
    }

    public void tableCellRenderer(JLabel view, JLabel update, JLabel delete) {
        view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    }

    public void bookTableCellRenderer(JLabel view, JLabel update, JLabel delete, JLabel orderBook) {
        view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        orderBook.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    }

}
