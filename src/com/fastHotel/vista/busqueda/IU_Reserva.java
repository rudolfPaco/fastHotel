/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista.busqueda;

import FAST.com.botones.IU_Boton;
import FAST.com.calendario.HoraIU;
import FAST.com.clases.Apoyo;
import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelCampoTexto;
import FAST.com.paneles.IU_PanelCampoTextoUnidad;
import FAST.com.paneles.IU_PanelSpinner;
import FAST.com.tablas.IU_Tabla;
import FAST.com.ventanas.IUVentanaHijo;
import com.fastHotel.control.disponibilidad.C_Disponibilidad;
import com.fastHotel.modeloTabla.F_Reserva;
import com.fastHotel.modeloTabla.MT_Reserva;
import com.fastHotel.vista.disponibilidad.IU_VentanaReserva;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hotel-felipez
 */
public class IU_Reserva extends IUVentanaHijo{
    
    public C_Disponibilidad controlDisponibilidad;
    
    private IU_Panel primerPanel;
    private IU_PanelCampoTexto campoFechaLlegada;
    private IU_Etiqueta etiquetaFechaLlegada;
    private IU_PanelCampoTexto campoFechaSalida;
    private IU_Etiqueta etiquetaFechaSalida;
    private IU_PanelSpinner spinnerNoches;
    public IU_PanelCampoTextoUnidad campoHoraLlegada;    
    public IU_Etiqueta botonHoraLlegada;
    public IU_PanelCampoTexto campoNumeroReserva;
    
    private IU_Panel segundoPanel;
    private IU_PanelCampoTexto nombreTitular;
    private IU_PanelCampoTexto telefonoTitular;
    private IU_PanelCampoTexto empresaTitular;
    private IU_PanelCampoTexto nit;
    private IU_PanelCampoTexto razonSocial;
    private IU_PanelCampoTexto descripcionReserva;
    public IU_Etiqueta botonBuscarPersona;
    
    private IU_Panel tercerPanel;
    public IU_Tabla tablaReserva;
    public MT_Reserva modeloReserva;
        
