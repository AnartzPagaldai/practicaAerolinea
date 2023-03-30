package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vuelosPorDestinoPlazarLibres {
    private JButton salirButton;
    private JButton aceptarButton;
    private JPanel panel1;
    private JTable resultado;
    private JLabel error;

    public vuelosPorDestinoPlazarLibres() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("vuelosPorDestinoPlazasLibres");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
