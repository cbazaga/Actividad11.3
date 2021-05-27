/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcos;

import java.text.NumberFormat;

/**
 *
 * @author jmas
 */
public class Alquiler {
    private final String nombre;
    private final String DNI;
    private final int diasOcupacion;
    private final int posicionAmarre;
    private double precio=0;
    Barco barco;

    public Alquiler(String nombre, String DNI, int diasOcupacion, int posicionAmarre, Barco barco) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.diasOcupacion = diasOcupacion;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }
    
    public double calcularPrecio(){
        precio = this.diasOcupacion * this.barco.factor();
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getDiasOcupacion() {
        return String.valueOf(diasOcupacion);
    }

    public String getPosicionAmarre() {
        return String.valueOf(posicionAmarre);
    }

    public Barco getBarco() {
        return barco;
    }

    public String getPrecio() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(precio);
    }
    
    
}
