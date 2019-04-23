/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

import FAST.com.botones.IU_Boton;
import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelBotonImagen;
import FAST.com.paneles.IU_PanelCampoTexto;
import FAST.com.paneles.IU_PanelCampoTextoUnidad;
import FAST.com.paneles.IU_PanelComboBox;
import FAST.com.tablas.IU_Tabla;
import FAST.com.ventanas.IU_VentanaSecundaria;
import com.fastHotel.modeloTabla.F_Categoria;
import com.fastHotel.modeloTabla.F_DetalleProducto;
import com.fastHotel.modeloTabla.F_Frigobar;
import com.fastHotel.modeloTabla.MT_Categoria;
import com.fastHotel.modeloTabla.MT_DetalleProducto;
import com.fastHotel.modeloTabla.MT_Frigobar;
import com.fastHotel.modeloTabla.MT_Servicio;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author rudolf
 */
public class IU_VentanaFrigobar extends IU_VentanaSecundaria{
    
    private JFrame ventana;
    
    private IU_Panel primerPanel;
    private MT_Categoria modeloCategoria;
    private IU_Tabla tablaCategoria;
    private IU_Panel segundoPanel;
    private MT_Frigobar modeloFrigobar;
    private IU_Tabla tablaFrigobar;
    private IU_Panel tercerPanel;
    private IU_Panel panelDatos;
    private IU_Boton botonTitulo;
    private IU_PanelCampoTexto nombreHabitacion;
    private IU_PanelCampoTexto fechaFrigobar;
    private IU_PanelCampoTextoUnidad horaFrigobar;
    private IU_PanelComboBox responsableFrigobar;
    private IU_Panel panelTabla;
    private MT_DetalleProducto modeloDetalleProducto;
    private IU_Tabla tablaDetalleProducto;
    private IU_Etiqueta cantidadTotal;
    private IU_PanelCampoTexto campoTotalPagar;
    private IU_Panel panelBotones;
    private IU_PanelBotonImagen botonGuardar;
    private IU_PanelBotonImagen botonDevolver;
    
