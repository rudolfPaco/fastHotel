/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.vista;

import FAST.com.botones.IU_Boton;
import FAST.com.botones.IU_BotonCheckBox;
import FAST.com.botones.IU_BotonRadio;
import FAST.com.campos.IU_CampoTexto;
import FAST.com.clases.Apoyo;
import FAST.com.clases.Limite;
import FAST.com.etiquetas.IU_Etiqueta;
import FAST.com.paneles.IU_Panel;
import FAST.com.paneles.IU_PanelBotonImagen;
import FAST.com.paneles.IU_PanelCampoTexto;
import FAST.com.paneles.IU_PanelComboBox;
import FAST.com.tablas.IU_Tabla;
import FAST.com.ventanas.IU_VentanaSecundaria;
import com.fastHotel.modeloTabla.MT_Documentos;
import com.fastHotel.modeloTabla.MT_RegistroHuesped;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

/**
 *
 * @author rudolf
 */
public class IU_Huesped extends IU_VentanaSecundaria{
    
    private IU_Panel primerPanel;
    private IU_Etiqueta iuImagen;
    
    private IU_Etiqueta iuFoto;
    private IU_Boton iuBotonFoto;
    private IU_Boton iuBotonBorrar;
    private IU_PanelCampoTexto iuNombre;
    private IU_PanelCampoTexto iuApellido;
    private IU_PanelComboBox iuTipoDocumento;
    private IU_PanelCampoTexto iuNumeroDocumento;
    private IU_PanelCampoTexto iuOrigenDocumento;    
    private IU_PanelCampoTexto iuFechaNacimiento;
    private IU_Etiqueta etiquetaFechaNacimiento;
    private IU_PanelCampoTexto iuEdad;
    private IU_PanelCampoTexto iuFechaCaducidad;
    private IU_Etiqueta etiquetaFechaCaducidad;
    private IU_PanelCampoTexto iuEstadoCaducidad;    
    private IU_PanelComboBox iuGenero;
    private IU_PanelComboBox iuTipoPersona;
    private IU_PanelCampoTexto iuNacionalidad;
    private IU_PanelCampoTexto iuLugarNacimiento;
    private IU_PanelCampoTexto iuDireccion;
    private IU_PanelComboBox iuEstadoCivil;
    private IU_PanelCampoTexto iuProfesion;
    private IU_PanelCampoTexto iuProcedencia;
    private IU_PanelCampoTexto iuDestino;
    private IU_PanelCampoTexto iuTelefono;
    private IU_PanelCampoTexto iuEmail;
    private IU_PanelCampoTexto iuPrimerAntecedente;
    private IU_PanelCampoTexto iuSegundoAntecedente;
    private IU_PanelCampoTexto iuTercerAntecedente;
    private IU_Panel panelImagenes;
    private IU_Boton botonTituloImagenes;
    private IU_Panel panelTablaDocumentos;
    private IU_Panel panelBotonesDocumentos;
    private IU_PanelBotonImagen iuBotonEscanear;
    private IU_PanelBotonImagen iuBotonExaminar;
    private IU_PanelBotonImagen iuBotonCortar;
    private IU_PanelBotonImagen iuBotonEliminarDocumento;    
    
    private MT_Documentos modeloDocumentos;
    private IU_Tabla tablaDocumentos;
    
    private IU_Panel segundoPanel;
    
    private IU_Panel tercerPanel;
    private ButtonGroup grupoBotones;
    private IU_BotonRadio iuBotonBuscarNombre;
    private IU_BotonRadio iuBotonBuscarNumero;
    private IU_CampoTexto iuCampoBuscador;
    private IU_PanelBotonImagen iuBotonBuscar;
    private IU_PanelBotonImagen iuBotonOk;
    private IU_PanelBotonImagen iuBotonGuardar;
    private IU_PanelBotonImagen iuBotonAgregar;
    private IU_PanelBotonImagen iuBotonModificar;
    private IU_PanelBotonImagen iuBotonEliminar;
    private IU_PanelBotonImagen iuBotonImprimir;
    
