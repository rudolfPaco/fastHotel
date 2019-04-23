/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista.disponibilidad;

import FAST.com.botones.IU_Boton;
import FAST.com.campos.IU_CampoTexto;
import FAST.com.clases.Apoyo;
import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelCampoTexto;
import FAST.com.tablas.IU_Tabla;
import FAST.com.ventanas.IU_VentanaSecundaria;
import com.fastHotel.modeloTabla.F_Nombres;
import com.fastHotel.modeloTabla.MT_Nombres;
import com.fastHotel.modeloTabla.MT_Reserva;
import com.fastHotel.vista.busqueda.IU_Reserva;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hotel-felipez
 */
public class IU_VentanaReserva extends IU_VentanaSecundaria{

    public IU_Reserva iuReserva;
    
    private IU_Panel primerPanel;
    private IU_PanelCampoTexto fechaLlegada;
    private IU_PanelCampoTexto fechaSalida;
    private IU_PanelCampoTexto numeroNoches;
    private IU_PanelCampoTexto horaLlegada;
    private IU_Etiqueta botonHora;
    
    private IU_Panel segundoPanel;
    private IU_PanelCampoTexto nroHabitacion;
    private IU_PanelCampoTexto tipoHabitacion;
    private IU_PanelCampoTexto precioHabitacion;
        
    private IU_Panel tercerPanel;
    private IU_PanelCampoTexto nombreHuesped;
    private IU_Boton botonAgregarHuesped;
    private IU_Boton botonEliminarHuesped;
    private IU_PanelCampoTexto telefonoHuesped;
    private IU_Tabla tablaHuespedes;
    private MT_Nombres modeloHuespedes;
        
    private IU_Panel cuartoPanel;
    private IU_PanelCampoTexto anticipo;
    private IU_PanelCampoTexto descripcionAnticipo;
    private IU_PanelCampoTexto observacion;
    
