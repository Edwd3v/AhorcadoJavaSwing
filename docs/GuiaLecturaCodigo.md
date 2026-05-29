# Guia de lectura del codigo

Esta guia esta pensada para leer el proyecto mientras se exploran los archivos fuente. El objetivo es entender que hace cada clase, como se conectan entre si y donde esta ubicada la logica principal del juego.

## 1. Idea general del proyecto

El proyecto implementa un Juego del Ahorcado con Java Swing. La parte importante de la estructura es que la logica del juego no esta mezclada dentro de la ventana grafica.

La separacion principal es esta:
- `modelo`: clases que representan datos del juego.
- `logica`: reglas y estado de la partida.
- `ui`: interfaz grafica con Swing.
- `app`: punto de inicio del programa.

## 2. Orden recomendado para leer el codigo

Para entender el proyecto, conviene leer los archivos en este orden:

1. `src/ahorcado/app/Main.java`
2. `src/ahorcado/modelo/FichaPalabra.java`
3. `src/ahorcado/modelo/BancoDePalabras.java`
4. `src/ahorcado/logica/JuegoAhorcado.java`
5. `src/ahorcado/ui/PanelAhorcado.java`
6. `src/ahorcado/ui/VentanaAhorcado.java`

Ese orden permite empezar por el arranque del programa, luego entender los datos, despues las reglas y finalmente la interfaz.

## 3. Main.java

`Main` es el punto de entrada del programa. Su responsabilidad es iniciar los objetos principales y abrir la ventana.

Flujo principal:
- crea un `BancoDePalabras`;
- obtiene una `FichaPalabra` aleatoria;
- crea un `JuegoAhorcado` usando esa ficha;
- abre una `VentanaAhorcado` usando `SwingUtilities.invokeLater`.

Esta clase no contiene reglas del juego. Solo prepara el inicio de la aplicacion.

## 4. FichaPalabra.java

`FichaPalabra` representa una ficha completa del banco de palabras.

Atributos principales:
- `palabra`: palabra que el jugador debe adivinar;
- `categoria`: categoria usada como primera pista;
- `pistaEscrita`: descripcion escrita usada como tercera pista.

Metodos principales:
- `getPalabra()`;
- `getCategoria()`;
- `getPistaEscrita()`.

Esta clase es un modelo simple. Solo guarda informacion y permite consultarla.

## 5. BancoDePalabras.java

`BancoDePalabras` almacena las palabras disponibles para jugar.

Responsabilidades:
- crear un `ArrayList<FichaPalabra>`;
- cargar las palabras iniciales;
- entregar una ficha aleatoria cuando inicia una partida.

El banco esta organizado por metodos privados de carga, por ejemplo:
- `cargarAnimales()`;
- `cargarComidas()`;
- `cargarPaises()`;
- `cargarDeportes()`;
- `cargarInstrumentos()`;
- `cargarFrutas()`;
- `cargarProfesiones()`;
- `cargarColores()`;
- `cargarObjetos()`;
- `cargarMediosDeTransporte()`.

El metodo clave es:

```java
public FichaPalabra obtenerFichaAleatoria()
```

Ese metodo selecciona una posicion aleatoria del arreglo y devuelve una ficha.

## 6. JuegoAhorcado.java

`JuegoAhorcado` es la clase mas importante de la logica. Controla el estado de la partida y sus reglas.

Atributos principales:
- `fichaSecreta`: ficha que contiene la palabra, la categoria y la pista escrita;
- `erroresActuales`: errores cometidos por el jugador;
- `erroresMaximos`: limite de errores, actualmente 7;
- `letrasUsadas`: letras que ya se intentaron;
- `letrasCorrectas`: letras acertadas;
- `letrasIncorrectas`: letras falladas.

Metodos clave:
- `obtenerProgresoPalabra()`: devuelve la palabra con guiones bajos y letras descubiertas;
- `procesarLetra(char letra)`: procesa una letra y retorna `correcta`, `incorrecta` o `repetida`;
- `haGanado()`: indica si ya se descubrio toda la palabra;
- `haPerdido()`: indica si ya se llego al maximo de errores;
- `usarPistaCategoria()`: devuelve la categoria;
- `revelarLetraComoPista()`: revela una letra oculta;
- `usarPistaEscrita()`: devuelve la pista escrita.

