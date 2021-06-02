/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcos;

import java.util.ArrayList;

/**
 *
 * @author jmas
 */
public class Barco {
    protected static final int MODULO = 10;
    
    protected int matricula;
    protected double eslora;
    protected int anyoFabricacion;

    public Barco(int matricula, double eslora, int anyoFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anyoFabricacion = anyoFabricacion;
    }
    public double  factor(){
        return MODULO * eslora; 
    }

    public String getMODULO() {
        return String.valueOf(MODULO);
    }

    public String getMatricula() {
        return String.valueOf(matricula);
    }

    public String getEslora() {
        return String.valueOf(eslora);
    }

    public String getAnyoFabricacion() {
        return String.valueOf(anyoFabricacion);
    }
    
    public static Barco buscar(ArrayList<Barco> lista, int matricula){
        for (int i=0; i<lista.size();i++) {
            if (lista.get(i).matricula==matricula) return lista.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        return ("Matrícula: "+matricula+", eslora: "+eslora+", año de fabricación: "+anyoFabricacion);
    }
    
    public String getPotencia(){
        return "-";
    }
    
    public String getNumeroDeMastiles(){
        return "-";
    }
    
    public String getNumeroDeCamarotes() {
        return "-";
    }
    
}
