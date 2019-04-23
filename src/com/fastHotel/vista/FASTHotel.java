/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fastHotel.vista;

import FAST.com.ventanas.IU_VentanaIdentificacion;
import com.fastHotel.control.C_AplicacionPrincipal;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author rudolf
 */
public class FASTHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IU_VentanaIdentificacion iuVentana = new IU_VentanaIdentificacion();        
        
        if(iuVentana.getEstado()){
            C_AplicacionPrincipal controlAplicacion = new C_AplicacionPrincipal();            
        }
    }
}