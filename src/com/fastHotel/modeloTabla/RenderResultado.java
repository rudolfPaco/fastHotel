/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modeloTabla;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rudolf
 */
public class RenderResultado extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean seleccion, boolean foco, int fila, int columna){
        if(((boolean)tabla.getModel().getValueAt(fila, 9))){
            setBackground(Color.YELLOW);            
            tabla.setFont(new Font("Verdana", Font.BOLD, 16));
            if(columna == 7)
                setForeground(Color.MAGENTA);
            else
                setForeground(Color.BLACK);
        }else{
            setBackground(null);
            tabla.setFont(new Font("Verdana", Font.PLAIN, 14));
        }
        
        setHorizontalAlignment(SwingConstants.CENTER);
        super.getTableCellRendererComponent(tabla, valor, seleccion, foco, fila, columna);
        return this;
    }
}
