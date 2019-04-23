/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modeloTabla;

/**
 *
 * @author rudolf
 */
public class F_Frigobar {
    
    private String direccionImagen;
    private String categoriaProducto;
    private String nombreProducto;
    private String fechaVencimiento;
    private int diasFaltantes;
    private double precioProducto;
    private int cantidadStock;
    
    public F_Frigobar(String direccionImagen, String categoriaProducto, String nombreProducto, String fechaVencimiento, int diasFaltantes, double precioProducto, int cantidadStock){
        this.direccionImagen = direccionImagen;
        this.categoriaProducto = categoriaProducto;
        this.nombreProducto = nombreProducto;
        this.fechaVencimiento = fechaVencimiento;
        this.diasFaltantes = diasFaltantes;
        this.precioProducto = precioProducto;
        this.cantidadStock = cantidadStock;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getDiasFaltantes() {
        return diasFaltantes;
    }

    public void setDiasFaltantes(int diasFaltantes) {
        this.diasFaltantes = diasFaltantes;
    }
        
    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    
}
