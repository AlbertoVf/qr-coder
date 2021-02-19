package Interfaz;

import QR.QR;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class Decodificar extends JPanel {
    private final Mensajes t = new Mensajes();
    private JButton decodificar;
    private JFileChooser fileChooser;
    private File fichero = null;// coger imagen
    private String mensaje = null;

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
                mensaje = new QR().decoder(finalFichero);
                t.mensajeOptimo(mensaje);
            } catch (FormatException | ChecksumException | NotFoundException | IOException ex) {
                t.mensajeError(ex);
            }
        });
        this.decodificar = decodificar;
    }

    /**
     * Establece un buscador de ficheros con limitaciones a solo archivos de imagen y establece el fichero de trabajo
     * o un mensaje de advertencia
     *
     * @param fileChooser selector de ficheros
     */
    public void setFileChooser(JFileChooser fileChooser) {
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "bmp", "jpg", "jpeg", "png"));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            fichero = fileChooser.getSelectedFile();//obtener fichero
        } else {
            t.mensajeWarning(Mensajes.MSG_CANCELACION);
            System.exit(0);
        }
        this.fileChooser = fileChooser;
    }
}