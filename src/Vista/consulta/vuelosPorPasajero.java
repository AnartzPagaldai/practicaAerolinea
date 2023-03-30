package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vuelosPorPasajero {
    private JButton salirButton;
    private JButton aceptarButton;
    private JPanel panel1;

    public vuelosPorPasajero() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("vuelosPorPasajero");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
