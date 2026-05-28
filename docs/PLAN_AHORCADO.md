# Plan incremental del Juego del Ahorcado

## Notas importantes
- El proyecto se construye por fases: primero logica sin Swing, luego pruebas por consola, despues interfaz y finalmente documentacion.
- Por ahora se usan palabras simples en minuscula, sin tildes, espacios ni caracteres especiales.
- Las letras repetidas no deben contar como error ni duplicarse en letras usadas.
- La pista 2 debe revelar una letra oculta sin contar como error.
- No modificar `README.md`, `out/` ni ampliar el banco a 200 palabras en esta etapa.
- La interfaz Swing debe mantenerse separada de la logica del juego.

## Tareas

| # | Tarea | Estado | Archivos modificados | Validacion |
|---|-------|--------|----------------------|------------|
| 1 | Encapsular `Palabra`: cambiar atributos a `private` y mantener getters. | completada | `src/ahorcado/modelo/Palabra.java`, `docs/PLAN_AHORCADO.md` | Compilar clases actuales y ejecutar `Main`. |
| 2 | Agregar metodo de seleccion en `BancoPalabras` con pocas palabras iniciales. | pendiente | `src/ahorcado/modelo/BancoPalabras.java`, `src/ahorcado/app/Main.java` | Probar desde `Main` que devuelve una `Palabra`. |
| 3 | Crear `JuegoAhorcado` basico sin Swing con palabra, maximo de 7 errores y getters. | pendiente | `src/ahorcado/logica/JuegoAhorcado.java`, `src/ahorcado/app/Main.java` | Instanciar desde `Main` y mostrar estado inicial. |
| 4 | Implementar progreso oculto con guiones bajos. | pendiente | `src/ahorcado/logica/JuegoAhorcado.java`, `src/ahorcado/app/Main.java` | Validar que `perro` se vea como `_ _ _ _ _`. |
| 5 | Procesar intento de letra correcta, incorrecta y repetida. | pendiente | `src/ahorcado/logica/JuegoAhorcado.java`, `src/ahorcado/app/Main.java` | Probar revelado, errores y repetidas sin duplicar. |
| 6 | Detectar victoria y derrota. | pendiente | `src/ahorcado/logica/JuegoAhorcado.java`, `src/ahorcado/app/Main.java` | Probar partida ganada y partida perdida con 7 errores. |
| 7 | Agregar pistas: categoria, letra aleatoria oculta y pista escrita. | pendiente | `src/ahorcado/logica/JuegoAhorcado.java`, `src/ahorcado/app/Main.java` | Validar las tres pistas por consola. |
| 8 | Ampliar banco a minimo 5 categorias, sin llegar todavia a 200 palabras. | pendiente | `src/ahorcado/modelo/BancoPalabras.java` | Revisar categorias y probar seleccion. |
| 9 | Crear interfaz Swing minima. | pendiente | `src/ahorcado/ui/VentanaAhorcado.java`, `src/ahorcado/app/Main.java` | Abrir ventana basica. |
| 10 | Conectar intento de letra en la interfaz. | pendiente | `src/ahorcado/ui/VentanaAhorcado.java` | Ver que el progreso cambie al ingresar letras. |
| 11 | Mostrar letras usadas y errores en Swing. | pendiente | `src/ahorcado/ui/VentanaAhorcado.java` | Confirmar que la interfaz refleja el estado de la partida. |
| 12 | Mostrar avance grafico del ahorcado. | pendiente | `src/ahorcado/ui/VentanaAhorcado.java` | Confirmar que el dibujo cambia con cada error. |
| 13 | Agregar botones de pistas en Swing. | pendiente | `src/ahorcado/ui/VentanaAhorcado.java` | Validar categoria, letra revelada y pista escrita. |
| 14 | Controlar fin de partida en Swing. | pendiente | `src/ahorcado/ui/VentanaAhorcado.java` | Confirmar victoria, derrota y bloqueo de nuevos intentos. |
| 15 | Revisar claridad del codigo. | pendiente | Clases creadas o modificadas | Revision manual y compilacion. |
| 16 | Preparar documentacion base. | pendiente | `docs/` y posible archivo de documentacion futuro | Revisar instrucciones de ejecucion y explicacion del proyecto. |
