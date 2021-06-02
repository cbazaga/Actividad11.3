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
public class Yate extends Barco {
    
    protected int potencia;
    protected int numeroDeCamarotes;

    public Yate(int potencia, int numeroDeCamarotes, int matricula, double eslora, int anyoFabricacion) {
        super(matricula, eslora, anyoFabricacion);
        this.potencia = potencia;
        this.numeroDeCamarotes = numeroDeCamarotes;
    }

    @Override
    public double factor(){
        return super.factor() + this.potencia + this.numeroDeCamarotes * MODULO;
    }
    
    public String toString(){
        return super.toString()+", numero de camarotes: "+numeroDeCamarotes;
    }

    @Override
    public String getNumeroDeMastiles() {
        return super.getNumeroDeMastiles(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPotencia() {
        return super.getPotencia(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNumeroDeCamarotes() {
        return String.valueOf(numeroDeCamarotes);
    }
    
    
   
}
