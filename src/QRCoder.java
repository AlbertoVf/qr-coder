import Interfaz.Frame;
import Interfaz.Mensajes;

import javax.swing.*;

/**
 * Clase principal.
 * Crea un JOption pane para seleccionar la accion
 */
public class QRCoder {
    /**
     * Metodo principal encargado de la ejecucion
     *
     * @param args parametros
     */
    public static void main(String[] args) {
        String[] opciones = {"Codificar", "Decodificar", "Cancelar"};
        int seleccion = JOptionPane.showOptionDialog(null,
              Mensajes.MSG_PREG, Mensajes.TITLE, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
              null, opciones, null);

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
