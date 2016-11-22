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

//tendrán un nivel de ataque. Cuando una carta de tipo tropa ataca descuenta su nivel de ataque / 2 la vida de la carta a la que hayan atacado.
public class TipoTropa extends Cartas implements Cloneable{
    
    private int nivelAtaque;

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public TipoTropa(int nivelAtaque, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelAtaque = nivelAtaque;
    }

    
    
    
     public int Ataca (int nivelAtaque) {
         int descuento = nivelAtaque / (2 * this.getNivelVida());
         return descuento;
 
    }
     
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
