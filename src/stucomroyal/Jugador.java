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
 * @author dam
 */

// nombre de usuario, password y número de trofeos conseguidos
public class Jugador {
    
    private String nombreUsuario;

    private String Password;
    
    private List<Jugador> misCartas;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }


    private int numeroTrofes;

    public int getNumeroTrofes() {
        return numeroTrofes;
    }

    public void setNumeroTrofes(int numeroTrofes) {
        this.numeroTrofes = numeroTrofes;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Jugador(String nombreUsuario, String Password, int numeroTrofes) {
        this.nombreUsuario = nombreUsuario;
        this.Password = Password;
        this.numeroTrofes = numeroTrofes;
        misCartas = new ArrayList<>();
    }

   
}
