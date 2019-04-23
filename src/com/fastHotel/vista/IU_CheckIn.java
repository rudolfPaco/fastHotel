/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

import FAST.com.botones.IU_BotonRadio;
import FAST.com.calendario.Fecha;
import FAST.com.calendario.CalendarioPantallaIU;
import FAST.com.clases.Hora;
import FAST.com.clases.Limite;
import FAST.com.componentes.IU_Mensaje;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelCampoTexto;
import FAST.com.paneles.IU_PanelCampoTextoUnidad;
import FAST.com.paneles.IU_PanelSpinner;
import FAST.com.ventanas.IU_VentanaSecundaria;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author rudolf
 */
public class IU_CheckIn extends IU_VentanaSecundaria{
    
    private JFrame ventana;
    
    private IU_Panel panelEstadia;
    private IU_PanelCampoTexto campoFechaLlegada;
    private IU_PanelCampoTextoUnidad campoHoraLlegada;
    private IU_Etiqueta etiquetaHoraLlegada;
    private IU_Etiqueta etiquetaFechaLlegada;
    private IU_PanelCampoTexto campoFechaSalida;
    private IU_PanelCampoTextoUnidad campoHoraSalida;    
    private IU_Etiqueta etiquetaHoraSalida;
    private IU_Etiqueta etiquetaFechaSalida;
    private IU_PanelSpinner spinnerNoches;
    private IU_Etiqueta etiquetaHabitacion;
    private IU_PanelCampoTexto campoNombreHabitacion;
    private IU_PanelCampoTexto campoCapacidad;
    private IU_PanelCampoTextoUnidad campoPrecioHabitacion;
    
    private IU_Panel panelResultados;
    
    private IU_Panel panelIzquierda;
    private IU_Panel primerPanel;
    private ButtonGroup grupo;
    private IU_BotonRadio iuHuespedes;
    private IU_BotonRadio iuHospedaje;
    private IU_BotonRadio iuServicios;
    private IU_BotonRadio iuMiniBar;
    private IU_BotonRadio iuHabitacion;
    private IU_BotonRadio iuDisponible;
    private IU_BotonRadio iuAnticipo;
    
    private CardLayout administrador;
    private IU_Panel segundoPanel;
    private IU_PanelHospedaje panelHospedaje;
    private IU_PanelHuesped panelHuesped;
    private IU_PanelServicios panelServicios;
    private IU_PanelMiniBar panelMiniBar;
    private IU_PanelHabitacion panelHabitacion;
    private IU_PanelDisponible panelDisponible;
    private IU_PanelAnticipo panelAnticipos;
    
