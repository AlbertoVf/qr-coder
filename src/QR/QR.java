package QR;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Clase encargada de los códigos QR
 */
public class QR {
    private final Color colorCode, colorBackground;
    private final String textQr;
    private int height, width;
    private String nameQr;

    //region Constructores

    /**
     * Constructor del codigo QR
     */
    public QR() {
        this.height = 50;
        this.width = 50;
        this.colorCode = Color.BLACK;
        this.colorBackground = Color.WHITE;
        this.textQr = "Texto de prueba";
        this.nameQr = "qr-prueba";
    }

    /**
     * Constructor del codigo QR
     *
     * @param height   alto del codigo
     * @param width    ancho del codigo
     * @param textQr   texto para codificar
     * @param nameFile nombre del archivo resultante
     */
    public QR(int height, int width, String textQr, String nameFile) {
        this.height = height;
        this.width = width;
        this.colorCode = Color.BLACK;
        this.colorBackground = Color.WHITE;
        this.textQr = textQr;
        this.nameQr = nameFile;
    }

    /**
     * Constructor del codigo QR cuando no tiene un nombre establecido
     *
     * @param height alto del codigo
     * @param width  ancho del codigo
     * @param textQr texto para codificar
     */
    public QR(int height, int width, String textQr) {
        this.height = height;
        this.width = width;
        this.colorCode = Color.BLACK;
        this.colorBackground = Color.WHITE;
        this.textQr = textQr;
        this.nameQr = "qr-" + new Date().getTime();
    }
    //endregion

    //region Getter y Setter

    /**
     * Obtiene el alto del codigo
     *
     * @return alto del codigo
     */
    public int getHeight() {
        return height;
    }

    /**
     * Establece el alto del codigo
     * es diferente al del archivo resultante
     *
     * @param height alto de codigo
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Obtiene el ancho del codigo
     *
     * @return ancho del codigo
     */
    public int getWidth() {
        return width;
    }

    /**
     * Establece el ancho del codigo QR.QR
     * es diferente al del archivo resultante
     *
     * @param width ancho del codigo
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Obtiene el texto codificado en el codigo
     *
     * @return texto del codigo
     */
    public String getTextQr() {
        return textQr;
    }


    /**
     * Obtiene el nombre del archivo del codigo QR.QR
     *
     * @return String con el nombre del archivo
     */
    public String getNameQr() {
        return nameQr;
    }

    /**
     * Establece el nombre del archivo con el que se guardara el codigo QR.QR
     *
     * @param nameQr nombre del archivo de imagen
     */
    public void setNameQr(String nameQr) {
        String[] invalidos = {" ", "!", "¡", "?", "¿", "\"", "'", "º", "ª", "\\", "/", "{", "}", "[", "]", ",", "}", "@"};

        for (String s : invalidos) {
            nameQr = nameQr.replace(s, "_");
        }
        this.nameQr = nameQr;
    }
    //endregion

    //region Codigo QR

    /**
     * Crea un archivo de imagen que contiene el codigo QR.QR
     *
     * @return Fichero generado
     * @throws IOException     Excepcion del fichero
     * @throws WriterException Excepcion al escribir
     */
    public File generarImagen() throws IOException, WriterException {
        File f = new File(getNameQr() + ".png");

        generateQR(f, getTextQr(), getHeight(), getWidth());
        return f;
    }

    /**
     * Genera un codigo QR con los parametros recibidos
     *
     * @param file Archivo del codigo QR.QR
     * @param text Texto que se codificara en el codigo QR.QR
     * @param h    Alto del codigo
     * @param w    Ancho del codigo
     * @return Archivo de imagen con el codigo QR.QR
     * @throws WriterException Excepcion de la libreria
     * @throws IOException     Excepcion del fichero
     */
    public File generateQR(File file, String text, int h, int w) throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(text, com.google.zxing.BarcodeFormat.QR_CODE, w * 10, h * 10);
        BufferedImage image = new BufferedImage(matrix.getWidth(), matrix.getHeight(), BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(this.colorBackground);
        graphics.fillRect(0, 0, matrix.getWidth(), matrix.getHeight());
        graphics.setColor(this.colorCode);

        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (matrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        ImageIO.write(image, "png", file);
        return file;
    }

    /**
     * Decodifica el codigo QR.QR del archivo seleccionado
     *
     * @param file Arquivo de imagen con el codigo QR.QR
     * @return Cadena de texto del codigo QR.QR
     * @throws IOException       Error en el fichero
     * @throws FormatException   Excepcion al decodificar el codigo
     * @throws ChecksumException Excepcion de la libreria
     * @throws NotFoundException Excepcion de la liberria
     */
    public String decoder(File file) throws IOException, FormatException, ChecksumException, NotFoundException {
        FileInputStream inputStream = new FileInputStream(file);
        BufferedImage image = ImageIO.read(inputStream);

        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        // decode the barcode
        QRCodeReader reader = new QRCodeReader();
        Result result = reader.decode(bitmap);
        return result.getText();
    }

    /**
     * Imprime la informacion del objeto creado
     *
     * @return Descripcion de los elementos de la clase
     */
    @Override
    public String toString() {
        return "QR{" +
            "height=" + height +
            ", width=" + width +
            ", colorCode=" + colorCode +
            ", colorBackground=" + colorBackground +
            ", textQr='" + textQr + '\'' +
            ", nameQr='" + nameQr + '\'' +
            '}';
    }
    //endregion
}
