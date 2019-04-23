/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

import com.fastHotel.vista.disponibilidad.IU_Disponibilidad;
import FAST.com.botones.IU_Boton;
import FAST.com.clases.Limite;
import FAST.com.paneles.IU_Panel;
import FAST.com.ventanas.IU_VentanaPrincipal;
import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author rudolf
 */
public class IU_AplicacionPrincipal extends IU_VentanaPrincipal{

    private IU_Panel panelOpciones;
    public IU_Boton iuDisponibilidad;
    public IU_Boton iuReservas;        
    public IU_Boton iuHabitaciones;
    public IU_Boton iuServicios;
    public IU_Boton iuReportes;
    
    public CardLayout administrador;
    public IU_Panel contenedorPaneles;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public IU_AplicacionPrincipal(String titulo, int idUsuario) {
        super(titulo);
        
        minimizarVentana();
        moverVentana();
        cerrarVentana();        
    }
    public void construirPaneles(){
        int espacio = 4;
        int ancho = panelFondo.getAncho() - 2*espacio;
        int alto = panelFondo.getAlto() - 3*espacio;
        
        panelOpciones = new IU_Panel(new Limite(espacio, espacio, ancho, alto/27));
        panelFondo.add(panelOpciones);
        construirPanelOpciones(ancho, alto/27);
        
        administrador = new CardLayout();
        contenedorPaneles = new IU_Panel(new Limite(espacio, 2*espacio + panelOpciones.getAlto(), ancho, alto - panelOpciones.getAlto()));        
        contenedorPaneles.setLayout(administrador);
        panelFondo.add(contenedorPaneles);
        construirPanelContenedor();
    }
    private void construirPanelOpciones(int ancho, int alto){
        iuDisponibilidad = new IU_Boton("disponibilidad", new Limite(0, 0, ancho/7, alto), 1);
        iuDisponibilidad.agregarBordeContorno(null);        
        panelOpciones.add(iuDisponibilidad);
        
        iuReservas = new IU_Boton("reservas", new Limite(iuDisponibilidad.getAncho(), 0, ancho/7, alto), 1);
        iuReservas.agregarBordeContorno(null);        
        panelOpciones.add(iuReservas);
        
        iuHabitaciones = new IU_Boton("habitaciones", new Limite(iuReservas.getAncho() + iuDisponibilidad.getAncho(), 0, ancho/7, alto), 1);
        iuHabitaciones.agregarBordeContorno(null);        
        panelOpciones.add(iuHabitaciones);
        
        iuServicios = new IU_Boton("servicios", new Limite(iuHabitaciones.getAncho() + iuReservas.getAncho() + iuDisponibilidad.getAncho(), 0, ancho/7, alto), 1);
        iuServicios.agregarBordeContorno(null);        
        panelOpciones.add(iuServicios);
        
        iuReportes = new IU_Boton("reportes", new Limite(iuServicios.getAncho() + iuHabitaciones.getAncho() + iuDisponibilidad.getAncho() + iuReservas.getAncho(), 0, ancho/7, alto), 1);
        iuReportes.agregarBordeContorno(null);        
        panelOpciones.add(iuReportes);
    }
    private void construirPanelContenedor(){
        
    }
}