package ahorcado.modelo;

// Representa una ficha con palabra, categoria y pista escrita.
public class FichaPalabra {
    private String palabra;
    private String categoria;
    private String pistaEscrita;

    // Crea una ficha lista para usarse en el juego.
    public FichaPalabra(String palabra, String categoria, String pistaEscrita){
        this.palabra = palabra;
        this.categoria = categoria;
        this.pistaEscrita = pistaEscrita;
    }

    // Permiten consultar los datos sin modificar los atributos.
    public String getPalabra(){
        return palabra;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPistaEscrita() {
        return pistaEscrita;
    }
}


