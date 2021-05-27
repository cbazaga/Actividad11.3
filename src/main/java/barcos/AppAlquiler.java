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
public class AppAlquiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alquiler a1 = new Alquiler("Antonio", "75411484X", 7, 1, new Velero(2, 25412, 3.75, 2001));
        Alquiler a2 = new Alquiler("Laura", "78451145S",10,2, new Yate(500, 1, 3513, 4.5, 2020));
        Alquiler a3 =  new Alquiler ("Manuel", "79944154T", 2, 3, new EmbarcacionDeportiva(2500, 26548, 5.45, 1999));
        
        System.out.printf("El alquiler 1 pagará %.2f euros\n",a1.calcularPrecio());
        System.out.printf("El alquiler 2 pagará %.2f euros\n",a2.calcularPrecio());
        System.out.printf("El alquiler 3 pagará %.2f euros\n",a3.calcularPrecio());
    }
    
}
