package Vista.crudPasajero;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertarPasajero {

    private JPanel panel1;
    private JButton salirButton;
    private JButton aceptarButton;
    private JTextArea resultado;
    private JTextField dni;
    private JTextField nombre;

    public insertarPasajero() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("insertarPasajero");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] datos = {dni.getText().trim(), nombre.getText().trim()};
                    Main.validarVacios(datos);
                    Main.validarDni(datos[0], false);
                    resultado.setText(Main.insertarPasajero(datos));
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
