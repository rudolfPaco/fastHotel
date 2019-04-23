/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author rudolf
 */
public class IU_PanelDisponible extends IU_Panel{
    private JFrame ventana;
    private String titulo;
    private Limite limite;
    
    private IU_Panel panelTitulo;
    private IU_Etiqueta etiquetaTitulo;
    private IU_Panel panelFondo;
    private IU_Panel panelControl;
    
    public IU_PanelDisponible(JFrame ventana, String titulo, Limite limite){
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
        //construirPanelFondo(ancho - 8, alto - alto/18 - alto/7 - 8);

        panelControl = new IU_Panel(new Limite(0, alto - alto/7, ancho, alto/7));
        add(panelControl);
        //construirPanelControl(ancho - 2, alto/7 - 2);
    }
    private void construirPanelTitulo(int ancho, int alto) {
        etiquetaTitulo = new IU_Etiqueta(titulo, new Limite(0, 0, ancho, alto), 1);
        etiquetaTitulo.setForeground(Color.WHITE);
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(etiquetaTitulo);
    }
}
