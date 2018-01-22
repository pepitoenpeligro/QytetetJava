/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qytetetjava;
/**
 *
 * @author pepito
 */

// No se puede instanciar un objeto de tipo Casilla
public abstract class Casilla{

    protected int numeroCasilla;
    protected int coste;
    protected TipoCasilla tipo;
    

    // Constructor (numCasillas, coste, tipo)
    public Casilla(int numCasilla, int c, TipoCasilla t){
        this.numeroCasilla = numCasilla;
        this.coste = coste;
        this.tipo = t;
    }
    
    // Constructor para una casailla de tipo impuesto
    public Casilla(int numeroCasilla, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        if (tipo == TipoCasilla.IMPUESTO)
            this.coste = 200;
    }
    
    public abstract int getNumHoteles();
    public abstract int getNumCasas();

    public int getNumeroCasilla() {
        return numeroCasilla;
    }
    
    public int getCoste() {
        return coste;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }
    
    boolean soyEdificable() {
        boolean ret = false;
        
        if (this.tipo == TipoCasilla.CALLE)
            ret = true;
        else
            ret =  false;
        return ret;
    }
    
    public void setNumeroCasilla(int numeroCasilla) {
        this.numeroCasilla = numeroCasilla;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return  "[Casilla]" + "\n Numero Casilla=" + numeroCasilla + 
                "\t Coste=" + coste + 
                "\t Tipo=" + tipo;
    }


}






/*public class Casilla {
    private int numeroCasilla;
    private int coste;
    private int numHoteles = 0;
    private int numCasas = 0;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    // Constructor para casillas de tipo calle
    public Casilla(int numeroCasilla, int coste, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        setTituloPropiedad(titulo);
        this.titulo.setCasilla(this);
        this.tipo = TipoCasilla.CALLE;
    }
    
    // Constructor para casillas que no so de tipo calle
    public Casilla(int numeroCasilla, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getCoste() {
        return coste;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }
    
    

    public void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }

    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    public void setNumeroCasilla(int numeroCasilla) {
        this.numeroCasilla = numeroCasilla;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
    private void setTituloPropiedad(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    TituloPropiedad asignarPropietario(Jugador jugador) {
        titulo.setPropietario(jugador);
        
        return this.titulo;
    }
    
    int calcularValorHipoteca() {
        int hipotecaBase = this.titulo.getHipotecaBase();
        
        int cantidadRecibida;
        cantidadRecibida = hipotecaBase + (int)(numCasas * (float)0.5 * hipotecaBase + numHoteles * hipotecaBase);
        
        return cantidadRecibida;
    }
    
    int cancelarHipoteca() {
        titulo.setHipotecada(false);
        int cantidadPagar = (int) (calcularValorHipoteca() * 1.1);
        
        return cantidadPagar;
    }
    
    int cobrarAlquiler() {
        int costeAlquilerBase = titulo.getAlquilerBase();
        int costeAlquiler = (costeAlquilerBase + (int)(numCasas*0.5 + numHoteles*2) );
        titulo.cobrarAlquiler(costeAlquiler);
        
        return costeAlquiler;
    }
    
    int edificarCasa() {
        int nuevoNum = numCasas+1;
        this.setNumCasas(nuevoNum);
        int costeEdificarCasa = titulo.getPrecioEdificar();
        
        return costeEdificarCasa;
    }
    
    int edificarHotel() {
        int nuevoNum = numHoteles + 1;
        numHoteles = nuevoNum;
        numCasas = 0;
        int costeEdificarHotel = titulo.getPrecioEdificar();
        
        return costeEdificarHotel;
    }
    
    boolean estaHipotecada() {
        return this.titulo.getHipotecada();
    }
    
    int getPrecioEdificar() {
        int costeEdificarCasa = titulo.getPrecioEdificar();
        return costeEdificarCasa;
    }
    
    int hipotecar() {
        this.titulo.setHipotecada(true);
        int cantidadRecibida = calcularValorHipoteca();
        
        return cantidadRecibida;
    }
    
    int precioTotalComprar() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
  
    
    boolean propietarioEncarcelado() {
        boolean encarcelado = titulo.propietarioEncarcelado();
        return encarcelado;
    }
    
    boolean sePuedeEdificarCasa(int factorEspeculador) {
        return numCasas < 4*factorEspeculador;
    }
    
    boolean sePuedeEdificarHotel(int factorEspeculador) {
        return numHoteles < 4*factorEspeculador && numCasas == 4*factorEspeculador;
    }
    
    boolean soyEdificable() {
        boolean ret = false;
        
        if (this.tipo == TipoCasilla.CALLE)
            ret = true;
        else
            ret =  false;
        return ret;
    }
    
    boolean tengoPropietario() {
        boolean tengoPropietario = titulo.tengoPropietario();
        return tengoPropietario;
    }
    
    int precioVenta(){
        int precioVenta, precioCompra;
        precioCompra = this.coste + (this.numCasas + this.numHoteles) * this.titulo.getPrecioEdificar();
        return precioVenta = (int) (precioCompra + titulo.getFactorRevalorizacion() * precioCompra);
    }
    
    int venderTitulo() {
        int precioVenta, precioCompra;
        precioCompra = this.coste + (this.numCasas + this.numHoteles) * this.titulo.getPrecioEdificar();
        precioVenta = (int) (precioCompra + titulo.getFactorRevalorizacion() * precioCompra);
        
        this.titulo.setPropietario(null);
        setNumHoteles(0);
        setNumCasas(0);
        
        return precioVenta;
    }
    
    void asignarTituloPropiedad() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString() {
        if (this.tipo == TipoCasilla.CALLE){
            return "Casilla{" + "numeroCasilla=" + numeroCasilla + ", coste=" + coste + ", numHoteles=" + numHoteles + ", numCasas=" + numCasas + ", tipo=" + tipo + ", titulo=" + titulo.toString() + '}';
        }
        else{
            return "Casilla{" + "numeroCasilla=" + numeroCasilla + ", tipo=" + tipo + '}';
        }
    }
    
    
}

*/
