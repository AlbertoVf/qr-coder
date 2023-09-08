package Interfaz;

import QR.QR;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

/**
 * Clase para decodificar un código qr
 */
public class Decodificar extends JPanel {
    /**
     * Parametro para visualizar los mensajes de informacion
     */
    private final Mensajes t = new Mensajes();
    /**
     * Boton para decodificar
     */
    private JButton decodificar;
    /**
     * Selector de ficheros
     */
    private JFileChooser fileChooser;
    /**
     * Fichero que tendra el codigo qr
     */
    private File fichero = null;

    /**
     * Crea la interfaz para decodificar
     */
    public Decodificar() {
        setFileChooser(new JFileChooser());
        setDecodificar(new JButton(Mensajes.BTN_DECODIFICAR));
        add(decodificar);
        add(fileChooser);

    }

    /**
     * Decodifica la imagen con el codigo qr y muestra su contenido en una ventana.
     *
     * @param decodificar boton que decodifica el codigo
     */
    public void setDecodificar(JButton decodificar) {
        File finalFichero = fichero;
        decodificar.setFont(Mensajes.BOLD);
        decodificar.addActionListener(e -> {
            try {
                t.mensajeOptimo(new QR().decoder(finalFichero));
            } catch (FormatException | ChecksumException | NotFoundException | IOException ex) {
                t.mensajeError(ex);
            }
        });
        this.decodificar = decodificar;
    }

    /**
     * Establece un buscador de ficheros con limitaciones a solo archivos de imagen
     * y establece el fichero de trabajo
     * o un mensaje de advertencia
     *
     * @param fileChooser selector de ficheros
     */
    public void setFileChooser(JFileChooser fileChooser) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "bmp", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                if (filter.accept(fileChooser.getSelectedFile())) {
                    fichero = fileChooser.getSelectedFile();// obtener fichero
                } else {
                    t.mensajeError(Mensajes.MSG_CANCELACION);
                }
            } catch (Exception e) {
                t.mensajeError(e);
            }
        } else {
            t.mensajeWarning(Mensajes.MSG_CANCELACION);
            System.exit(0);
        }
        this.fileChooser = fileChooser;
    }
}