    private IU_Panel cuartoPanel;
    public IU_Boton botonGuardar;    
    public IU_Boton botonModificar;
    public IU_Boton botonVer;
    public IU_Boton botonEliminar;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public IU_Reserva(C_Disponibilidad controlDisponibilidad, String titulo){
        super(controlDisponibilidad.iuDisponibilidad, titulo);
        this.controlDisponibilidad = controlDisponibilidad;
    }
    public void contruirPaneles(){
        int espacio = 4;
        int ancho = getContentPane().getWidth() - 2*espacio;
        int alto = getContentPane().getHeight() - 4*espacio;
        
        primerPanel = new IU_Panel(new Limite(espacio, espacio, ancho, alto/12));
        add(primerPanel);
        construirPrimerPanel();
        
        segundoPanel = new IU_Panel(new Limite(espacio, primerPanel.getY() + primerPanel.getAlto(), ancho, alto/4 + alto/30));
        add(segundoPanel);
        construirSegundoPanel();
        
        tercerPanel = new IU_Panel(new Limite(espacio, segundoPanel.getY() + segundoPanel.getAlto(), ancho, alto/2));
        add(tercerPanel);
        construirTercerPanel();
        
        cuartoPanel = new IU_Panel(new Limite(espacio, tercerPanel.getY() + tercerPanel.getAlto(), ancho, alto - primerPanel.getAlto() - segundoPanel.getAlto() - tercerPanel.getAlto() + 3*espacio));
        add(cuartoPanel);
        construirCuartoPanel();
    }
    private void construirPrimerPanel(){
        int espacio = 4;
        int ancho = primerPanel.getWidth() - 2*espacio;
        int alto = primerPanel.getHeight() - 2*espacio;
        
        campoFechaLlegada = new IU_PanelCampoTexto("fecha de llegada", "", new Limite(2, 2 + alto/20, ancho/7, alto - alto/10), 40);        
        campoFechaLlegada.iuTexto.setFocusable(false);
        campoFechaLlegada.iuTexto.deshabilitarTexto();
        campoFechaLlegada.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        campoFechaLlegada.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
        primerPanel.add(campoFechaLlegada);
        
        etiquetaFechaLlegada = new IU_Etiqueta("src/imagenes/fecha.png", new Limite(4 + ancho/7, 2 + alto/20, (alto - alto/10), (alto - alto/10)));
        etiquetaFechaLlegada.agregarBordeContorno(null);
        primerPanel.add(etiquetaFechaLlegada);
        
        campoFechaSalida = new IU_PanelCampoTexto("fecha de salida", "", new Limite(ancho/5, 2 + alto/20, ancho/7, alto - alto/10), 40);        
        campoFechaSalida.iuTexto.setFocusable(false);
        campoFechaSalida.iuTexto.deshabilitarTexto();
        campoFechaSalida.cambiarColorTituloTexto(new Color(24, 75, 152), new Color(180, 0, 0));
        campoFechaSalida.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
        primerPanel.add(campoFechaSalida);
        
        etiquetaFechaSalida = new IU_Etiqueta("src/imagenes/fecha.png", new Limite(4 + ancho/5 + ancho/7, 2 + alto/20, (alto - alto/10), (alto - alto/10)));
        etiquetaFechaSalida.agregarBordeContorno(null);
        primerPanel.add(etiquetaFechaSalida);
        
        spinnerNoches = new IU_PanelSpinner("noches", new Limite(ancho/2 - ancho/10, 2 + alto/20, ancho/10, alto - alto/10), 38, 1, 1, 50);
        spinnerNoches.iuBotonAbajo.setVisible(false);
        spinnerNoches.iuBotonArriba.setVisible(false);
        spinnerNoches.setColor(new Color(24, 75, 152), Color.BLACK, Color.BLACK);
        spinnerNoches.campoTexto.setText("");
        primerPanel.add(spinnerNoches);
        
        campoHoraLlegada = new IU_PanelCampoTextoUnidad("hora de llegada", "", "", new Limite(4 + spinnerNoches.getX() + spinnerNoches.getAncho(), 2 + alto/20, ancho/7, (alto - alto/10)), 40, 30);
        campoHoraLlegada.iuTexto.setFocusable(false);
        campoHoraLlegada.iuTexto.deshabilitarTexto();
        campoHoraLlegada.iuUnidad.setHorizontalAlignment(SwingConstants.CENTER);
        campoHoraLlegada.cambiarColorTituloTextoUnidad(new Color(24, 75, 152), Color.BLACK, new Color(180, 0, 0));
        primerPanel.add(campoHoraLlegada);
        
        botonHoraLlegada = new IU_Etiqueta("src/imagenes/hora.png", new Limite(campoHoraLlegada.getX() + campoHoraLlegada.getAncho(), 2 + alto/20, (alto - alto/10), (alto - alto/10)));
        botonHoraLlegada.agregarBordeContorno(null);
        primerPanel.add(botonHoraLlegada);
        
        campoNumeroReserva = new IU_PanelCampoTexto("numero de reserva", "", new Limite(ancho - ancho/5 - espacio, 2 + alto/20, ancho/5, (alto - alto/10)), 40);
        campoNumeroReserva.iuTexto.setFocusable(false);
        campoNumeroReserva.iuTexto.deshabilitarTexto();
        campoNumeroReserva.cambiarColorTituloTexto(new Color(24, 75, 152), new Color(180, 0, 0));
        campoNumeroReserva.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
        primerPanel.add(campoNumeroReserva);
    }
    private void construirSegundoPanel(){
        int espacio = 4;
        int ancho = segundoPanel.getWidth() - 2*espacio;
        int alto = (segundoPanel.getHeight() - 3*espacio)/4 - espacio;
        
        nombreTitular = new IU_PanelCampoTexto("nombre del titular", "", new Limite(espacio, espacio, ancho/2, alto), 40);
        nombreTitular.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        nombreTitular.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        segundoPanel.add(nombreTitular);
        
        botonBuscarPersona = new IU_Etiqueta("src/imagenes/buscar.png", new Limite(espacio + nombreTitular.getX() + nombreTitular.getAncho(), espacio, alto, alto));        
        botonBuscarPersona.setBorder(null);
        segundoPanel.add(botonBuscarPersona);
        
        telefonoTitular = new IU_PanelCampoTexto("telefono", "", new Limite(espacio, espacio + nombreTitular.getY() + nombreTitular.getAlto(), ancho/6, alto), 40);
        telefonoTitular.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        telefonoTitular.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        segundoPanel.add(telefonoTitular);
        
        empresaTitular = new IU_PanelCampoTexto("nombre de la empresa", "", new Limite(espacio + telefonoTitular.getX() + telefonoTitular.getAncho(), espacio + nombreTitular.getY() + nombreTitular.getAlto(), ancho/2, alto), 40);
        empresaTitular.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        empresaTitular.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        segundoPanel.add(empresaTitular);
        
        descripcionReserva = new IU_PanelCampoTexto("descripcion de la reserva", "", new Limite(espacio, 3*espacio + telefonoTitular.getY() + telefonoTitular.getAlto(), ancho - 2*espacio, alto), 40);
        descripcionReserva.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        descripcionReserva.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        segundoPanel.add(descripcionReserva);
        
        nit = new IU_PanelCampoTexto("nit/carnet de identidad", "", new Limite(espacio, espacio + descripcionReserva.getY() + descripcionReserva.getAlto(), ancho/6, alto), 40);
        nit.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        nit.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        segundoPanel.add(nit);
        
        razonSocial = new IU_PanelCampoTexto("nombre/razon social", "", new Limite(espacio + nit.getX() + nit.getAncho(), nit.getY(), ancho/3, alto), 40);
        razonSocial.iuTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        razonSocial.cambiarColorTituloTexto(new Color(24, 75, 152), Color.BLACK);
        segundoPanel.add(razonSocial);
    }
    private void construirTercerPanel(){
        int espacio = 2;
        int ancho = tercerPanel.getAncho() - 2*espacio;
        int alto = tercerPanel.getAlto() - 2*espacio;
        
        String[] nombre_cabecera = {"habitacion","precio","nombre","telefono","pers.","anticipo","descripcion anticipo","llegada","observacion"};        
        int[] ancho_cabecera = {15, 6, 21, 8, 5, 6, 15, 7, 17};
        
        modeloReserva = new MT_Reserva(nombre_cabecera);        
        
        tablaReserva = new IU_Tabla(modeloReserva, espacio, espacio, ancho, alto);
        tablaReserva.setFuente_letra(new Font("Verdana", Font.PLAIN, 14));
        JTableHeader th = tablaReserva.getTableHeader();          
        Font fuente = new Font("Verdana", Font.BOLD, 14); 
        th.setFont(fuente);                
        tablaReserva.posicionarHorizontalmenteTexto(1, SwingConstants.CENTER);
        tablaReserva.posicionarHorizontalmenteTexto(4, SwingConstants.CENTER);
        tablaReserva.posicionarHorizontalmenteTexto(5, SwingConstants.CENTER);
        tablaReserva.posicionarHorizontalmenteTexto(7, SwingConstants.CENTER);
        tablaReserva.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaReserva.setShowHorizontalLines(false);
        tablaReserva.setShowVerticalLines(true);
        tablaReserva.setColumnSelectionAllowed(false);
        tablaReserva.setRowSelectionAllowed(true);          
        tablaReserva.establecer_ancho_columnas(ancho_cabecera);        
        tercerPanel.add(tablaReserva.deslizador);
        
        F_Reserva r = new F_Reserva();
        r.setHabitacion("101S SIMPLE");
        r.setPrecio(170);
        //r.setNombre("Antonio Barrera Delgadillo");
        //r.setTelefono("70786029");
        r.setNumeroPersonas(1);
        r.setAnticipo(0);
        r.setDescripcionAnticipo("");
        //r.setHoraLlegada(new Hora().cadenaHora());
        //r.setObservacion("cliente del grupo LARCOS");        
        modeloReserva.agregar_fila(r);
        
        F_Reserva a = new F_Reserva();
        a.setHabitacion("102M MATRIMONIAL");
        a.setPrecio(220.0);
        //a.setNombre("Claros Anabel Delmiris Escalera Calderon");
        //a.setTelefono("60375589");
        a.setNumeroPersonas(1);
        //a.setAnticipo(100.0);
        //a.setDescripcionAnticipo("dep. banco union");
        //a.setHoraLlegada(new Hora().cadenaHora());
        //a.setObservacion("cliente del grupo LARCOS");        
        modeloReserva.agregar_fila(a);
        
        
    }
    private void construirCuartoPanel(){
        int espacio = 2;
        int ancho = cuartoPanel.getAncho() - 2*espacio;
        int alto = cuartoPanel.getAlto() - 2*espacio;
        
        botonGuardar = new IU_Boton("src/imagenes/ok.png", new Limite(ancho - (alto - alto/10) - (alto - alto/10)/7, espacio + alto/20, alto - alto/10, alto - alto/10));
        cuartoPanel.add(botonGuardar);        
        
        botonModificar = new IU_Boton("src/imagenes/cambiar.png", new Limite(ancho - 2*(alto - alto/10) - 2*(alto - alto/10)/7, espacio + alto/20, alto - alto/10, alto - alto/10));
        cuartoPanel.add(botonModificar);
        
        botonVer = new IU_Boton("src/imagenes/visualizar.png", new Limite(ancho - 3*(alto - alto/10) - 3*(alto - alto/10)/7, espacio + alto/20, alto - alto/10, alto - alto/10));
        cuartoPanel.add(botonVer);
        
        botonEliminar = new IU_Boton("src/imagenes/borrar.png", new Limite(ancho - 4*(alto - alto/10) - 4*(alto - alto/10)/7, espacio + alto/20, alto - alto/10, alto - alto/10));
        cuartoPanel.add(botonEliminar);
    }
    public void establecerHora(){
        HoraIU iuHora = new HoraIU(controlDisponibilidad.iuDisponibilidad.principal, "establecer la hora", Apoyo.ANCHO - Apoyo.ANCHO/4, Apoyo.ALTO/2, 50);            
        iuHora.mostrar();
        if(iuHora.getEstado()){
            campoHoraLlegada.iuTexto.setText(iuHora.getHora().cadenaHora());
            campoHoraLlegada.iuUnidad.setText(iuHora.getFormato());
        }
    }
    public void modificarReserva(){
        IU_VentanaReserva iuModificarReserva = new IU_VentanaReserva(this);
        iuModificarReserva.construirPaneles();
        iuModificarReserva.mostrarVentana();
    }
}