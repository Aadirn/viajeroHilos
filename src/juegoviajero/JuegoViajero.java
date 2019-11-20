/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoviajero;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JuegoViajero {

    private static int total = 0;

    public static void main(String[] args) {
        for (int i = 0; i <5000; i++) {
            ViajeroErrante ve = new ViajeroErrante();
            ve.setNombre("Viajero");

            ve.start();

            try {
                ve.join();
                total = total + ve.getIteraciones()-1;
            } catch (InterruptedException ex) {
                Logger.getLogger(JuegoViajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(total + "\n");
    }

}
