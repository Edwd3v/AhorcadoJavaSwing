package ahorcado.logica;

import ahorcado.modelo.Palabra;

// Controla el estado basico de una partida sin depender de Swing.
public class JuegoAhorcado {

    private Palabra palabraSecreta;
    private int erroresActuales;
    private int erroresMaximos;

    // Inicia una partida con una palabra y cero errores.
    public JuegoAhorcado(Palabra palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.erroresActuales = 0;
        this.erroresMaximos = 7;
    }

    public Palabra getPalabraSecreta() {
        return palabraSecreta;
    }

    public int getErroresActuales() {
        return erroresActuales;
    }

    public int getErroresMaximos() {
        return erroresMaximos;
    }
}
