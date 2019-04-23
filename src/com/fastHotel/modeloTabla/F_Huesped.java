/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modeloTabla;

import com.fastHotel.modelo.Huesped;

/**
 *
 * @author rudolf
 */
public class F_Huesped {
    
    private String nombreHuesped;
    private String fechaNacimiento;
    private int edad;
    private String tipoDocumento;
    private String caducidad;
    private boolean seleccionado;
    private Huesped huesped;
    
    public F_Huesped(String nombreHuesped, String fechaNacimiento, int edad, String tipoDocumento, String caducidad, boolean seleccionado, Huesped huesped){
        this.nombreHuesped = nombreHuesped;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.tipoDocumento = tipoDocumento;
        this.caducidad = caducidad;
        this.huesped = huesped;
        this.seleccionado = seleccionado;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }
    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getCaducidad() {
        return caducidad;
    }
    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }
    public Huesped getHuesped() {
        return huesped;
    }
    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
    public boolean isSeleccionado() {
        return seleccionado;
    }
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}