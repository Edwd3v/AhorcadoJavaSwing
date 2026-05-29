package ahorcado.modelo;

// Representa una ficha completa del banco.
// Guarda el texto a adivinar, su categoria
// y una pista escrita para ayudar al jugador.
public class FichaPalabra {

    // Texto de la palabra que el jugador debe adivinar.
    private String textoPalabra;

    // Grupo al que pertenece la palabra.
    // Se usa como primera pista durante la partida.
    private String categoria;

    // Pista escrita asociada a la palabra.
    // Se muestra cuando el jugador usa la tercera pista.
    private String pistaEscrita;

    // Crea una ficha lista para entrar al banco.
    // Recibe los tres datos que describen una palabra jugable.
    public FichaPalabra(String textoPalabra, String categoria, String pistaEscrita){
        this.textoPalabra = textoPalabra;
        this.categoria = categoria;
        this.pistaEscrita = pistaEscrita;
    }

    // Devuelve el texto que debe adivinar el jugador.
    public String getPalabra(){
        return textoPalabra;
    }

    // Devuelve la categoria de la ficha.
    public String getCategoria() {
        return categoria;
    }

    // Devuelve la pista escrita de la ficha.
    public String getPistaEscrita() {
        return pistaEscrita;
    }
}


