/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoviajero;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Castealo
 */
public class JuegoViajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViajeroErrante ve = new ViajeroErrante();
        ve.setNombre("Viajero");
        
        ve.start();
        
        try {
            ve.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(JuegoViajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
