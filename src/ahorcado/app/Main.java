package ahorcado.app;

import ahorcado.logica.JuegoAhorcado;
import ahorcado.modelo.Palabra;

public class Main {

    public static void main(String[] args) {

        // Palabra fija para probar intentos de forma clara.
        Palabra palabraPrueba = new Palabra("perro", "Animales", "Es una mascota comun");
        JuegoAhorcado juego = new JuegoAhorcado(palabraPrueba);

        // Mostrar el estado inicial de la partida.
        System.out.println("Palabra seleccionada: " + juego.getPalabraSecreta().getTexto());
        System.out.println("Progreso: " + juego.obtenerProgreso());
        System.out.println("Errores: " + juego.getErroresActuales() + "/" + juego.getErroresMaximos());

        // Probar una letra correcta, una incorrecta y una repetida.
        System.out.println("Intento r: " + juego.intentarLetra('r'));
        System.out.println("Progreso: " + juego.obtenerProgreso());

        System.out.println("Intento z: " + juego.intentarLetra('z'));
        System.out.println("Errores: " + juego.getErroresActuales() + "/" + juego.getErroresMaximos());

        System.out.println("Intento r repetido: " + juego.intentarLetra('r'));
        System.out.println("Letras usadas: " + juego.getLetrasUsadas());
        System.out.println("Letras correctas: " + juego.getLetrasCorrectas());
        System.out.println("Letras incorrectas: " + juego.getLetrasIncorrectas());

        // Probar victoria descubriendo todas las letras de perro.
        juego.intentarLetra('p');
        juego.intentarLetra('e');
        juego.intentarLetra('o');
        System.out.println("Progreso final: " + juego.obtenerProgreso());
        System.out.println("Gano: " + juego.haGanado());

        // Probar derrota con siete errores en otra partida.
        JuegoAhorcado juegoDerrota = new JuegoAhorcado(palabraPrueba);
        juegoDerrota.intentarLetra('a');
        juegoDerrota.intentarLetra('b');
        juegoDerrota.intentarLetra('c');
        juegoDerrota.intentarLetra('d');
        juegoDerrota.intentarLetra('f');
        juegoDerrota.intentarLetra('g');
        juegoDerrota.intentarLetra('h');
        System.out.println("Errores derrota: " + juegoDerrota.getErroresActuales() + "/" + juegoDerrota.getErroresMaximos());
        System.out.println("Perdio: " + juegoDerrota.haPerdido());

    }

}
