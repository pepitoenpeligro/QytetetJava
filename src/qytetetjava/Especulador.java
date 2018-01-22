/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qytetetjava;

import java.util.ArrayList;

/**
 *
 * @author pepe
 */
public class Especulador extends Jugador{
    static protected int FactorEspeculador = 2;
    private int fianza;

    public Especulador (Jugador j, int f){
        super(j);
        this.fianza = f;
    }
    
    protected void pagarImpuestos(int cantidad){
        this.modificarSaldo(-(cantidad/2));
    }
    
    protected void irACarcel(Casilla casilla){
        boolean pagarFianza = false;
        pagarFianza = this.pagarFianza(fianza);
        if(!pagarFianza){
            setCasillaActual(casilla);
            setEncarcelado(true);
        }else{
            
            this.modificarSaldo(-fianza);
        }
    }
    
    
    protected Especulador convertirme(int f){
        return this;
    }
    
    private boolean pagarFianza(int cantidad){
        if(cantidad <= this.getSaldo()){
            this.modificarSaldo(-cantidad);
            return true;
        }
        return false;
    }
    
    
}
