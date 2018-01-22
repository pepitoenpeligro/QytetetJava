/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qytetetjava;
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

    Casilla getCarcel() {
        return carcel;
    }
    
    boolean esCasillaCarcel(int numeroCasilla){
        return this.casillas.get(numeroCasilla).getTipo() == TipoCasilla.CALLE;
    }
    
    Casilla obtenerCasillaNumero(int numeroCasilla){
        return casillas.get(numeroCasilla);
    }
    
    Casilla obtenerNuevaCasilla(Casilla casilla, int desplazamiento){
        int numCasilla = casilla.getNumeroCasilla(); 
        numCasilla = (numCasilla + desplazamiento) % casillas.size()  ;
        return this.casillas.get(numCasilla);
    }

    
    @Override
    public String toString() {
        return "Tablero {" + "casillas=" + casillas + ", carcel=" + carcel + '}';
    }
    
    public void inicializar(){
        this.casillas = new ArrayList();
        
        // Creamos las casillas que son calles
        int i = 0;
        // https://github.com/pepitoenpeligro/QytetetJava/issues/5
        ArrayList<TituloPropiedad> titulosCalles = new ArrayList();
        titulosCalles.add(new TituloPropiedad("Calle Machirulo Opresor", 350, 0.17f, 80, 190));
        titulosCalles.add(new TituloPropiedad("Calle Desengaño", 350, -0.14f, 90, 675));
        titulosCalles.add(new TituloPropiedad("Calle Volcá", 400, 0.13f, 95, 340));
        titulosCalles.add(new TituloPropiedad("Calle La Sal", 250, 0.17f, 65, 645));
        titulosCalles.add(new TituloPropiedad("Calle Endeble", 650, 0.2f, 100, 1000));
        titulosCalles.add(new TituloPropiedad("Calle Grindr", 550, -0.2f, 75, 900));
        titulosCalles.add(new TituloPropiedad("Calle Tus Ojos Bandidos", 350, 0.15f, 75, 625));
        titulosCalles.add(new TituloPropiedad("Calle Cristina La Veneno", 400, 0.1f, 65, 970));
        titulosCalles.add(new TituloPropiedad("Calle Bolleras Siesas", 500, 0.19f, 55, 310));
        titulosCalles.add(new TituloPropiedad("Calle Capillita", 450, -0.14f, 75, 860));
        titulosCalles.add(new TituloPropiedad("Calle Ofertaza", 600, 0.1f, 55, 650));
        titulosCalles.add(new TituloPropiedad("Calle Paloma Urban Fashion", 750, 0.2f, 100, 1000));
        
        this.casillas.add(new OtraCasilla(0, TipoCasilla.SALIDA));
        this.casillas.add(new Calle(1, 400, titulosCalles.get(i++)));
        this.casillas.add(new Calle(2, 360, titulosCalles.get(i++)));
        this.casillas.add(new Calle(3, 380, titulosCalles.get(i++)));
        this.casillas.add(new Calle(4, 300, titulosCalles.get(i++)));
        this.casillas.add(new OtraCasilla(5, TipoCasilla.CARCEL));
        this.carcel = this.casillas.get(5);
        this.casillas.add(new OtraCasilla(6, TipoCasilla.SORPRESA));
        this.casillas.add(new Calle(7, 500, titulosCalles.get(i++)));
        this.casillas.add(new Calle(8, 490, titulosCalles.get(i++)));
        this.casillas.add(new Calle(9, 400, titulosCalles.get(i++)));
        this.casillas.add(new OtraCasilla(10, TipoCasilla.IMPUESTO));
        this.casillas.add(new Calle(11, 550, titulosCalles.get(i++)));
        this.casillas.add(new OtraCasilla(12, TipoCasilla.SORPRESA));
        this.casillas.add(new Calle(13, 600, titulosCalles.get(i++)));
        this.casillas.add(new OtraCasilla(14, TipoCasilla.PARKING));
        this.casillas.add(new OtraCasilla(15, TipoCasilla.JUEZ));
        this.casillas.add(new Calle(16, 550, titulosCalles.get(i++)));
        this.casillas.add(new Calle(17, 700, titulosCalles.get(i++)));
        this.casillas.add(new OtraCasilla(18, TipoCasilla.SORPRESA)); 
        this.casillas.add(new Calle(19, 790, titulosCalles.get(i)));        
    }
}
