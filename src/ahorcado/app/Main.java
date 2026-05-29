package ahorcado.app;

import ahorcado.logica.JuegoAhorcado;
import ahorcado.modelo.BancoDePalabras;
import ahorcado.modelo.FichaPalabra;
import ahorcado.ui.VentanaAhorcado;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        BancoDePalabras bancoDePalabras = new BancoDePalabras();
        FichaPalabra fichaAleatoria = bancoDePalabras.obtenerFichaAleatoria();
        JuegoAhorcado juego = new JuegoAhorcado(fichaAleatoria);

        SwingUtilities.invokeLater(() -> {
            VentanaAhorcado ventana = new VentanaAhorcado(juego);
            ventana.setVisible(true);
        });
    }
}
