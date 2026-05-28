package ahorcado.logica;

import ahorcado.modelo.Palabra;
import java.util.ArrayList;

// Controla el estado basico de una partida sin depender de Swing.
public class JuegoAhorcado {

    private Palabra palabraSecreta;
    private int erroresActuales;
    private int erroresMaximos;
    private ArrayList<Character> letrasUsadas;
    private ArrayList<Character> letrasCorrectas;
    private ArrayList<Character> letrasIncorrectas;

    // Inicia una partida con una palabra y cero errores.
    public JuegoAhorcado(Palabra palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.erroresActuales = 0;
        this.erroresMaximos = 7;
        this.letrasUsadas = new ArrayList<>();
        this.letrasCorrectas = new ArrayList<>();
        this.letrasIncorrectas = new ArrayList<>();
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

    public ArrayList<Character> getLetrasUsadas() {
        return letrasUsadas;
    }

    public ArrayList<Character> getLetrasCorrectas() {
        return letrasCorrectas;
    }

    public ArrayList<Character> getLetrasIncorrectas() {
        return letrasIncorrectas;
    }

    // Muestra la palabra oculta con un guion por cada letra.
    public String obtenerProgreso() {
        StringBuilder progreso = new StringBuilder();
        String texto = palabraSecreta.getTexto();

        for (int posicion = 0; posicion < texto.length(); posicion++) {
            if (posicion > 0) {
                progreso.append(" ");
            }

            char letraActual = texto.charAt(posicion);

            if (letrasCorrectas.contains(letraActual)) {
                progreso.append(letraActual);
            } else {
                progreso.append("_");
            }
        }

        return progreso.toString();
    }

    // Procesa una letra y devuelve el resultado del intento.
    public String intentarLetra(char letra) {
        char letraNormalizada = Character.toLowerCase(letra);

        if (letrasUsadas.contains(letraNormalizada)) {
            return "repetida";
        }

        letrasUsadas.add(letraNormalizada);

        if (palabraSecreta.getTexto().indexOf(letraNormalizada) >= 0) {
            letrasCorrectas.add(letraNormalizada);
            return "correcta";
        }

        letrasIncorrectas.add(letraNormalizada);
        erroresActuales++;
        return "incorrecta";
    }
}
