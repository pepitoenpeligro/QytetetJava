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
    private Jugador propietario;
    private Casilla casilla;
    
    
    public TituloPropiedad(String n, int alqBase, float fRevalorizacion, int hipoBase, int precioEdif, Jugador propie, Casilla casilla){
        this.nombre = n;
        this.hipotecada = false;
        this.alquilerBase = alqBase;
        this.factorRevalorizacion = fRevalorizacion;
        this.hipotecaBase = hipoBase;
        this.precioEdificar = precioEdif;
        this.propietario = propie;
        this.casilla = casilla;
    }
    
    
    public TituloPropiedad(String n, int alqBase, float fRevalorizacion, int hipoBase, int precioEdif ){
        this.nombre = n;
        this.hipotecada = false;
        this.alquilerBase = alqBase;
        this.factorRevalorizacion = fRevalorizacion;
        this.hipotecaBase = hipoBase;
        this.precioEdificar = precioEdif;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    public int getHipotecaBase() {
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
    
    @Override
    public String toString(){
        return "Titulo de Propiedad {" + "nombre de la calle = " + this.nombre +
                ",\t¿Está hipotecado? = " + this.hipotecada +
                ",\tPrecio Base a pagar = "+ this.alquilerBase  +
                ",\tRevalorizacion = " + this.factorRevalorizacion +
                ",\tValor Hipoteca Base = " + this.hipotecaBase +
                ",\tPrecio Edificacion = " + this.precioEdificar +
                "}";
    }
    
    
    protected void cobrarAlquiler(int coste){
        throw new UnsupportedOperationException("[cobrarAlquiler] Sin implementar");
    }
    
    public int getAlquilerBase() {
        return alquilerBase;
    }
    
    protected boolean propietaroEncarcelado(){
        throw new UnsupportedOperationException("[propietaroEncarcelado] Sin implementar");
    }
    
    protected void setCasilla(Casilla casilla){
        this.casilla = casilla;
    }
    
    protected void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }
    
    protected boolean tengoPropietario(){
        throw new UnsupportedOperationException("[tengoPropietario] Sin implementar");
    }
    

     
    
}
