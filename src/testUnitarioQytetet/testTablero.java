/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarioQytetet;
import modeloqytetet.*;
/**
 *
 * @author pepito
 */
public class testTablero {
    public static void main(String[] args){
        
        
        final String SEPARADOR = "\n___________________________________________" +
            "____________________________________________________________" +
            "____\n\n\n\n\n";
        final String Titulo = "\t\t\t\t" + 
                              "[JAVA] Prueba de unidad de la clase TABLERO" +
                              "\n\n\n\n\n\n";
        
        System.out.println(Titulo);
        
        
        Tablero miTableroPrueba = new Tablero();
        
        System.out.println("Test [esCasillaCarcel]");
        System.out.println(miTableroPrueba.esCasillaCarcel(6));
        System.out.println(miTableroPrueba.esCasillaCarcel(4));
        System.out.println(SEPARADOR);
        
        System.out.println("Test [getCarcel]");
        System.out.println(miTableroPrueba.getCarcel());
        System.out.println(SEPARADOR);
        
        System.out.println("Test [obtenerCasillaNumero(numero)]:");
        System.out.println(miTableroPrueba.obtenerCasillaNumero(19));
        System.out.println(SEPARADOR);
        
        System.out.println("Test [obtenerNuevaCasilla(casilla, desplazamiento)]:");
        System.out.println(miTableroPrueba.obtenerNuevaCasilla(miTableroPrueba.getCarcel(),23));
        System.out.println(SEPARADOR);
        
        
        
    }
}
