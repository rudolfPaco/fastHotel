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
public class F_Documento {

    private String nombreDocumento;
    private String direccionDocumento;
    private String tipoDocumento;
    
    public F_Documento(String nombreDocumento, String direccionDocumento, String tipoDocumento){
        this.nombreDocumento = nombreDocumento;
        this.direccionDocumento = direccionDocumento;
        this.tipoDocumento = tipoDocumento;
    }
    public String getNombreDocumento() {
        return nombreDocumento;
    }
    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }
    public String getDireccionDocumento() {
        return direccionDocumento;
    }
    public void setDireccionDocumento(String direccionDocumento) {
        this.direccionDocumento = direccionDocumento;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}