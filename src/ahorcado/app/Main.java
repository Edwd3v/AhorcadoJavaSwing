package ahorcado.app;

import ahorcado.logica.JuegoAhorcado;
import ahorcado.modelo.BancoPalabras;
import ahorcado.modelo.Palabra;

public class Main {

    public static void main(String[] args) {

        // Prueba simple: pedir una palabra al banco.
        BancoPalabras bancoPalabras = new BancoPalabras();
        Palabra palabraPrueba = bancoPalabras.obtenerPalabraAleatoria();

        // Crear una partida basica con la palabra seleccionada.
        JuegoAhorcado juego = new JuegoAhorcado(palabraPrueba);

        // Mostrar el estado inicial de la partida.
        System.out.println("Palabra seleccionada: " + juego.getPalabraSecreta().getTexto());
        System.out.println("Errores: " + juego.getErroresActuales() + "/" + juego.getErroresMaximos());

    }

}
