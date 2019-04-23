/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

import FAST.com.clases.Apoyo;
import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelBotonImagen;
import FAST.com.paneles.IU_PanelCampoTextoUnidad;
import FAST.com.tablas.IU_Tabla;
import FAST.com.ventanas.IU_VentanaSeleccion;
import com.fastHotel.modeloTabla.MT_Servicio;
import com.fastHotel.modeloTabla.MT_Hospedaje;
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
public class IU_PanelServicios extends IU_Panel{
        
    private JFrame ventana;
    private String titulo;
    private Limite limite;
    
    private IU_Panel panelTitulo;
    private IU_Etiqueta etiquetaTitulo;
    private IU_Panel panelFondo;
    private MT_Servicio modeloFrigobar;
    private IU_Tabla tablaFrigobar;
    private IU_Panel panelControl;
    private IU_PanelBotonImagen botonComanda;
    private IU_PanelCampoTextoUnidad campoPrecioTotal;
    private IU_PanelBotonImagen botonVer;
    private IU_PanelBotonImagen botonModificar;
    private IU_PanelBotonImagen botonEliminar;
    private IU_PanelBotonImagen botonImprimir;
    private IU_PanelBotonImagen botonPagar;
    
    
    public IU_PanelServicios(JFrame ventana, String titulo, Limite limite){
        this.ventana = ventana;
        this.titulo = titulo;
        this.limite = limite;
        
        construirPanelFrigobar();
    }
    private void construirPanelFrigobar() {
        int ancho = limite.getAncho();
        int alto = limite.getAlto();

        panelTitulo = new IU_Panel(new Limite(0, 0, ancho, alto/18));
        panelTitulo.agregarColorFondo(new Color(24, 75, 152), new Color(24, 75, 152), "HORIZONTAL");
        add(panelTitulo);
        construirPanelTitulo(ancho, alto/18);

        panelFondo = new IU_Panel(new Limite(0, alto/18, ancho, alto - alto/18 - alto/7));
        add(panelFondo);
        construirPanelFondo(ancho - 8, alto - alto/18 - alto/7 - 8);

        panelControl = new IU_Panel(new Limite(0, alto - alto/7, ancho, alto/7));
        add(panelControl);
        construirPanelControl(ancho - 2, alto/7 - 2);
    }

    private void construirPanelTitulo(int ancho, int alto) {
        etiquetaTitulo = new IU_Etiqueta(titulo, new Limite(0, 0, ancho, alto), 1);
        etiquetaTitulo.setForeground(Color.WHITE);
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(etiquetaTitulo);
    }
    private void construirPanelFondo(int ancho, int alto){
        String[] nombre_cabecera = {"N°", "codigo", "responsable", "fecha", "hora", "concepto", "total", "estado", "•"};
        int[] ancho_cabecera = {4, 10, 20, 12, 14, 18, 8, 10, 4};

        modeloFrigobar = new MT_Servicio(nombre_cabecera);

        tablaFrigobar = new IU_Tabla(modeloFrigobar, 4, 4, ancho, alto);
        tablaFrigobar.setFuente_letra(new Font("Verdana", Font.PLAIN, 14));
        JTableHeader th = tablaFrigobar.getTableHeader();
        Font fuente = new Font("Verdana", Font.PLAIN, 14);
        th.setFont(fuente);
        tablaFrigobar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaFrigobar.setShowHorizontalLines(false);
        tablaFrigobar.setShowVerticalLines(true);
        tablaFrigobar.setColumnSelectionAllowed(false);
        tablaFrigobar.setRowSelectionAllowed(false);
        tablaFrigobar.establecer_ancho_columnas(ancho_cabecera);
        panelFondo.add(tablaFrigobar.deslizador);
    }
    private void construirPanelControl(int ancho, int alto){
        
        botonEliminar = new IU_PanelBotonImagen("eliminar", "src/imagenes/eliminarProducto.png", 70, new Limite(2, alto/50, alto - alto/25, alto - alto/25));
        panelControl.add(botonEliminar);
        
        botonImprimir = new IU_PanelBotonImagen("imp. todo", "src/imagenes/imprimir.png", 70, new Limite(botonEliminar.getAncho() + botonEliminar.getX() + 2, alto/50, alto - alto/25, alto - alto/25));
        panelControl.add(botonImprimir);        
        
        botonModificar = new IU_PanelBotonImagen("modificar", "src/imagenes/modificarProducto.png", 70, new Limite(botonImprimir.getAncho() + botonImprimir.getX() + 2, alto/50, alto - alto/25, alto - alto/25));
        panelControl.add(botonModificar);
        
        botonVer = new IU_PanelBotonImagen("ver", "src/imagenes/verProducto.png", 70, new Limite(botonModificar.getX() + botonModificar.getAncho() + 2, alto/50, alto - alto/25, alto - alto/25));
        panelControl.add(botonVer);
        
        botonComanda = new IU_PanelBotonImagen("comanda", "src/imagenes/agregarProducto.png", 70, new Limite(botonVer.getX() + botonVer.getAncho() + 2, alto/50, alto - alto/25, alto - alto/25));
        panelControl.add(botonComanda);
        botonComanda.iuImagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                elegirComanda();
            }
        });
        
        campoPrecioTotal = new IU_PanelCampoTextoUnidad("total a pagar", "250", "Bs.-", new Limite(botonComanda.getX() + botonComanda.getAncho() + 4, alto/50, ancho/3 - ancho/50, alto - alto/25), 30, 40);
        campoPrecioTotal.cambiarColorTituloTextoUnidad(new Color(24, 75, 152), Color.BLACK, new Color(180, 0, 0));
        campoPrecioTotal.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.RIGHT, SwingConstants.LEFT);
        campoPrecioTotal.agregarColorFondo(Color.YELLOW, Color.YELLOW, "HORIZONTAL");
        panelControl.add(campoPrecioTotal);
        
        botonPagar = new IU_PanelBotonImagen("pagar", "src/imagenes/pagar.png", 70, new Limite(ancho - (alto - alto/25) - 2, alto/50, alto - alto/25, alto - alto/25));
        panelControl.add(botonPagar);
    }
    private void elegirComanda(){        
        String[] opciones = {"frigobar","lavanderia","cafeteria","otros"};
        IU_VentanaSeleccion iuSeleccionar = new IU_VentanaSeleccion(ventana, "crear comanda", opciones, 4, 2, Apoyo.ANCHO/3, Apoyo.ALTO - Apoyo.ALTO/10, 50);
        switch(iuSeleccionar.getOpcion()){
            case "frigobar":
                IU_VentanaFrigobar iuFrigobar = new IU_VentanaFrigobar(ventana, "crear una nueva comanda", Apoyo.ANCHO, Apoyo.ALTO, 50);                        
            break;
            case "lavanderia":
            break;
            case "cafeteria": 
            break;
            case "otros":
            break;
        }
    }
}
