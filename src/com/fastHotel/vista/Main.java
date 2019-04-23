/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

/**
 *
 * @author rudolf
 */
import java.awt.Color;
import java.awt.Component;
/*from  w  ww .j a  va  2  s  . c o  m*/
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

public class Main extends JPanel {

    final String[] DATA = {"One\n1", "Two\n2", "Three\n3", "saque cervezas huaris de las habitaciones: 204 y 208, para poner a la habitacion 209."};
    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> list = new JList<>(listModel);

    public Main() {
        list.setCellRenderer(new Listm(3, 30));
        add(new JScrollPane(list));
        for (String datum : DATA) {
            listModel.addElement(datum);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Main());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class Listm extends JTextArea implements ListCellRenderer {

    protected Listm(int rows, int cols) {
        super(rows, cols);
        setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {

        setLineWrap(true);
        setWrapStyleWord(true);
        setText(value.toString());
        
        if (cellHasFocus) {
            setBackground(Color.RED);
        } else if (isSelected) {
            setBackground(Color.BLUE);
        } else {
            setBackground(null);
        }
        return this;
    }
}
