package ahorcado.ui;

import ahorcado.logica.JuegoAhorcado;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// Ventana inicial del juego, separada de la logica principal.
public class VentanaAhorcado extends JFrame {

    private JuegoAhorcado juego;
    private JLabel etiquetaProgreso;
    private JLabel etiquetaErrores;
    private JLabel etiquetaLetrasUsadas;
    private JLabel etiquetaLetrasIncorrectas;
    private JLabel etiquetaMensaje;
    private PanelAhorcado panelAhorcado;
    private JTextField campoLetra;
    private JButton botonIntentar;
    private JButton botonPistaCategoria;
    private JButton botonPistaLetra;
    private JButton botonPistaDescripcion;
    private boolean juegoTerminado;

    public VentanaAhorcado(JuegoAhorcado juego) {
        this.juego = juego;

        setTitle("Juego del Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(580, 500);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(540, 460));

        crearComponentes();
        actualizarEstadoInicial();
    }

    // Construye una interfaz simple para la siguiente fase.
    private void crearComponentes() {
        setLayout(new BorderLayout(12, 12));

        JLabel titulo = new JLabel("Juego del Ahorcado", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(16, 16, 0, 16));
        add(titulo, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout(12, 12));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));

        panelAhorcado = new PanelAhorcado();
        panelCentral.add(panelAhorcado, BorderLayout.WEST);

        JPanel panelEstado = new JPanel();
        panelEstado.setLayout(new BorderLayout(8, 8));

        etiquetaProgreso = new JLabel("", SwingConstants.CENTER);
        etiquetaProgreso.setFont(new Font("Monospaced", Font.BOLD, 28));
        panelEstado.add(etiquetaProgreso, BorderLayout.NORTH);

