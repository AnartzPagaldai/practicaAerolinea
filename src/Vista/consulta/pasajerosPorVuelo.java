package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pasajerosPorVuelo {
    private JButton salirButton;
    private JButton aceptarButton;
    private JPanel panel1;

    public pasajerosPorVuelo() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("pasajerosPorVuelo");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

}
