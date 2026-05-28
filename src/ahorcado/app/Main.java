package ahorcado.app;

import ahorcado.modelo.BancoPalabras;
import ahorcado.modelo.Palabra;

public class Main {

    public static void main(String[] args) {

        // Prueba simple: pedir una palabra al banco.
        BancoPalabras bancoPalabras = new BancoPalabras();
        Palabra palabraPrueba = bancoPalabras.obtenerPalabraAleatoria();

        // Mostrar los datos usando los getters.
        System.out.println("Palabra: " + palabraPrueba.getTexto());
        System.out.println("Categoría: " + palabraPrueba.getCategoria());
        System.out.println("Pista: " + palabraPrueba.getPista());

    }

}
