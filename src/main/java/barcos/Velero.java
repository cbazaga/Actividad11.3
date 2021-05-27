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
public class Velero extends Barco {
    
    protected static int MODULO_MASTILES = 5;
    protected int numeroDeMastiles;

    public Velero(int numeroDeMastiles, int matricula, double eslora, int anyoFabricacion) {
        super(matricula, eslora, anyoFabricacion);
        this.numeroDeMastiles = numeroDeMastiles;
    }
    
    @Override
    public double factor(){
        return super.factor() + this.numeroDeMastiles * MODULO_MASTILES;
    }
    
    
}
