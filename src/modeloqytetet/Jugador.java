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

    public Jugador(String nombre, boolean encarcelado, int saldo, Sorpresa cartaLibertad, Casilla casillaActual, ArrayList<TituloPropiedad> propiedades) {
        this.encarcelado = encarcelado;
        this.nombre = nombre;
        this.saldo = saldo;
        this.cartaLibertad = cartaLibertad;
        this.casillaActual = casillaActual;
        this.propiedades = propiedades;
    }
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.encarcelado = false;
        this.saldo = 0;
        this.cartaLibertad = null;
        this.casillaActual = null;
        this.propiedades = new ArrayList<TituloPropiedad>();
    }

    @Override
    public String toString() {
        return "Jugador{" + "encarcelado=" + encarcelado + ", nombre=" + nombre + ", saldo=" + saldo + ", cartaLibertad=" + cartaLibertad + ", casillaActual=" + casillaActual + ", propiedades=" + propiedades + '}';
    }
    
    public String getNombreFuncion(){
        // Se podria usar reflexion ;)
        StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace();
        return "[" + stackTraceElements[1].toString() + "]";
    }

    
    public Casilla getCasillActual(){
        return this.casillaActual;
    }
    
    public boolean getEncarcelado(){
        return this.encarcelado;
    }
    
    public boolean tengoPropiedades(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean actualizarPosicion(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean comprarTitulo(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected Sorpresa devolverCartaLibertad(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected void irACarcel(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected void modificarSaldo(int cantidad){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected int obtenerCapital(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected void pagarCobrarPorCasaYHotel(int cantidad){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean pagarLibertad(int cantidad){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean puedoEdificarCasa(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean puedoEdificarHotel(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean puedoHipotecar(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean puedoPagarHipoteca(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean puedoVenderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected void setCartaLibertad(Sorpresa carta){
        this.cartaLibertad = carta;
    }

    protected void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }
    
    protected void setEncarcelado(boolean encarcelado){
        this.encarcelado = encarcelado;
    }
    
    protected boolean tengoCartaLibertad(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected void venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    private int cuantasCasasHotelesTengo(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    private void eliminarDeMisPropiedades(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    private boolean esDeMiPropiedad(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    private boolean tengoSaldo(int cantidad){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
 
}
