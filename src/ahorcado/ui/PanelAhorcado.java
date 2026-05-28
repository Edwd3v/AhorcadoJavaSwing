package ahorcado.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

// Dibuja el avance del ahorcado segun la cantidad de errores.
public class PanelAhorcado extends JPanel {

    private int erroresActuales;

    public PanelAhorcado() {
        setPreferredSize(new Dimension(200, 300));
        setMinimumSize(new Dimension(200, 300));
        setBackground(Color.WHITE);
    }

    public void setErroresActuales(int erroresActuales) {
        this.erroresActuales = erroresActuales;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D dibujo = (Graphics2D) graphics;
        dibujo.setStroke(new BasicStroke(3));
        dibujo.setColor(Color.BLACK);

        // La estructura base siempre se muestra desde el inicio.
        dibujo.drawLine(20, 220, 130, 220);
        dibujo.drawLine(45, 220, 45, 30);
        dibujo.drawLine(45, 30, 120, 30);

        if (erroresActuales >= 1) {
            dibujo.drawOval(100, 55, 40, 40);
        }

        if (erroresActuales >= 2) {
            dibujo.drawLine(120, 95, 120, 145);
        }

        if (erroresActuales >= 3) {
            dibujo.drawLine(120, 105, 145, 125);
        }

        if (erroresActuales >= 4) {
            dibujo.drawLine(120, 105, 95, 125);
        }

        if (erroresActuales >= 5) {
            dibujo.drawLine(120, 145, 140, 190);
        }

        if (erroresActuales >= 6) {
            dibujo.drawLine(120, 145, 100, 190);
        }

        if (erroresActuales >= 7) {
            dibujo.drawLine(120, 30, 120, 55);
        }
    }
}
