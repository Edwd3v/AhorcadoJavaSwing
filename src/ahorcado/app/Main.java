package ahorcado.app;

import ahorcado.logica.JuegoAhorcado;
import ahorcado.modelo.BancoDePalabras;
import ahorcado.modelo.FichaPalabra;
import ahorcado.ui.VentanaAhorcado;
import javax.swing.SwingUtilities;

// Punto de inicio de la aplicacion.
// Crea los objetos principales y abre la ventana del juego.
public class Main {

    // Prepara el banco, la partida y la interfaz grafica.
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
