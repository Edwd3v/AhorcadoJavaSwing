package ahorcado.modelo;

import java.util.ArrayList;
import java.util.Random;

public class BancoPalabras {

    // Guarda las palabras disponibles para jugar.
    private ArrayList<Palabra> bancoDePalabras;

    // Permite elegir una palabra al azar del banco.
    private Random random;

    // Crea el banco y carga las primeras palabras de prueba.
    public BancoPalabras() {
        bancoDePalabras = new ArrayList<>();
        random = new Random();

        bancoDePalabras.add(new Palabra("perro", "Animales", "Es una mascota común"));
        bancoDePalabras.add(new Palabra("pizza", "Comidas", "Tiene queso y salsa"));
        bancoDePalabras.add(new Palabra("colombia", "Países", "Está en Sudamérica"));
    }

    // Devuelve una palabra aleatoria para iniciar una partida.
    public Palabra obtenerPalabraAleatoria() {
        int posicion = random.nextInt(bancoDePalabras.size());
        return bancoDePalabras.get(posicion);
    }
}
