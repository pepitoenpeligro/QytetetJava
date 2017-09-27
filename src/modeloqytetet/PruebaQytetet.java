/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author pepito
 */
public class PruebaQytetet {
    static private ArrayList<Sorpresa> mazo;
    
    static public void inicializarSorpresa(){
        mazo.add(new Sorpresa("Texto1", TipoSorpresa.IRACASILLA, 1));
        mazo.add(new Sorpresa("Texto2", TipoSorpresa.PAGARCOBRAR, 2));
        mazo.add(new Sorpresa("Texto3", TipoSorpresa.PORCASAHOTEL, 3));
        mazo.add(new Sorpresa("Texto4", TipoSorpresa.PORJUGADOR, 4));
        mazo.add(new Sorpresa("Texto5", TipoSorpresa.SALIRCARCEL, 5));
        mazo.add(new Sorpresa("Texto6", TipoSorpresa.IRACASILLA, 6));
        mazo.add(new Sorpresa("Texto7", TipoSorpresa.PAGARCOBRAR, 7));
        mazo.add(new Sorpresa("Texto8", TipoSorpresa.PORCASAHOTEL, 8));
        mazo.add(new Sorpresa("Texto9", TipoSorpresa.PORJUGADOR, 9));
        mazo.add(new Sorpresa("Texto10", TipoSorpresa.SALIRCARCEL, 10));
    }
    
    static private ArrayList<Sorpresa> devolverMayorCero(){
        ArrayList<Sorpresa> mazoTemporal = new ArrayList<Sorpresa>();
        
        for(Sorpresa m: mazo){
            if(m.getValor() > 0){
                mazoTemporal.add(m);
            }
        }
        
        return mazoTemporal;
    }
    
    static private ArrayList<Sorpresa> devolverIrACasilla(){
        ArrayList<Sorpresa> mazoTemporal = new ArrayList<Sorpresa>();
        
        for(Sorpresa s: mazo){
            if(s.getTipo()==TipoSorpresa.IRACASILLA){
                mazoTemporal.add(s);
            }
        }
        
        return mazoTemporal;
    }
    
    static private ArrayList<Sorpresa> devolverTipo(TipoSorpresa t){
        ArrayList<Sorpresa> mazoTemporal = new ArrayList<Sorpresa>();
        
        for(Sorpresa s : mazo){
            if(s.getTipo() == t){
                mazoTemporal.add(s);
            }
        }
        
        return mazoTemporal;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        mazo = new ArrayList<Sorpresa>();
        inicializarSorpresa();
        
        System.out.println(mazo.toString()); // Si no hubieramos llamado al toString, 
        // se llamaria al toString por defecto del tipo base del array, 
        // por lo que el resultado final es el mismo -> Se imprime correctamente
        System.out.println("Sorpresas con valores mayores a cero: " + devolverMayorCero().toString());
        
        System.out.println("Sorpresas con tipo IRACASILLA: " + devolverIrACasilla().toString());
        
        System.out.println("Sorpresas con tipo PAGARCOBRAR: " + devolverTipo(TipoSorpresa.PAGARCOBRAR).toString());
        System.out.println("Sorpresas con tipo PORCASAHOTEL: " + devolverTipo(TipoSorpresa.PORCASAHOTEL).toString());
        System.out.println("Sorpresas con tipo PORJUGADOR: " + devolverTipo(TipoSorpresa.PORJUGADOR).toString());
        System.out.println("Sorpresas con tipo SALIRCARCEL: " + devolverTipo(TipoSorpresa.SALIRCARCEL).toString());
    }
    
}
