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
public class Dado {
    private static Dado dado = null;
    
    private Dado(){
        
    }
    
    public static Dado getInstance(){
        if(dado == null){
            dado = new Dado();
        }
        return dado;
    }
    
    protected int tirar(){
        return (int) (Math.random() * 6) + 1;
    } 
    
    
}
