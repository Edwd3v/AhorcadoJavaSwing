package ahorcado.ui;

import ahorcado.logica.JuegoAhorcado;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
    private JLabel etiquetaMensaje;
    private JTextField campoLetra;
    private JButton botonIntentar;

    public VentanaAhorcado(JuegoAhorcado juego) {
        this.juego = juego;

        setTitle("Juego del Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(420, 280));

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
        panelCentral.setLayout(new BorderLayout(8, 8));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));

        etiquetaProgreso = new JLabel("", SwingConstants.CENTER);
        etiquetaProgreso.setFont(new Font("Monospaced", Font.BOLD, 28));
        panelCentral.add(etiquetaProgreso, BorderLayout.NORTH);

        etiquetaErrores = new JLabel("", SwingConstants.CENTER);
        etiquetaErrores.setFont(new Font("SansSerif", Font.PLAIN, 16));
        panelCentral.add(etiquetaErrores, BorderLayout.CENTER);

        etiquetaMensaje = new JLabel("La conexion del intento se hara en la siguiente fase.", SwingConstants.CENTER);
        panelCentral.add(etiquetaMensaje, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 12));

        campoLetra = new JTextField(5);
        panelInferior.add(campoLetra);

        botonIntentar = new JButton("Intentar letra");
        panelInferior.add(botonIntentar);

        add(panelInferior, BorderLayout.SOUTH);

        conectarEventos();
    }

    // Muestra el estado actual de la partida al abrir la ventana.
    private void actualizarEstadoInicial() {
        etiquetaProgreso.setText(juego.obtenerProgreso());
        etiquetaErrores.setText("Errores: " + juego.getErroresActuales() + "/" + juego.getErroresMaximos());
        etiquetaMensaje.setText("Escribe una letra y presiona el boton.");
    }

    // Conecta el boton y la tecla Enter con el intento de letra.
    private void conectarEventos() {
        ActionListener accionIntentar = evento -> procesarIntento();
        botonIntentar.addActionListener(accionIntentar);
        campoLetra.addActionListener(accionIntentar);
    }

    // Toma una letra de la interfaz y la envia a la logica del juego.
    private void procesarIntento() {
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

        campoLetra.setText("");
        campoLetra.requestFocus();
    }

    // Refresca la ventana despues de cada intento realizado.
    private void actualizarEstadoPartida(String resultado, char letra) {
        etiquetaProgreso.setText(juego.obtenerProgreso());
        etiquetaErrores.setText("Errores: " + juego.getErroresActuales() + "/" + juego.getErroresMaximos());

        if (resultado.equals("correcta")) {
            etiquetaMensaje.setText("La letra " + letra + " si esta en la palabra.");
        } else if (resultado.equals("incorrecta")) {
            etiquetaMensaje.setText("La letra " + letra + " no esta en la palabra.");
        } else {
            etiquetaMensaje.setText("La letra " + letra + " ya fue usada.");
        }
    }

    // Muestra mensajes simples de validacion para el usuario.
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
