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
    
    public void setSaldo(int cantidad){
        this.saldo = cantidad;
    }
    
    public int getSaldo(){
        return this.saldo;
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
        return this.propiedades.size() != 0;
    }
    
    protected boolean actualizarPosicion(Casilla casilla){
        
        if(casilla.getNumeroCasilla()  < this.casillaActual.getNumeroCasilla()){
            this.modificarSaldo(Qytetet.SALDO_SALIDA);
        }
        
        this.setCasillaActual(casilla);
        
        if(casilla.soyEdificable()){
            boolean tengoPropietario = casilla.tengoPropietario();
            if(tengoPropietario){
                boolean encarcelado = casilla.propietarioEncarcelado();
                if(!encarcelado){
                    int coste = casilla.cobrarAlquiler();
                    this.modificarSaldo(-coste);
                }
                
            }
        }else if(casilla.getTipo() == TipoCasilla.IMPUESTO){
            this.modificarSaldo(-casilla.getCoste());
        }
        return casilla.tengoPropietario();
    }
    
    protected boolean comprarTitulo(){
        
        boolean puedoComprar = false;
        if(casillaActual.soyEdificable()){
            boolean tengoPropietario = this.casillaActual.tengoPropietario();
            if(tengoPropietario){
                int coste = this.casillaActual.getCoste();
                
                if(coste < this.saldo){
                    TituloPropiedad titulo = this.casillaActual.asignarPropiedad(this);
                    this.propiedades.add(titulo);
                    this.modificarSaldo(-coste);
                    puedoComprar = true;
                }
            }
        }
        return puedoComprar;
    }
    
    protected Sorpresa devolverCartaLibertad(){
        Sorpresa carta = this.cartaLibertad;
        this.cartaLibertad = null;
        
        return carta;
    }
    
    protected void irACarcel(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected void modificarSaldo(int cantidad){
        this.saldo += cantidad;
    }
    
    protected int obtenerCapital(){
        int capital = this.saldo;
        for(int  i = 0; i < this.propiedades.size(); i++){
            int precioEdificarHotelyCasa = this.propiedades.get(i).getPrecioEdificar();
            int costeBase = this.propiedades.get(i).getCasilla().getCoste();
            int numCasas = this.propiedades.get(i).getCasilla().getNumCasas();
            int numHoteles = this.propiedades.get(i).getCasilla().getNumHoteles();
            // Se suma
            if(!this.propiedades.get(i).getHipotecada()){
                capital += costeBase * (numCasas + numHoteles);
            }else{
            // Se resta
                capital -= costeBase * (numCasas + numHoteles);
            }
        }
        
        return capital;
    }
    
    protected ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada){
        ArrayList<TituloPropiedad> hipotecadas = new ArrayList<TituloPropiedad>();
        ArrayList<TituloPropiedad> noHipotecadas = new ArrayList<TituloPropiedad>(); 
        for(int i = 0; i < this.propiedades.size(); i++){
            if(this.propiedades.get(i).isHipotecada())
                hipotecadas.add(this.propiedades.get(i));
            else
                noHipotecadas.add(this.propiedades.get(i));
        }
        if(hipotecada) 
            return hipotecadas; 
        else 
            return noHipotecadas;
    }
    
    protected void pagarCobrarPorCasaYHotel(int cantidad){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean pagarLibertad(int cantidad){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean puedoEdificarCasa(Casilla casilla){
        boolean esMia = this.esDeMiPropiedad(casilla);
        if(esMia){
            int costeEdificarCasa = casilla.getPrecioEdificar();
            boolean tengoSaldo = this.tengoSaldo(costeEdificarCasa);
            return esMia && tengoSaldo;
        }
        return false;
    }
    
    protected boolean puedoEdificarHotel(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean puedoHipotecar(Casilla casilla){
        return this.esDeMiPropiedad(casilla);
    }
    
    protected boolean puedoPagarHipoteca(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean puedoVenderPropiedad(Casilla casilla){
        return this.esDeMiPropiedad(casilla) && !casilla.getTitulo().isHipotecada();
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
        return this.cartaLibertad != null;
    }
    
    protected void venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    private int cuantasCasasHotelesTengo(){
        int numCasas = 0;
        int numHoteles = 0;
        for(int i = 0; i < this.propiedades.size(); i++){
            numCasas += this.propiedades.get(i).getCasilla().getNumCasas();
            numHoteles += this.propiedades.get(i).getCasilla().getNumHoteles();
        }
        return numCasas + numHoteles;
    }
    
    private void eliminarDeMisPropiedades(Casilla casilla){
        this.propiedades.remove(casilla.getTitulo());
    }
    
    private boolean esDeMiPropiedad(Casilla casilla){
       for(int i = 0; i < this.propiedades.size(); i++){
           if(casilla.getTitulo() == this.propiedades.get(i))
               return true; 
       }
       return false; 
    }
    
    private boolean tengoSaldo(int cantidad){
        return this.saldo >= cantidad;
    }
 
}
