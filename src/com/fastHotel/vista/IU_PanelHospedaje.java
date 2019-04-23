/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelBotonImagen;
import FAST.com.paneles.IU_PanelCampoTextoUnidad;
import FAST.com.tablas.IU_Tabla;
import com.fastHotel.modeloTabla.F_Hospedaje;
import com.fastHotel.modeloTabla.MT_Hospedaje;
import com.fastHotel.modeloTabla.MT_Huespedes;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

/**
 *
 * @author rudolf
 */
public class IU_PanelHospedaje extends IU_Panel {

    private JFrame ventana;

    private final String titulo;
    private IU_Panel panelTitulo;
    private IU_Etiqueta etiquetaTitulo;
    private IU_Panel panelFondo;
    private MT_Hospedaje modeloHospedaje;
    private IU_Tabla tablaHospedaje;
    private IU_Panel panelControl;
    private IU_PanelBotonImagen botonDevolucion;
    private IU_PanelBotonImagen botonCambiarPrecio;
    private IU_PanelBotonImagen botonImprimirCuenta;
    private IU_PanelCampoTextoUnidad campoPrecioTotal;
    private IU_PanelBotonImagen botonPagar;

    public IU_PanelHospedaje(JFrame ventana, String titulo, Limite limite) {
        super(limite);

        this.ventana = ventana;
        this.titulo = titulo;
        construirPanelHospedaje();
    }

    private void construirPanelHospedaje() {
        int ancho = limite.getAncho();
        int alto = limite.getAlto();

        panelTitulo = new IU_Panel(new Limite(0, 0, ancho, alto / 18));
        panelTitulo.agregarColorFondo(new Color(24, 75, 152), new Color(24, 75, 152), "HORIZONTAL");
        add(panelTitulo);
        construirPanelTitulo(ancho, alto / 18);

        panelFondo = new IU_Panel(new Limite(0, alto / 18, ancho, alto - alto / 18 - alto / 7));
        add(panelFondo);
        construirPanelFondo(ancho - 8, alto - alto / 16 - alto / 7 - 8);

        panelControl = new IU_Panel(new Limite(0, alto - alto / 7, ancho, alto / 7));
        add(panelControl);
        construirPanelControl(ancho - 4, alto / 7 - 4);
    }

    private void construirPanelTitulo(int ancho, int alto) {
        etiquetaTitulo = new IU_Etiqueta(titulo, new Limite(0, 0, ancho, alto), 1);
        etiquetaTitulo.setForeground(Color.WHITE);
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(etiquetaTitulo);
    }

    private void construirPanelFondo(int ancho, int alto) {
        String[] nombre_cabecera = {"N°", "desde la fecha", "hasta la fecha", "descripcion de hospedaje", "estado", "precio", "•"};
        int[] ancho_cabecera = {4, 20, 20, 30, 10, 12, 4};

        modeloHospedaje = new MT_Hospedaje(nombre_cabecera);

        tablaHospedaje = new IU_Tabla(modeloHospedaje, 4, 4, ancho, alto);
        tablaHospedaje.setFuente_letra(new Font("Verdana", Font.PLAIN, 14));
        JTableHeader th = tablaHospedaje.getTableHeader();
        Font fuente = new Font("Verdana", Font.PLAIN, 14);
        th.setFont(fuente);
        tablaHospedaje.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaHospedaje.setShowHorizontalLines(false);
        tablaHospedaje.setShowVerticalLines(true);
        tablaHospedaje.setColumnSelectionAllowed(false);
        tablaHospedaje.setRowSelectionAllowed(false);
        tablaHospedaje.establecer_ancho_columnas(ancho_cabecera);
        panelFondo.add(tablaHospedaje.deslizador);

        modeloHospedaje.agregar_fila(new F_Hospedaje("MIE-12/05/17", "JUE-13/05/17", "PAGO de 1 noche", 170, "PAGADO", true));
        modeloHospedaje.agregar_fila(new F_Hospedaje("JUE-13/05/17", "VIE-14/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("VIE-14/05/17", "SAB-15/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("JUE-13/05/17", "VIE-14/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("VIE-14/05/17", "SAB-15/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("JUE-13/05/17", "VIE-14/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("VIE-14/05/17", "SAB-15/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("JUE-13/05/17", "VIE-14/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("VIE-14/05/17", "SAB-15/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("JUE-13/05/17", "VIE-14/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("VIE-14/05/17", "SAB-15/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("JUE-13/05/17", "VIE-14/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("VIE-14/05/17", "SAB-15/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("JUE-13/05/17", "VIE-14/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("VIE-14/05/17", "SAB-15/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
        modeloHospedaje.agregar_fila(new F_Hospedaje("VIE-14/05/17", "SAB-15/05/17", "FALTA PAGAR de 1 noche", 170, "DEBE", false));
    }

    private void construirPanelControl(int ancho, int alto) {
        botonDevolucion = new IU_PanelBotonImagen("devolucion", "src/imagenes/devolucion.png", 70, new Limite(2, alto / 100, alto - alto / 50, alto - alto / 50));
        panelControl.add(botonDevolucion);
        
        botonCambiarPrecio = new IU_PanelBotonImagen("cambiar precio", "src/imagenes/cambiar.png", 70, new Limite(4 + botonDevolucion.getX() + botonDevolucion.getAncho(), alto/100, ancho/7, alto - alto/50));
        panelControl.add(botonCambiarPrecio);
        
        botonImprimirCuenta = new IU_PanelBotonImagen("imprimir", "src/imagenes/imprimir.png", 70, new Limite(8 + botonCambiarPrecio.getX() + botonCambiarPrecio.getAncho(), alto/100, ancho/7, alto - alto/50));
        panelControl.add(botonImprimirCuenta);
        
        botonPagar = new IU_PanelBotonImagen("pagar", "src/imagenes/pagar.png", 70, new Limite(ancho - alto - alto / 50 - 4, alto / 100, alto - alto / 50, alto - alto / 50));
        panelControl.add(botonPagar);

        campoPrecioTotal = new IU_PanelCampoTextoUnidad("total a pagar (bolivianos)", "340", "Bs.-", new Limite(ancho/2 + 8, alto/100, ancho/3, alto - alto/100), 30, 40);
        campoPrecioTotal.cambiarColorTituloTextoUnidad(new Color(24, 75, 152), Color.BLACK, new Color(180, 0, 0));
        campoPrecioTotal.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.RIGHT, SwingConstants.LEFT);
        campoPrecioTotal.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
        panelControl.add(campoPrecioTotal);
        
        
    }
}
