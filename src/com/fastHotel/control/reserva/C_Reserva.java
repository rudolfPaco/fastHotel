/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.control.reserva;

import com.fastHotel.control.disponibilidad.C_Disponibilidad;
import com.fastHotel.vista.busqueda.IU_Reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author hotel-felipez
 */
public class C_Reserva implements ActionListener{

    public C_Disponibilidad controlDisponibilidad;
    public IU_Reserva iuReserva;
    
    public C_Reserva(C_Disponibilidad controlDisponibilidad){
        this.controlDisponibilidad = controlDisponibilidad;        
    }
    
    public void iniciarAplicacion(){
        iuReserva = new IU_Reserva(controlDisponibilidad, "Reserva de Habitacion(es)");
        iuReserva.contruirPaneles();        
    }
    public void cargarEventos(){
        //iuReserva.botonBuscarPersona.addMouseListener(this);
        //iuReserva.botonHoraLlegada.addMouseListener(this);
        iuReserva.botonGuardar.addActionListener(this);
        iuReserva.botonModificar.addActionListener(this);
        iuReserva.botonVer.addActionListener(this);
        iuReserva.botonEliminar.addActionListener(this);
    }
    public void cargarInformacion(){
        
    }
    public void mostrarAplicacion(){
        iuReserva.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == iuReserva.botonHoraLlegada){
            iuReserva.establecerHora();
        }
        if(e.getSource() == iuReserva.botonModificar){
            if(iuReserva.tablaReserva.getSelectedRow() > -1)
                iuReserva.modificarReserva();
        }
    }
}
