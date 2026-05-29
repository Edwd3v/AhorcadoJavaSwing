# Diagrama de clases

Este diagrama representa la estructura principal del Juego del Ahorcado Interactivo con Java Swing.
Incluye las clases del modelo, la logica, la interfaz y el punto de inicio, omitiendo componentes internos de Swing para mantenerlo legible en una sustentacion academica.

```mermaid
classDiagram
    class Main {
        +main(String[] args) void
    }

    class FichaPalabra {
        -String palabra
        -String categoria
        -String pistaEscrita
        +FichaPalabra(String palabra, String categoria, String pistaEscrita)
        +getPalabra() String
        +getCategoria() String
        +getPistaEscrita() String
    }

    class BancoDePalabras {
        -ArrayList~FichaPalabra~ fichasPalabra
        -Random random
        +BancoDePalabras()
        +obtenerFichaAleatoria() FichaPalabra
        -cargarPalabrasIniciales() void
        -agregarFicha(String palabra, String categoria, String pistaEscrita) void
        -cargarAnimales() void
        -cargarComidas() void
        -cargarPaises() void
        -cargarDeportes() void
        -cargarInstrumentos() void
        -cargarFrutas() void
        -cargarProfesiones() void
        -cargarColores() void
        -cargarObjetos() void
        -cargarMediosDeTransporte() void
    }

    class JuegoAhorcado {
        -int ERRORES_MAXIMOS
        -FichaPalabra fichaSecreta
        -int erroresActuales
        -int erroresMaximos
        -ArrayList~Character~ letrasUsadas
        -ArrayList~Character~ letrasCorrectas
        -ArrayList~Character~ letrasIncorrectas
        -Random random
        +JuegoAhorcado(FichaPalabra fichaSecreta)
        +getFichaSecreta() FichaPalabra
        +getErroresActuales() int
        +getErroresMaximos() int
        +getLetrasUsadas() ArrayList~Character~
        +getLetrasCorrectas() ArrayList~Character~
        +getLetrasIncorrectas() ArrayList~Character~
        +obtenerProgresoPalabra() String
        +procesarLetra(char letra) String
        +haGanado() boolean
        +haPerdido() boolean
        +usarPistaCategoria() String
        +revelarLetraComoPista() char
        +usarPistaEscrita() String
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
        -actualizarDespuesDeIntento(String resultado, char letra) void
        -usarPistaCategoria() void
        -revelarLetraComoPista() void
        -usarPistaEscrita() void
        -mostrarMensaje(String mensaje) void
        -actualizarVistaJuego() void
        -mostrarResultadoIntento(String resultado, char letra) void
        -verificarFinDePartida() void
        -bloquearControles() void
        -convertirLetrasATexto(ArrayList~Character~ letras) String
        -formatearPalabraConEspacios(String palabra) String
    }

    class PanelAhorcado {
        -int erroresActuales
        +PanelAhorcado()
        +setErroresActuales(int erroresActuales) void
        #paintComponent(Graphics graphics) void
    }

    Main --> BancoDePalabras : crea
    Main --> JuegoAhorcado : crea
    Main --> VentanaAhorcado : abre
    BancoDePalabras "1" o-- "200" FichaPalabra : contiene
    JuegoAhorcado --> FichaPalabra : ficha secreta
    VentanaAhorcado --> JuegoAhorcado : controla partida
    VentanaAhorcado *-- PanelAhorcado : muestra dibujo
```
