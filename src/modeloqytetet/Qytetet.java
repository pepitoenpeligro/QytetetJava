package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author pepito
 */
public class Qytetet {
    static private Qytetet juego;
    
    static public final int MAX_JUGADORES = 4;
    static public final int MAX_CARTAS = 10;
    static public final int MAX_CASILLAS = 20;
    
    static protected final int PRECIO_LIBERTAD = 2000;
    static protected final int SALDO_SALIDA = 1000;
    
    private Dado dado;
    private Tablero tablero;
    private Jugador jugadorActual;  // por inicializar
    private ArrayList<Jugador> jugadores; // por inicializar
    private ArrayList<Sorpresa> mazo;
    private Sorpresa cartaActual;
    
    private Qytetet(){
        jugadores = new ArrayList<Jugador>();
        mazo = new ArrayList<Sorpresa>();
        dado = Dado.getInstance();
    }
    
    public static Qytetet getInstance(){
        if(juego == null){
            juego = new Qytetet();
        }
        return juego;
    }

    @Override
    public String toString() {
        return "Qytetet{" + "dado=" + dado + ", tablero=" + tablero + ", jugadorActual=" + jugadorActual + ", jugadores=" + jugadores + ", mazo=" + mazo + ", cartaActual=" + cartaActual + '}';
    }
    
    
    
    public String getNombreFuncion(){
        // Se podria usar reflexion ;)
        StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace();
        return "[" + stackTraceElements[1].toString() + "]";
    }
    
    public boolean aplicarSorpresa(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public boolean cancelarHipoteca(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public boolean edificarCasa(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public boolean edificarHotel(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public Sorpresa getCartaActual(){
        return this.cartaActual;
    }
    
    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }
    
    public boolean hipotecarPropiedades(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public void inicializarJuego(ArrayList<String> nombres){
        this.inicializarJugadores(nombres);
        this.inicializarCartasSorpresa();
        this.inicializarTablero();
        this.salidaJugadores(); // POR implementar
        
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public boolean jugar(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public ArrayList<Jugador> obtenerRanking(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas){
        ArrayList<Casilla> casillasPropiedad = new ArrayList<Casilla>();
        
        // Para cada uno de los titulos de propiedad hipotecados, obtengo su casilla y la devuelvo en un array aux
        for(int i = 0; i < jugadorActual.obtenerPropiedadesHipotecadas(hipotecadas).size(); i++){
            casillasPropiedad.add(jugadorActual.obtenerPropiedadesHipotecadas(hipotecadas).get(i).getCasilla());
        }
        
        return casillasPropiedad;
    }
    
    public Jugador siguienteJugador(){
        // Obtengo el indice del jugador actual en la coleccion
        // Retorno el siguiente al jugadorActual
        int posicion = 0;
        boolean encontrado = false;
        for(int i = 0; i < jugadores.size() && !encontrado; i++){
            if(jugadorActual == jugadores.get(i)){
                posicion = i; 
                encontrado = true;
            }
        }
        return jugadores.get( (posicion+1) % Qytetet.MAX_JUGADORES);
        
    }
    
    public boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    private void encarcelarJugador(){
        throw new UnsupportedOperationException(getNombreFuncion() + "Sin implementar");
    }
    
    private void inicializarCartasSorpresa(){
        this.mazo.add(new Sorpresa("Tu casero te ha robado todo el dinero (y más) de tu fianza. Sales de la carcel por muerto de hambre.", TipoSorpresa.SALIRCARCEL, 4)); // Carcel
        
        this.mazo.add(new Sorpresa("Te ponen La Reina del Grindr en La Sal. Ganas 1000€", TipoSorpresa.PAGARCOBRAR, 2));
        this.mazo.add(new Sorpresa("Samu te roba hummus. Pierdes 500€", TipoSorpresa.PAGARCOBRAR, 3));
        
        this.mazo.add(new Sorpresa("Pompino te toca el culo. Sales corriendo hasta la casilla 16", TipoSorpresa.IRACASILLA, 1));
        this.mazo.add(new Sorpresa("El Six Colours está lleno de capillitas. Te vas indignada hasta la casilla 11", TipoSorpresa.IRACASILLA, 5));
        this.mazo.add(new Sorpresa("Paloma Cuesta te tira una falda y punto en boca. Te mueves hasta la casilla 9", TipoSorpresa.IRACASILLA, 6));
        
        
        this.mazo.add(new Sorpresa("La Chunga y La Hierbas tiran un muro de carga. Pagas 100€ por cada Casa y 150 por cada Hotel", TipoSorpresa.PORCASAHOTEL, 7));
        this.mazo.add(new Sorpresa("Te has peleado con la Hierbas y te vas al Hostal Loli. Pagas 200€ por cada Casa/Hotel", TipoSorpresa.PORCASAHOTEL, 8));
        
        this.mazo.add(new Sorpresa("Vas a la sal con los alcoholicos. Los invitas a cervezas y gastas 60€", TipoSorpresa.PORJUGADOR, 9));
        this.mazo.add(new Sorpresa("Tus amigos te roban el movil y no puedes pagar con el contactless. Te dan 100€", TipoSorpresa.PORJUGADOR, 10));
        
        this.mazo.add(new Sorpresa("Te has liado con un capillita machirulo opresor.Vas a la cárcel", TipoSorpresa.SALIRCARCEL, 0)); // Carcel
    }
    
    private void inicializarJugadores(ArrayList<String> nombres){
        
        for(int i = 0; i < nombres.size(); i++){
            this.jugadores.add( new Jugador(nombres.get(i)) );
        }
    }
    
    private void inicializarTablero(){
        this.tablero = new Tablero();
    }
    
    private void salidaJugadores(){
        for(int i = 0; i < this.jugadores.size(); i++){
            // Establecemos a cada jugador en la casilla 0 -> Casilla de salida
            jugadores.get(i).setCasillaActual(tablero.obtenerCasillaNumero(0));
            
            // Establecemos a cada jugador el saldo a 7500
            jugadores.get(i).setSaldo(7500);            
            
        }
        
        // Establecemos el jugadorActual
        int actual = (int) (Math.random() * (Qytetet.MAX_JUGADORES - 1));
        jugadorActual = jugadores.get(actual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
}
