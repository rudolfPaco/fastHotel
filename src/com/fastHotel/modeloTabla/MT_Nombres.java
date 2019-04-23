/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modeloTabla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hotel-felipez
 */
public class MT_Nombres extends AbstractTableModel{
    private final String[] nombre_cabecera;
    public Class[] tipoColumnas = {Integer.class, String.class, String.class, Boolean.class};
    private final ArrayList<F_Nombres> lista = new ArrayList<>();

    public MT_Nombres(String[] nombre_cabecera) {
        this.nombre_cabecera = nombre_cabecera;
    }

    public boolean isVacia() {
        return lista.isEmpty();
    }

    public void agregar_fila(F_Nombres elemento) {
        lista.add(elemento);
        fireTableDataChanged();
    }

    public void eliminar_fila(int rowIndex) {
        lista.remove(rowIndex);
        fireTableDataChanged();
    }

    public void limpiar_tabla() {
        lista.clear();
        fireTableDataChanged();
    }

    public F_Nombres getFila(int rowIndex) {
        return lista.get(rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return nombre_cabecera[columnIndex];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return nombre_cabecera.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return lista.get(rowIndex).getNombre();
            case 2:
                return lista.get(rowIndex).getTelefono();
            case 3:
                return lista.get(rowIndex).isEstado();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return tipoColumnas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        /*if (columnIndex == 3) {
            return true;
        } else {
            return false;
        }*/
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        F_Nombres filaResultado = null;
        if(rowIndex < lista.size())
            if(lista.get(rowIndex) != null){
                filaResultado = lista.get(rowIndex);
                switch (columnIndex) {
                    case 3:
                        filaResultado.setEstado((Boolean) value);
                        fireTableCellUpdated(rowIndex, columnIndex);
                    default:                
                }
            }                 
    }
}
