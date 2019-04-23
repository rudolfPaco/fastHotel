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
public class F_RegistroHuesped {

    private String nombreCompleto;
    private String tipoDocumento;
    private String numeroDocumento;
    private String caducidadDocumento;
    private String fechaNacimiento;
    private int edad;
    private String nacionalidad;
    private String telefono;
    private String email;
    private boolean seleccionar;

    public F_RegistroHuesped(String nombreCompleto, String tipoDocumento, String numeroDocumento, String caducidadDocumento, String fechaNacimiento, int edad, String nacionalidad, String telefono, String email, boolean seleccionar){
        this.nombreCompleto = nombreCompleto;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.caducidadDocumento = caducidadDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.email = email;
        this.seleccionar = seleccionar;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCaducidadDocumento() {
        return caducidadDocumento;
    }

    public void setCaducidadDocumento(String caducidadDocumento) {
        this.caducidadDocumento = caducidadDocumento;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSeleccionar() {
        return seleccionar;
    }

    public void setSeleccionar(boolean seleccionar) {
        this.seleccionar = seleccionar;
    }
}
