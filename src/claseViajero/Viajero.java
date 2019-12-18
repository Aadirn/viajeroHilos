/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseViajero;

/**
 *
 * @author Castealo
 */
public class Viajero implements Comparable<Viajero> {

    private String nombre;
    private int up;
    private int down;
    private int left;
    private int right;
    private int sleep;
    private long tiempo;

    public Viajero(String nombre, int up, int down, int left, int right, int sleep, long tiempo) {
        this.nombre = nombre;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.sleep = sleep;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Nombre Hilo: "+nombre + " //UP: " + up + " //DOWN: " + down + " //LEFT: " + left + " //RIGHT: " + right + " //SLEEP: " + sleep + " //Tiempo Trabajo(ms): " + tiempo;
    }

    @Override
    public int compareTo(Viajero v) {
        if (tiempo < v.tiempo) {
                return -1;
            }
            if (tiempo > v.tiempo) {
                return 1;
            }
            return 0;
        }
    

}
