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
public class MiniBar {
    
    private int idMiniBar;
    private String nombreMiniBar;
    private String tipoMiniBar;
    private String descripcionMiniBar;
    
    private ArrayList<Producto> listaProductos;
    
    public MiniBar(int idMiniBar, String nombreMiniBar, String tipoMiniBar, String descripcionMiniBar){
        this.idMiniBar = idMiniBar;
        this.nombreMiniBar = nombreMiniBar;
        this.tipoMiniBar = tipoMiniBar;
        this.descripcionMiniBar = descripcionMiniBar;
        
        this.listaProductos = new ArrayList<>();
        
        cargarProductos();
    }
    private void cargarProductos(){
        //en este metodo obtiene todos los productos que pertenences al minibar y guarda en la lista de productos.
    }
    public void agregarProductos(ArrayList<Producto> nuevosProductos, Empleado empleado){
        boolean verificador = false;
        int contador = 0;
        Frigobar frigobar = new Frigobar(0);
        frigobar.setEmpleado(empleado);
        
        for( int i = 0; i < nuevosProductos.size(); i++){
            Producto producto = nuevosProductos.get(i);
            ArrayList<Producto> productosMiniBar = getListaProductos(producto.getCodigoProducto());
            
            if(productosMiniBar.isEmpty()){
                agregarNuevoProducto(producto);
            }else{
                while(contador < productosMiniBar.size() && !verificador){
                    Producto productoMiniBar = productosMiniBar.get(contador);
                    if(productoMiniBar.getCantidad() == 0 || productoMiniBar.esIgual(producto)){
                        actualizarDatosProducto(productoMiniBar);
                        verificador = true;
                    }
                }
                if(!verificador){
                    agregarNuevoProducto(producto);
                }
                frigobar.agregarProducto(producto);
            }
        }
    }
    public ArrayList<Producto> getListaProductos(String codigoProducto){
        //hace un llamado a la base de datos, buscando el o los productos que tuviese el minibar.
        //mediante el codigoProducto busca en el minibar si existe se agregar a la lista de productosMinibar.
        //y luego dispone la lista de productosMinibar
        ArrayList<Producto> productosMiniBar = new ArrayList<>();
        return productosMiniBar;
    }
    public void agregarNuevoProducto(Producto producto){
        //hace un llamado a la clase que maneja el acceso a la base de datos y agrega un nuevo producto a la base de datos.
    }
    public void actualizarDatosProducto(Producto producto){
        //hace un llamado a la clase que maneja el acceso a la base de datos y modifica los datos guardandolos en la mista tabla de la base de datos.
    }
    public int getIdMiniBar() {
        return idMiniBar;
    }
    public void setIdMiniBar(int idMiniBar) {
        this.idMiniBar = idMiniBar;
    }
    public String getNombreMiniBar() {
        return nombreMiniBar;
    }
    public void setNombreMiniBar(String nombreMiniBar) {
        this.nombreMiniBar = nombreMiniBar;
    }
    public String getTipoMiniBar() {
        return tipoMiniBar;
    }
    public void setTipoMiniBar(String tipoMiniBar) {
        this.tipoMiniBar = tipoMiniBar;
    }
    public String getDescripcionMiniBar() {
        return descripcionMiniBar;
    }
    public void setDescripcionMiniBar(String descripcionMiniBar) {
        this.descripcionMiniBar = descripcionMiniBar;
    }
}
