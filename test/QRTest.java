package test;

import QR.QR;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Tests de la clase QR
 */
public class QRTest {
    QR q = new QR();

    /**
     * Test para la propiedad width
     */
    @Test
    public void setWidth() {
        q.setWidth(40);
        assertEquals(40, q.getWidth());
    }

    /**
     * Test para la propiedad height
     */
    @Test
    public void setHeight() {
        q.setHeight(40);
        assertEquals(40, q.getHeight());
    }

    /**
     * Test para la propiedad nameQr.
     */
    @Test
    public void setNameQr() {
        q.setNameQr("codigo-qr");
        assertEquals("codigo-qr", q.getNameQr());

        q.setNameQr("qr-code!ªº{}[]?¿¡'\"@");
        assertEquals("qr-code_____________", q.getNameQr());
    }

    /**
     * Test de la funcion generarImagen
     */
    @Test
    public void generarImagen() {
        File f = new File("qr-prueba.png");
        try {
            assertEquals(f, q.generarImagen());
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test de la funcion generateQR
     */
    @Test
    public void generateQR() {
        try {
            assertEquals(new File("qr-prueba.png"),
                    q.generateQR(new File("qr-prueba.png"), "Texto del codigo QR", 50, 50));
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test de la funcion decoder
     */
    @Test
    public void decoder() {
        String a = null;
        try {
            a = q.decoder(new File("qr-prueba.png"));
        } catch (IOException | FormatException | ChecksumException | NotFoundException e) {
            e.printStackTrace();
        }
        assertEquals("Texto del codigo QR", a);
    }
}