package ahorcado.modelo;

// Representa una palabra con su categoria y su pista.
public class Palabra {
    private String texto;
    private String categoria;
    private String pista;

    // Crea una palabra con los datos necesarios para el juego.
    public Palabra(String texto, String categoria, String pista){
        this.texto = texto;
        this.categoria = categoria;
        this.pista = pista;
    }

    // Permiten consultar los datos sin modificar los atributos.
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


