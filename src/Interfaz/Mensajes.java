package Interfaz;


import javax.swing.*;

/**
 * Clase para mostrar mensajes emergentes
 */
public class Mensajes {
    /**
     * Muestra una ventana emergente con un mensaje de advertencia
     *
     * @param mensaje el mensaje
     */
    public void mensajeWarning(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Muestra una ventana emergente con un mensaje indicando que se realizo correctamente
     *
     * @param mensaje el mensaje
     */
    public void mensajeOptimo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra una ventana emergente con un mensaje de error mostrando la excencion
     *
     * @param ex la excepcion
     */
    public void mensajeError(Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra una ventana emergente con un mensaje de error personalizado
     *
     * @param mensaje el mensaje
     */
    public void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