    private IU_Panel quintoPanel;
    private IU_Boton botonGuardar;    
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public IU_VentanaReserva(IU_Reserva iuReserva) {
        super(iuReserva.controlDisponibilidad.iuDisponibilidad.principal, "reserva id = 2", Apoyo.ANCHO - Apoyo.ANCHO/7, Apoyo.ALTO - Apoyo.ALTO/14, 50);
        this.iuReserva = iuReserva;
        
        moverVentana();
        cerrarVentana();
    }
    public void construirPaneles(){
        int espacio = 2;
        int ancho = panelFondo.getWidth() - 2*espacio;
        int alto = panelFondo.getHeight() - 2*espacio;
        
        primerPanel = new IU_Panel(new Limite(espacio, espacio, ancho, alto/14));
        panelFondo.add(primerPanel);
        construirPrimerPanel();
        
        segundoPanel = new IU_Panel(new Limite(espacio, espacio + primerPanel.getY() + primerPanel.getAlto(), ancho, alto/14));
        panelFondo.add(segundoPanel);
        construirSegundoPanel();
        
        tercerPanel = new IU_Panel(new Limite(espacio, espacio + segundoPanel.getY() + segundoPanel.getAlto(), ancho, alto/4));
        panelFondo.add(tercerPanel);
        construirTercerPanel();
        
        cuartoPanel = new IU_Panel(new Limite(espacio, espacio + tercerPanel.getY() + tercerPanel.getAlto(), ancho, alto/7));
        panelFondo.add(cuartoPanel);
        construirCuartoPanel();
        
        quintoPanel = new IU_Panel(new Limite(espacio, espacio + cuartoPanel.getY() + cuartoPanel.getAlto(), ancho, alto - primerPanel.getAlto() - segundoPanel.getAlto() - tercerPanel.getAlto() - cuartoPanel.getAlto()));
        panelFondo.add(quintoPanel);
        construirQuintoPanel();
    }
    private void construirPrimerPanel(){        
        int espacio = primerPanel.getAlto()/14;
        int ancho = primerPanel.getAncho() - 2*espacio;
        int alto = primerPanel.getAlto() - 2*espacio;
                
        fechaLlegada = new IU_PanelCampoTexto("fecha llegada", "", new Limite(espacio, espacio, ancho/7, alto), 40);
        fechaLlegada.iuTexto.setEditable(false);
        fechaLlegada.iuTexto.setFocusable(false);
        primerPanel.add(fechaLlegada);
        
        fechaSalida = new IU_PanelCampoTexto("fecha salida", "", new Limite(espacio + fechaLlegada.getX() + fechaLlegada.getAncho(), espacio, ancho/7, alto), 40);
        fechaSalida.iuTexto.setEditable(false);
        fechaSalida.iuTexto.setFocusable(false);
        primerPanel.add(fechaSalida);
        
        numeroNoches = new IU_PanelCampoTexto("nro dias", "", new Limite(espacio + fechaSalida.getX() + fechaSalida.getAncho(), espacio, ancho/14, alto), 40);
        numeroNoches.iuTexto.setEditable(false);
        numeroNoches.iuTexto.setFocusable(false);
        primerPanel.add(numeroNoches);
    }
    private void construirSegundoPanel(){
        int espacio = segundoPanel.getAlto()/14;
        int ancho = segundoPanel.getAncho() - 2*espacio;
        int alto = segundoPanel.getAlto() - 2*espacio;
        
        nroHabitacion = new IU_PanelCampoTexto("nro habitacion", "", new Limite(espacio, espacio, ancho/12, alto), 40);
        nroHabitacion.iuTexto.setEditable(false);
        nroHabitacion.iuTexto.setFocusable(false);
        segundoPanel.add(nroHabitacion);
        
        tipoHabitacion = new IU_PanelCampoTexto("tipo habitacion", "", new Limite(espacio + nroHabitacion.getX() + nroHabitacion.getAncho(), espacio, ancho/5, alto), 40);
        tipoHabitacion.iuTexto.setEditable(false);
        tipoHabitacion.iuTexto.setFocusable(false);
        segundoPanel.add(tipoHabitacion);
        
        precioHabitacion = new IU_PanelCampoTexto("precio de hab. x noche", "", new Limite(espacio + tipoHabitacion.getX() + tipoHabitacion.getAncho(), espacio, ancho/7, alto), 40);
        precioHabitacion.iuTexto.setFocusable(false);
        precioHabitacion.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        segundoPanel.add(precioHabitacion);        
    }
    private void construirTercerPanel(){
        int espacio = tercerPanel.getAlto()/40;
        int ancho = tercerPanel.getAncho() - 2*espacio;
        int alto = tercerPanel.getAlto() - 2*espacio;
         
        nombreHuesped = new IU_PanelCampoTexto("nombre de huesped", "", new Limite(espacio, espacio, ancho/3, alto/4), 40);
        tercerPanel.add(nombreHuesped);
        
        telefonoHuesped = new IU_PanelCampoTexto("telefono del huesped", "", new Limite(espacio + nombreHuesped.getX() + nombreHuesped.getAncho(), espacio, ancho/6, alto/4), 40);
        tercerPanel.add(telefonoHuesped);        
        
        botonAgregarHuesped = new IU_Boton("src/imagenes/ok.png", new Limite(espacio + telefonoHuesped.getX() + telefonoHuesped.getAncho(), espacio, alto/4, alto/4));
        tercerPanel.add(botonAgregarHuesped);
        botonAgregarHuesped.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                agregarNombres();
            }
        });
        
        botonEliminarHuesped = new IU_Boton("src/imagenes/borrar.png", new Limite(espacio + telefonoHuesped.getX() + telefonoHuesped.getAncho(), espacio + botonAgregarHuesped.getY() + botonAgregarHuesped.getAlto(), alto/4, alto/4));
        tercerPanel.add(botonEliminarHuesped);
        botonEliminarHuesped.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(tablaHuespedes.getSelectedRow() > -1){
                    modeloHuespedes.eliminar_fila(tablaHuespedes.getSelectedRow());
                    if(!modeloHuespedes.isVacia())
                        modeloHuespedes.getFila(0).setEstado(true);
                }
                    
            }
        });
        
        String[] nombre_cabecera = {"nro.","nombre completo del huesped", "telefono","•"};        
        int[] ancho_cabecera = {10, 65, 20, 5};
        
        modeloHuespedes = new MT_Nombres(nombre_cabecera);        
        
        tablaHuespedes = new IU_Tabla(modeloHuespedes, espacio, espacio + nombreHuesped.getY() + nombreHuesped.getAlto(), ancho/2, alto - nombreHuesped.getAlto() - espacio);
        tablaHuespedes.setFuente_letra(new Font("Verdana", Font.PLAIN, 14));
        JTableHeader th = tablaHuespedes.getTableHeader();          
        Font fuente = new Font("Verdana", Font.BOLD, 14); 
        th.setFont(fuente);
        tablaHuespedes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaHuespedes.setShowHorizontalLines(false);
        tablaHuespedes.setShowVerticalLines(true);
        tablaHuespedes.setColumnSelectionAllowed(false);
        tablaHuespedes.setRowSelectionAllowed(true);          
        tablaHuespedes.establecer_ancho_columnas(ancho_cabecera);        
        tercerPanel.add(tablaHuespedes.deslizador);
        
        horaLlegada = new IU_PanelCampoTexto("hora del check out", "", new Limite(espacio + botonEliminarHuesped.getX() + botonEliminarHuesped.getAncho(), espacio + nombreHuesped.getY() + nombreHuesped.getAlto(), ancho/2 - alto/4 - alto/12, alto - nombreHuesped.getAlto() - espacio), 20);
        horaLlegada.iuTexto.setEditable(false);
        horaLlegada.iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        horaLlegada.iuTexto.setFocusable(false);
        tercerPanel.add(horaLlegada);
        
        botonHora = new IU_Etiqueta("src/imagenes/hora.png", new Limite(ancho - ancho/32 , espacio, alto/4, alto/4));
        botonHora.setFocusable(false);
        tercerPanel.add(botonHora);
    }
    private void construirCuartoPanel(){
        int espacio = cuartoPanel.getAlto()/50;
        int ancho = cuartoPanel.getWidth() - 2*espacio;
        int alto = cuartoPanel.getHeight() - 3*espacio;
        
        anticipo = new IU_PanelCampoTexto("anticipo", "", new Limite(espacio, espacio, ancho/10, alto/2), 35);
        anticipo.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        cuartoPanel.add(anticipo);
        
        descripcionAnticipo = new IU_PanelCampoTexto("descripcion", "", new Limite(espacio + anticipo.getX() + anticipo.getAncho(), espacio, ancho - 2*anticipo.getAncho(), alto/2), 35);
        descripcionAnticipo.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        cuartoPanel.add(descripcionAnticipo);
        
        observacion = new IU_PanelCampoTexto("observacion", "", new Limite(espacio, espacio + anticipo.getY() + anticipo.getAlto(), ancho/2, alto/2), 35);
        observacion.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        cuartoPanel.add(observacion);
        telefonoHuesped.iuTexto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {                
                agregarNombres();
                observacion.iuTexto.transferFocus();
            }
        });
    }
    private void construirQuintoPanel(){
        int espacio = quintoPanel.getAlto()/100;
        int ancho = quintoPanel.getWidth() - 2*espacio;
        int alto = quintoPanel.getHeight() - 3*espacio;
        
        botonGuardar = new IU_Boton("src/imagenes/guardar.png", new Limite(ancho - alto/3, alto - alto/3, alto/3, alto/3));
        botonGuardar.setBorder(null);
        quintoPanel.add(botonGuardar);
        botonGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();                
            }
        });
    }
    private void agregarNombres(){
        if(!nombreHuesped.iuTexto.getText().isEmpty()){
            if(modeloHuespedes.isVacia())
                modeloHuespedes.agregar_fila(new F_Nombres(nombreHuesped.getDato(), telefonoHuesped.getDato(), true));
            else
                modeloHuespedes.agregar_fila(new F_Nombres(nombreHuesped.getDato(), telefonoHuesped.getDato(), false));
        }
        nombreHuesped.iuTexto.setText("");
        telefonoHuesped.iuTexto.setText("");
        
    }
}