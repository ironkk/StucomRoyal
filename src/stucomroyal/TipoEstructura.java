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

//tendrán un nivel de defensa. Cuando se utiliza una carta de tipo estructura, sube la vida de las cartas del jugador que la utiliza en su nivel de defensa + 8.
public class TipoEstructura extends Cartas implements Cloneable{
    
    private int nivelDefensa;

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public TipoEstructura(int nivelDefensa, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelDefensa = nivelDefensa;
    }



    public int subeVida (int nivelDefensa){
        int subir = this.getNivelVida() + (8 + nivelDefensa);
        
        return subir;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
