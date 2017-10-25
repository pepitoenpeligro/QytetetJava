/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.Random;

/**
 *
 * @author pepito
 */
public class Dado {
    private static Dado dado = null;
    
    private Dado(){
        
    }
      
    public Dado getInstance(){
        if(dado == null){
            dado = new Dado();
        }
        return dado;
    }
    
    protected int tirar(){
        Random r = new Random();
        int valorDado = r.nextInt(6)+1;
        return valorDado;
    }
}
