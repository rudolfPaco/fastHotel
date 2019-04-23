/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modeloTabla;

import FAST.com.botones.IU_BotonCheckBox;
import FAST.com.clases.Limite;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author rudolf
 */
public class R_ColumnaResultado implements TableCellRenderer{

    private final IU_BotonCheckBox etiqueta;
    public R_ColumnaResultado(){
        this.etiqueta = new IU_BotonCheckBox("", new Limite(0, 0, 10, 10), false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        boolean dato = (boolean)o;
        if(dato)
            etiqueta.setSelected(true);
        else
            etiqueta.setSelected(false);
        return etiqueta;
    }     
}
