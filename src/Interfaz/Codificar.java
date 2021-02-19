package Interfaz;

import QR.QR;
import com.google.zxing.WriterException;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Codificar extends JPanel {
    private final Mensajes t = new Mensajes();
    private JTextField nameQr;
    private JTextArea textQr;
    private JComboBox<Integer> listHeight, listWidth;

    /**
     * Crear y posicionar los elementos de la interfaz
     */
    public Codificar() {
        add(construirDimensiones());
        add(construirTexto());
        add(construirBoton());
    }
    //region Paneles

    /**
     * Establece los componentes para seleccionar las dimensiones.
     * Crea sus Combobox, label y boton para generar el codigo
     *
     * @return JPanel con dos listas desplegables y su texto correspondiente
     */
    public JPanel construirDimensiones() {
        JPanel jpDimension = new JPanel();
        JLabel w, h;

        listHeight = setDimension();
        listWidth = setDimension();

        h = new JLabel(Mensajes.LBL_ALTO);
        h.setFont(Mensajes.BOLD);
        jpDimension.add(h);
        jpDimension.add(listHeight);

        w = new JLabel(Mensajes.LBL_ANCHO);
        w.setFont(Mensajes.BOLD);
        jpDimension.add(w);
        jpDimension.add(listWidth);

        return jpDimension;
    }

    /**
     * Establece un JComboBox con los posibles valores para el ancho y alto del codigo
     * Los posibles valores van desde 10 a 100 aumentando en 5
     *
     * @return lista con items numericos
     */
    public JComboBox<Integer> setDimension() {
        JComboBox<Integer> jcb = new JComboBox<>();
        jcb.setFont(Mensajes.BOLD);
        for (int x = 10; x <= 100; x += 5) {
            jcb.addItem(x);
        }
        return jcb;
    }

    /**
     * Establece los componentes de escritura de texto y
     * nombre del fichero. Crea los TextField y label
     *
     * @return Jpanel  para nombre y contenido para codificar
     */
    public JPanel construirTexto() {
        JPanel jpText = new JPanel(new BorderLayout());
        nameQr = new JTextField(Mensajes.NAME_TEXT);
        nameQr.setColumns(30);
        textQr = new JTextArea(Mensajes.QR_TEXT, 15, 25);
        textQr.setLineWrap(true);
        nameQr.setFont(Mensajes.NORMAL);
        textQr.setFont(Mensajes.NORMAL);
        jpText.add(nameQr, BorderLayout.NORTH);
        jpText.add(new JToolBar.Separator());
        jpText.add(textQr, BorderLayout.SOUTH);
        return jpText;
    }

    /**
     * Construye un boton para realizar la codificacion del texto
     *
     * @return boton que codifica el mensaje
     */
    public JButton construirBoton() {
        JButton codificar = new JButton(Mensajes.BTN_CODIFICAR);
        codificar.setFont(Mensajes.BOLD);
        codificar.addActionListener(new GenerateQR());
        return codificar;
    }
    //endregion

    private class GenerateQR implements ActionListener {
        /**
         * Comprueba si un campo tiene un texto valido para crear el codigo QR.QR.
         * No puede ser nullo ni una cadena vacia
         *
         * @param f Campo de texto
         * @return boolean true si esta vacio
         */
        private boolean isValid(JTextComponent f) {
            return !f.getText().equals("") || f.getText() != null;
        }

        /**
         * Evento de creacion de codigo QR a partir de los datos obtenidos de la interfaz
         * Tras acabar cada accion se visualiza una ventana con informacion sobre el proceso.
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isValid(textQr)) {
                QR q = new QR(
                    (Integer) listHeight.getSelectedItem(),
                    (Integer) listWidth.getSelectedItem(),
                    textQr.getText()
                );
                if (isValid(nameQr)) {
                    q.setNameQr(nameQr.getText());
                    t.mensajeOptimo(Mensajes.MSG_OPTIMO);
                } else {
                    t.mensajeWarning(Mensajes.NAME_WARNING);
                }
                try {
                    q.generarImagen();
                } catch (IOException | WriterException ex) {
                    t.mensajeError(ex);
                }
            } else {
                t.mensajeError(Mensajes.MSG_ERROR);
            }
        }
    }
}