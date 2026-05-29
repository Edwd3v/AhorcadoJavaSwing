package ahorcado.logica;

import ahorcado.modelo.FichaPalabra;
import java.util.ArrayList;
import java.util.Random;

// Controla el estado basico de una partida sin depender de Swing.
public class JuegoAhorcado {

    private static final int ERRORES_MAXIMOS = 7;

    private final FichaPalabra fichaSecreta;
    private int erroresActuales;
    private final int erroresMaximos;
    private final ArrayList<Character> letrasUsadas;
    private final ArrayList<Character> letrasCorrectas;
    private final ArrayList<Character> letrasIncorrectas;
    private final Random random;

    // Inicia una partida con una ficha y cero errores.
    public JuegoAhorcado(FichaPalabra fichaSecreta) {
        this.fichaSecreta = fichaSecreta;
        this.erroresActuales = 0;
        this.erroresMaximos = ERRORES_MAXIMOS;
        this.letrasUsadas = new ArrayList<>();
        this.letrasCorrectas = new ArrayList<>();
        this.letrasIncorrectas = new ArrayList<>();
        this.random = new Random();
    }

    public FichaPalabra getFichaSecreta() {
        return fichaSecreta;
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
    public String obtenerProgresoPalabra() {
        StringBuilder progreso = new StringBuilder();
        String palabra = fichaSecreta.getPalabra();

        for (int posicion = 0; posicion < palabra.length(); posicion++) {
            if (posicion > 0) {
                progreso.append(" ");
            }

            char letraActual = palabra.charAt(posicion);

            if (letrasCorrectas.contains(letraActual)) {
                progreso.append(letraActual);
            } else {
                progreso.append("_");
            }
        }

        return progreso.toString();
    }

    // Procesa una letra y devuelve el resultado del intento.
    public String procesarLetra(char letra) {
        char letraNormalizada = Character.toLowerCase(letra);

        if (letrasUsadas.contains(letraNormalizada)) {
            return "repetida";
        }

        letrasUsadas.add(letraNormalizada);

        if (fichaSecreta.getPalabra().indexOf(letraNormalizada) >= 0) {
            letrasCorrectas.add(letraNormalizada);
            return "correcta";
        }

        letrasIncorrectas.add(letraNormalizada);
        erroresActuales++;
        return "incorrecta";
    }

    // Verifica si todas las letras de la palabra fueron descubiertas.
    public boolean haGanado() {
        String palabra = fichaSecreta.getPalabra();

        for (int posicion = 0; posicion < palabra.length(); posicion++) {
            char letraActual = palabra.charAt(posicion);

            if (!letrasCorrectas.contains(letraActual)) {
                return false;
            }
        }

        return true;
    }

    // Verifica si se alcanzo el limite de errores permitidos.
    public boolean haPerdido() {
        return erroresActuales >= erroresMaximos;
    }

    // Devuelve la categoria de la palabra como primera pista.
    public String usarPistaCategoria() {
        return fichaSecreta.getCategoria();
    }

    // Revela una letra aun oculta sin contar como error.
    public char revelarLetraComoPista() {
        ArrayList<Character> letrasOcultas = new ArrayList<>();
        String palabra = fichaSecreta.getPalabra();

        for (int posicion = 0; posicion < palabra.length(); posicion++) {
            char letraActual = palabra.charAt(posicion);

            if (!letrasCorrectas.contains(letraActual) && !letrasOcultas.contains(letraActual)) {
                letrasOcultas.add(letraActual);
            }
        }

        if (letrasOcultas.isEmpty()) {
            return '\0';
        }

        int indiceAleatorio = random.nextInt(letrasOcultas.size());
        char letraRevelada = letrasOcultas.get(indiceAleatorio);

        letrasCorrectas.add(letraRevelada);

        if (!letrasUsadas.contains(letraRevelada)) {
            letrasUsadas.add(letraRevelada);
        }

        return letraRevelada;
    }

    // Devuelve la pista escrita asociada a la palabra.
    public String usarPistaEscrita() {
        return fichaSecreta.getPistaEscrita();
    }
}
