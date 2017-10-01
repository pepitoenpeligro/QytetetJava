/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarioQytetet;
import java.util.ArrayList;
import modeloqytetet.Sorpresa;
import modeloqytetet.TipoSorpresa;
import modeloqytetet.TipoCasilla;
import modeloqytetet.TituloPropiedad;
/**
 *
 * @author pepito
 */
public class testTituloPropiedad {
    public static void main(String[] args){
       ArrayList<TituloPropiedad> titulos = new ArrayList<TituloPropiedad>();
               
       titulos.add(new TituloPropiedad("Calle Machirulo Opresor", 50,(float)0.2, 200, 250)); 
       titulos.add(new TituloPropiedad("Calle Desengaño", 50,(float)0.2, 150, 300)); 
       titulos.add(new TituloPropiedad("Calle Volcá", 80,(float)-0.2, 120, 350));
       titulos.add(new TituloPropiedad("Calle La Sal", 100,(float)0.2, 900, 700));
       titulos.add(new TituloPropiedad("Calle Endeble", 50,(float)-0.12, 300, 660));
       titulos.add(new TituloPropiedad("Calle Grindr", 90,(float)0.15, 400, 600));
       titulos.add(new TituloPropiedad("Calle Tus Ojos Bandidos", 60, (float) 0.13, 500, 300));
       titulos.add(new TituloPropiedad("Calle Cristina La Veneno", 80,(float)0.2, 1000, 750));
       titulos.add(new TituloPropiedad("Calle Bollera Siesa", 50,(float)-0.14, 600, 400));
       titulos.add(new TituloPropiedad("Calle Capillita", 100,(float)-0.2, 700, 700));
       titulos.add(new TituloPropiedad("Calle Ofertaza", 100,(float)1.7, 800, 750));
       titulos.add(new TituloPropiedad("Calle El Futuro es de las Lesbianas", 70,(float)1.5, 500, 500));
       
       System.out.println(titulos.toString());
       System.out.println(titulos.size());
    }
}
