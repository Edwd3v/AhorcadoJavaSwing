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

        cargarPalabrasIniciales();
    }

    // Devuelve una palabra aleatoria para iniciar una partida.
    public Palabra obtenerPalabraAleatoria() {
        int posicion = random.nextInt(bancoDePalabras.size());
        return bancoDePalabras.get(posicion);
    }

    // Carga un conjunto inicial de palabras con varias categorias.
    private void cargarPalabrasIniciales() {
        bancoDePalabras.add(new Palabra("perro", "Animales", "Es una mascota comun"));
        bancoDePalabras.add(new Palabra("gato", "Animales", "Le gusta maullar"));

        bancoDePalabras.add(new Palabra("pizza", "Comidas", "Tiene queso y salsa"));
        bancoDePalabras.add(new Palabra("sopa", "Comidas", "Se sirve caliente"));

        bancoDePalabras.add(new Palabra("colombia", "Paises", "Esta en sudamerica"));
        bancoDePalabras.add(new Palabra("mexico", "Paises", "Es famoso por sus tacos"));

        bancoDePalabras.add(new Palabra("futbol", "Deportes", "Se juega con un balon"));
        bancoDePalabras.add(new Palabra("tenis", "Deportes", "Se juega con raqueta"));

        bancoDePalabras.add(new Palabra("guitarra", "Instrumentos", "Tiene cuerdas"));
        bancoDePalabras.add(new Palabra("piano", "Instrumentos", "Tiene teclas"));
    }
}
