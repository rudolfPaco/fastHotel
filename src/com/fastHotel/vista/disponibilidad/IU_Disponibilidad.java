/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista.disponibilidad;

import FAST.com.botones.IU_Boton;
import FAST.com.botones.IU_BotonCheckBox;
import FAST.com.calendario.Fecha;
import FAST.com.calendario.CalendarioPantallaIU;
import FAST.com.clases.Apoyo;
import FAST.com.clases.Hora;
import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelCampoTexto;
import FAST.com.paneles.IU_PanelSpinner;
import FAST.com.tablas.IU_Tabla;
import FAST.com.ventanas.IUVentanaPadre;
import FAST.com.ventanas.IU_VentanaSecundaria;
import com.fastHotel.modeloTabla.F_Resultados;
import com.fastHotel.modeloTabla.MT_ResultadosHabitacion;
import com.fastHotel.modeloTabla.RenderResultado;
import com.fastHotel.vista.IU_CheckIn;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

/**
 *
 * @author rudolf
 */
public class IU_Disponibilidad extends IUVentanaPadre{
    public JFrame principal;
    
    private IU_Panel panelBusqueda;
    private IU_PanelCampoTexto campoFechaLlegada;
    private IU_Etiqueta etiquetaFechaLlegada;
    private IU_PanelCampoTexto campoFechaSalida;
    private IU_Etiqueta etiquetaFechaSalida;
    private IU_PanelSpinner spinnerNoches;
    private IU_BotonCheckBox botonCheckSimple;
    private IU_BotonCheckBox botonCheckMatrimonial;
    private IU_BotonCheckBox botonCheckDobleSimple;
    private IU_BotonCheckBox botonCheckTriple;
    private IU_BotonCheckBox botonCheckFamiliar;
    public IU_Etiqueta etiquetaBuscar;
    
    private IU_Panel panelResultados;

    private IU_Panel panelTabla;
    public IU_Tabla tablaResultados;
    public MT_ResultadosHabitacion modeloResultados;
    
