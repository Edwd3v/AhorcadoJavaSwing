# Documentacion Base del Proyecto

## Nombre del proyecto
Juego del Ahorcado Interactivo con Java Swing

## Descripcion general
Este proyecto desarrolla el juego clasico del ahorcado usando Java y Java Swing.
La solucion se construyo por fases, separando la logica del juego de la interfaz grafica.

El objetivo academico es aplicar Programacion Orientada a Objetos con una estructura simple,
con el fin de poner en practica los conceptos aprendidos en los modulos de la asignatura.

## Estructura principal
- `src/ahorcado/modelo/Palabra.java`: representa una palabra, su categoria y su pista escrita.
- `src/ahorcado/modelo/BancoPalabras.java`: almacena las palabras disponibles y entrega una palabra aleatoria.
- `src/ahorcado/logica/JuegoAhorcado.java`: controla las reglas de la partida, los errores, el progreso y las pistas.
- `src/ahorcado/ui/VentanaAhorcado.java`: construye la interfaz grafica y conecta la vista con la logica.
- `src/ahorcado/ui/PanelAhorcado.java`: dibuja el avance grafico del ahorcado segun los errores.
- `src/ahorcado/app/Main.java`: punto de inicio del programa.

## Reglas del juego implementadas
- La partida permite maximo 7 errores.
- Se selecciona una palabra aleatoria desde un banco de 200 palabras.
- El progreso de la palabra se muestra con guiones bajos.
- Las letras usadas no se repiten como error adicional.
- Se registran letras correctas e incorrectas.
- El juego detecta victoria y derrota.
- La interfaz bloquea nuevas acciones cuando la partida termina.

## Categorias actuales
Actualmente el banco incluye 200 palabras distribuidas en estas categorias:
- Animales
- Comidas
- Paises
- Deportes
- Instrumentos
- Frutas
- Profesiones
- Colores
- Objetos
- Transporte

## Pistas implementadas
- Pista 1: muestra la categoria.
- Pista 2: revela una letra oculta.
- Pista 3: muestra una descripcion relacionada con la palabra.

Cada pista se puede usar una sola vez en la interfaz.

## Interfaz grafica actual
La interfaz Swing permite:
- ver el progreso de la palabra;
- ingresar letras;
- ver errores actuales;
- ver letras usadas;
- ver letras incorrectas;
- usar las tres pistas;
- ver el dibujo del ahorcado por etapas;
- recibir mensajes de victoria o derrota.

## Como ejecutar el proyecto
1. Abrir una terminal en la carpeta del proyecto.
2. Compilar el codigo:

```bash
javac -d out $(find src -name '*.java')
```

3. Ejecutar la aplicacion:

```bash
java -cp out ahorcado.app.Main
```

## Ideas clave para la sustentacion
- La logica del juego no depende de Swing.
- `JuegoAhorcado` concentra las reglas principales.
- `VentanaAhorcado` solo muestra informacion y llama metodos de la logica.
- `PanelAhorcado` dibuja el avance grafico sin usar imagenes externas.
- El proyecto se desarrollo por fases para mantener control y claridad.

## Estado actual del proyecto
- Logica del juego completada.
- Interfaz grafica basica completada.
- Conexion entre logica, pistas y dibujo completada.
- Banco de 200 palabras completado.
- Revision de claridad del codigo completada.
- Documentacion base iniciada en este archivo.

## Pendiente para entregables finales
- Convertir esta base en manual de usuario mas formal.
- Preparar diagrama de clases.
- Preparar presentacion o video de explicacion del proyecto.
