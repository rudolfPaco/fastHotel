/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modelo;

/**
 *
 * @author rudolf
 */
public class Precio {

    private int idPrecio;
    private String tipoHabitacion;
    private double precio;
    private String unidad;
    private String simbolo;
    
    public Precio(int idPrecio, String tipoHabitacion, double precio, String unidad, String simbolo){
        this.idPrecio = idPrecio;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.unidad = unidad;
        this.simbolo = simbolo;
    }
    public int getIdPrecio() {
        return idPrecio;
    }
    public void setIdPrecio(int idPrecio) {
        this.idPrecio = idPrecio;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public String getUnidad() {
        return unidad;
    }
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    public String getSimbolo() {
        return simbolo;
    }
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
