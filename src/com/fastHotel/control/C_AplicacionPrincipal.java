/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.control;

import FAST.com.clases.Apoyo;
import FAST.com.ventanas.IUVentanaHijo;
import FAST.com.ventanas.IUVentanaPadre;
import com.fastHotel.control.disponibilidad.C_Disponibilidad;
import com.fastHotel.vista.IU_AplicacionPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author cero
 */
public class C_AplicacionPrincipal implements MouseListener{
    
    public IU_AplicacionPrincipal iuAplicacionPrincipal;
    
    C_Disponibilidad controlDisponibilidad;
    
    public C_AplicacionPrincipal(){        
        iniciarAplicacionPrincipal();
        cargarEventos();
        llamarModulos();
        
        iuAplicacionPrincipal.mostrarVentana();
    }
    private void iniciarAplicacionPrincipal(){
        iuAplicacionPrincipal = new IU_AplicacionPrincipal("", 0);        
        iuAplicacionPrincipal.construirPaneles();
    }
    private void cargarEventos(){
        iuAplicacionPrincipal.iuDisponibilidad.addMouseListener(this);
        iuAplicacionPrincipal.iuHabitaciones.addMouseListener(this);
        iuAplicacionPrincipal.iuReportes.addMouseListener(this);
        iuAplicacionPrincipal.iuReservas.addMouseListener(this);
        iuAplicacionPrincipal.iuServicios.addMouseListener(this);
    }
    private void llamarModulos(){
        controlDisponibilidad = new C_Disponibilidad(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == iuAplicacionPrincipal.iuDisponibilidad){
            controlDisponibilidad.iniciarAplicacionDisponible();
            controlDisponibilidad.cargarEventos();
            controlDisponibilidad.cargarInformacion();            
            controlDisponibilidad.mostrarAplicacion();
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
