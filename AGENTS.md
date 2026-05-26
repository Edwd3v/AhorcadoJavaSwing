# Juego del Ahorcado en Java Swing

## Objetivo
Desarrollar un proyecto academico en Java llamado "Juego del Ahorcado Interactivo con Java Swing" aplicando Programacion Orientada a Objetos.

## Forma de trabajo
- Construir el proyecto por fases.
- Priorizar primero la logica del juego y despues la interfaz grafica.
- Mantener el codigo simple, claro y facil de explicar en una sustentacion academica.
- Evitar generar todo el proyecto de una vez.

## Fases
1. Crear la logica del juego sin depender de Swing.
2. Probar la logica con un `main` o pruebas simples en consola.
3. Crear una interfaz basica con Swing.
4. Conectar la interfaz con la logica del juego y las pistas.
5. Pulir la interfaz, preparar entregables y documentacion final.

## Estructura inicial sugerida
- `Palabra`: representa una palabra, su categoria y su pista escrita.
- `BancoPalabras`: almacena y entrega palabras del juego.
- `JuegoAhorcado`: controla el estado del juego, sus reglas y las pistas.

## Reglas tecnicas
- No mezclar la logica principal dentro de un `JFrame`.
- La clase `JuegoAhorcado` no debe depender de Swing.
- Usar `ArrayList` para la gestion de palabras y categorias.
- No usar frameworks externos.
- No usar base de datos.
- No usar patrones avanzados ni arquitectura compleja si no son necesarios.

## Requisitos funcionales clave
- Maximo de 7 errores por partida.
- Banco de 200 palabras.
- Minimo 5 categorias.
- Mostrar progreso de la palabra.
- Controlar letras usadas.
- Registrar letras correctas e incorrectas.
- Detectar victoria y derrota correctamente.
- Mostrar el avance grafico del ahorcado.
- Ofrecer 3 pistas durante la partida:
- Pista 1: mostrar la categoria.
- Pista 2: revelar una letra aleatoria.
- Pista 3: mostrar una pista escrita relacionada con la palabra.

## Estilo de codigo
- Usar nombres de clases en PascalCase.
- Usar variables y metodos en camelCase.
- Mantener metodos pequenos y con una sola responsabilidad.
- Evitar nombres genericos como `x`, `dato`, `cosa` o `obj`.
- Preferir soluciones explicitas y faciles de leer.

## Entregables del proyecto
- Codigo fuente organizado y documentado.
- Manual de usuario en PDF.
- Diagrama de clases.
- Video de presentacion del proyecto.

## Criterio principal
El codigo debe poder entenderse y explicarse paso a paso por un estudiante que esta aprendiendo Java.
