/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author pepito
 */
public class TituloPropiedad {
    private String nombre;
    private boolean hipotecada;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    
    private Casilla casilla;
    private Jugador propietario;
    
    public TituloPropiedad(String n, int alqBase, float fRevalorizacion, int hipoBase, int precioEdif ){
        this.nombre = n;
        this.hipotecada = false;
        this.alquilerBase = alqBase;
        this.factorRevalorizacion = fRevalorizacion;
        this.hipotecaBase = hipoBase;
        this.precioEdificar = precioEdif;
    }
    
    public TituloPropiedad(String n, int alqBase, float fRevalorizacion, int hipoBase, int precioEdif, Casilla casilla, Jugador jugador){
        this.nombre = n;
        this.hipotecada = false;
        this.alquilerBase = alqBase;
        this.factorRevalorizacion = fRevalorizacion;
        this.hipotecaBase = hipoBase;
        this.precioEdificar = precioEdif;
        this.casilla = casilla;
        this.propietario = jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    protected int getAlquilerBase() {
        return alquilerBase;
    }

    protected float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    protected int getHipotecaBase() {
        return hipotecaBase;
    }

    public int getPrecioEdificar() {
        return precioEdificar;
    }
    
    public void setHipotecada(boolean h){
        this.hipotecada = h;
    }
    
    // Método propio de @pepito
    public void conmutarHipoteca(){
        this.hipotecada = !this.hipotecada;
    }
    
    public String toString(){
        return "Titulo de Propiedad {" + "nombre de la calle = " + this.nombre +
                ",\t¿Está hipotecado? = " + this.hipotecada +
                ",\tPrecio Base a pagar = "+ this.alquilerBase  +
                ",\tRevalorizacion = " + this.factorRevalorizacion +
                ",\tValor Hipoteca Base = " + this.hipotecaBase +
                ",\tPrecio Edificacion = " + this.precioEdificar +
                "}";
    }
    
    public String getNombreFuncion(){
        // Se podria usar reflexion ;)
        StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace();
        return "[" + stackTraceElements[1].toString() + "]";
    }
    
    protected void cobrarAlquiler(int coste){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean getHipotecada(){
        return this.hipotecada;
    }
    
    protected boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected void setCasilla(Casilla casilla){
        this.casilla = casilla;
    }
    
    protected void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }
    
    protected boolean tengoPropietario(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
  
}
