package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vuelosPorFechaPlazasLibres {
    private JButton salirButton;
    private JButton aceptarButton;
    private JPanel panel1;

    public vuelosPorFechaPlazasLibres() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("vuelosPorFechaPlazasLibres");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
