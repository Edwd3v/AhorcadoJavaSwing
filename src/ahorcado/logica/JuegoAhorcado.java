package ahorcado.logica;

import ahorcado.modelo.Palabra;
import java.util.ArrayList;
import java.util.Random;

// Controla el estado basico de una partida sin depender de Swing.
public class JuegoAhorcado {

    private Palabra palabraSecreta;
    private int erroresActuales;
    private int erroresMaximos;
    private ArrayList<Character> letrasUsadas;
    private ArrayList<Character> letrasCorrectas;
    private ArrayList<Character> letrasIncorrectas;
    private Random random;

    // Inicia una partida con una palabra y cero errores.
    public JuegoAhorcado(Palabra palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.erroresActuales = 0;
        this.erroresMaximos = 7;
        this.letrasUsadas = new ArrayList<>();
        this.letrasCorrectas = new ArrayList<>();
        this.letrasIncorrectas = new ArrayList<>();
        this.random = new Random();
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

    // Verifica si todas las letras de la palabra fueron descubiertas.
    public boolean haGanado() {
        String texto = palabraSecreta.getTexto();

        for (int posicion = 0; posicion < texto.length(); posicion++) {
            char letraActual = texto.charAt(posicion);

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
        return palabraSecreta.getCategoria();
    }

    // Revela una letra aun oculta sin contar como error.
    public char usarPistaLetra() {
        ArrayList<Character> letrasOcultas = new ArrayList<>();
        String texto = palabraSecreta.getTexto();

        for (int posicion = 0; posicion < texto.length(); posicion++) {
            char letraActual = texto.charAt(posicion);

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
    public String usarPistaDescripcion() {
        return palabraSecreta.getPista();
    }
}
