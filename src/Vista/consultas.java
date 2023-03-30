package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultas {
    private JButton salirButton;
    private JButton crudVuelosButton;
    private JButton crudPasajerosButton;
    private JButton consultasButton;
    private JPanel panel1;
    private JButton vuelosPorDestinoButton;
    private JButton vuelosPorOrigenButton;
    private JButton vuelosPorDestinoConButton;
    private JButton vuelosPorFechaConButton;
    private JButton vuelosPorPasajeroButton;
    private JButton listaDePsajerosPorButton;

    public consultas() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("consultas");
            }
        });
        crudVuelosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("crudVuelos");
            }
        });
        crudPasajerosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("crudPasajeros");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
