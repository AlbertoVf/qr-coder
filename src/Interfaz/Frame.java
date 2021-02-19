package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

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
