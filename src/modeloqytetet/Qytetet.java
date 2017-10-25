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
public class Qytetet {
    static int MAX_JUGADORES = 4;
    static int MAX_CARTAS = 10;
    static int  MAX_CASILLAS = 20;
    static int PRECIO_LIBERDAD = 200;
    static int SALDO_SALIDA = 1000;
    
    private Sorpresa cartaActual;
    private Tablero tablero;
    private Jugador jugadorActual;
    private ArrayList<Sorpresa> mazo = new ArrayList();
    
    private Qytetet(Tablero tablero, Jugador jugadorActual) {
        this.cartaActual = null;
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
    }
    
    private Qytetet(){
        
    }
    
    public static Qytetet getInstance() {
        return QytetetHolder.INSTANCE;
    }
    
    private static class QytetetHolder {
        private static final Qytetet INSTANCE = new Qytetet();
    }
    
    public Sorpresa getCartaActual(){
        return cartaActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    private void inicializarJugadores(String nombre, int MAX_JUGADORES ){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void inicializarTablero(){
        tablero = new Tablero();
    }

    // Se sobrecarga el toString original
    @Override
    public String toString() {
        return "Qytetet{" + "cartaActual=" + cartaActual + ", tablero=" + tablero + ", jugadorActual=" + jugadorActual + ", mazo=" + mazo + '}';
    }
    
    private void inicializarCartasSorpresa(){
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
    
}
