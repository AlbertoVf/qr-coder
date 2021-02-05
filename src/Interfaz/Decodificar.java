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
    private JButton decodificar;
    private JFileChooser fileChooser;
    private File fichero = null;// coger imagen
    private String mensaje = null;

    public Decodificar() {
        setFileChooser(new JFileChooser());
        setDecodificar(new JButton("Decodificar"));
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
        decodificar.addActionListener(e -> {
            try {
                mensaje = new QR().decoder(finalFichero);
                new Mensajes().mensajeOptimo(mensaje);
            } catch (FormatException | ChecksumException | NotFoundException | IOException ex) {
                new Mensajes().mensajeError(ex);
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
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "bmp", "jpg", "jpeg", "png"));//obtener fichero
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            fichero = fileChooser.getSelectedFile();
        } else {
            new Mensajes().mensajeWarning("Has cancelado la busqueda");
            System.exit(0);
        }
        this.fileChooser = fileChooser;
    }
}