/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcos;

/**
 *
 * @author jmas
 */
public class EmbarcacionDeportiva extends Barco{
    protected static double MODULO_DEPORTIVA = .5;
    
    protected int potencia;

    public EmbarcacionDeportiva(int potencia, int matricula, double eslora, int anyoFabricacion) {
        super(matricula, eslora, anyoFabricacion);
        this.potencia = potencia;
    }
    
    @Override
    public double factor(){
        return super.factor() + this.potencia * MODULO_DEPORTIVA;
    }

    public static double getMODULO_DEPORTIVA() {
        return MODULO_DEPORTIVA;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
    public String toString() {
        return super.toString()+",modulo: "+MODULO_DEPORTIVA+ ",potencia: "+potencia;
    }

    
    
    
    
}
