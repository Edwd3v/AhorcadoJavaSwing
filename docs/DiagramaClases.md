# Diagrama de clases

Este diagrama representa la estructura principal del Juego del Ahorcado Interactivo con Java Swing.
Incluye las clases del modelo, la logica, la interfaz y el punto de inicio, omitiendo componentes internos de Swing para mantenerlo legible en una sustentacion academica.

```mermaid
classDiagram
    class Main {
        +main(String[] args) void
    }

    class Palabra {
        -String texto
        -String categoria
        -String pista
        +Palabra(String texto, String categoria, String pista)
        +getTexto() String
        +getCategoria() String
        +getPista() String
    }

    class BancoPalabras {
        -ArrayList~Palabra~ bancoDePalabras
        -Random random
        +BancoPalabras()
        +obtenerPalabraAleatoria() Palabra
        -cargarPalabrasIniciales() void
        -agregarPalabra(String texto, String categoria, String pista) void
        -cargarAnimales() void
        -cargarComidas() void
        -cargarPaises() void
        -cargarDeportes() void
        -cargarInstrumentos() void
        -cargarFrutas() void
        -cargarProfesiones() void
        -cargarColores() void
        -cargarObjetos() void
        -cargarTransporte() void
    }

    class JuegoAhorcado {
        -int ERRORES_MAXIMOS
        -Palabra palabraSecreta
        -int erroresActuales
        -int erroresMaximos
        -ArrayList~Character~ letrasUsadas
        -ArrayList~Character~ letrasCorrectas
        -ArrayList~Character~ letrasIncorrectas
        -Random random
        +JuegoAhorcado(Palabra palabraSecreta)
        +getPalabraSecreta() Palabra
        +getErroresActuales() int
        +getErroresMaximos() int
        +getLetrasUsadas() ArrayList~Character~
        +getLetrasCorrectas() ArrayList~Character~
        +getLetrasIncorrectas() ArrayList~Character~
        +obtenerProgreso() String
        +intentarLetra(char letra) String
        +haGanado() boolean
        +haPerdido() boolean
        +usarPistaCategoria() String
        +usarPistaLetra() char
        +usarPistaDescripcion() String
    }

    class VentanaAhorcado {
        -JuegoAhorcado juego
        -PanelAhorcado panelAhorcado
        -boolean juegoTerminado
        +VentanaAhorcado(JuegoAhorcado juego)
        -crearComponentes() void
        -actualizarEstadoInicial() void
        -conectarEventos() void
        -procesarIntento() void
        -actualizarEstadoPartida(String resultado, char letra) void
        -usarPistaCategoria() void
        -usarPistaLetra() void
        -usarPistaDescripcion() void
        -mostrarMensaje(String mensaje) void
        -actualizarVistaJuego() void
        -mostrarResultadoIntento(String resultado, char letra) void
        -revisarFinDePartida() void
        -bloquearControles() void
        -convertirListaATexto(ArrayList~Character~ letras) String
        -separarLetras(String palabra) String
    }

    class PanelAhorcado {
        -int erroresActuales
        +PanelAhorcado()
        +setErroresActuales(int erroresActuales) void
        #paintComponent(Graphics graphics) void
    }

    Main --> BancoPalabras : crea
    Main --> JuegoAhorcado : crea
    Main --> VentanaAhorcado : abre
    BancoPalabras "1" o-- "200" Palabra : contiene
    JuegoAhorcado --> Palabra : palabra secreta
    VentanaAhorcado --> JuegoAhorcado : controla partida
    VentanaAhorcado *-- PanelAhorcado : muestra dibujo
```
