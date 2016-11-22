/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ironkk
 */
//un nombre, un coste de elixir (que estará entre 1 y 5) y un nivel de vida (entre 1 y 100).
public class Cartas implements Cloneable {

    private String nombre;

    private int costeElixir;

    private int nivelVida;

    public Cartas(String nombre, int costeElixir, int nivelVida) {
        this.nombre = nombre;
        this.costeElixir = costeElixir;
        this.nivelVida = nivelVida;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    public int getCosteElixir() {
        return costeElixir;
    }

    public void setCosteElixir(int costeElixir) {
        this.costeElixir = costeElixir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cartas{" + "nombre=" + nombre + ", costeElixir=" + costeElixir + ", nivelVida=" + nivelVida + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
