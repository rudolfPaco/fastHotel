/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fastHotel.modelo;

import FAST.com.clases.Hora;
import java.util.ArrayList;

/**
 *
 * @author rudolf
 */
public class Habitacion {
    private int idHabitacion; 
    private String numeroHabitacion;
    private String simboloHabitacion;
    private String nombreHabitacion;
    private String tipoHabitacion;  
    private String numeroPiso;
    private int telefonoHabitacion;
    private double precioHabitacion;
    private String unidadPrecio;
    private int capacidad;
    private String descripcionCamas;
    private String descripcionServicio; 
    private String descripcionHabitacion;    
    private String estadoHabitacion;    
    private String estadoHabilitado;
    
    private MiniBar miniBar;
    private ArrayList<Reserva> listaReservas;
    private ArrayList<Documento> listaDocumentos;
    private ArrayList<Precio> listaPrecios;
    
    
    public Habitacion(int idHabitacion, String numeroHabitacion, String simboloHabitacion, String nombreHabitacion, String tipoHabitacion, String numeroPiso, int telefonoHabitacion, double precioHabitacion, String unidadPrecio, int capacidad, String descripcionCamas, String descripcionServicio, String descripcionHabitacion, String estadoHabitacion, String estadoHabilitado){
        this.idHabitacion = idHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.simboloHabitacion = simboloHabitacion;
        this.nombreHabitacion = nombreHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.numeroPiso = numeroPiso;
        this.telefonoHabitacion = telefonoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.unidadPrecio = unidadPrecio;
        this.capacidad = capacidad;
        this.descripcionCamas = descripcionCamas;
        this.descripcionServicio = descripcionServicio;
        this.descripcionHabitacion = descripcionHabitacion;
        this.estadoHabitacion = estadoHabitacion;
        this.estadoHabilitado = estadoHabilitado;
        
        this.miniBar = null;
        
        this.listaReservas = new ArrayList<>();
        this.listaDocumentos = new ArrayList<>();
        this.listaPrecios = new ArrayList<>();
        
        cargarMiniBar();
        cargarPrecios();
        cargarReservas();
        
    }
    private void cargarMiniBar(){
        //este metodo obtiene todos los productos del minibar y se guarda en el objeto miniBar.
    }
    private void cargarPrecios(){
        //en este metodo realiza la llamada a la base de datos y obtiene los distintos precios, y se guarda a la lista de precio.
        listaPrecios.add(new Precio(1, "SIMPLE", 170, "bolivianos", "Bs.-"));
        listaPrecios.add(new Precio(2, "MATRIMONIAL", 220, "bolivianos", "Bs.-"));
        listaPrecios.add(new Precio(3, "DOBLE SIMPLE", 280, "bolivianos", "Bs.-"));
        listaPrecios.add(new Precio(4, "TRIPLE MATRIMONIAL", 380, "bolivianos", "Bs.-"));
        listaPrecios.add(new Precio(5, "FAMILIAR", 310, "bolivianos", "Bs.-"));
        listaPrecios.add(new Precio(6, "NOCHE DE BODAS", 450, "bolivianos", "Bs.-"));        
    }
    private void cargarReservas(){
        // en este metodo hace la llamada a la base de datos, para obtener la lista de reservas que tiene la habitacion. y se guarda a la lista de reservas
    }
    private void cargarDocumentos(){
        //en este metodo hace la llamada a la base de datos, obteniendo las imagenes que se guardaron en esta habitacion.
    }
    public int getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }
    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    public String getSimboloHabitacion() {
        return simboloHabitacion;
    }
    public void setSimboloHabitacion(String simboloHabitacion) {
        this.simboloHabitacion = simboloHabitacion;
    }
    public String getNombreHabitacion() {
        return nombreHabitacion;
    }
    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public int getTelefonoHabitacion() {
        return telefonoHabitacion;
    }
    public void setTelefonoHabitacion(int telefonoHabitacion) {
        this.telefonoHabitacion = telefonoHabitacion;
    }
    public double getPrecioHabitacion() {
        return precioHabitacion;
    }
    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }
    public String getUnidadPrecio() {
        return unidadPrecio;
    }
    public void setUnidadPrecio(String unidadPrecio) {
        this.unidadPrecio = unidadPrecio;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public String getDescripcionCamas() {
        return descripcionCamas;
    }
    public void setDescripcionCamas(String descripcionCamas) {
        this.descripcionCamas = descripcionCamas;
    }
    public String getDescripcionServicio() {
        return descripcionServicio;
    }
    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }
    public String getDescripcionHabitacion() {
        return descripcionHabitacion;
    }
    public void setDescripcionHabitacion(String descripcionHabitacion) {
        this.descripcionHabitacion = descripcionHabitacion;
    }
    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }
    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }
    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    public ArrayList<Documento> getListaDocumentos() {
        return listaDocumentos;
    }
    public void setListaDocumentos(ArrayList<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
    public ArrayList<Precio> getListaPrecios() {
        return listaPrecios;
    }
    public void setListaPrecios(ArrayList<Precio> listaPrecios) {
        this.listaPrecios = listaPrecios;
    }
    public String getNumeroPiso() {
        return numeroPiso;
    }
    public void setNumeroPiso(String numeroPiso) {
        this.numeroPiso = numeroPiso;
    }
    public MiniBar getMiniBar() {
        return miniBar;
    }
    public void setMiniBar(MiniBar miniBar) {
        this.miniBar = miniBar;
    }
    public String getCheckIn(){
        return new Hora().cadenaHora();
    }
    public String getEstadoHabilitado() {
        return estadoHabilitado;
    }
    public void setEstadoHabilitado(String estadoHabilitado) {
        this.estadoHabilitado = estadoHabilitado;
    }
}