    private IU_Panel cuartoPanel;
    private IU_Tabla tablaRegistroHuesped;
    private MT_RegistroHuesped modeloRegistroHuesped;
    
    public IU_Huesped(JFrame ventana, String titulo, int ancho, int alto, int altura){
        super(ventana, titulo, ancho, alto, altura);
        
        construirPaneles(ancho - 10, alto - altura - 14);
        
        moverVentana();
        cerrarVentana();
        mostrarVentana();
    }
    private void construirPaneles(int ancho, int alto){
        primerPanel = new IU_Panel(new Limite(0, 0, ancho/3 - ancho/40, alto - alto/3 + alto/10));
        panelFondo.add(primerPanel);        
        construirPrimerPanel(ancho/3 - ancho/40 - 8, alto - alto/3 + alto/10 - 8);
        
        segundoPanel = new IU_Panel(new Limite(ancho/3 - ancho/40, 0, ancho - ancho/3 + ancho/40 - 2, alto - alto/3));        
        panelFondo.add(segundoPanel);
        construirSegundoPanel(ancho - ancho/3 + ancho/40 - 6 - 20, alto - alto/3);
        
        tercerPanel = new IU_Panel(new Limite(primerPanel.getAncho(), segundoPanel.getAlto(), segundoPanel.getAncho(), alto/10));
        panelFondo.add(tercerPanel);
        construirTercerPanel(segundoPanel.getAncho(), alto/10);
                
        cuartoPanel = new IU_Panel(new Limite(0, segundoPanel.getAlto() + tercerPanel.getAlto(), ancho - 2, alto - segundoPanel.getAlto() - tercerPanel.getAlto()));
        panelFondo.add(cuartoPanel);
        construirCuartoPanel(ancho - 10, alto - segundoPanel.getAlto() - tercerPanel.getAlto() - 8);
    }
    private void construirPrimerPanel(int ancho, int alto){
        iuImagen = new IU_Etiqueta("", new Limite(4, 4, ancho, alto));
        primerPanel.add(iuImagen);
        
        
    }
    private void construirSegundoPanel(int ancho, int alto){
        iuFoto = new IU_Etiqueta("src/fotos/usuario.png", new Limite(2, 2, Apoyo.ANCHO_CARNET, Apoyo.ALTO_CARNET));
        segundoPanel.add(iuFoto);
        
        iuBotonFoto = new IU_Boton("foto", new Limite(2, 4 + iuFoto.getAlto(), iuFoto.getAncho()/3, iuFoto.getAlto()/7), 3);
        iuBotonFoto.agregarFuenteTexto(new Font("Verdana", Font.PLAIN, 14));
        segundoPanel.add(iuBotonFoto);
        
        iuBotonBorrar = new IU_Boton("eliminar", new Limite(2 + iuFoto.getAncho()/2, 4 + iuFoto.getAlto(), iuFoto.getAncho()/2, iuFoto.getAlto()/7), 3);
        iuBotonBorrar.agregarFuenteTexto(new Font("Verdana", Font.PLAIN, 14));
        segundoPanel.add(iuBotonBorrar);
        
        iuNombre = new IU_PanelCampoTexto("nombre(s) del huesped", "", new Limite(iuFoto.getAncho() + iuFoto.getX() + 2, iuFoto.getY(), (ancho - iuFoto.getAncho() - iuFoto.getX())/5, alto/14), 40);        
        iuNombre.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuNombre);
        
