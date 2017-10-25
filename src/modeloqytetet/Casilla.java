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
    private int numeroCasilla;
    private int coste;
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
    
    protected TituloPropiedad asignarPropietario(Jugador jugador){
        throw new UnsupportedOperationException("[asignarPropietario] Sin implementar");
    } 
    
    protected int calcularValorHipoteca(){
        throw new UnsupportedOperationException("[calcularValorHipoteca] Sin implementar");
    }
    
    protected int cancelarHipoteca(){
        throw new UnsupportedOperationException("[cancelarHipoteca] Sin implementar");
    }
    
    protected int cobrarAlquiler(){
        throw new UnsupportedOperationException("[cobrarAlquiler] Sin implementar");
    }
    
    protected int edificarCasa(){
        throw new UnsupportedOperationException("[edificarCasa] Sin implementar");
    }
    
    protected int edificarHotel(){
        throw new UnsupportedOperationException("[edificarHotel] Sin implementar");
    }
    
    protected boolean estaHipotecada(){
        throw new UnsupportedOperationException("[estaHipotecada] Sin implementar");
    }
    
    protected int getCosteHipoteca(){
        throw new UnsupportedOperationException("[getCosteHipoteca] Sin implementar");
    }
    
    protected int getPrecioEdificar(){
        throw new UnsupportedOperationException("[getPrecioEdificar] Sin implementar");
    }
    
    protected int hipotecar(){
        throw new UnsupportedOperationException("[hipotecar] Sin implementar");
    }
    
    protected int precioTotalComprar(){
        throw new UnsupportedOperationException("[precioTotalComprar] Sin implementar");
    }
    
    protected boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("[propietarioEncarcelado] Sin implementar");
    }
    
    protected boolean sePuedeEdificarCasa(){
        throw new UnsupportedOperationException("[sePuedeEdificarCasa] Sin implementar");
    }
    
    protected boolean sePuedeEdificarHotel(){
        throw new UnsupportedOperationException("[sePuedeEdificarHotel] Sin implementar");
    }
    
    protected boolean soyEdificable(){
        throw new UnsupportedOperationException("[soyEdificable] Sin implementar");
    }
    
    protected boolean tengoPropietario(){
        throw new UnsupportedOperationException("[tengoPropietario] Sin implementar");
    }
    
    protected int tengoTitulo(){
        throw new UnsupportedOperationException("[tengoTitulo] Sin implementar");
    }
    
    protected void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    protected void asignarTituloPropiedad(){
        throw new UnsupportedOperationException("[asignarTituloPropiedad] Sin implementar");
    }
    
    
    
    
    
}
