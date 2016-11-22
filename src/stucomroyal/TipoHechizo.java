/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

/**
 *
 * @author dam
 */

//  modo ataque afectarán descontando vida a todas las cartas del contrincante en su nivel de alcance *2 / 3
// modo defensa subirá la vida de todas las cartas del jugador que la ha utilizado en la misma cantidad anterior (nivel de alcance * 2 / 3).
public class TipoHechizo extends Cartas implements Cloneable{
   
    private String Modo;

    private int nivelAlcance;

    public TipoHechizo(String Modo, int nivelAlcance, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.Modo = Modo;
        this.nivelAlcance = nivelAlcance;
    }

  
    
    public int getNivelAlcance() {
        return nivelAlcance;
    }

    public void setNivelAlcance(int nivelAlcance) {
        this.nivelAlcance = nivelAlcance;
    }

    public String getModo() {
        return Modo;
    }

    public void setModo(String Modo) {
        this.Modo = Modo;
    }
    
    public int DescuentoVidaModo (int nivelAlcance){
        
        if(Modo.equalsIgnoreCase("Ataque")){
        int descontarAtaque = this.getNivelVida() - nivelAlcance * (2 / 3);
        return descontarAtaque;
        }else if (Modo.equalsIgnoreCase("Defensa")){
         int descontarDefensa = this.getNivelVida() + nivelAlcance * (2 / 3); 
         return descontarDefensa;
        }
        return nivelAlcance;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
 
}
