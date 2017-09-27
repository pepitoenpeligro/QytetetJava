/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarioQytetet;

import modeloqytetet.TipoSorpresa;

/**
 *
 * @author pepito
 */
public class testTipoSorpresa {
    public static void main(String[] args){
        System.out.println("Los tipos de sorpresa válidos pueden ser: ");
        System.out.println(TipoSorpresa.IRACASILLA.toString());
        System.out.println(TipoSorpresa.PAGARCOBRAR.toString());
        System.out.println(TipoSorpresa.PORCASAHOTEL.toString());
        System.out.println(TipoSorpresa.PORJUGADOR.toString());
        System.out.println(TipoSorpresa.SALIRCARCEL.toString());
        
        
        
        
    }
}
