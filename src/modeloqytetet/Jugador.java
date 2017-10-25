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
public class Jugador {
    private boolean encarcelado;
    private String nombre;
    private int saldo;
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    private ArrayList<TituloPropiedad> propiedades;
    
    public Jugador(String nombre, Casilla c){
        this.encarcelado = false;
        this.nombre = nombre;
        this.saldo = 7500;
        this.casillaActual = c;
        propiedades = new ArrayList<TituloPropiedad>();
        
    }
    
    public Casilla getCasillaActual(){
        //throw new UnsupportedOperationException("[getCasillaActual] Sin implementar");
        return casillaActual;
    }
    
    public boolean getEncarcelado(){
        throw new UnsupportedOperationException("[getEncarcelado] Sin implementar");
    }
    
    protected boolean tengoPropiedades(){
        throw new UnsupportedOperationException("[tengoPropiedades] Sin implementar");
    }
    
    protected boolean comprarTitulo(){
        throw new UnsupportedOperationException("[comprarTitulo] Sin implementar");
    }
    
    protected Sorpresa devolverCartaLibertad(){
        throw new UnsupportedOperationException("[devolverCartaLibertad] Sin implementar");
    }
    
    protected void irACarcel(Casilla c){
        throw new UnsupportedOperationException("[irACarcel] Sin implementar");
    }
    
    protected void modificarSaldo(int cantidad){
        throw new UnsupportedOperationException("[modificarSaldo] Sin implementar");
    }
    
    protected int obtenerCapital(){
        throw new UnsupportedOperationException("[obtenerCapital] Sin implementar");
    }
    
    protected ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada){
        throw new UnsupportedOperationException("[obtenerPropiedadesHipotecadas] Sin implementar");
    }
    
    protected void pagarCobrarPorCasaYHotel(int cantidad){
        throw new UnsupportedOperationException("[pagarCobrarPorCasaYHotel] Sin implementar");
    }
    
    protected boolean pagarLibertad(int cantidad){
        throw new UnsupportedOperationException("[pagarLibertad] Sin implementar");
    }
    
    protected boolean puedoEdificarCasa(Casilla casilla){
        throw new UnsupportedOperationException("[puedoEdificarCasa] Sin implementar");
    }
    
    protected boolean puedoEdificarHotel(Casilla casilla){
        throw new UnsupportedOperationException("[puedoEdificarCasa] Sin implementar");
    }
    
    protected boolean puedoHipotecar(Casilla casilla){
        throw new UnsupportedOperationException("[puedoHipotecar] Sin implementar");
    }
    
    protected boolean puedoPagarHipoteca(Casilla casilla){
        throw new UnsupportedOperationException("[puedoPagarHipoteca] Sin implementar");
    }
    
    protected boolean puedoVenderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("[puedoVenderPropiedad] Sin implementar");
    }
    
    protected void setCartaLibertad(Sorpresa carta){
        throw new UnsupportedOperationException("[setCartaLibertad] Sin implementar");
    }
    
    protected void setCasillaActual(Casilla casilla){
        throw new UnsupportedOperationException("[setCasillaActual] Sin implementar");
    }
    
    protected void setEncarcelado(boolean encarcelado){
        throw new UnsupportedOperationException("[setEncarcelado] Sin implementar");
    }
    
    protected boolean tengoCartaLibertad(){
        throw new UnsupportedOperationException("[tengoCartaLibertad] Sin implementar");
    }
    
    protected void venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("[venderPropiedad] Sin implementar");
    }
    
    private int cuantasCasasHotelesTengo(){
        throw new UnsupportedOperationException("[cuantasCasasHotelesTengo] Sin implementar");
    }
    
    private void eliminarDeMisPropiedades(Casilla casilla){
        throw new UnsupportedOperationException("[eliminarDeMisPropiedades] Sin implementar");
    }
    
    private boolean esDeMipropiedad(Casilla casilla ){
        throw new UnsupportedOperationException("[esDeMipropiedad] Sin implementar");
    }
    
    private boolean tengoSaldo(int cantidad){
        throw new UnsupportedOperationException("[tengoSaldo] Sin implementar");
    }
}
