package juegoviajero;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViajeroErrante extends Thread {

    private static final int POS_INICIAL = 0;
    private int col;
    private int fil;
    private int dado;
    private int up=0;
    private int down=0;
    private int left=0;
    private int right=0;
    private int sleep=0;
    private boolean ejecutar = true;
    private Random rnd = new Random(System.currentTimeMillis());
    private int iteraciones = 0;
    private String nombre;
    private long fin;
    private long inicio;

    public ViajeroErrante(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void run() {
        inicio = System.currentTimeMillis();
        col = POS_INICIAL;
        fil = POS_INICIAL;
        while (ejecutar) {
            dado = aleatorio();
            //System.out.println("El viajero está en la posicion: [" + fil + "],[" + col + "]\n");
            iteraciones++;
            movimiento(dado);
        }

    }

    private void movimiento(int mov) {
        if (fil != 19 && col != 19) {
            switch (mov) {
                case 0:
                    up++;
                    if (fil == 0) {
                        //System.out.println("Ha chocado con una pared hacia ARRIBA\n");
                    } else {
                        fil = fil - 1;
                    }
                    break;
                case 1:
                    right++;
                    if (col == 19) {
                        //System.out.println("Ha chocado con una pared a la DERECHA\n");
                    } else {
                        col = col + 1;
                    }
                    break;
                case 2:
                    down++;
                    if (fil == 19) {
                        //System.out.println("Ha chocado con una pared hacia ABAJO\n");
                    } else {
                        fil = fil + 1;
                    }
                    break;
                case 3:
                    left++;
                    if (col == 0) {
                        //System.out.println("Ha chocado con una pared a la IZQUIERDA\n");
                    } else {
                        col = col - 1;
                    }
                    break;
                case 4:
                    sleep++;
                    try {
                        //System.out.println("Me voy a dormir 10ms\n");
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViajeroErrante.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
            }
        } else {
            fin = System.currentTimeMillis() - inicio;
            salir();
        }
    }

    private void salir() {
        ejecutar = false;
    }

    private int aleatorio() {
        return rnd.nextInt(4 - 0 + 1) + 0;
    }
    
    public int getIteraciones() {
        return iteraciones;
    }
    
    public int getUp() {
        return up;
    }
    public int getDown() {
        return down;
    }
    public int getLeft() {
        return left;
    }
    public int getRight() {
        return right;
    }
    public int getSleep() {
        return sleep;
    }
    public long getTiempo(){
        return fin;
    }
    public String getNombre(){
        return nombre;
    }

}
