/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fastHotel.modelo;

import FAST.com.clases.Fecha;

/**
 *
 * @author rudolf
 */
public class Producto {
    
    private int idProducto;
    private String codigoProducto;
    private String tipoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Fecha fechaVencimiento;
    private Fecha fechaAdquisicion;
    private double costoProducto;
    private double precioProducto;
    private int cantidad;
    private String estadoProducto;
    
    public Producto(int idProducto, String codigoProducto, String tipoProducto, String nombreProducto, String descripcionProducto, Fecha fechaVencimiento, Fecha fechaAdquisicion, double costoProducto, double precioProducto, int cantidad, String estadoProducto){
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.tipoProducto = tipoProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.fechaVencimiento = fechaVencimiento;        
        this.fechaAdquisicion = fechaAdquisicion;
        this.costoProducto = costoProducto;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
        this.estadoProducto = estadoProducto;
    }
    
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getCodigoProducto() {
        return codigoProducto;
    }
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    public String getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getDescripcionProducto() {
        return descripcionProducto;
    }
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    public Fecha getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(Fecha fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public Fecha getFechaAdquisicion() {
        return fechaAdquisicion;
    }
    public void setFechaAdquisicion(Fecha fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }
    public double getCostoProducto() {
        return costoProducto;
    }
    public void setCostoProducto(double costoProducto) {
        this.costoProducto = costoProducto;
    }
    public double getPrecioProducto() {
        return precioProducto;
    }
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getEstadoProducto() {
        return estadoProducto;
    }
    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
    public boolean esIgual(Producto producto){
        return true;
    }
}