    public IU_VentanaFrigobar(JFrame ventana, String titulo, int ancho, int alto, int altura){
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
        int alto = panelFondo.getHeight() - 3*espacio;
        
        primerPanel = new IU_Panel(new Limite(espacio, espacio, ancho/7, alto));
        panelFondo.add(primerPanel);
        construirPrimerPanel(ancho/7 - 8, alto - 8);
        
        segundoPanel = new IU_Panel(new Limite(espacio + primerPanel.getAncho() + primerPanel.getX(), espacio, ancho - primerPanel.getAncho() - primerPanel.getX() - ancho/4, alto));
        panelFondo.add(segundoPanel);
        construirSegundoPanel(ancho - primerPanel.getAncho() - primerPanel.getX() - ancho/4 - 8, alto - 8);
        
        tercerPanel = new IU_Panel(new Limite(espacio + segundoPanel.getAncho() + segundoPanel.getX(), espacio, ancho - (espacio + segundoPanel.getAncho() + segundoPanel.getX()), alto + espacio));
        panelFondo.add(tercerPanel);
        construirTercerPanel(ancho - (espacio + segundoPanel.getAncho() + segundoPanel.getX()) - 6, alto + espacio - 10);
    }
    private void construirPrimerPanel(int ancho, int alto){
        String[] nombre_cabecera = {"categoria"};
        int[] ancho_cabecera = {100};

        modeloCategoria = new MT_Categoria(nombre_cabecera);

        tablaCategoria = new IU_Tabla(modeloCategoria, 4, 4, ancho, alto);
        tablaCategoria.setFuente_letra(new Font("Verdana", Font.PLAIN, 20));
        JTableHeader th = tablaCategoria.getTableHeader();
        Font fuente = new Font("Verdana", Font.PLAIN, 30);
        th.setFont(fuente);
        tablaCategoria.getColumnModel().getColumn(0).setCellRenderer(null);
        
        tablaCategoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaCategoria.setRowHeight(50);
        tablaCategoria.setShowHorizontalLines(false);
        tablaCategoria.setShowVerticalLines(true);
        tablaCategoria.setColumnSelectionAllowed(false);
        tablaCategoria.setRowSelectionAllowed(true);
        tablaCategoria.setSelectionBackground(Color.yellow);
        tablaCategoria.establecer_ancho_columnas(ancho_cabecera);
        primerPanel.add(tablaCategoria.deslizador);
        
        modeloCategoria.agregar_fila(new F_Categoria("todas las categorias"));
        modeloCategoria.agregar_fila(new F_Categoria("chocolate"));
        modeloCategoria.agregar_fila(new F_Categoria("gaseosas"));
        modeloCategoria.agregar_fila(new F_Categoria("aseo personal"));
        modeloCategoria.agregar_fila(new F_Categoria("liquidos"));
        modeloCategoria.agregar_fila(new F_Categoria("salados"));
    }
    private void construirSegundoPanel(int ancho, int alto){
        String[] nombre_cabecera = {"N°","imagen","categoria","producto","vencimiento", "dias","precio","stock"};
        int[] ancho_cabecera = {3,10,19,30,15,8,8,7};

        modeloFrigobar = new MT_Frigobar(nombre_cabecera);

        tablaFrigobar = new IU_Tabla(modeloFrigobar, 4, 4, ancho, alto);
        tablaFrigobar.setFuente_letra(new Font("Verdana", Font.PLAIN, 16));
        JTableHeader th = tablaFrigobar.getTableHeader();
        Font fuente = new Font("Verdana", Font.PLAIN, 16);
        th.setFont(fuente);        
        
        tablaFrigobar.setCursor(new Cursor(Cursor.HAND_CURSOR));        
        tablaFrigobar.setRowHeight(tablaFrigobar.getColumnModel().getColumn(1).getWidth() + tablaFrigobar.getColumnModel().getColumn(1).getWidth()/4);
        tablaFrigobar.setShowHorizontalLines(false);
        tablaFrigobar.setShowVerticalLines(true);
        tablaFrigobar.setColumnSelectionAllowed(false);
        tablaFrigobar.setRowSelectionAllowed(true);
        tablaFrigobar.setSelectionBackground(Color.yellow);
        tablaFrigobar.establecer_ancho_columnas(ancho_cabecera);
        segundoPanel.add(tablaFrigobar.deslizador);
        
        modeloFrigobar.agregar_fila(new F_Frigobar("src/imagenes/", "gaseosas", "coca cola personal", "2017-11-20", 28, 2, 2));
        modeloFrigobar.agregar_fila(new F_Frigobar("src/imagenes/", "gaseosas", "coca cola personal", "2017-11-20", 28, 2, 2));
        modeloFrigobar.agregar_fila(new F_Frigobar("src/imagenes/", "gaseosas", "coca cola personal", "2017-11-20", 28, 2, 2));
    }
    private void construirTercerPanel(int ancho, int alto){
        panelDatos = new IU_Panel(new Limite(2, 2, ancho, alto/4));
        tercerPanel.add(panelDatos);
        construirPanelDatos(ancho - 6, alto/4 - 8);
        
        panelTabla = new IU_Panel(new Limite(2, 2 + panelDatos.getAlto() + panelDatos.getY(), ancho, alto - alto/4 - alto/8));
        tercerPanel.add(panelTabla);
        construirPanelTabla(ancho - 8, alto - alto/4 - alto/8 - 8);
        
        panelBotones = new IU_Panel(new Limite(2, 2 + panelTabla.getY() + panelTabla.getAlto(), ancho, alto/8));
        tercerPanel.add(panelBotones);
        construirPanelBotones(ancho, alto/8);
        
    }
    private void construirPanelDatos(int ancho, int alto){
        botonTitulo = new IU_Boton("comanda de frigobar", new Limite(2, 4, ancho, alto/6), 3);
        botonTitulo.agregarFuenteTexto(new Font("Verdana", Font.PLAIN, alto/7));
        panelDatos.add(botonTitulo);
        
        fechaFrigobar = new IU_PanelCampoTexto("fecha frigobar", "2017-05-22", new Limite(2, 4 + botonTitulo.getY()+ botonTitulo.getAlto(), ancho/2, alto/4), 40);
        panelDatos.add(fechaFrigobar);
        
        nombreHabitacion = new IU_PanelCampoTexto("habitacion", "204 TM", new Limite(ancho - ancho/3, 4 + botonTitulo.getAlto() + botonTitulo.getY(), ancho/3, alto/4), 40);
        panelDatos.add(nombreHabitacion);
        
        horaFrigobar = new IU_PanelCampoTextoUnidad("hora frigobar", "14:15:12", "PM", new Limite(2, 4 + nombreHabitacion.getAlto() + nombreHabitacion.getY(), ancho/2, alto/4), 40, 30);
        panelDatos.add(horaFrigobar);
        
        String[] opciones = {"rudolf felipez mancilla", "sofia tapia", "natividad cabrera", "hilaria quispe", "leocadia vargas", "uri felipez mancilla", "milco felipez mancilla", "alejandro mauricio felipez mancilla", "jesus junior felipez mancilla"};
        responsableFrigobar = new IU_PanelComboBox("responsable de comanda", opciones, new Limite(2, 4 + (alto - alto/4), ancho, alto/4), 40, true);
        panelDatos.add(responsableFrigobar);
    }
    private void construirPanelTabla(int ancho, int alto){
        String[] nombre_cabecera = {"cant","detalle de producto","precio"};
        int[] ancho_cabecera = {12,68,20};

        modeloDetalleProducto = new MT_DetalleProducto(nombre_cabecera);

        tablaDetalleProducto = new IU_Tabla(modeloDetalleProducto, 4, 4, ancho, alto - alto/8);
        tablaDetalleProducto.setFuente_letra(new Font("Verdana", Font.PLAIN, 16));
        JTableHeader th = tablaDetalleProducto.getTableHeader();
        Font fuente = new Font("Verdana", Font.PLAIN, 16);
        th.setFont(fuente);        
        
        tablaDetalleProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaDetalleProducto.setShowHorizontalLines(false);
        tablaDetalleProducto.setShowVerticalLines(true);
        tablaDetalleProducto.setColumnSelectionAllowed(false);
        tablaDetalleProducto.setRowSelectionAllowed(true);
        tablaDetalleProducto.setSelectionBackground(Color.yellow);
        tablaDetalleProducto.establecer_ancho_columnas(ancho_cabecera);
        panelTabla.add(tablaDetalleProducto.deslizador);
        
        modeloDetalleProducto.agregar_fila(new F_DetalleProducto(1, "coca cola 1/2Lt", 7));
        modeloDetalleProducto.agregar_fila(new F_DetalleProducto(1, "agua 1/2Lt", 6));
        modeloDetalleProducto.agregar_fila(new F_DetalleProducto(1, "snickers", 11));
        modeloDetalleProducto.agregar_fila(new F_DetalleProducto(1, "jugo ades grande 1Lt", 14));
        
        cantidadTotal = new IU_Etiqueta("4", new Limite(2, tablaDetalleProducto.limite.getAlto() + tablaDetalleProducto.limite.getY() + (alto/8)/3, ancho/8, alto/8 - (alto/8)/3), 1);
        cantidadTotal.setHorizontalAlignment(SwingConstants.CENTER);
        cantidadTotal.setFont(new Font("Verdana", Font.PLAIN, cantidadTotal.getAlto() - cantidadTotal.getAlto()/7));
        cantidadTotal.setBorder(null);
        panelTabla.add(cantidadTotal);
        
        campoTotalPagar = new IU_PanelCampoTexto("total a pagar", "38", new Limite(2 + ancho/2, tablaDetalleProducto.limite.getAlto() + tablaDetalleProducto.limite.getY(), ancho/2, alto/8), 30);        
        campoTotalPagar.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.RIGHT);
        panelTabla.add(campoTotalPagar);
    }
    private void construirPanelBotones(int ancho, int alto){
        botonGuardar = new IU_PanelBotonImagen("guardar", "src/imagenes/guardar.png", 70, new Limite(ancho - alto - alto/100, alto/100, alto - alto/50, alto - alto/50));
        panelBotones.add(botonGuardar);
        
        botonDevolver = new IU_PanelBotonImagen("devolver", "src/imagenes/devolucion.png", 70, new Limite(alto/100, alto/100, alto - alto/50, alto - alto/50));
        panelBotones.add(botonDevolver);
    }
}
