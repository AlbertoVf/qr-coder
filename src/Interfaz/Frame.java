package Interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Clase constructora de la interfaz grafica
 */
public class Frame extends JFrame {
    /**
     * Dimensiones de la pantalla
     */
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Posicion en el eje X de las ventanas
     */
    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
    /**
     * Posicion en el eje Y de las ventanas
     */
    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

    /**
     * Constructor de la ventana
     *
     * @param tipo: tipo de ventana que se creara segun la actividad
     */
    public Frame(String tipo) {
        if (tipo.equals("Codificar")) {
            setBounds(x / 2, y / 2, x / 2, x / 2 + 100);
            add(new Codificar());
        } else if (tipo.equals("Decodificar")) {
            setBounds(x / 2, y / 2, x, y);
            add(new Decodificar());
        }
        setVisible(true);
        setResizable(false);
        setTitle(Mensajes.TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
