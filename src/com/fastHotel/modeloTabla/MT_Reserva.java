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
 * @author cero
 */
public class MT_Reserva extends AbstractTableModel{
    
    private final String[] nombre_cabecera;
    public Class[] tipoColumnas = {String.class, Double.class, String.class, String.class, Integer.class, Double.class, String.class, String.class, String.class};
    private final ArrayList<F_Reserva> lista = new ArrayList<>();

    public MT_Reserva(String[] nombre_cabecera) {
        this.nombre_cabecera = nombre_cabecera;
    }

    public boolean isVacia() {
        return lista.isEmpty();
    }

    public void agregar_fila(F_Reserva elemento) {
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

    public F_Reserva getFila(int rowIndex) {
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
                return lista.get(rowIndex).getHabitacion();
            case 1:
                return lista.get(rowIndex).getPrecio();
            case 2:
                return lista.get(rowIndex).getNombre();
            case 3:
                return lista.get(rowIndex).getTelefono();
            case 4:
                return lista.get(rowIndex).getNumeroPersonas();
            case 5:
                return lista.get(rowIndex).getAnticipo();
            case 6:
                return lista.get(rowIndex).getDescripcionAnticipo();
            case 7:
                return lista.get(rowIndex).getHoraLlegada();
            case 8:
                return lista.get(rowIndex).getObservacion();
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
        //if (columnIndex == 6) {
          //  return true;
        //} else {
            return false;
        //}
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        /*F_Huesped filaResultado = null;
        if(rowIndex < lista.size())
            if(lista.get(rowIndex) != null){
                filaResultado = lista.get(rowIndex);
                switch (columnIndex) {
                    case 6:
                        filaResultado.setSeleccionado((Boolean) value);
                        fireTableCellUpdated(rowIndex, columnIndex);
                    default:                
                }
            }*/
    }
}
