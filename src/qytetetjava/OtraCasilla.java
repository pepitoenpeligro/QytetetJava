/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qytetetjava;

/**
 *
 * @author pepe
 */
public class OtraCasilla extends Casilla {
    
    public OtraCasilla(int numeroCasilla, TipoCasilla tipo) {
        super(numeroCasilla, tipo);
    }
    

    // Las casillas que no son calle no se pueden edificar
    
    @Override
    public int getNumHoteles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNumCasas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
