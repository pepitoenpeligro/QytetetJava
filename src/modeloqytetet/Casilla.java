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
public class Casilla {
    private int coste;
    private int numeroCasilla;
    private int numHoteles;
    private int numCasas;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    
    // Casillas que no son calle, es decir, casillas SALIDA, SORPRESA, CARCEL, JUEZ, IMPUESTO, PARKING
    public Casilla(int nCasilla, int coste, TipoCasilla t){
        this.numeroCasilla = nCasilla;
        this.coste = coste;
        this.numHoteles = 0;
        this.numCasas = 0;
        this.tipo = t;
        this.titulo = null;
    }
    
    
    // Casillas de Tipo Calle y tienen titulo de propiedad
    public Casilla(int nCasilla, int coste, TituloPropiedad tp){
        this.numeroCasilla = nCasilla;
        this.coste = coste;
        this.numHoteles = 0;
        this.numCasas = 0;
        this.tipo = TipoCasilla.CALLE;
        this.titulo = tp;
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
    
    public void setNumCasas(int n){
        this.numCasas = n;
    }
    
    public void setNumHoteles(int n){
        this.numHoteles = n;
    }
    
    // Metodo opcional de @pepito
    public void incrementarNumCasas(){
        this.numCasas++;
    }
    
    // Metodo opcional de @pepito
    public void incrementarNumHoteles(){
        this.numHoteles++;
    }
    
    public String toString(){
        // Tiene titulo, luego es una calle
        String comun = "Numero casilla = " + this.numeroCasilla + "\t" +
                    "Coste = " + this.coste + "\t" + 
                    "Numero Hoteles = " + this.numHoteles + "\t" +
                    "Numero Casas = " + this.numCasas + "\t" +
                    "Tipo = " + this.tipo.toString() + "\n\n";
        if(this.titulo != null){
            return comun +
                   "Titulo = " + this.titulo.toString() + "\n";
        }else{
            return comun;
        }
        
    }
    
    public String getNombreFuncion(){
        // Se podria usar reflexion ;)
        StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace();
        return "[" + stackTraceElements[1].toString() + "]";
    }
    
    protected TituloPropiedad asignarCasilla(Jugador jugador) {
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected int calcularValorHipoteca(){
        return this.titulo.getHipotecaBase()
        + (int) ((this.numCasas * 0.5 * this.titulo.getHipotecaBase())
        + (this.numHoteles * this.titulo.getHipotecaBase()));
    }
    
    protected int cancelarHipoteca(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected int cobrarAlquiler(){
        int costeAlquilerBase = this.titulo.getAlquilerBase();
        int costeAlquiler = costeAlquilerBase + (int) (this.numCasas * 0.5 + this.numHoteles * 2);
        this.titulo.cobrarAlquiler(costeAlquiler);
        return costeAlquiler;
    }
    
    protected int edificarCasa(){
        this.setNumCasas(this.numCasas + 1);
        int costeEdificarCasa = this.titulo.getPrecioEdificar();
        return costeEdificarCasa;
    }
    
    // NO ESTA ESPECIFICADO EN LA ASIGNATURA
    protected int edificarHotel(){
       this.setNumHoteles(numHoteles + 1);
       return titulo.getPrecioEdificar();
    }
    
    protected boolean estaHipotecada(){
        return this.titulo.getHipotecada();
    }
    
    protected int getCosteHipoteca(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected int getPrecioEdificar(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected int hipotecar(){
        this.titulo.setHipotecada(true);
        int hipotecaBase = this.titulo.getHipotecaBase();
        int cantidadRecibida = this.calcularValorHipoteca();
        return cantidadRecibida;
    }
    
    protected int precioTotalCompra(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean sePuedeEdificarCasa(){
        return this.numCasas < 4;
    }
    
    protected boolean sePuedeEdificarHotel(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected boolean soyEdificable(){
        return this.tipo == TipoCasilla.CALLE;
    }
    
    protected boolean tengoPropietario(){
        return this.titulo.tengoPropietario();
    }
    
    protected int venderTitulo(){
        
        int precioCompra = this.coste + (this.numCasas + this.numHoteles) * this.titulo.getPrecioEdificar();
        int precioVenta = precioCompra +  (int) this.titulo.getFactorRevalorizacion() * precioCompra;
        
        this.titulo.setPropietario(null);
        this.setNumCasas(0);
        this.setNumHoteles(0);
        
        return precioVenta;
    }
    
    protected void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    protected void asignarTituloPropiedad(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    protected TituloPropiedad asignarPropiedad(Jugador jugador){
        this.titulo.setPropietario(jugador);
        return this.titulo;
    }
    
   
    
    
    
}
