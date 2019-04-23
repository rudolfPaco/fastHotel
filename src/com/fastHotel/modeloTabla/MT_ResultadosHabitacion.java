package com.fastHotel.modeloTabla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rudolf
 */
public class MT_ResultadosHabitacion extends AbstractTableModel {

    private final String[] nombre_cabecera;
    public Class[] tipoColumnas = {Integer.class, String.class, String.class, Integer.class, String.class, String.class, Double.class, String.class, String.class, Boolean.class};
    private final ArrayList<F_Resultados> lista = new ArrayList<>();

    public MT_ResultadosHabitacion(String[] nombre_cabecera) {
        this.nombre_cabecera = nombre_cabecera;
    }

    public boolean isVacia() {
        return lista.isEmpty();
    }

    public void agregar_fila(F_Resultados elemento) {
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

    public F_Resultados getFila(int rowIndex) {
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
                return lista.get(rowIndex).getNombreHabitacion();
            case 2:
                return lista.get(rowIndex).getTipoHabitacion();
            case 3:
                return lista.get(rowIndex).getCapacidad();
            case 4:
                return lista.get(rowIndex).getNumeroPiso();
            case 5:
                return lista.get(rowIndex).getDescripcionCamas();
            case 6:
                return lista.get(rowIndex).getPrecioHabitacion();
            case 7:
                return lista.get(rowIndex).getEstadoHabitacion();
            case 8:
                return lista.get(rowIndex).getCheckIn();
            case 9:
                return lista.get(rowIndex).isSeleccionado();
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
        if (columnIndex == 9) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        F_Resultados filaResultado = null;
        if(rowIndex < lista.size())
            if(lista.get(rowIndex) != null){
                filaResultado = lista.get(rowIndex);
                switch (columnIndex) {
                    case 9:
                        filaResultado.setSeleccionado((Boolean) value);
                        fireTableCellUpdated(rowIndex, columnIndex);
                    default:                
                }
            }                 
    }
}