    public IU_Boton botonCheckIn;
    public IU_Boton botonReservar;
    
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public IU_Disponibilidad(JFrame ventana, String titulo, int ancho, int alto, int altura){
        super(ventana, titulo);
        this.principal = ventana;        
        
        moverVentana();
        cerrarVentana();        
    }
    public void construirPaneles(){
        int espacio = 2;
        int ancho = pantalla.getWidth() - 2*espacio;
        int alto = pantalla.getHeight() - 2*espacio;
        
        panelBusqueda = new IU_Panel(new Limite(espacio, espacio, ancho, alto/12));        
        pantalla.add(panelBusqueda);
        construirPanelBusqueda(ancho - 6, alto/12 - 4);
        
        panelResultados = new IU_Panel(new Limite(espacio, espacio + alto/12, ancho, (alto - alto/12 - espacio) - (alto - alto/12 - espacio)/6));        
        panelResultados.agregarColorFondo(Color.orange, Color.red, "HORIZONTAL");
        pantalla.add(panelResultados);
        construirPanelResultados();        
        construirPanelBotones();
    }
    private void construirPanelBusqueda(int ancho, int alto){        
        campoFechaLlegada = new IU_PanelCampoTexto("fecha de llegada", "", new Limite(2, 2 + alto/20, ancho/7, alto - alto/10), 40);        
        campoFechaLlegada.iuTexto.setFocusable(false);
        campoFechaLlegada.iuTexto.deshabilitarTexto();
        campoFechaLlegada.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        panelBusqueda.add(campoFechaLlegada);
        
        etiquetaFechaLlegada = new IU_Etiqueta("src/imagenes/fecha.png", new Limite(4 + ancho/7, 2 + alto/20, (alto - alto/10), (alto - alto/10)));
        etiquetaFechaLlegada.agregarBordeContorno(null);
        panelBusqueda.add(etiquetaFechaLlegada);
        etiquetaFechaLlegada.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                CalendarioPantallaIU calendario = new CalendarioPantallaIU(principal, new Fecha().getFechaDia_literal_fechaHotel(), new Fecha(), ANCHO - ANCHO/5, ALTO/2, 50);
                calendario.mostrar();
                
                if(calendario.getElemento().getObjeto() != null){
                    if(!((Fecha)calendario.getElemento().getObjeto()).esMenor(new Fecha())){
                        campoFechaLlegada.iuTexto.setText(((Fecha)calendario.getElemento().getObjeto()).getFechaMysql());
                        campoFechaSalida.iuTexto.setText(((Fecha)calendario.getElemento().getObjeto()).proximaDiaFecha().getFechaMysql());
                        spinnerNoches.iuBotonAbajo.setVisible(true);
                        spinnerNoches.iuBotonArriba.setVisible(true);
                        spinnerNoches.campoTexto.setText("1");
                        campoFechaLlegada.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
                        campoFechaSalida.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
                    }                    
                    else
                        Apoyo.mostrarMensaje(principal, "la fecha que ingreso es INCORRECTA...!");                        
                }                                    
            }
        });
        
        campoFechaSalida = new IU_PanelCampoTexto("fecha de salida", "", new Limite(ancho/5, 2 + alto/20, ancho/7, alto - alto/10), 40);        
        campoFechaSalida.iuTexto.setFocusable(false);
        campoFechaSalida.iuTexto.deshabilitarTexto();
        campoFechaSalida.cambiarColorTituloTexto(new Color(24, 75, 152), new Color(180, 0, 0));
        panelBusqueda.add(campoFechaSalida);
        
        etiquetaFechaSalida = new IU_Etiqueta("src/imagenes/fecha.png", new Limite(4 + ancho/5 + ancho/7, 2 + alto/20, (alto - alto/10), (alto - alto/10)));
        etiquetaFechaSalida.agregarBordeContorno(null);
        panelBusqueda.add(etiquetaFechaSalida);
        etiquetaFechaSalida.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(!campoFechaLlegada.getDato().isEmpty()){
                    CalendarioPantallaIU calendario = new CalendarioPantallaIU(principal, new Fecha().getFechaDia_literal_fechaHotel(), new Fecha(), ANCHO - ANCHO/5, ALTO/2, 50);
                    calendario.mostrar();

                    if(((Fecha)calendario.getElemento().getObjeto()).esMayor(new Fecha(campoFechaLlegada.getDato(), "yyyy-MM-dd"))){
                        campoFechaSalida.iuTexto.setText(((Fecha)calendario.getElemento().getObjeto()).getFechaMysql());
                        int numero = new Fecha(campoFechaLlegada.getDato(), "yyyy-MM-dd").restarDiasFecha(((Fecha)calendario.getElemento().getObjeto()));
                        spinnerNoches.campoTexto.setText(String.valueOf(numero));                                                    
                    }else
                        Apoyo.mostrarMensaje(principal, "la fecha que ingreso es INCORRECTA...!");
                }
            }
        });
        
        spinnerNoches = new IU_PanelSpinner("noches", new Limite(ancho/2 - ancho/10, 2 + alto/20, ancho/10, alto - alto/10), 40, 1, 1, 50);
        spinnerNoches.iuBotonAbajo.setVisible(false);
        spinnerNoches.iuBotonArriba.setVisible(false);
        spinnerNoches.setColor(new Color(24, 75, 152), Color.BLACK, Color.BLACK);
        spinnerNoches.campoTexto.setText("");
        panelBusqueda.add(spinnerNoches);
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
        
        botonCheckSimple = new IU_BotonCheckBox("SIMPLE", new Limite(ancho/20 + ancho/2, 2 + alto/20, ancho/10, etiquetaFechaLlegada.getAlto()/2), false);
        botonCheckSimple.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        panelBusqueda.add(botonCheckSimple);
        
        botonCheckMatrimonial = new IU_BotonCheckBox("MATRIMONIAL", new Limite(ancho/20 + ancho/2 + ancho/10 + 4, 2 + alto/20, ancho/6, etiquetaFechaLlegada.getAlto()/2), false);
        botonCheckMatrimonial.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        panelBusqueda.add(botonCheckMatrimonial);
        
        botonCheckTriple = new IU_BotonCheckBox("TRIPLE", new Limite(ancho/20 + ancho/2 + ancho/10 + 8 + ancho/6, 2 + alto/20, ancho/10, etiquetaFechaLlegada.getAlto()/2), false);
        botonCheckTriple.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        panelBusqueda.add(botonCheckTriple);
        
        etiquetaBuscar = new IU_Etiqueta("src/imagenes/buscar.png", new Limite(ancho - (alto - alto/10), 2 + alto/20, (alto - alto/10), (alto - alto/10)));
        etiquetaBuscar.agregarBordeContorno(null);
        panelBusqueda.add(etiquetaBuscar);
        
        botonCheckDobleSimple = new IU_BotonCheckBox("DOBLE SIMPLE", new Limite(ancho/20 + ancho/2, 2 + alto/20 + etiquetaFechaLlegada.getAlto()/2, ancho/5, etiquetaFechaLlegada.getAlto()/2), false);               
        botonCheckDobleSimple.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        panelBusqueda.add(botonCheckDobleSimple);
        
        botonCheckFamiliar = new IU_BotonCheckBox("FAMILIAR", new Limite(ancho/20 + ancho/2 + 4 + ancho/5, 2 + alto/20 + etiquetaFechaLlegada.getAlto()/2, ancho/7, etiquetaFechaLlegada.getAlto()/2), false);
        botonCheckFamiliar.setColorSeleccion(Color.BLACK, new Color(180, 0, 0));
        panelBusqueda.add(botonCheckFamiliar);
    }
    private void construirPanelResultados(){
        int ancho = panelResultados.getAncho();
        int alto = panelResultados.getAlto();
        
        panelTabla = new IU_Panel(new Limite(0, 0, ancho, alto));
        panelResultados.add(panelTabla);
        construirPanelTabla();        
    }
    private void construirPanelTabla(){
        int espacio = 4;
        int ancho = panelTabla.getAncho() - 2*espacio;
        int alto = panelTabla.getAlto() - 2*espacio;
        
        String[] nombre_cabecera = {"N°","habitacion","tipo de habitacion","cap.","piso","camas","precio","estado","hora disponible","•"};        
        int[] ancho_cabecera = {4, 10, 19, 4, 10, 21, 10, 10, 10, 2};        
        
        modeloResultados = new MT_ResultadosHabitacion(nombre_cabecera);        
        
        tablaResultados = new IU_Tabla(modeloResultados, espacio, espacio, ancho, alto);
        tablaResultados.setFuente_letra(new Font("Verdana", Font.PLAIN, 14));        
        JTableHeader th = tablaResultados.getTableHeader();          
        Font fuente = new Font("Verdana", Font.PLAIN, 14); 
        th.setFont(fuente);        
        tablaResultados.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaResultados.setShowHorizontalLines(false);
        tablaResultados.setShowVerticalLines(true);
        tablaResultados.setColumnSelectionAllowed(false);
        tablaResultados.setRowSelectionAllowed(false);
        tablaResultados.establecer_ancho_columnas(ancho_cabecera);        
        panelTabla.add(tablaResultados.deslizador);
        
        modeloResultados.agregar_fila(new F_Resultados("101 S", "SIMPLE", 1, "2° piso", "1 cama de 1 1/2 plaza", 170.0, "VACANTE", new Hora().cadenaHora()+" "+new Hora().getFormato(), false, null));
        modeloResultados.agregar_fila(new F_Resultados("105 S", "SIMPLE", 1, "2° piso", "1 cama de 1 1/2 plaza", 170.0, "VACANTE", new Hora().cadenaHora()+" "+new Hora().getFormato(), false, null));
        
        for (int i = 0; i < modeloResultados.tipoColumnas.length - 1; i++) {
            tablaResultados.setDefaultRenderer(modeloResultados.tipoColumnas[i], new RenderResultado());
        }        
    }
    private void construirPanelBotones(){
        int espacio = 5;
        int ancho = pantalla.getWidth() - 2*espacio;
        int alto = pantalla.getHeight() - 2*espacio;
        
        botonCheckIn = new IU_Boton("check in", new Limite(ancho - alto/7 + espacio, alto - alto/7 + espacio, alto/7, alto/7), 5);        
        pantalla.add(botonCheckIn);
        botonCheckIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                IU_CheckIn iuCheckIn = new IU_CheckIn(principal, "CHECK-IN a la habitacion: 204 TM (TRIPLE MATRIMONIAL)", ANCHO, ALTO, 50);
            }
        });
        
        botonReservar = new IU_Boton("reservar", new Limite(ancho - 2*alto/7, alto - alto/7 + espacio, alto/7, alto/7), 5);        
        pantalla.add(botonReservar);
    }
    public boolean estaSeleccionadoFilaTabla(){
        return tablaResultados.getSelectedRow() > -1;
    }
}
