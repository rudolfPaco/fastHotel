/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modeloTabla;

import com.fastHotel.modelo.Habitacion;

/**
 *
 * @author rudolf
 */
public class F_Resultados {

    private String nombreHabitacion;
    private String tipoHabitacion;
    private int capacidad;
    private String numeroPiso;
    private String descripcionCamas;
    private double precioHabitacion;
    private String estadoHabitacion;
    private String checkIn;
    private boolean seleccionado;
    private Habitacion habitacion;
    
    public F_Resultados(String nombreHabitacion, String tipoHabitacion, int capacidad, String numeroPiso, String descripcionCamas, double precioHabitacion, String estadoHabitacion, String checkIn, boolean seleccionado, Habitacion habitacion){
        this.nombreHabitacion = nombreHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.capacidad = capacidad;
        this.numeroPiso = numeroPiso;
        this.descripcionCamas = descripcionCamas;
        this.precioHabitacion = precioHabitacion;
        this.estadoHabitacion = estadoHabitacion;
        this.checkIn = checkIn;
        this.seleccionado = seleccionado;
        this.habitacion = habitacion;
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
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public String getNumeroPiso() {
        return numeroPiso;
    }
    public void setNumeroPiso(String numeroPiso) {
        this.numeroPiso = numeroPiso;
    }
    public String getDescripcionCamas() {
        return descripcionCamas;
    }
    public void setDescripcionCamas(String descripcionCamas) {
        this.descripcionCamas = descripcionCamas;
    }
    public double getPrecioHabitacion() {
        return precioHabitacion;
    }
    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }
    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }
    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
    public String getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    public boolean isSeleccionado() {
        return seleccionado;
    }
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
