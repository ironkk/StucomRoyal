/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static stucomroyal.Entrada.pedirCadena;
import static stucomroyal.Entrada.pedirEntero;

/**
 *
 * @author ironkk
 */
// En el método principal de la aplicación, crea al menos 3 cartas de cada tipo (tropa, estructura y hechizo) y guárdalas como las cartas disponibles para el juego.
public class StucomRoyal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contador = 0;

        List<Cartas> misCartas = new ArrayList<>(4);

        TipoTropa umpalumpa = new TipoTropa(8, "umpalumpa", 200, 300);
        TipoTropa umpalumpa2 = new TipoTropa(8, "umpalumpa2", 250, 350);
        TipoEstructura umpalumpa3 = new TipoEstructura(10, "umpalumpa3", 400, 250);
        TipoEstructura umpalumpa4 = new TipoEstructura(16, "umpalumpa4", 450, 300);
        TipoHechizo umpalumpa5 = new TipoHechizo("Ataque", 15, "umpalumpa5", 15, 260);
        TipoHechizo umpalumpa6 = new TipoHechizo("Defensa", 7, "umpalumpa6", 22, 250);

        misCartas.add(umpalumpa);
        misCartas.add(umpalumpa2);
        misCartas.add(umpalumpa3);
        misCartas.add(umpalumpa4);
        misCartas.add(umpalumpa5);
        misCartas.add(umpalumpa6);

        // Crea al menos 4 jugadores. Inicialmente su no de trofeos debe ser 0 y no deben tener ninguna carta disponible.
        List<Jugador> misJugadores = new ArrayList<>(4);
        Jugador mark = new Jugador("Mark", "Xaviele123", 0);
        Jugador xavi = new Jugador("Xavi", "Xaviele234", 0);
        Jugador debuen = new Jugador("Debuen", "Xaviele345", 0);
        Jugador manzano = new Jugador("Manzano", "Xaviele456", 0);
        misJugadores.add(xavi);
        misJugadores.add(mark);
        misJugadores.add(debuen);
        misJugadores.add(manzano);

        //a) Conseguir cartas
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String usuario;
            usuario = pedirCadena("¿Usuario");
            String contraseña;
            contraseña = pedirCadena("¿Contraseña?");
            existeJugador(misJugadores, usuario, contraseña);

            if (existeJugador(misJugadores, usuario, contraseña) == true) {
                for (Cartas c : misCartas) {
                    //listado cartas
                    System.out.println(contador + misCartas.toString());
                    // cartas añadir
                    contador++;
                }

                //Cada vez que escoja una carta se comprobará que no la tenga
                int cartasAñadir;
                cartasAñadir = pedirEntero("¿Qué Cartas quieres añadir?");
                if (misCartas.get(0)) {
                    TipoTropa p1 = (TipoTropa) misCartas.get(0).clone();
                    if (existeCarta(misCartas, usuario)) {
                        System.out.println("YA EXISTE ESTA CARTA QUE QUIERES AÑADIR");
                    } else {
                        misCartas.add(p1);
                    }
                } else if (misCartas.get(1)) {
                    TipoTropa p2 = (TipoTropa) misCartas.get(1).clone();
                    if () {
                        System.out.println("YA EXISTE ESTA CARTA QUE QUIERES AÑADIR");
                    } else {
                        misCartas.add(p2);
                    }

                } else if (misCartas.get(2)) {
                    TipoTropa p3 = (TipoTropa) misCartas.get(2).clone();
                    if () {
                        System.out.println("YA EXISTE ESTA CARTA QUE QUIERES AÑADIR");
                    } else {
                        misCartas.add(p3);
                    }
                } else if (misCartas.get(3)) {

                    TipoTropa p4 = (TipoTropa) misCartas.get(3).clone();
                    if () {
                        System.out.println("YA EXISTE ESTA CARTA QUE QUIERES AÑADIR");
                    } else {
                        misCartas.add(p4);
                    }
                } else if (misCartas.get(4)) {
                    TipoTropa p5 = (TipoTropa) misCartas.get(4).clone();
                    if () {
                        System.out.println("YA EXISTE ESTA CARTA QUE QUIERES AÑADIR");
                    }
                } else if (misCartas.get(5)) {
                    TipoTropa p6 = (TipoTropa) misCartas.get(5).clone();
                    if () {
                        misCartas.add(p6);
                    }
                }
            } else {
                System.out.println("No estas dado de alta");

            }

        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ex);

        }

    }

    public static boolean existeJugador(List<Jugador> misJugadores, String usuario, String contraseña) {
        for (Jugador j : misJugadores) {
            if (j.getNombreUsuario().equalsIgnoreCase(usuario) && j.getPassword().equalsIgnoreCase(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public static String existeCarta(List<Cartas> misCartas, String nombreUsuario) {
        for (Cartas c : misCartas) {
            if (c.getNombre().equalsIgnoreCase(nombreUsuario)) {
                return nombreUsuario;
            }
        }
        return "";
    }

}
