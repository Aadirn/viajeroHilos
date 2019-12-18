/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoviajero;

import claseViajero.Viajero;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JuegoViajero {

    private static int total = 0;
    private static Viajero v;
    private static final int REPS = 100;
    private static ArrayList<Viajero> lst = new ArrayList<>();
    private static ArrayList<Long> rapidez = new ArrayList<>();
    private static ArrayList<Viajero> orden = new ArrayList<>();
    private static long masRapido;
    private static long rapido;

    public static void main(String[] args) {
        for (int i = 0; i < REPS; i++) {
            ViajeroErrante ve = new ViajeroErrante("Viajero" + i);

            ve.start();

            try {
                ve.join();
                total = total + ve.getIteraciones();
                v = new Viajero(ve.getNombre(), ve.getUp(), ve.getDown(), ve.getLeft(), ve.getRight(), ve.getSleep(), ve.getTiempo());
                lst.add(v);
            } catch (InterruptedException ex) {
                Logger.getLogger(JuegoViajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        lst.sort((Viajero v1, Viajero v2) -> new Long(v1.getTiempo()).compareTo(new Long(v2.getTiempo())));

        mostrarViajeros();
    }

    public static void mostrarViajeros() {
        for (int i = 0; i < REPS; i++) {
            System.out.println(lst.get(i).toString() + "\n");
        }
    }

}