Esta clase no depende de Swing. Por eso puede explicarse como el centro de las reglas del juego.

## 7. PanelAhorcado.java

`PanelAhorcado` se encarga solo del dibujo del ahorcado.

Responsabilidades:
- guardar la cantidad de errores actuales;
- redibujar el panel cuando cambian los errores;
- dibujar la estructura base siempre visible;
- dibujar cabeza, torso, extremidades y cuerda final segun los errores.

Metodo principal:

```java
protected void paintComponent(Graphics graphics)
```

Ese metodo usa `Graphics2D` para dibujar lineas y ovalos. No usa imagenes externas.

La secuencia visual es:
- base, poste y soporte siempre visibles;
- error 1: cabeza;
- error 2: torso;
- error 3: brazo derecho;
- error 4: brazo izquierdo;
- error 5: pierna derecha;
- error 6: pierna izquierda;
- error 7: cuerda final.

## 8. VentanaAhorcado.java

`VentanaAhorcado` es la interfaz grafica del juego. Extiende `JFrame` y organiza los componentes visuales.

Responsabilidades principales:
- construir la ventana;
- mostrar progreso, errores, letras usadas e incorrectas;
- recibir intentos de letras;
- llamar metodos de `JuegoAhorcado`;
- actualizar el dibujo en `PanelAhorcado`;
- manejar las pistas;
- bloquear controles al ganar o perder.

Metodos importantes:
- `crearComponentes()`: construye la interfaz;
- `conectarEventos()`: conecta botones y campo de texto con acciones;
- `procesarIntento()`: toma una letra y la envia a la logica;
- `actualizarVistaJuego()`: refresca progreso, errores, letras y dibujo;
- `verificarFinDePartida()`: detecta victoria o derrota;
- `bloquearControles()`: impide seguir jugando cuando termina la partida.

Esta clase si depende de Swing, pero no contiene las reglas principales. La ventana consulta y actualiza la logica a traves de `JuegoAhorcado`.

## 9. Flujo de una jugada

Cuando el usuario escribe una letra y presiona el boton:

1. `VentanaAhorcado.procesarIntento()` lee el texto del campo.
2. Valida que sea una sola letra.
3. Llama a `JuegoAhorcado.procesarLetra(letra)`.
4. `JuegoAhorcado` decide si la letra es correcta, incorrecta o repetida.
5. `VentanaAhorcado.actualizarVistaJuego()` refresca la pantalla.
6. `PanelAhorcado` se redibuja segun los errores actuales.
7. `VentanaAhorcado.verificarFinDePartida()` valida si gano o perdio.

Este flujo muestra claramente la separacion entre interfaz y logica.

## 10. Flujo de las pistas

La ventana tiene tres botones de pistas:

- `Pista categoria`: llama a `usarPistaCategoria()` y muestra la categoria.
- `Pista letra`: llama a `revelarLetraComoPista()` y revela una letra oculta.
- `Pista descripcion`: llama a `usarPistaEscrita()` y muestra la pista escrita.

Cada pista se desactiva despues de usarse para evitar repetirla.

## 11. Conceptos de Programacion Orientada a Objetos usados

El proyecto permite explicar estos conceptos:

- Clases y objetos: cada archivo representa una clase con una responsabilidad clara.
- Encapsulamiento: los atributos son privados y se acceden mediante metodos.
- Composicion: `BancoDePalabras` contiene objetos `FichaPalabra`; `VentanaAhorcado` contiene un `PanelAhorcado`.
- Separacion de responsabilidades: la logica esta en `JuegoAhorcado`, la interfaz en `VentanaAhorcado` y el dibujo en `PanelAhorcado`.
- Metodos con responsabilidad unica: cada metodo realiza una tarea concreta.

## 12. Resumen para sustentacion

Una forma clara de explicar el proyecto es:

1. `Main` inicia el juego.
2. `BancoDePalabras` entrega una ficha aleatoria.
3. `FichaPalabra` guarda palabra, categoria y pista escrita.
4. `JuegoAhorcado` controla reglas, errores, progreso y pistas.
5. `VentanaAhorcado` muestra la interfaz y recibe acciones del usuario.
6. `PanelAhorcado` dibuja el avance del ahorcado.

La idea central es que la interfaz no decide las reglas del juego. La interfaz solo muestra informacion y llama a la logica.
