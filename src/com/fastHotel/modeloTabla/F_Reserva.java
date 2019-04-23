/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastHotel.modeloTabla;

/**
 *
 * @author cero
 */
public class F_Reserva {

    String habitacion;
    double precio;
    String nombre;
    String telefono;
    int numeroPersonas;
    double anticipo;
    String descripcionAnticipo;
    String horaLlegada;
    String observacion;
    
    public F_Reserva(){
        habitacion = "";
        precio = 0.0;
        nombre = "";
        telefono = "";
        numeroPersonas = 0;
        anticipo = 0.0;
        descripcionAnticipo = "";
        horaLlegada = "";
        observacion = "";
    }

    public String getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
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
    public int getNumeroPersonas() {
        return numeroPersonas;
    }
    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }
    public double getAnticipo() {
        return anticipo;
    }
    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }
    public String getDescripcionAnticipo() {
        return descripcionAnticipo;
    }
    public void setDescripcionAnticipo(String descripcionAnticipo) {
        this.descripcionAnticipo = descripcionAnticipo;
    }
    public String getHoraLlegada() {
        return horaLlegada;
    }
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    @Override
    public String toString() {
        return "F_Reserva{" + "habitacion=" + habitacion + ", precio=" + precio + ", nombre=" + nombre + ", telefono=" + telefono + ", numeroPersonas=" + numeroPersonas + ", anticipo=" + anticipo + ", descripcionAnticipo=" + descripcionAnticipo + ", horaLlegada=" + horaLlegada + ", observacion=" + observacion + '}';
    }
}
