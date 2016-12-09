/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import static stucomroyal.Entrada.pedirCadena;
import static stucomroyal.Entrada.pedirEntero;

/**
 *
 * @author ironkk
 */
// En el método principal de la aplicación, crea al menos 3 cartas de cada tipo (tropa, estructura y hechizo) y guárdalas como las cartas disponibles para el juego.
public class StucomRoyal {

    public static List<Jugador> misJugadores = new ArrayList<>(4);
    public static List<Jugador> misJugadoresordenados = new ArrayList<>(4);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

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
        Jugador mark = new Jugador("Mark", "Xaviele123", 0);
        Jugador xavi = new Jugador("Xavi", "Xaviele234", 0);
        Jugador debuen = new Jugador("Debuen", "Xaviele345", 0);
        Jugador manzano = new Jugador("Manzano", "Xaviele456", 0);
        Jugador crack = new Jugador("Francesc", "cesc", 0);
        misJugadores.add(xavi);
        misJugadores.add(mark);
        misJugadores.add(debuen);
        misJugadores.add(manzano);

        switch (mostrarMenu()) {
            case 1:
                ConseguirCartas(misJugadores, misCartas);
                break;
            case 2:
                Batalla(misJugadores, misCartas, umpalumpa);
                break;
            case 3:
                ranking(misJugadores);
                break;
            case 4:
                System.out.println("Adiós!");
                System.exit(0);
                break;

            default:
                System.out.println("Opción incorrecta.");

        }

    }

    private static int mostrarMenu() {
        int opcion = -1;

        do {

            System.out.println("*** StucomRoyal ***");
            System.out.println("1. Conseguir cartas.");
            System.out.println("2. Batalla.");
            System.out.println("3. Obtener el ránking de jugadores por no de trofeos.");
            System.out.println("4. Salir");
            opcion = Entrada.pedirEntero("Escoge una opción");

        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    // FUNCIONA CORRECTAMENTE 
    public static void ConseguirCartas(List<Jugador> misJugadores, List<Cartas> misCartas) {
        int contador = 0;
        String usuario;
        usuario = pedirCadena("¿Usuario");
        String contraseña;
        contraseña = pedirCadena("¿Contraseña?");

        if (existeJugador(misJugadores, usuario, contraseña) == true) {
            mostrarCartas(misCartas);

            int cartasAñadir = pedirEntero("¿Qué Cartas quieres añadir?");
            // Necesitamos traer al jugador
            Jugador jugadorActual = obtenerJugadorPorUsuario(misJugadores, usuario);
            // Comprobamos si ya tiene 6 cartas
            if (jugadorActual.getCartasJuego().size() < 6) {
                // traemos la carta con el nº que ha puesto el usuario
                Cartas cartaSeleccionada = misCartas.get(cartasAñadir);
                // Comprobamos si el jugador la tiene
                if (buscarCarta(jugadorActual.getCartasJuego(), cartaSeleccionada) == false) {
                    // Se la añadimos a las cartas del jugador
                    jugadorActual.getCartasJuego().add(cartaSeleccionada);
                    System.out.println("Carta Añadida :D");
                } else {
                    System.out.println("Ya tienes esa Carta!");
                }
            } else {
                System.out.println("Tienes el cupo de cartas lleno");
                System.out.println("Lánzate a la batalla!");
            }

        } else {
            System.out.println("No estas dado de alta");

        }

    }

    // ACABAR INTERACCION DE CARTAS
    public static void Batalla(List<Jugador> misJugadores, List<Cartas> misCartas, Cartas cartaElegida) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int jugadores = 0;

            do {
                elegirCarta(misJugadores, misCartas, cartaElegida);
                jugadores++;

            } while (jugadores == 2);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // INTENTAR HACER RANKING DE TROFEOS MIRAR JAVA 8 HASHSET SENTENCIA CON EL SORTED Y COUNT.
    public static void ranking(List<Jugador> jugador) {
        int contador = 0;

        Collections.sort(jugador, trofes);
        
        
        System.out.println("Ranking Trofeos");
        for (Jugador j : jugador) {
            System.out.println("");
            System.out.println(contador + " - " + j.getNombreUsuario() + ", trofeos: " + j.getNumeroTrofes());
            contador++;
        }
    }

    public static Jugador validar(List<Jugador> jugador) {
        String usuario = pedirCadena("Introduce el usuario:");
        String password = pedirCadena("Introduce la contraseña:");
        Jugador validar = null;
        for (Jugador j : jugador) {
            if (j.getNombreUsuario().equalsIgnoreCase(usuario) && j.getPassword().equalsIgnoreCase(password)) {
                validar = j;
            }
        }
        return validar;
    }

    public static boolean existeJugador(List<Jugador> misJugadores, String usuario, String contraseña) {
        for (Jugador j : misJugadores) {
            if (j.getNombreUsuario().equalsIgnoreCase(usuario) && j.getPassword().equalsIgnoreCase(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarCartas(List<Cartas> cartas) {
        int contador = 0;
        for (Cartas c : cartas) {
            System.out.println(contador + " " + c);
            contador++;
        }
    }

    public static boolean buscarCarta(List<Cartas> CartasJuego, Cartas cartaSeleccionada) {
        for (Cartas c : CartasJuego) {
            if (c.getNombre().equals(cartaSeleccionada.getNombre())) {
                return true;
            }
        }
        return false;

    }

    // PLANTEAR ESTE METODO!!
    public static Cartas buscarCartaElegida(List<Cartas> CartasJuego, Cartas cartaElegida) {
        for (Cartas c : CartasJuego) {
            if (c.getNombre()) {
                System.out.println("");
            }
        }
        System.out.println("");
        return null;
    }

    public static Jugador obtenerJugadorPorUsuario(List<Jugador> jugadores, String nombreUsuario) {
        for (Jugador j : jugadores) {
            if (j.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return j;
            }
        }
        return null;
    }

    //!!
    // La suma del elixir de las cartas que escoja no podrá ser superior a 10.
    //PENDIENTE DE ARREGLAR
    public static Cartas sumaElixir(List<Cartas> CartasJuego, Cartas cartaSeleccionada) {
        for (Cartas c : CartasJuego) {
            do {
                // cartaSeleccionada.getCosteElixir()

                if (true) {
                    System.out.println("¡Elixir Demasiado Alto!");

                } else {
                    System.out.println("¡Elixir Correcto!");

                }

            } while (c.getCosteElixir() > 10);
        }
        return null;
    }

    public static void elegirCarta(List<Jugador> misJugadores, List<Cartas> misCartas, Cartas cartaElegida) {
        String usuario;
        int CartasElegidas = 0;
        usuario = pedirCadena("¿Usuario");
        String contraseña;
        contraseña = pedirCadena("¿Contraseña?");
        existeJugador(misJugadores, usuario, contraseña);
        if (existeJugador(misJugadores, usuario, contraseña) == true) {
            mostrarCartas(misCartas);

        }
        do {

            primeroEnAtacar(misJugadores, misCartas, cartaElegida);

            int elegirCarta;

            elegirCarta = pedirEntero("¿Qué Carta quieres escoger?");
            Jugador jugadorActual = obtenerJugadorPorUsuario(misJugadores, usuario);
            // me traigo la carta?
            Cartas cartaSeleccionada = buscarCartaElegida(misCartas, cartaElegida);
            
            //??
            jugadorActual.getCartasJuego();
            // nombre?
            if (cartaSeleccionada.getNombre().equalsIgnoreCase(nombre)) {
                sumaElixir(misCartas, cartaSeleccionada);
            } else {
                // clone
                Cartas clonacion = misCartas.get(0);
                misCartas.add(clonacion);
                CartasElegidas++;
                sumaElixir(misCartas, clonacion);

            }

        } while (CartasElegidas == 3);

    }

    // ARREGLAR ESTE METODO
    public static boolean primeroEnAtacar(List<Jugador> misJugadores, List<Cartas> CartasJuego, Cartas cartaElegida) {

        //Se decidirá aleatoriamente quien es el que ataca primero. 
        double numAleatorio = Math.random() * 20;

        if (numAleatorio < 20 && numAleatorio > 10) {

            //Jugador 1
            Jugador jugador1 = misJugadores.get(0);

            //la primera carta que escoge
            Cartas cartaEmpieza = buscarCartaElegida(CartasJuego, cartaElegida);

     //====       //se la asignamos BOOLEAN???????
            jugador1 = CartasJuego.add(cartaEmpieza);

            //Jugador 2
            Jugador jugador2 = misJugadores.get(1);

            //Siguiente Jugador lo mismo?
            Cartas cartaEmpiezaJ2 = buscarCartaElegida(CartasJuego, cartaElegida);

            jugador2 = CartasJuego.add(cartaEmpiezaJ2);

            // si pasa tal tal y tal trofeos a 5
            if (cartaEmpieza.getNivelVida() > cartaEmpiezaJ2.getNivelVida()) {
                misJugadores.get(0).setNumeroTrofes(5);

            }

        } else {
            System.out.println("");
        }
        return false;

    }

}
