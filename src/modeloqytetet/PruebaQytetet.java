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
        mazo.add(new Sorpresa("Tu casero te ha robado todo el dinero (y más) de tu fianza. Sales de la carcel por muerto de hambre.", TipoSorpresa.SALIRCARCEL, 4)); // Carcel
        
        mazo.add(new Sorpresa("Te ponen La Reina del Grindr en La Sal. Ganas 1000€", TipoSorpresa.PAGARCOBRAR, 2));
        mazo.add(new Sorpresa("Samu te roba hummus. Pierdes 500€", TipoSorpresa.PAGARCOBRAR, 3));
        
        mazo.add(new Sorpresa("Pompino te toca el culo. Sales corriendo hasta la casilla 16", TipoSorpresa.IRACASILLA, 1));
        mazo.add(new Sorpresa("El Six Colours está lleno de capillitas. Te vas indignada hasta la casilla 11", TipoSorpresa.IRACASILLA, 5));
        mazo.add(new Sorpresa("Paloma Cuesta te tira una falda y punto en boca. Te mueves hasta la casilla 9", TipoSorpresa.IRACASILLA, 6));
        
        
        mazo.add(new Sorpresa("La Chunga y La Hierbas tiran un muro de carga. Pagas 100€ por cada Casa y 150 por cada Hotel", TipoSorpresa.PORCASAHOTEL, 7));
        mazo.add(new Sorpresa("Te has peleado con la Hierbas y te vas al Hostal Loli. Pagas 200€ por cada Casa/Hotel", TipoSorpresa.PORCASAHOTEL, 8));
        
        mazo.add(new Sorpresa("Vas a la sal con los alcoholicos. Los invitas a cervezas y gastas 60€", TipoSorpresa.PORJUGADOR, 9));
        mazo.add(new Sorpresa("Tus amigos te roban el movil y no puedes pagar con el contactless. Te dan 100€", TipoSorpresa.PORJUGADOR, 10));
        
        mazo.add(new Sorpresa("Te has liado con un capillita machirulo opresor.Vas a la cárcel", TipoSorpresa.SALIRCARCEL, 0)); // Carcel
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
        
        /*System.out.println(mazo.toString()); // Si no hubieramos llamado al toString, 
        // se llamaria al toString por defecto del tipo base del array, 
        // por lo que el resultado final es el mismo -> Se imprime correctamente
        System.out.println("Sorpresas con valores mayores a cero: " + devolverMayorCero().toString());
        
        System.out.println("Sorpresas con tipo IRACASILLA: " + devolverIrACasilla().toString());
        
        System.out.println("Sorpresas con tipo PAGARCOBRAR: " + devolverTipo(TipoSorpresa.PAGARCOBRAR).toString());
        System.out.println("Sorpresas con tipo PORCASAHOTEL: " + devolverTipo(TipoSorpresa.PORCASAHOTEL).toString());
        System.out.println("Sorpresas con tipo PORJUGADOR: " + devolverTipo(TipoSorpresa.PORJUGADOR).toString());
        System.out.println("Sorpresas con tipo SALIRCARCEL: " + devolverTipo(TipoSorpresa.SALIRCARCEL).toString());
        */
        
        
        /*Tablero miTableroPrueba = new Tablero();
        System.out.println(miTableroPrueba.toString());
        System.out.println("La carcel esta: " + miTableroPrueba.getCarcel().getNumeroCasilla());
        
        
        
        Jugador j = new Jugador("Anda Paqui", true, 2000,null,  null, null );
        
        j.actualizarPosicion();*/
        
        ArrayList<String> nombreJugadores = new ArrayList<String>();
        nombreJugadores.add("Jelaminah");
        nombreJugadores.add("Jela");
        Qytetet q = Qytetet.getInstance();
        q.inicializarJuego(nombreJugadores);
        System.out.println(q.getJugadores().toString());
        System.out.println("Ranking:" + q.obtenerRanking().toString());
        
    }
    
}
