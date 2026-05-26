package ahorcado.modelo;

import java.util.ArrayList;

public class BancoPalabras {

    // Lista donde se guardan las palabras disponibles
    ArrayList<Palabra> bancoDePalabras;

    // Constructor: crea el banco y carga palabras iniciales
    public BancoPalabras() {
        bancoDePalabras = new ArrayList<>();

        bancoDePalabras.add(new Palabra("perro", "Animales", "Es una mascota común"));
        bancoDePalabras.add(new Palabra("pizza", "Comidas", "Tiene queso y salsa"));
        bancoDePalabras.add(new Palabra("colombia", "Países", "Está en Sudamérica"));
    }
}
