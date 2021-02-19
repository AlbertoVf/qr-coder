package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Mensajes {
    public static final Font BOLD = new java.awt.Font("Monospaced", Font.BOLD, 14);
    public static final Font NORMAL = new java.awt.Font("Monospaced", Font.PLAIN, 14);

    public static final String BTN_CODIFICAR = "Generar codigo QR";
    public static final String BTN_DECODIFICAR = "Decodificar";
    public static final String LBL_ALTO = "Alto";
    public static final String LBL_ANCHO = "Ancho";
    public static final String MSG_CANCELACION = "Has cancelado la busqueda";
    public static final String MSG_ERROR = "El texto esta vacio";
    public static final String MSG_OPTIMO = "Codigo generado";
    public static final String MSG_PREG = "Selecciona lo que deseas hacer";
    public static final String NAME_TEXT = "Nombre del codigo";
    public static final String NAME_WARNING = "Nombre erroneo. Se creara con el formato predeterminado";
    public static final String QR_TEXT = "Texto del codigo Qr";
    public static final String TITLE = "QR Coder";

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
