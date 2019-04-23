/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.control.disponibilidad;

import static FAST.com.ventanas.IU_VentanaPrincipal.ALTO;
import static FAST.com.ventanas.IU_VentanaPrincipal.ANCHO;
import com.fastHotel.control.C_AplicacionPrincipal;
import com.fastHotel.control.reserva.C_Reserva;
import com.fastHotel.vista.disponibilidad.IU_Disponibilidad;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author cero
 */
public class C_Disponibilidad implements MouseListener{
    
    public IU_Disponibilidad iuDisponibilidad;
    public C_AplicacionPrincipal controlPrincipal;
            
    public C_Disponibilidad(C_AplicacionPrincipal controlPrincipal){
        this.controlPrincipal = controlPrincipal;
    }
    
    public void iniciarAplicacionDisponible(){
        iuDisponibilidad = new IU_Disponibilidad(controlPrincipal.iuAplicacionPrincipal, "disponibilidad de habitaciones", ANCHO, ALTO, 50);
        iuDisponibilidad.construirPaneles();
    }
    public void cargarEventos(){
        iuDisponibilidad.botonCheckIn.addMouseListener(this);
        iuDisponibilidad.botonReservar.addMouseListener(this);
        iuDisponibilidad.etiquetaBuscar.addMouseListener(this);        
    }    
    public void cargarInformacion(){
        
    }
    public void mostrarAplicacion(){
        iuDisponibilidad.mostrarVentana();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == iuDisponibilidad.botonReservar){
            if(iuDisponibilidad.estaSeleccionadoFilaTabla()){
                C_Reserva controlReserva = new C_Reserva(this);
                controlReserva.iniciarAplicacion();
                controlReserva.cargarEventos();
                controlReserva.cargarInformacion();
                controlReserva.mostrarAplicacion();
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}