package ahorcado.app;

import ahorcado.logica.JuegoAhorcado;
import ahorcado.modelo.BancoPalabras;
import ahorcado.modelo.Palabra;
import ahorcado.ui.VentanaAhorcado;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        BancoPalabras bancoPalabras = new BancoPalabras();
        Palabra palabraAleatoria = bancoPalabras.obtenerPalabraAleatoria();
        JuegoAhorcado juego = new JuegoAhorcado(palabraAleatoria);

        SwingUtilities.invokeLater(() -> {
            VentanaAhorcado ventana = new VentanaAhorcado(juego);
            ventana.setVisible(true);
        });
    }
}
