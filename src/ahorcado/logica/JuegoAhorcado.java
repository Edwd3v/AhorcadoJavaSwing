package ahorcado.logica;

import ahorcado.modelo.FichaPalabra;
import java.util.ArrayList;
import java.util.Random;

// Controla el estado y las reglas de una partida.
// No depende de Swing, por eso puede probarse
// sin abrir la interfaz grafica.
public class JuegoAhorcado {

    // Limite fijo de errores permitido por partida.
    private static final int ERRORES_MAXIMOS = 7;

    // Ficha elegida para la partida actual.
    // Contiene la palabra, categoria y pista escrita.
    private final FichaPalabra fichaSecreta;

    // Cantidad de letras incorrectas intentadas.
    private int erroresActuales;

    // Limite de errores usado por esta partida.
    private final int erroresMaximos;

    // Letras que el jugador ya intento.
    private final ArrayList<Character> letrasUsadas;

    // Letras encontradas dentro de la palabra.
    private final ArrayList<Character> letrasCorrectas;

    // Letras que no aparecen en la palabra.
    private final ArrayList<Character> letrasIncorrectas;

    // Generador usado para revelar una letra oculta al azar.
    private final Random generadorAleatorio;

    // Inicia una partida con una ficha y cero errores.
    public JuegoAhorcado(FichaPalabra fichaSecreta) {
        this.fichaSecreta = fichaSecreta;
        this.erroresActuales = 0;
        this.erroresMaximos = ERRORES_MAXIMOS;
        this.letrasUsadas = new ArrayList<>();
        this.letrasCorrectas = new ArrayList<>();
        this.letrasIncorrectas = new ArrayList<>();
        this.generadorAleatorio = new Random();
    }

    // Devuelve la ficha usada como palabra secreta.
    public FichaPalabra getFichaSecreta() {
        return fichaSecreta;
    }

    // Devuelve la cantidad actual de errores.
    public int getErroresActuales() {
        return erroresActuales;
    }

    // Devuelve el maximo de errores permitido.
    public int getErroresMaximos() {
        return erroresMaximos;
    }

    // Devuelve las letras que ya fueron intentadas.
    public ArrayList<Character> getLetrasUsadas() {
        return letrasUsadas;
    }

    // Devuelve las letras acertadas hasta el momento.
    public ArrayList<Character> getLetrasCorrectas() {
        return letrasCorrectas;
    }

    // Devuelve las letras falladas hasta el momento.
    public ArrayList<Character> getLetrasIncorrectas() {
        return letrasIncorrectas;
    }

    // Muestra el avance de la palabra.
    // Usa guiones bajos para letras no descubiertas
    // y letras reales para aciertos.
    public String obtenerProgresoPalabra() {
        StringBuilder progreso = new StringBuilder();
        String textoPalabra = fichaSecreta.getPalabra();

        for (int posicion = 0; posicion < textoPalabra.length(); posicion++) {
            if (posicion > 0) {
                progreso.append(" ");
            }

            char letraActual = textoPalabra.charAt(posicion);

            if (letrasCorrectas.contains(letraActual)) {
                progreso.append(letraActual);
            } else {
                progreso.append("_");
            }
        }

        return progreso.toString();
    }

    // Procesa una letra escrita por el jugador.
    // Devuelve correcta, incorrecta o repetida
    // para que la interfaz muestre el mensaje adecuado.
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

    // Verifica si todas las letras de la palabra
    // ya se encuentran dentro de letrasCorrectas.
    public boolean haGanado() {
        String textoPalabra = fichaSecreta.getPalabra();

        for (int posicion = 0; posicion < textoPalabra.length(); posicion++) {
            char letraActual = textoPalabra.charAt(posicion);

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
    // Si no quedan letras ocultas, devuelve el caracter nulo.
    public char revelarLetraComoPista() {
        ArrayList<Character> letrasOcultas = new ArrayList<>();
        String textoPalabra = fichaSecreta.getPalabra();

        for (int posicion = 0; posicion < textoPalabra.length(); posicion++) {
            char letraActual = textoPalabra.charAt(posicion);

            if (!letrasCorrectas.contains(letraActual) && !letrasOcultas.contains(letraActual)) {
                letrasOcultas.add(letraActual);
            }
        }

        if (letrasOcultas.isEmpty()) {
            return '\0';
        }

        int indiceAleatorio = generadorAleatorio.nextInt(letrasOcultas.size());
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
