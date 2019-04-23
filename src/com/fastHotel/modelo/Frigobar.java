/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fastHotel.modelo;

import java.util.ArrayList;

/**
 *
 * @author rudolf
 */
public class Frigobar {
    
    private int idFrigobar;
    
    private ArrayList<Producto> listaProductos;
    private Empleado empleado;
    
    
    public Frigobar(int idFrigobar){
        this.idFrigobar = idFrigobar;
        this.listaProductos = new ArrayList<>();
    }

    public int getIdFrigobar() {
        return idFrigobar;
    }

    public void setIdFrigobar(int idFrigobar) {
        this.idFrigobar = idFrigobar;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }
}
