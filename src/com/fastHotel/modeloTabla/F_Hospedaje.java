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
public class F_Hospedaje {
    
    private String desde;
    private String hasta;
    private String noche;
    private double precio;
    private String estado;
    private boolean seleccionado;
    
    public F_Hospedaje(String desde, String hasta, String noche, double precio, String estado, boolean seleccionado){
        this.desde = desde;
        this.hasta = hasta;
        this.noche = noche;
        this.precio = precio;
        this.estado = estado;
        this.seleccionado = seleccionado;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getNoche() {
        return noche;
    }

    public void setNoche(String noche) {
        this.noche = noche;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