    private IU_Panel tercerPanel;
    private IU_Panel panelDerecha;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public IU_CheckIn(JFrame ventana, String titulo, int ancho, int alto, int altura){
        super(ventana, titulo, ancho, alto, altura);
        this.ventana = ventana;
        
        construirPaneles();
                
        moverVentana();
        cerrarVentana();
        mostrarVentana();
    }
    private void construirPaneles(){
        int espacio = 2;
        int ancho = panelFondo.getWidth() - 2*espacio;
        int alto = panelFondo.getHeight() - 2*espacio;
        
        panelEstadia = new IU_Panel(new Limite(espacio, espacio, ancho, alto/6));        
        panelFondo.add(panelEstadia);
        construirPanelBusqueda(ancho - 6, alto/6 - 4);
        
        panelResultados = new IU_Panel(new Limite(espacio, espacio + alto/6, ancho, alto - alto/6 - espacio));
        panelFondo.add(panelResultados);        
        construirPanelResultados(ancho, alto - alto/6 - espacio);
    }
    private void construirPanelBusqueda(int ancho, int alto){
        
        //fecha de llegada y hora de llegada
        campoFechaLlegada = new IU_PanelCampoTexto("fecha de llegada", new Fecha().getFechaMysql(), new Limite(2, 2 + alto/20, ancho/7, (alto - alto/10)/2), 40);        
        campoFechaLlegada.iuTexto.setFocusable(false);
        campoFechaLlegada.iuTexto.deshabilitarTexto();
        campoFechaLlegada.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        panelEstadia.add(campoFechaLlegada);
        
        etiquetaFechaLlegada = new IU_Etiqueta("src/imagenes/fecha.png", new Limite(4 + ancho/7, 2 + alto/20, (alto - alto/10)/2, (alto - alto/10)/2));
        etiquetaFechaLlegada.agregarBordeContorno(null);
        panelEstadia.add(etiquetaFechaLlegada);
        etiquetaFechaLlegada.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                CalendarioPantallaIU calendario = new CalendarioPantallaIU(ventana_principal, new Fecha().getFechaDia_literal_fechaHotel(), new Fecha(), ANCHO - ANCHO/5, ALTO/2, 50);
                calendario.mostrar();
                
                if(!((Fecha)calendario.getElemento().getObjeto()).esMenor(new Fecha())){
                    campoFechaLlegada.iuTexto.setText(((Fecha)calendario.getElemento().getObjeto()).getFechaMysql());
                    campoFechaSalida.iuTexto.setText(((Fecha)calendario.getElemento().getObjeto()).proximaDiaFecha().getFechaMysql());
                    spinnerNoches.iuBotonAbajo.setVisible(true);
                    spinnerNoches.iuBotonArriba.setVisible(true);
                    spinnerNoches.campoTexto.setText("1");
                    campoFechaLlegada.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
                    campoFechaSalida.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
                }                    
                else{
                    IU_Mensaje iuMensaje = new IU_Mensaje(ventana_principal, "aceptacion", "la fecha que ingreso es INCORRECTA...!", 4, ANCHO/2, ALTO/2, 50);
                }                    
            }
        });
        
        campoHoraLlegada = new IU_PanelCampoTextoUnidad("hora de llegada", new Hora().cadenaHora(), new Hora().getFormato(), new Limite(2, 6 + alto/20 + (alto - alto/10)/2, ancho/7, (alto - alto/10)/2), 40, 30);        
        campoHoraLlegada.iuTexto.setFocusable(false);
        campoHoraLlegada.iuTexto.deshabilitarTexto();
        campoHoraLlegada.cambiarColorTituloTextoUnidad(new Color(24, 75, 152), Color.BLACK, new Color(180, 0, 0));
        panelEstadia.add(campoHoraLlegada);
        
        etiquetaHoraLlegada = new IU_Etiqueta("src/imagenes/hora.png", new Limite(4 + ancho/7, 6 + alto/20 + (alto - alto/10)/2, (alto - alto/10)/2, (alto - alto/10)/2));
        etiquetaHoraLlegada.agregarBordeContorno(null);
        panelEstadia.add(etiquetaHoraLlegada);
        
        ///fecha de salida hora de salida        
        campoFechaSalida = new IU_PanelCampoTexto("fecha de salida", "", new Limite(ancho/5, 2 + alto/20, ancho/7, (alto - alto/10)/2), 40);        
        campoFechaSalida.iuTexto.setFocusable(false);
        campoFechaSalida.iuTexto.deshabilitarTexto();
        campoFechaSalida.cambiarColorTituloTexto(new Color(24, 75, 152), new Color(180, 0, 0));
        panelEstadia.add(campoFechaSalida);
        
        campoHoraSalida = new IU_PanelCampoTextoUnidad("hora de salida", new Hora().cadenaHora(), new Hora().getFormato(), new Limite(ancho/5, 6 + alto/20 + (alto - alto/10)/2, ancho/7, (alto - alto/10)/2), 40, 30);        
        campoHoraSalida.iuTexto.setFocusable(false);
        campoHoraSalida.iuTexto.deshabilitarTexto();
        campoHoraSalida.cambiarColorTituloTextoUnidad(new Color(24, 75, 152), Color.BLACK, new Color(180, 0, 0));
        panelEstadia.add(campoHoraSalida);
        
        etiquetaHoraSalida = new IU_Etiqueta("src/imagenes/hora.png", new Limite(4 + ancho/7 + ancho/5, 6 + alto/20 + (alto - alto/10)/2, (alto - alto/10)/2, (alto - alto/10)/2));
        etiquetaHoraSalida.agregarBordeContorno(null);
        panelEstadia.add(etiquetaHoraSalida);
        
        etiquetaFechaSalida = new IU_Etiqueta("src/imagenes/fecha.png", new Limite(4 + ancho/5 + ancho/7, 2 + alto/20, (alto - alto/10)/2, (alto - alto/10)/2));
        etiquetaFechaSalida.agregarBordeContorno(null);
        panelEstadia.add(etiquetaFechaSalida);
        etiquetaFechaSalida.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(!campoFechaLlegada.getDato().isEmpty()){
                    CalendarioPantallaIU calendario = new CalendarioPantallaIU(ventana_principal, new Fecha().getFechaDia_literal_fechaHotel(), new Fecha(), ANCHO - ANCHO/5, ALTO/2, 50);
                    calendario.mostrar();

                    if(((Fecha)calendario.getElemento().getObjeto()).esMayor(new Fecha(campoFechaLlegada.getDato(), "yyyy-MM-dd"))){
                        campoFechaSalida.iuTexto.setText(((Fecha)calendario.getElemento().getObjeto()).getFechaMysql());
                        int numero = new Fecha(campoFechaLlegada.getDato(), "yyyy-MM-dd").restarDiasFecha(((Fecha)calendario.getElemento().getObjeto()));
                        spinnerNoches.campoTexto.setText(String.valueOf(numero));                                                    
                    }else{
                        IU_Mensaje iuMensaje = new IU_Mensaje(ventana_principal, "aceptacion", "la fecha que ingreso es INCORRECTA...!", 4, ANCHO/2, ALTO/2, 50);
                    }                        
                }
            }
        });
        
        //numero de noches
        spinnerNoches = new IU_PanelSpinner("noches", new Limite(ancho/2 - ancho/10, 2 + alto/20, ancho/16, (alto - alto/10)/2), 40, 1, 1, 50);
        spinnerNoches.iuBotonAbajo.setVisible(false);
        spinnerNoches.iuBotonArriba.setVisible(false);
        spinnerNoches.setColor(new Color(180, 0, 0), Color.BLACK, Color.BLACK);
        spinnerNoches.campoTexto.setText("");
        panelEstadia.add(spinnerNoches);
        spinnerNoches.iuBotonArriba.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(!campoFechaLlegada.getDato().isEmpty()){
                    int noches = (int)spinnerNoches.getDato();
                    Fecha fecha = new Fecha(campoFechaLlegada.getDato(), "yyyy-MM-dd");
                    for (int i = 0; i < noches; i++) {
                        fecha = fecha.proximaDiaFecha();                        
                    }
                    campoFechaSalida.iuTexto.setText(fecha.getFechaMysql());
                }
            }
        });
        spinnerNoches.iuBotonAbajo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(!campoFechaLlegada.getDato().isEmpty()){
                    int noches = (int)spinnerNoches.getDato();
                    Fecha fecha = new Fecha(campoFechaLlegada.getDato(), "yyyy-MM-dd");
                    for (int i = 0; i < noches; i++) {
                        fecha = fecha.proximaDiaFecha();
                    }
                    campoFechaSalida.iuTexto.setText(fecha.getFechaMysql());
                }
            }
        });
        
        etiquetaHabitacion = new IU_Etiqueta("src/imagenes/habitacion.png", new Limite(ancho - ancho/6 - (alto - alto/10) - 8, 2 + alto/20, alto - alto/10, alto - alto/10));
        etiquetaHabitacion.agregarBordeContorno(null);
        panelEstadia.add(etiquetaHabitacion);
        
        campoNombreHabitacion = new IU_PanelCampoTexto("habitacion", "204 TM", new Limite(ancho - ancho/6 - 4, 2 + alto/20, ancho/6, (alto - alto/10)), 30);
        campoNombreHabitacion.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.CENTER);
        campoNombreHabitacion.cambiarColorTituloTexto(new Color(24, 75, 152), new Color(180, 0, 0));
        campoNombreHabitacion.iuTexto.deshabilitarTexto();
        //campoNombreHabitacion.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
        panelEstadia.add(campoNombreHabitacion);
        
        campoCapacidad = new IU_PanelCampoTexto("capacidad", "1", new Limite(ancho/2 - ancho/36, 2 + alto/20, ancho/14, (alto - alto/10)/2), 40);
        campoCapacidad.iuTexto.deshabilitarTexto();
        campoCapacidad.modificarPosicionHorizontal(SwingConstants.RIGHT, SwingConstants.CENTER);
        campoCapacidad.cambiarColorTituloTexto(new Color(180, 0, 0), new Color(24, 75, 152));
        panelEstadia.add(campoCapacidad);
        
        campoPrecioHabitacion = new IU_PanelCampoTextoUnidad("precio de la habitacion", "170", "Bs.-", new Limite(ancho/2 + ancho/20, 2 + alto/20, ancho/5, (alto - alto/10)), 30, 50);
        campoPrecioHabitacion.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.CENTER, SwingConstants.CENTER);
        campoPrecioHabitacion.cambiarColorTituloTextoUnidad(new Color(24, 75, 152), Color.BLACK, new Color(180, 0, 0));
        campoPrecioHabitacion.iuTexto.deshabilitarTexto();
        //campoPrecioHabitacion.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
        panelEstadia.add(campoPrecioHabitacion);
        
    }
    private void construirPanelResultados(int ancho, int alto){
        panelIzquierda = new IU_Panel(new Limite(0, 0, ancho/2 + ancho/10, alto));
        panelResultados.add(panelIzquierda);
        construirPanelIzquierda(ancho/2 + ancho/10, alto);
        
        panelDerecha = new IU_Panel(new Limite(ancho/2 + ancho/10, 0, ancho/2 - ancho/10, alto));
        panelResultados.add(panelDerecha);
    }
    private void construirPanelIzquierda(int ancho, int alto){
        primerPanel = new IU_Panel(new Limite(0, 0, ancho/6, alto - alto/9));
        //primerPanel.agregarColorFondo(Color.orange, Color.red, "HORIZONTAL");
        panelIzquierda.add(primerPanel);
        construirPrimerPanel(ancho/6 - 8, alto - alto/9 - 28);
        
        administrador = new CardLayout();
        segundoPanel = new IU_Panel(new Limite(ancho/6, 0, ancho - ancho/6, alto - alto/9));
        segundoPanel.setLayout(administrador);        
        panelIzquierda.add(segundoPanel);
        construirSegundoPanel(ancho - ancho/6, alto - alto/9);
        
        tercerPanel = new IU_Panel(new Limite(0, alto - alto/9, ancho, alto/9));
        tercerPanel.agregarColorFondo(Color.BLUE, Color.BLUE, "HORIZONTAL");
        panelIzquierda.add(tercerPanel);
    }
    private void construirPrimerPanel(int ancho, int alto){

        grupo = new ButtonGroup();
        
        iuHospedaje = new IU_BotonRadio("hospedaje", new Limite(4, 8, ancho, alto/20), true);
        iuHospedaje.setForeground(new Color(180, 0, 0));
        iuHospedaje.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        primerPanel.add(iuHospedaje);
        grupo.add(iuHospedaje);
        iuHospedaje.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {                
                administrador.first(segundoPanel);
            }
        });
        
        iuHuespedes = new IU_BotonRadio("huespedes", new Limite(4, 8 + iuHospedaje.getAlto() + iuHospedaje.getY(), ancho, alto/20), false);
        iuHuespedes.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        primerPanel.add(iuHuespedes);
        grupo.add(iuHuespedes);
        iuHuespedes.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                administrador.first(segundoPanel);
                administrador.next(segundoPanel);
            }
        });
        
        iuServicios = new IU_BotonRadio("servicios", new Limite(4, 8 + iuHuespedes.getAlto() + iuHuespedes.getY(), ancho, alto/20), false);
        iuServicios.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        primerPanel.add(iuServicios);
        grupo.add(iuServicios);
        iuServicios.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                administrador.first(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
            }
        });
        
        iuMiniBar = new IU_BotonRadio("mini bar", new Limite(4, 8 + iuServicios.getAlto() + iuServicios.getY(), ancho, alto/20), false);
        iuMiniBar.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        primerPanel.add(iuMiniBar);
        grupo.add(iuMiniBar);
        iuMiniBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                administrador.first(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
            }
        });
        
        iuHabitacion = new IU_BotonRadio("habitacion", new Limite(4, 8 + iuMiniBar.getAlto() + iuMiniBar.getY(), ancho, alto/20), false);
        iuHabitacion.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        primerPanel.add(iuHabitacion);
        grupo.add(iuHabitacion);
        iuHabitacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                administrador.first(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
            }
        });
        
        iuDisponible = new IU_BotonRadio("disponible", new Limite(4, 8 + iuHabitacion.getY() + iuHabitacion.getAlto(), ancho, alto/20), false);
        iuDisponible.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        primerPanel.add(iuDisponible);
        grupo.add(iuDisponible);
        iuDisponible.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                administrador.first(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
                administrador.next(segundoPanel);
            }
        });
        
        iuAnticipo = new IU_BotonRadio("anticipos", new Limite(4, 8 + iuDisponible.getAlto() + iuDisponible.getY(), ancho, alto/20), false);
        iuAnticipo.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        primerPanel.add(iuAnticipo);
        grupo.add(iuAnticipo);
        iuAnticipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                administrador.last(segundoPanel);
            }
        });
        
    }
    private void construirSegundoPanel(int ancho, int alto){
        panelHospedaje = new IU_PanelHospedaje(ventana, "hospedaje", new Limite(0, 0, ancho, alto));
        segundoPanel.add(panelHospedaje);
        
        panelHuesped = new IU_PanelHuesped(ventana, "huespedes", new Limite(0, 0, ancho, alto));
        segundoPanel.add(panelHuesped);
        
        panelServicios = new IU_PanelServicios(ventana, "servicios", new Limite(0, 0, ancho, alto));
        segundoPanel.add(panelServicios);
        
        panelMiniBar = new IU_PanelMiniBar(ventana, "mini bar", new Limite(0, 0, ancho, alto));
        segundoPanel.add(panelMiniBar);
        
        panelHabitacion = new IU_PanelHabitacion(ventana, "habitacion", new Limite(0, 0, ancho, alto));
        segundoPanel.add(panelHabitacion);
        
        panelDisponible = new IU_PanelDisponible(ventana, "disponibilidad", new Limite(0, 0, ancho, alto));
        segundoPanel.add(panelDisponible);
        
        panelAnticipos = new IU_PanelAnticipo(ventana, "anticipos", new Limite(0, 0, ancho, alto));
        segundoPanel.add(panelAnticipos);
    }
}