        etiquetaErrores = new JLabel("", SwingConstants.CENTER);
        etiquetaErrores.setFont(new Font("SansSerif", Font.PLAIN, 16));
        panelEstado.add(etiquetaErrores, BorderLayout.CENTER);

        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BorderLayout(4, 4));

        etiquetaLetrasUsadas = new JLabel("", SwingConstants.CENTER);
        panelInfo.add(etiquetaLetrasUsadas, BorderLayout.NORTH);

        etiquetaLetrasIncorrectas = new JLabel("", SwingConstants.CENTER);
        panelInfo.add(etiquetaLetrasIncorrectas, BorderLayout.CENTER);

        etiquetaMensaje = new JLabel("Escribe una letra para comenzar.", SwingConstants.CENTER);
        panelInfo.add(etiquetaMensaje, BorderLayout.SOUTH);

        panelEstado.add(panelInfo, BorderLayout.SOUTH);
        panelCentral.add(panelEstado, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout(8, 8));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(0, 16, 12, 16));

        JPanel panelIntento = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 6));

        campoLetra = new JTextField(5);
        panelIntento.add(campoLetra);

        botonIntentar = new JButton("Intentar letra");
        panelIntento.add(botonIntentar);

        panelInferior.add(panelIntento, BorderLayout.NORTH);

        JPanel panelPistas = new JPanel(new GridLayout(1, 3, 8, 0));

        botonPistaCategoria = new JButton("Pista categoria");
        panelPistas.add(botonPistaCategoria);

        botonPistaLetra = new JButton("Pista letra");
        panelPistas.add(botonPistaLetra);

        botonPistaDescripcion = new JButton("Pista descripcion");
        panelPistas.add(botonPistaDescripcion);

        panelInferior.add(panelPistas, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);

        conectarEventos();
    }

    // Muestra el estado actual de la partida al abrir la ventana.
    private void actualizarEstadoInicial() {
        actualizarVistaJuego();
        etiquetaMensaje.setText("Escribe una letra y presiona el boton.");
    }

    // Conecta el boton y la tecla Enter con el intento de letra.
    private void conectarEventos() {
        ActionListener accionIntentar = evento -> procesarIntento();
        botonIntentar.addActionListener(accionIntentar);
        campoLetra.addActionListener(accionIntentar);
        botonPistaCategoria.addActionListener(evento -> usarPistaCategoria());
        botonPistaLetra.addActionListener(evento -> usarPistaLetra());
        botonPistaDescripcion.addActionListener(evento -> usarPistaDescripcion());
    }

    // Toma una letra de la interfaz y la envia a la logica del juego.
    private void procesarIntento() {
        if (juegoTerminado) {
            return;
        }

        String textoIngresado = campoLetra.getText().trim().toLowerCase();

        if (textoIngresado.length() != 1 || !Character.isLetter(textoIngresado.charAt(0))) {
            mostrarMensaje("Ingresa solo una letra.");
            campoLetra.setText("");
            campoLetra.requestFocus();
            return;
        }

        char letra = textoIngresado.charAt(0);
        String resultado = juego.intentarLetra(letra);

        actualizarEstadoPartida(resultado, letra);
        revisarFinDePartida();

        campoLetra.setText("");
        campoLetra.requestFocus();
    }

    // Refresca la ventana despues de cada intento realizado.
    private void actualizarEstadoPartida(String resultado, char letra) {
        actualizarVistaJuego();
        mostrarResultadoIntento(resultado, letra);
    }

    // Muestra la categoria y desactiva esa pista para evitar repetirla.
    private void usarPistaCategoria() {
        if (juegoTerminado) {
            return;
        }

        String categoria = juego.usarPistaCategoria();
        etiquetaMensaje.setText("Categoria: " + categoria);
        botonPistaCategoria.setEnabled(false);
    }

    // Revela una letra oculta y refresca la interfaz.
    private void usarPistaLetra() {
        if (juegoTerminado) {
            return;
        }

        char letraRevelada = juego.usarPistaLetra();

        if (letraRevelada == '\0') {
            etiquetaMensaje.setText("No hay mas letras ocultas para revelar.");
        } else {
            actualizarVistaJuego();
            etiquetaMensaje.setText("Se revelo la letra: " + letraRevelada);
        }

        botonPistaLetra.setEnabled(false);
        revisarFinDePartida();
    }

    // Muestra la descripcion de la palabra y desactiva esa pista.
    private void usarPistaDescripcion() {
        if (juegoTerminado) {
            return;
        }

        String descripcion = juego.usarPistaDescripcion();
        etiquetaMensaje.setText("Pista: " + descripcion);
        botonPistaDescripcion.setEnabled(false);
    }

    // Muestra mensajes simples de validacion para el usuario.
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Actualiza en bloque los elementos visuales ligados al estado del juego.
    private void actualizarVistaJuego() {
        etiquetaProgreso.setText(juego.obtenerProgreso());
        etiquetaErrores.setText("Errores: " + juego.getErroresActuales() + "/" + juego.getErroresMaximos());
        etiquetaLetrasUsadas.setText("Letras usadas: " + convertirListaATexto(juego.getLetrasUsadas()));
        etiquetaLetrasIncorrectas.setText("Letras incorrectas: " + convertirListaATexto(juego.getLetrasIncorrectas()));
        panelAhorcado.setErroresActuales(juego.getErroresActuales());
    }

    // Muestra un mensaje corto segun el tipo de intento realizado.
    private void mostrarResultadoIntento(String resultado, char letra) {
        if (resultado.equals("correcta")) {
            etiquetaMensaje.setText("La letra " + letra + " si esta en la palabra.");
        } else if (resultado.equals("incorrecta")) {
            etiquetaMensaje.setText("La letra " + letra + " no esta en la palabra.");
        } else {
            etiquetaMensaje.setText("La letra " + letra + " ya fue usada.");
        }
    }

    // Verifica si la partida termino y bloquea la interfaz si corresponde.
    private void revisarFinDePartida() {
        if (juego.haGanado()) {
            juegoTerminado = true;
            etiquetaMensaje.setText("Ganaste la partida.");
            bloquearControles();
            mostrarMensaje("Ganaste. Descubriste la palabra.");
            return;
        }

        if (juego.haPerdido()) {
            juegoTerminado = true;
            etiquetaProgreso.setText(separarLetras(juego.getPalabraSecreta().getTexto()));
            etiquetaMensaje.setText("Perdiste la partida.");
            bloquearControles();
            mostrarMensaje("Perdiste. La palabra era: " + juego.getPalabraSecreta().getTexto());
        }
    }

    // Desactiva los controles para impedir mas acciones al terminar la partida.
    private void bloquearControles() {
        campoLetra.setEnabled(false);
        botonIntentar.setEnabled(false);
        botonPistaCategoria.setEnabled(false);
        botonPistaLetra.setEnabled(false);
        botonPistaDescripcion.setEnabled(false);
    }

    // Convierte una lista de letras en un texto sencillo para la interfaz.
    private String convertirListaATexto(java.util.ArrayList<Character> letras) {
        if (letras.isEmpty()) {
            return "ninguna";
        }

        StringBuilder texto = new StringBuilder();

        for (int indice = 0; indice < letras.size(); indice++) {
            if (indice > 0) {
                texto.append(", ");
            }

            texto.append(letras.get(indice));
        }

        return texto.toString();
    }

    // Separa las letras para mostrar la palabra completa con el mismo estilo del progreso.
    private String separarLetras(String palabra) {
        StringBuilder texto = new StringBuilder();

        for (int indice = 0; indice < palabra.length(); indice++) {
            if (indice > 0) {
                texto.append(" ");
            }

            texto.append(palabra.charAt(indice));
        }

        return texto.toString();
    }
}
