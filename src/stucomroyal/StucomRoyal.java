/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        List<Jugador> misJugadores = new ArrayList<>(4);
        Jugador mark = new Jugador("Mark", "Xaviele123", 0);
        Jugador xavi = new Jugador("Xavi", "Xaviele234", 0);
        Jugador debuen = new Jugador("Debuen", "Xaviele345", 0);
        Jugador manzano = new Jugador("Manzano", "Xaviele456", 0);
        misJugadores.add(xavi);
        misJugadores.add(mark);
        misJugadores.add(debuen);
        misJugadores.add(manzano);

        int opcion;

        do {

            mostrarMenu();
            opcion = Entrada.pedirEntero("Escoge una opción");

            switch (opcion) {
                case 1:
                    ConseguirCartas(misJugadores, misCartas);
                    break;
                case 2:
                    Batalla(misJugadores, misCartas);
                    break;
                case 3:
                    RankingJugadoresNumeroTrofeos();
                    break;
                case 4:
                    System.out.println("Adiós!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción incorrecta.");

            }

        } while (opcion != 0);

    }

    private static void mostrarMenu() {
        System.out.println("*** StucomRoyal ***");
        System.out.println("1. Conseguir cartas.");
        System.out.println("2. Batalla.");
        System.out.println("3. Obtener el ránking de jugadores por no de trofeos.");
        System.out.println("4. Salir");

    }

    public static void ConseguirCartas(List<Jugador> misJugadores, List<Cartas> misCartas) {
        int contador = 0;
        String usuario;
        usuario = pedirCadena("¿Usuario");
        String contraseña;
        contraseña = pedirCadena("¿Contraseña?");

        if (existeJugador(misJugadores, usuario, contraseña) == true) {
            for (Cartas c : misCartas) {
                System.out.println(contador + " " + c);
                contador++;
            }

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

    public static void Batalla(List<Jugador> misJugadores, List<Cartas> misCartas) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int contador = 0;
            int cartas = 0;
            int CartasElegidas = 0;
            int jugadores = 0;

            do {

                String usuario;
                usuario = pedirCadena("¿Usuario");
                String contraseña;
                contraseña = pedirCadena("¿Contraseña?");
                existeJugador(misJugadores, usuario, contraseña);
                if (existeJugador(misJugadores, usuario, contraseña) == true) {
                    for (Cartas c : misCartas) {
                        System.out.println(contador + "" + c);
                        contador++;
                        jugadores++;
                    }
                }
                do {

                    primeroEnAtacar(misJugadores, misCartas);

                    int elegirCarta;

                    elegirCarta = pedirEntero("¿Qué Carta quieres escoger?");
                    Jugador jugadorActual = obtenerJugadorPorUsuario(misJugadores, usuario);
                    // me traigo la carta?

                    if (cartaActual) {

                    } else {
                        // clone
                       Cartas clonacion = misCartas.get(0).clone();
                        misCartas.add(clonacion);
                        CartasElegidas++;
                        sumaElixir(misCartas, clonacion);

                    }

                } while (CartasElegidas == 3);

            } while (jugadores == 2);

        } catch (Exception e) {

        }
    }

    // Obtener el ranking de jugadores por no de trofeos. Deberá mostrarse el nombre del jugador y el no de trofeos que tiene, ordenador de mayor a menor.
    private final Set<Jugador> jugadores = new HashSet<>();

    public Optional<Jugador> RankingJugadoresNumeroTrofes() {

        return jugadores.stream().mapToInt(kol::getnumeroTrofeos).sorted().count();

    }

    public static boolean existeJugador(List<Jugador> misJugadores, String usuario, String contraseña) {
        for (Jugador j : misJugadores) {
            if (j.getNombreUsuario().equalsIgnoreCase(usuario) && j.getPassword().equalsIgnoreCase(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public static boolean buscarCarta(List<Cartas> CartasJuego, Cartas cartaSeleccionada) {
        for (Cartas c : CartasJuego) {
            if (c.getNombre().equals(cartaSeleccionada.getNombre())) {
                return true;
            }
        }
        return false;

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
    public static boolean sumaElixir(List<Cartas> CartasJuego, Cartas cartaSeleccionada) {
        for (Cartas c : CartasJuego) {
            do {
                cartaSeleccionada.getCosteElixir()
                        
                if () {
                    System.out.println("¡Elixir Demasiado Alto!");
                    return false;

                } else {
                    System.out.println("¡Elixir Correcto!");
                    return true;
                }

            } while (c.getCosteElixir() > 10);
        }

        return false;
    }

    public static boolean primeroEnAtacar(List<Jugador> misJugadores, List<Cartas> CartasJuego) {

        //Se decidirá aleatoriamente quien es el que ataca primero. 
        double numAleatorio = Math.random() * 20;

        if (numAleatorio < 20 && numAleatorio > 10) {

            //Jugador que empieza
            Jugador jugador1 = misJugadores.get(0);

            //la primera carta que escoge
            Cartas cartaEmpieza = CartasJuego.get(0);

            //se la asignamos
            Jugador jugador1 = CartasJuego.add(cartaEmpieza);

            //Siguiente Jugador lo mismo?
            Cartas cartaEmpiezaJ2 = CartasJuego.get(0);

            // si pasa tal tal y tal trofeos a 5
            if (cartaEmpieza.getNivelVida() > cartaEmpiezaJ2.getNivelVida()) {
                misJugadores.get(0).setNumeroTrofes(5);

            }

            //
        } else {

        }
        return false;

    }
}
