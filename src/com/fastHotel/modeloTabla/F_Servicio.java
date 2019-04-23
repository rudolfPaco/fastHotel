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
public class F_Servicio {

    private String codigo;
    private String responsable;
    private String fecha;
    private String hora;
    private String concepto;
    private double subTotal;
    private String estado;
    private boolean seleccionado;
    
    public F_Servicio(String codigo, String responsable, String fecha, String hora, String concepto, double subTotal, String estado, boolean seleccionado){
        this.codigo = codigo;
        this.responsable = responsable;
        this.fecha = fecha;
        this.hora = hora;
        this.concepto = concepto;
        this.subTotal = subTotal;
        this.estado = estado;
        this.seleccionado = seleccionado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
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
