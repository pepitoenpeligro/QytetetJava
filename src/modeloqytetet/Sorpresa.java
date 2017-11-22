// Métodos implementados (100%):
// - getTexto()
// - getTipo()
// - getValor()
// - toString()
package modeloqytetet;

/**
 *
 * @author pepito
 */
public class Sorpresa {
    
    // Sesion 1. C3
    
    // Datos miembro de la clase Sorpresa
    private String texto;   // Texto de la sorpresa
    private TipoSorpresa tipo;  // {PAGARCOBRAR, IRACASILLA, PORCASAHOTEL, PORJUGADOR, SALIRCARCEL }
    private int valor;
    
    // Constructor de la clase
    public Sorpresa(String txt, TipoSorpresa t, int v){
        this.texto = txt;
        this.tipo = t;
        this.valor = v;
    }

    // Consultores (getters) de la clase
    protected String getTexto() {
        return texto;
    }

    protected TipoSorpresa getTipo() {
        return tipo;
    }

    protected int getValor() {
        return valor;
    }
    
    
    // Sesión 1. C6
    public String toString(){
        return "Sorpresa {" + "texto = " + this.texto + ",\ttipo = " + this.tipo.toString() + ",\tvalor = "+ this.valor  + "}\n";
    }
    
    
}
