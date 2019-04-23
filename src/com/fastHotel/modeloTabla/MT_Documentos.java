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
 * @author rudolf
 */
public class MT_Documentos extends AbstractTableModel {
    private final String[] nombre_cabecera;
    public Class[] tipoColumnas = {Integer.class, String.class, String.class, String.class, String.class};
    private final ArrayList<F_Documento> lista = new ArrayList<>();

    public MT_Documentos(String[] nombre_cabecera) {
        this.nombre_cabecera = nombre_cabecera;
    }

    public boolean isVacia() {
        return lista.isEmpty();
    }

    public void agregar_fila(F_Documento elemento) {
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

    public F_Documento getFila(int rowIndex) {
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
                return lista.get(rowIndex).getDireccionDocumento();
            case 2:
                return lista.get(rowIndex).getNombreDocumento();
            case 3:
                return lista.get(rowIndex).getDireccionDocumento();
            case 4:
                return lista.get(rowIndex).getTipoDocumento();
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
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }
}
