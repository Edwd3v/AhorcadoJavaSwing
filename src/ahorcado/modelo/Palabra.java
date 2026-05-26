package ahorcado.modelo;

// Atributos: datos que guarda cada palabra del juego
public class Palabra {
    String texto;
    String categoria;
    String pista;

    // Constructor: crea una palabra con texto, categoría y pista
    public Palabra(String texto, String categoria, String pista){
        this.texto = texto;
        this.categoria = categoria;
        this.pista = pista;
    }

    // Getters: métodos para consultar los datos de una Palabra
    public String getTexto(){
        return texto;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPista() {
        return pista;
    }
}


