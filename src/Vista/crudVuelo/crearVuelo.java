package Vista.crudVuelo;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class crearVuelo {
    private JPanel panel1;
    private JTextField cod_vuelo;
    private JTextField fechaSalida;
    private JTextField destino;
    private JTextField procedencia;
    private JSpinner plazasTurista;
    private JSpinner plazasPrimera;
    private JButton aceptarButton;
    private JButton salirButton;
    private JTextArea resultado;

    public crearVuelo() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("crearVuelos");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText("");
                try {
                    String[] datos = {cod_vuelo.getText().trim(),fechaSalida.getText().trim(),destino.getText().trim(),
                            procedencia.getText().trim(),plazasTurista.getValue().toString().trim(),plazasPrimera.getValue().toString().trim()};
                    Main.validarVacios(datos);
                    Main.validarCodigo(datos[0], false);
                    resultado.setText(Main.crearVuelo(datos));
                }
                catch (Exception e1) {
                    resultado.setText(e1.getMessage());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
