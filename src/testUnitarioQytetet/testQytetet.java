/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarioQytetet;
import java.util.ArrayList;
import modeloqytetet.*;

/**
 *
 * @author pepito
 */
public class testQytetet {
    public static void main(String[] args){
        final String SEPARADOR = "\n___________________________________________" +
            "____________________________________________________________" +
            "____\n\n\n\n\n";
        
        final String Titulo = "\t\t\t\t" + 
                              "[JAVA] Prueba de unidad de la clase Qytetet" +
                              "\n\n\n\n\n\n";
        
        System.out.println(Titulo);
        
        
        Qytetet qytetet = Qytetet.getInstance();
        
        
        if(qytetet != null){
            ArrayList<String> jugadores;
            jugadores = new ArrayList();
            jugadores.add("Paqui");
            jugadores.add("Juan");
            jugadores.add("Samu");
            jugadores.add("Elisa");
            jugadores.add("Ana:pi");
            
            qytetet.inicializarJuego(jugadores);
            
            System.out.println("test [siguienteJugador]");
            System.out.println(qytetet.siguienteJugador());
            System.out.println(SEPARADOR);
            
            
            
            
            
            
            
            
            
            
            
        }else{
            System.out.println("La instancia qytetet era nula, revisa el patrón Singleton por favor");
        }
        
        
    }
}