        iuApellido = new IU_PanelCampoTexto("apellidos del huesped", "", new Limite(iuNombre.getAncho() + iuNombre.getX() + 4, iuFoto.getY(), (ancho - iuFoto.getAncho() - iuFoto.getX())/3, alto/14), 40);        
        iuApellido.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuApellido);
        
        String[] opciones = {"carnet de identidad","pasaporte","licencia de conducir","certificado de nacimiento","libreta de servicio militar","papeleta de sufragio"};
        iuTipoDocumento = new IU_PanelComboBox("tipo de documento", opciones, new Limite(iuApellido.getX() + iuApellido.getAncho() + 6, iuApellido.getY(), (ancho - iuApellido.getX() - iuApellido.getAncho())/2, alto/14), 40, true);                
        iuTipoDocumento.deshabilitarTexto();
        segundoPanel.add(iuTipoDocumento);
        
        iuNumeroDocumento = new IU_PanelCampoTexto("numero de documento", "", new Limite(iuTipoDocumento.getX() + iuTipoDocumento.getAncho() + 8, iuTipoDocumento.getY(), iuTipoDocumento.getAncho() - iuTipoDocumento.getAncho()/3, alto/14), 40);
        iuNumeroDocumento.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuNumeroDocumento);
        
        iuOrigenDocumento = new IU_PanelCampoTexto("origen", "", new Limite(iuNumeroDocumento.getX() + iuNumeroDocumento.getAncho() + 8, iuNumeroDocumento.getY(), iuTipoDocumento.getAncho()/3, alto/14), 40);
        iuOrigenDocumento.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuOrigenDocumento);
        
        iuFechaNacimiento = new IU_PanelCampoTexto("fecha de nacimiento", "", new Limite(iuFoto.getAncho() + iuFoto.getX() + 2, iuNombre.getY() + iuNombre.getAlto() + 4, (ancho - iuFoto.getAncho() - iuFoto.getX())/5, alto/14), 40);
        iuFechaNacimiento.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuFechaNacimiento);
        
        etiquetaFechaNacimiento = new IU_Etiqueta("src/imagenes/fecha.png", new Limite(iuFechaNacimiento.getX() + iuFechaNacimiento.getAncho() + 4, iuFechaNacimiento.getY(), alto/14, alto/14));
        etiquetaFechaNacimiento.agregarBordeContorno(null);
        segundoPanel.add(etiquetaFechaNacimiento);
        
        iuEdad = new IU_PanelCampoTexto("edad", "", new Limite(etiquetaFechaNacimiento.getX() + etiquetaFechaNacimiento.getAncho() + 6, etiquetaFechaNacimiento.getY(), ancho/14, alto/14), 40);
        iuEdad.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuEdad);
        
        iuFechaCaducidad = new IU_PanelCampoTexto("fecha de caducidad", "", new Limite(iuTipoDocumento.getX(), iuEdad.getY(), iuFechaNacimiento.getAncho(), alto/14), 40);
        iuFechaCaducidad.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuFechaCaducidad);
        
        etiquetaFechaCaducidad = new IU_Etiqueta("src/imagenes/fecha.png", new Limite(iuFechaCaducidad.getX() + iuFechaCaducidad.getAncho() + 2, iuFechaCaducidad.getY(), alto/14, alto/14));
        etiquetaFechaCaducidad.agregarBordeContorno(null);
        segundoPanel.add(etiquetaFechaCaducidad);
        
        iuEstadoCaducidad = new IU_PanelCampoTexto("estado de caducidad", "", new Limite(etiquetaFechaCaducidad.getX() + etiquetaFechaCaducidad.getAncho() + 4, iuFechaCaducidad.getY(), ancho/8, alto/14), 40);
        iuEstadoCaducidad.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuEstadoCaducidad);
        
        String[] opcionesGenero = {"masculino","femenino"};
        iuGenero = new IU_PanelComboBox("genero", opcionesGenero, new Limite(iuFoto.getX() + iuFoto.getAncho() + 2, iuFechaNacimiento.getY() + iuFechaNacimiento.getAlto() + 4, ancho/9, alto/14), 40, true);
        iuGenero.deshabilitarTexto();
        segundoPanel.add(iuGenero);
        
        String[] opcionesTipo = {"huesped","visita"};
        iuTipoPersona = new IU_PanelComboBox("tipo persona", opcionesTipo, new Limite(iuGenero.getX() + iuGenero.getAncho() + 4, iuFechaNacimiento.getY() + iuFechaNacimiento.getAlto() + 4, ancho/9, alto/14), 40, true);
        iuTipoPersona.deshabilitarTexto();
        segundoPanel.add(iuTipoPersona);
        
        iuNacionalidad = new IU_PanelCampoTexto("nacionalidad", "", new Limite(iuTipoPersona.getX() + iuTipoPersona.getAncho() + 6, iuEdad.getY() + iuEdad.getAlto() + 4, ancho/5, alto/14), 40);
        iuNacionalidad.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuNacionalidad);
        
        iuLugarNacimiento = new IU_PanelCampoTexto("lugar de nacimiento", "", new Limite(iuNacionalidad.getX() + iuNacionalidad.getAncho() + 8, iuEdad.getY() + iuEdad.getAlto() + 4, ancho/6, alto/14), 40);
        iuLugarNacimiento.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuLugarNacimiento);
        
        iuDireccion = new IU_PanelCampoTexto("direccion", "", new Limite(iuLugarNacimiento.getX() + iuLugarNacimiento.getAncho() + 10, iuEdad.getY() + iuEdad.getAlto() + 4, ancho/4 + ancho/40, alto/14), 40);
        iuDireccion.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuDireccion);
        
        String[] opcionesCivil = {"soltero(a)","casado(a)","divorciado(a)","viudo(a)"};
        iuEstadoCivil = new IU_PanelComboBox("estado civil", opcionesCivil, new Limite(iuFoto.getX() + iuFoto.getAncho() + 2, iuDireccion.getY() + iuDireccion.getAlto() + 4, ancho/6, alto/14), 40, true);
        iuEstadoCivil.deshabilitarTexto();
        segundoPanel.add(iuEstadoCivil);
        
        iuProfesion = new IU_PanelCampoTexto("profesion", "", new Limite(iuEstadoCivil.getX() + iuEstadoCivil.getAncho() + 4, iuDireccion.getY() + iuDireccion.getAlto() + 4, ancho/4, alto/14), 40);
        iuProfesion.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuProfesion);
        
        iuProcedencia = new IU_PanelCampoTexto("procedencia", "", new Limite(iuProfesion.getAncho() + iuProfesion.getX() + 4, iuProfesion.getY(), ancho/4, alto/14), 40);
        iuProcedencia.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuProcedencia);
        
        iuDestino = new IU_PanelCampoTexto("destino", "", new Limite(iuProcedencia.getAncho() + iuProcedencia.getX() + 4, iuProcedencia.getY(), ancho/5 + ancho/88, alto/14), 40);
        iuDestino.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuDestino);
        
        iuTelefono = new IU_PanelCampoTexto("telefono", "", new Limite(iuFoto.getX() + iuFoto.getAncho() + 2, iuDestino.getY() + iuDestino.getAlto() + 4, ancho/8, alto/14), 40);
        iuTelefono.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuTelefono);
        
        iuEmail = new IU_PanelCampoTexto("correo electronico", "", new Limite(iuTelefono.getX() + iuTelefono.getAncho() + 4, iuTelefono.getY(), ancho/3, alto/14), 40);
        iuEmail.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuEmail);
        
        iuPrimerAntecedente = new IU_PanelCampoTexto("primer antecedente", "", new Limite(2, 2 + iuEmail.getY() + iuEmail.getAlto(), iuFoto.getAncho(), alto/14), 40);
        iuPrimerAntecedente.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuPrimerAntecedente);
        
        iuSegundoAntecedente = new IU_PanelCampoTexto("segundo antecedente", "", new Limite(4 + iuPrimerAntecedente.getAncho() + iuPrimerAntecedente.getX(), 2 + iuEmail.getY() + iuEmail.getAlto(), ancho/3, alto/14), 40);
        iuSegundoAntecedente.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuSegundoAntecedente);
        
        iuTercerAntecedente = new IU_PanelCampoTexto("tercer antecedente", "", new Limite(6 + iuSegundoAntecedente.getAncho() + iuSegundoAntecedente.getX(), 2 + iuEmail.getY() + iuEmail.getAlto(), ancho - iuSegundoAntecedente.getAncho() - iuPrimerAntecedente.getAncho() + ancho/120, alto/14), 40);
        iuTercerAntecedente.modificarPosicionHorizontal(SwingConstants.LEFT, SwingConstants.LEFT);
        segundoPanel.add(iuTercerAntecedente);
        
        panelImagenes = new IU_Panel(new Limite(2, 2 + alto/2, ancho + ancho/58, alto/2 - alto/70));
        segundoPanel.add(panelImagenes);
        construirPanelImagenes(ancho + ancho/58 - 4, alto/2 - alto/70 - 4);
    }
    private void construirPanelImagenes(int ancho, int alto){
        botonTituloImagenes = new IU_Boton("documentos de la persona", new Limite(0, 0, ancho, alto/8), 4);
        botonTituloImagenes.agregarFuenteTexto(new Font("Verdana", Font.PLAIN, 16));
        panelImagenes.add(botonTituloImagenes);
        
        panelTablaDocumentos = new IU_Panel(new Limite(0, 2 + alto/8, ancho - ancho/14, alto - alto/8));
        panelImagenes.add(panelTablaDocumentos);
        construirPanelTablaDocumentos(ancho - ancho/14 - 8, alto - alto/8 - 8);
        
        panelBotonesDocumentos = new IU_Panel(new Limite(2 + ancho - ancho/14, 2 + alto/8, ancho/14, alto - alto/8));
        panelImagenes.add(panelBotonesDocumentos);
        construirPanelBotonesDocumentos(ancho/14 - 6, alto - alto/8 - 8);
    }
    private void construirPanelTablaDocumentos(int ancho, int alto){
        String[] nombre_cabecera = {"N°","imagen","nombre","direccion del documento","tipo de documento"};
        int[] ancho_cabecera = {4, 10, 15, 51, 20};
        
        modeloDocumentos = new MT_Documentos(nombre_cabecera);        
        
        tablaDocumentos = new IU_Tabla(modeloDocumentos, 4, 4, ancho, alto);
        tablaDocumentos.setFuente_letra(new Font("Verdana", Font.PLAIN, 14));        
        JTableHeader th = tablaDocumentos.getTableHeader();          
        Font fuente = new Font("Verdana", Font.PLAIN, 14); 
        th.setFont(fuente);        
        tablaDocumentos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaDocumentos.setShowHorizontalLines(false);
        tablaDocumentos.setShowVerticalLines(true);
        tablaDocumentos.setColumnSelectionAllowed(false);
        tablaDocumentos.setRowSelectionAllowed(false);
        tablaDocumentos.establecer_ancho_columnas(ancho_cabecera);        
        panelTablaDocumentos.add(tablaDocumentos.deslizador);
    }
    private void construirPanelBotonesDocumentos(int ancho, int alto){
        iuBotonEscanear = new IU_PanelBotonImagen("escanear", "src/imagenes/escaner.png", 70, new Limite(2, 2, ancho, alto/3));        
        panelBotonesDocumentos.add(iuBotonEscanear);
        
        iuBotonExaminar = new IU_PanelBotonImagen("examinar", "src/imagenes/examinar.png", 70, new Limite(2, 4 + alto/3, ancho, alto/3));
        panelBotonesDocumentos.add(iuBotonExaminar);
        
        iuBotonEliminarDocumento = new IU_PanelBotonImagen("eliminar", "src/imagenes/borrar.png", 70, new Limite(2, 6 + 2*alto/3, ancho, alto/3));
        panelBotonesDocumentos.add(iuBotonEliminarDocumento);
    }
    private void construirTercerPanel(int ancho, int alto){
        grupoBotones = new ButtonGroup();
        iuBotonBuscarNombre = new IU_BotonRadio("nombre(s)", new Limite(4, 4, ancho/6, alto/3), true);
        tercerPanel.add(iuBotonBuscarNombre);
        grupoBotones.add(iuBotonBuscarNombre);
        
        iuBotonBuscarNumero = new IU_BotonRadio("numero", new Limite(8 + ancho/6, 4, ancho/6, alto/3), false);
        tercerPanel.add(iuBotonBuscarNumero);
        grupoBotones.add(iuBotonBuscarNumero);
        
        iuCampoBuscador = new IU_CampoTexto(new Limite(8, alto/2, ancho/3, alto/2));
        tercerPanel.add(iuCampoBuscador);
        
        iuBotonBuscar = new IU_PanelBotonImagen("buscar", "src/imagenes/buscar.png", 70, new Limite(4 + iuCampoBuscador.getX() + iuCampoBuscador.getAncho(), 2, alto - 4, alto - 4));
        tercerPanel.add(iuBotonBuscar);
        
        iuBotonOk = new IU_PanelBotonImagen("ok", "src/imagenes/ok.png", 70, new Limite(ancho - alto - 4, 2, alto - 4, alto - 4));                
        tercerPanel.add(iuBotonOk);
        
        iuBotonGuardar = new IU_PanelBotonImagen("guardar", "src/imagenes/guardar.png", 70, new Limite(ancho - 2*alto - 8, 2, alto - 4, alto - 4));                
        tercerPanel.add(iuBotonGuardar);
        
        iuBotonAgregar = new IU_PanelBotonImagen("nuevo", "src/imagenes/agregar.png", 70, new Limite(ancho - 3*alto - 12, 2, alto - 4, alto - 4));        
        tercerPanel.add(iuBotonAgregar);
        
        iuBotonModificar = new IU_PanelBotonImagen("modificar", "src/imagenes/modificar.png", 70, new Limite(ancho - 4*alto - 16, 2, alto - 4, alto - 4));        
        tercerPanel.add(iuBotonModificar);
        
        iuBotonEliminar = new IU_PanelBotonImagen("eliminar", "src/imagenes/eliminar.png", 70, new Limite(ancho - 5*alto - 20, 2, alto - 4, alto - 4));        
        tercerPanel.add(iuBotonEliminar);
        
        iuBotonImprimir = new IU_PanelBotonImagen("imprimir", "src/imagenes/imprimir.png", 70, new Limite(ancho - 6*alto - 24, 2, alto - 4, alto - 4));        
        tercerPanel.add(iuBotonImprimir);
        
        
    }
    private void construirCuartoPanel(int ancho, int alto){
        String[] nombre_cabecera = {"N°","nombre completo","tipo documento","numero documento","caducidad","fecha nacimiento","edad","nacionalidad","telefono","email","•"};
        int[] ancho_cabecera = {2, 20, 10, 10, 6, 8, 4, 10, 8, 20, 2};
        
        modeloRegistroHuesped = new MT_RegistroHuesped(nombre_cabecera);        
        
        tablaRegistroHuesped = new IU_Tabla(modeloRegistroHuesped, 4, 4, ancho, alto);
        tablaRegistroHuesped.setFuente_letra(new Font("Verdana", Font.PLAIN, 14));        
        JTableHeader th = tablaRegistroHuesped.getTableHeader();          
        Font fuente = new Font("Verdana", Font.PLAIN, 14); 
        th.setFont(fuente);        
        tablaRegistroHuesped.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tablaRegistroHuesped.setShowHorizontalLines(false);
        tablaRegistroHuesped.setShowVerticalLines(true);
        tablaRegistroHuesped.setColumnSelectionAllowed(false);
        tablaRegistroHuesped.setRowSelectionAllowed(false);
        tablaRegistroHuesped.establecer_ancho_columnas(ancho_cabecera);        
        cuartoPanel.add(tablaRegistroHuesped.deslizador);
    }
}