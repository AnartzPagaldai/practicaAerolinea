package Vista.crudPasajero;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actualizarPasajero {
    private JTextField dni;
    private JTextField nombre;
    private JButton salirButton;
    private JButton aceptarButton;
    private JTextArea resultado;
    private JPanel panel1;

    public actualizarPasajero() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("actualizarPasajero");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] datos = {dni.getText().trim(), nombre.getText().trim()};
                    Main.validarVacios(datos);
                    Main.validarDni(datos[0], true);
                    resultado.setText(Main.actualizarPasajero(datos[0], datos[1]));
                } catch (Exception ex) {
                    resultado.setText(ex.getMessage());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
