/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarioQytetet;

import modeloqytetet.Sorpresa;
import modeloqytetet.TipoSorpresa;

/**
 *
 * @author pepito
 */
public class testSorpresa {
    public static void main(String[] args){
        Sorpresa miSorpresa = new Sorpresa("Anda Paqui", TipoSorpresa.IRACASILLA, 300);
        System.out.println(miSorpresa.toString());
        
        
    }
}
