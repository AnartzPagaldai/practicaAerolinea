package Vista.crudVuelo;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarVuelo {
    private JPanel panel1;
    private JButton aceptarButton;
    private JButton salirButton;
    private JTextField cod_vuelo;
    private JTextArea resultado;

    public eliminarVuelo() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("eliminarVuelo");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.validarVacios(new String[]{cod_vuelo.getText()});
                    Main.validarCodigo(cod_vuelo.getText(), true);
                    resultado.setText(Main.eliminarVuelo(cod_vuelo.getText()));
                }
                catch (Exception ex) {
                    resultado.setText(ex.getMessage());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
