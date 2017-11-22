// Métodos implementados (100%):
// - getCarcel()
// - toString()
// - inicializar()
// - esCasillaCarcel(int numeroCasilla)
// - obtenerCasillaNumero(int numeroCasilla)
// - obtenerNuevaCasilla(Casilla casilla, int desplazamiento)
package modeloqytetet;

import java.util.ArrayList;


/**
 *
 * @author pepito
 */
public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    
    
    public Tablero(){
        inicializar();
    }

    public Casilla getCarcel() {
        return carcel;
    }
    
    public String toString(){
        return "Casillas = " + casillas.toString() + "\t Cárcel = " + carcel.toString() + "\n";
    }
    
    private void inicializar(){
        casillas = new ArrayList<Casilla>();
        casillas.add(new Casilla(0,1000, TipoCasilla.SALIDA)); // Casilla de salida
        casillas.add(new Casilla(1,0, TipoCasilla.PARKING)); // Parking
        casillas.add(new Casilla(2,0, TipoCasilla.IMPUESTO)); // Impuesto
        casillas.add(new Casilla(3,0, TipoCasilla.JUEZ)); // Juez
        casillas.add(new Casilla(4,0, TipoCasilla.CARCEL)); // Cárcel
        
        casillas.add(new Casilla(5,0, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(6,0, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(7,0, TipoCasilla.SORPRESA));
        
        casillas.add(new Casilla(8,0, new TituloPropiedad("Calle Machirulo Opresor", 50,(float)0.2, 200, 250)));
        casillas.add(new Casilla(9,0, new TituloPropiedad("Calle Desengaño", 50,(float)0.2, 150, 300)));
        casillas.add(new Casilla(10,0, new TituloPropiedad("Calle Volcá", 80,(float)-0.2, 120, 350)));
        casillas.add(new Casilla(11,0, new TituloPropiedad("Calle La Sal", 100,(float)0.2, 900, 700)));
        casillas.add(new Casilla(12,0, new TituloPropiedad("Calle Endeble", 50,(float)-0.12, 300, 660)));
        casillas.add(new Casilla(13,0, new TituloPropiedad("Calle Grindr", 90,(float)0.15, 400, 600)));
        casillas.add(new Casilla(14,0, new TituloPropiedad("Calle Tus Ojos Bandidos", 60, (float) 0.13, 500, 300)));
        casillas.add(new Casilla(15,0, new TituloPropiedad("Calle Cristina La Veneno", 80,(float)0.2, 1000, 750)));
        casillas.add(new Casilla(16,0, new TituloPropiedad("Calle Bollera Siesa", 50,(float)-0.14, 600, 400)));
        casillas.add(new Casilla(17,0, new TituloPropiedad("Calle Capillita", 100,(float)-0.2, 700, 700)));
        casillas.add(new Casilla(18,0, new TituloPropiedad("Calle Ofertaza", 100,(float)1.7, 800, 750)));
        casillas.add(new Casilla(19,0, new TituloPropiedad("Calle El Futuro es de las Lesbianas", 70,(float)1.5, 500, 500)));
        
        carcel = casillas.get(4);
    }
    
    public String getNombreFuncion(){
        // Se podria usar reflexion ;)
        StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace();
        return "[" + stackTraceElements[1].toString() + "]";
    }
    
    //protected 
    public boolean esCasillaCarcel(int numeroCasilla){
        return numeroCasilla == 4;
    }
    
    //protected 
    public Casilla obtenerCasillaNumero(int numeroCasilla){
        return casillas.get(numeroCasilla);
    }
    
    //protected 
    public Casilla obtenerNuevaCasilla(Casilla casilla, int desplazamiento){
        boolean encontrado = false;
        int posicion = 0;
        for(int i = 0; i < casillas.size() && !encontrado; i++){
            if(casilla.getNumeroCasilla() == casillas.get(i).getNumeroCasilla()){
                posicion = i;
                encontrado = true;
            }
            
        }
        
        return casillas.get( ( posicion + desplazamiento) % Qytetet.MAX_CASILLAS);
        
    }
    
    
}
