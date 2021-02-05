import Interfaz.Frame;

import javax.swing.*;

public class QRCoder {

    public static void main(String[] args) {
        String[] opciones = {"Codificar", "Decodificar", "Cancelar"};
        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona lo que deseas hacer", "QR Coder",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);

        switch (seleccion) {
            case JOptionPane.YES_OPTION:
                new Frame("Codificar");
                break;
            case JOptionPane.NO_OPTION:
                new Frame("Decodificar");
                break;
            case JOptionPane.CANCEL_OPTION:
                System.exit(0);
        }
    }
}