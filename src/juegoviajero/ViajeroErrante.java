package juegoviajero;

import java.util.Random;

public class ViajeroErrante extends Thread {

    private final int posInicial = 7;
    //private int[][] tabla;
    private final int viajero = 0;
    private int col;
    private int fil;
    private int dado;
    private static final int numCols = 8;
    private static final int numFils = 8;
    private boolean ejecutar = true;
    private Random rnd = new Random(System.currentTimeMillis());
    private int iteraciones = 0;
    private String nombre;

    private static ViajeroErrante instance;

    public static ViajeroErrante getInstance() {
        if (instance == null) {
            instance = new ViajeroErrante();
        }
        return instance;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public enum Movimiento {
        UP, LEFT, DOWN, RIGHT;
    }

    @Override
    public void run() {
        col = posInicial;
        fil = posInicial;
        while (ejecutar) {
            dado = aleatorio();
            System.out.println("El viajero está en la posicion: [" + fil + "],[" + col + "]\n");
            movimiento(dado);
            iteraciones++;
        }

    }
    
    public int getIteraciones(){
        return iteraciones;
    }

    private void movimiento(int mov) {
        switch (mov) {
            case 0:
                if (fil == 0 ){//&& mov == Movimiento.UP.ordinal()) {
                    if (fil == 0 && col == 3 ){//&& mov == Movimiento.UP.ordinal()) {
                        System.out.println("Ha encontrado la salida!!\n");
                        System.out.println("He hecho: " + iteraciones + " iteraciones\n");
                        salir();
                    } else {
                        System.out.println("Ha chocado con una pared hacia ARRIBA\n");
                    }
                } else {
                    fil = fil - 1;
                }
                break;
            case 1:
                if (col == 7 ){//&& mov == Movimiento.LEFT.ordinal()) {
                    System.out.println("Ha chocado con una pared a la DERECHA\n");
                } else {
                    col = col + 1;
                }
                break;
            case 2:
                if (fil == 7 ){//&& mov == Movimiento.DOWN.ordinal()) {
                    System.out.println("Ha chocado con una pared hacia ABAJO\n");
                } else {
                    fil = fil + 1;
                }
                break;
            case 3:
                if (col == 0 ){//&& mov == Movimiento.RIGHT.ordinal()) {
                    System.out.println("Ha chocado con una pared a la IZQUIERDA\n");
                } else {
                    col = col - 1;
                }
                break;
        }

    }

    private void salir() {
        ejecutar = false;
    }

    private int aleatorio() {
        return rnd.nextInt(3 - 0 + 1) + 0;
    }

}
