/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

import FAST.com.botones.IU_Boton;
import FAST.com.clases.Apoyo;
import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelBotonImagen;
import FAST.com.tablas.IU_Tabla;
import com.fastHotel.modeloTabla.F_Huesped;
import com.fastHotel.modeloTabla.MT_Huespedes;
import com.fastHotel.modeloTabla.MT_ResultadosHabitacion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

/**
 *
 * @author rudolf
 */
public class IU_PanelHuesped extends IU_Panel{
    
    private JFrame ventana;
    
    private final String titulo;
    private IU_Panel panelTitulo;
    private IU_Etiqueta etiquetaTitulo;
    private IU_Panel panelFondo;
    private IU_Panel panelControl;
    private IU_PanelBotonImagen botonAgregarHuesped;
    private IU_PanelBotonImagen botonModificarHuesped;
    private IU_PanelBotonImagen botonEliminarHuesped;
    private IU_PanelBotonImagen botonImprimirDocumentos;
    private IU_PanelBotonImagen botonImprimirRegistros;
    private IU_PanelBotonImagen botonVisualizarHuesped;
    
    private MT_Huespedes modeloHuesped;
    private IU_Tabla tablaHuespedes;
    
    public IU_PanelHuesped(JFrame ventana, String titulo, Limite limite){
        super(limite);
        this.ventana = ventana;
        this.titulo = titulo;
        agregarColorFondo(Color.LIGHT_GRAY, Color.LIGHT_GRAY, "HORIZONTAL");
        construirPanelHuespedes();
    }
    private void construirPanelHuespedes(){
        int ancho = limite.getAncho();
        int alto = limite.getAlto();
        
        panelTitulo = new IU_Panel(new Limite(0, 0, ancho, alto/18));
        panelTitulo.agregarColorFondo(new Color(24, 75, 152), new Color(24, 75, 152), "HORIZONTAL");
        add(panelTitulo);
        construirPanelTitulo(ancho, alto/18);
        
        panelFondo = new IU_Panel(new Limite(0, alto/18, ancho, alto - alto/18 - alto/7));
        add(panelFondo);
        construirPanelFondo(ancho - 8, alto - alto/16 - alto/7 - 8);
        
        panelControl = new IU_Panel(new Limite(0, alto - alto/7, ancho, alto/7));        
        add(panelControl);
        construirPanelControl(ancho - 4, alto/7 - 4);
    }
    private void construirPanelTitulo(int ancho, int alto){
        etiquetaTitulo = new IU_Etiqueta(titulo, new Limite(0, 0, ancho, alto), 1);
        etiquetaTitulo.setForeground(Color.WHITE);
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(etiquetaTitulo);
    }
    private void construirPanelFondo(int ancho, int alto){
        String[] nombre_cabecera = {"N°","nombre completo","fecha nac.","edad","documento","estado","•"};
        int[] ancho_cabecera = {4, 40, 16, 6, 20, 10, 4};
        
        modeloHuesped = new MT_Huespedes(nombre_cabecera);        
        
        tablaHuespedes = new IU_Tabla(modeloHuesped, 4, 4, ancho, alto);
        tablaHuespedes.setFuente_letra(new Font("Verdana", Font.PLAIN, 14));        
        JTableHeader th = tablaHuespedes.getTableHeader();          
        Font fuente = new Font("Verdana", Font.PLAIN, 14); 
        th.setFont(fuente);        
        tablaHuespedes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaHuespedes.setShowHorizontalLines(false);
        tablaHuespedes.setShowVerticalLines(true);
        tablaHuespedes.setColumnSelectionAllowed(false);
        tablaHuespedes.setRowSelectionAllowed(false);
        tablaHuespedes.establecer_ancho_columnas(ancho_cabecera);        
        panelFondo.add(tablaHuespedes.deslizador);
        
        modeloHuesped.agregar_fila(new F_Huesped("rudolf felipez mancilla", "1983-07-02", 33, "carnet identidad", "vigente", false, null));
    }
    private void construirPanelControl(int ancho, int alto){
        botonAgregarHuesped = new IU_PanelBotonImagen("agregar", "src/imagenes/agregar.png", 70, new Limite(ancho - ancho/7 - 4, 4 + alto/20, ancho/7, alto - alto/10));
        panelControl.add(botonAgregarHuesped);
        botonAgregarHuesped.iuImagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                IU_Huesped iuHuesped = new IU_Huesped(ventana, "", Apoyo.ANCHO, Apoyo.ALTO, 50);
                
            }
        });
        
        botonVisualizarHuesped = new IU_PanelBotonImagen("visualizar", "src/imagenes/visualizar.png", 70, new Limite(ancho - 2*ancho/7 - 8, 4 + alto/20, ancho/7, alto - alto/10));
        panelControl.add(botonVisualizarHuesped);
        
        botonModificarHuesped = new IU_PanelBotonImagen("modificar", "src/imagenes/modificar.png", 70, new Limite(ancho - 3*ancho/7 - 12, 4 + alto/20, ancho/7, alto - alto/10));
        panelControl.add(botonModificarHuesped);
        
        botonImprimirDocumentos = new IU_PanelBotonImagen("imp. doc.", "src/imagenes/imprimirDoc.png", 70, new Limite(ancho - 4*ancho/7 - 16, 4 + alto/20, ancho/7, alto - alto/10));
        panelControl.add(botonImprimirDocumentos);
        
        botonImprimirRegistros = new IU_PanelBotonImagen("imp. reg.", "src/imagenes/imprimir.png", 70, new Limite(ancho - 5*ancho/7 - 20, 4 + alto/20, ancho/7, alto - alto/10));
        panelControl.add(botonImprimirRegistros);
        
        botonEliminarHuesped = new IU_PanelBotonImagen("eliminar", "src/imagenes/eliminar.png", 70, new Limite(4, 4 + alto/20, ancho/7, alto - alto/10));
        panelControl.add(botonEliminarHuesped);
    }
}
