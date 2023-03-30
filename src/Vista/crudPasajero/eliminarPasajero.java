package Vista.crudPasajero;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarPasajero {
    private JTextField dni;
    private JButton salirButton;
    private JButton aceptarButton;
    private JTextArea resultado;
    private JPanel panel1;

    public eliminarPasajero() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("eliminarPasajero");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.validarVacios(new String[]{dni.getText()});
                    Main.validarDni(dni.getText(),true);
                    resultado.setText(Main.eliminarPasajero(dni.getText()));
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
