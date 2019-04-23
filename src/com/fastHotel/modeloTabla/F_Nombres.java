/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modeloTabla;

/**
 *
 * @author hotel-felipez
 */
public class F_Nombres {

    String nombre;
    String telefono;
    boolean estado;
    
    public F_Nombres(String nombre, String telefono, boolean estado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "F_Nombres{" + ", nombre=" + nombre + ", telefono=" + telefono + ", estado=" + estado + '}';
    }
}