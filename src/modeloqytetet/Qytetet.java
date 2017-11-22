package modeloqytetet;

import java.util.ArrayList;
import java.util.Map.Entry;

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
        boolean tienePropietario = false;
        if(this.cartaActual.getTipo() == TipoSorpresa.PAGARCOBRAR){
            this.jugadorActual.modificarSaldo(this.cartaActual.getValor());
        }else if(this.cartaActual.getTipo() == TipoSorpresa.IRACASILLA){
            boolean esCarcel = this.tablero.esCasillaCarcel(this.cartaActual.getValor());
            if(esCarcel){
                this.encarcelarJugador();
            }else{
                Casilla nuevaCasilla = this.tablero.obtenerCasillaNumero(this.cartaActual.getValor());
            }
        }else if(this.cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL){
            this.jugadorActual.pagarCobrarPorCasaYHotel(this.cartaActual.getValor());
        }else if(this.cartaActual.getTipo() == TipoSorpresa.PORJUGADOR){
            for(int i = 0; i < this.jugadores.size(); i++){
                Jugador jugador = this.jugadores.get(i);
                if(jugador != this.jugadorActual){
                    jugador.modificarSaldo(this.cartaActual.getValor());
                    this.jugadorActual.modificarSaldo(-this.cartaActual.getValor());
                }
            }
        }
        
        if(this.cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL){
            this.jugadorActual.setCartaLibertad(cartaActual);
        }else{
            Sorpresa actual = this.cartaActual;
            this.mazo.remove(this.cartaActual);
            this.mazo.add(actual);            
        }
        
        
        return tienePropietario;     
    }
    
    public boolean cancelarHipoteca(Casilla casilla){
        if(casilla.estaHipotecada()){
            casilla.getTitulo().setHipotecada(false);
            return true;
        }
        
        return false;
    }
    
    public boolean comprarTituloPropiedad(){
        return this.jugadorActual.comprarTitulo();
    }
    
//    public boolean edificarCasa(Casilla casilla){
//        boolean puedoEdificar = false;
//        if(casilla.soyEdificable()){
//            boolean sePuedeEdificar = casilla.sePuedeEdificarCasa();
//            if(sePuedeEdificar){
//                puedoEdificar = this.jugadorActual.puedoEdificarCasa(casilla);
//                
//                if(puedoEdificar){
//                    int costeEdificarCasa = casilla.edificarCasa();
//                    this.jugadorActual.modificarSaldo(-costeEdificarCasa);
//                }
//                
//            }
//        }
//        return puedoEdificar;
//    }
    
    public static boolean edificarCasa(Casilla casilla){
    
        if(casilla.sePuedeEdificarCasa()){
       
            casilla.setNumCasas(casilla.getNumCasas() + 1);
            return true;
        }
        return false;
    }
    
    public boolean edificarHotel(Casilla casilla){
        if(casilla.sePuedeEdificarHotel()){
            casilla.setNumHoteles(casilla.getNumHoteles() + 1);
            return true;
        }
        return false;
    }
    
    public Sorpresa getCartaActual(){
        return this.cartaActual;
    }
    
    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }
    
    public boolean hipotecarPropiedad(Casilla casilla){
        boolean puedoHipotecarPropiedad = false;
        if(casilla.soyEdificable()){
            boolean sePuedeHipotecar = !casilla.estaHipotecada();
            boolean puedoHipotecar = this.jugadorActual.puedoHipotecar(casilla);
            if(sePuedeHipotecar && puedoHipotecar){
                int cantidadRecibida = casilla.hipotecar();
                this.jugadorActual.modificarSaldo(cantidadRecibida);
                puedoHipotecarPropiedad = true;
            }
        }
        return puedoHipotecarPropiedad;
    }
    
    public void inicializarJuego(ArrayList<String> nombres){
        this.inicializarJugadores(nombres);
        this.inicializarCartasSorpresa();
        this.inicializarTablero();
        this.salidaJugadores(); // POR implementar
        
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        boolean libre = false;
        if(metodo == MetodoSalirCarcel.TIRANDODADO){
            int valorDado = this.dado.tirar();
            if(valorDado > 5){
                libre = true;
            }
        }else if(metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
            boolean tengoSaldo = this.jugadorActual.pagarLibertad(Qytetet.PRECIO_LIBERTAD);
            if(tengoSaldo)
                libre = true;
        }
        
        if(libre)
            this.jugadorActual.setEncarcelado(false);
        
        return libre;
    }
    
    public boolean jugar(){
        int valorDado = this.dado.tirar();
        Casilla casillaPosicion = this.jugadorActual.getCasillActual();
        Casilla nuevaCasilla = this.tablero.obtenerNuevaCasilla(casillaPosicion, valorDado);
        boolean tienePropietario = this.jugadorActual.actualizarPosicion(nuevaCasilla);
        if(!nuevaCasilla.soyEdificable()){
            if( nuevaCasilla.getTipo() == TipoCasilla.JUEZ){
                this.encarcelarJugador();
            }else if (nuevaCasilla.getTipo() == TipoCasilla.SORPRESA){
                this.cartaActual = mazo.get(0);
            }
        }
        return tienePropietario;  
    }
    
    public ArrayList<Pair<Float,Integer>> obtenerRanking(){
        ArrayList<Pair<Float,Integer>> ranking = new ArrayList<Pair<Float,Integer>>();
        for(Jugador j: this.jugadores){
            Pair<Float,Integer> p = new Pair(j.getNombre(), j.obtenerCapital());
            ranking.add(p);
        }
        
        return ranking;
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
        boolean puedoVender = casilla.soyEdificable() && this.jugadorActual.puedoVenderPropiedad(casilla) && !casilla.estaHipotecada();
        if(puedoVender){
            this.jugadorActual.venderPropiedad(casilla);
            puedoVender = true;
            
        }
        return puedoVender;
    }
    
    private void encarcelarJugador(){
        if(!this.jugadorActual.tengoCartaLibertad()){
            Casilla carcel = this.tablero.getCarcel();
            this.jugadorActual.irACarcel(carcel);
        }else{
            this.jugadorActual.devolverCartaLibertad();
            Sorpresa sorpresa = this.getCartaActual();
            this.mazo.remove(sorpresa);
            this.mazo.add(sorpresa);
        }
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
        int actual = (int) (Math.random() * jugadores.size());
        System.out.println("Jugador actual: " +actual);
        jugadorActual = jugadores.get(actual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
}
