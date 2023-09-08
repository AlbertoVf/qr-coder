package Interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Clase para guardar todos los textos y
 * mensajes que se usan el la aplicacion
 */
public class Mensajes {
    /**
     * Fuente Bold
     */
    public static final Font BOLD = new java.awt.Font("Monospaced", Font.BOLD, 14);
    /**
     * Fuente por defecto para textos escritos por el usuario
     */
    public static final Font NORMAL = new java.awt.Font("Monospaced", Font.PLAIN, 14);
    /**
     * Texto de boton codificar
     */
    public static final String BTN_CODIFICAR = "Generar codigo QR";
    /**
     * Texto de boton decodificar
     */
    public static final String BTN_DECODIFICAR = "Decodificar";
    /**
     * Texto de etiqueta alto
     */
    public static final String LBL_ALTO = "Alto";
    /**
     * Texto de etiqueta ancho
     */
    public static final String LBL_ANCHO = "Ancho";
    /**
     * Texto de cancelacion de seleccion de codigo qr
     */
    public static final String MSG_CANCELACION = "Fichero no selecionado";
    /**
     * Texto para codigo qr vacio.
     */
    public static final String MSG_ERROR = "El texto esta vacio";
    /**
     * Texto para codigo generado correctamente
     */
    public static final String MSG_OPTIMO = "Codigo generado";
    /**
     * Mensaje de seleccione de opciones
     */
    public static final String MSG_PREG = "Selecciona lo que deseas hacer";
    /**
     * Nombre por defecto del codigo qr.
     */
    public static final String NAME_TEXT = "Nombre del codigo";
    /**
     * Texto para mensaje de nombre erroneo:
     */
    public static final String NAME_WARNING = "Nombre erroneo. Se creara con el formato predeterminado";
    /**
     * Texto por defecto del codigo qr
     */
    public static final String QR_TEXT = "Texto del codigo Qr";
    /**
     * Titulo de la aplicacion
     */
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
     * Muestra una ventana emergente con un mensaje indicando que se realizo
     * correctamente
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
