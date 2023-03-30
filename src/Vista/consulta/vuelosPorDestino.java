package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vuelosPorDestino {

    private JPanel panel1;
    private JButton salirButton;
    private JButton aceptarButton;

    public vuelosPorDestino() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("vuelosPorDestino");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
