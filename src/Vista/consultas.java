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
    private JButton vuelosPorDestinoPlazasLibresButton;
    private JButton vuelosPorFechaPlazasLibresButton;
    private JButton vuelosPorPasajeroButton;
    private JButton pasajerosPorVueloButton;
    private JButton comprarBilleteButton;

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
        vuelosPorDestinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("vuelosPorDestino");
            }
        });
        vuelosPorOrigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("vuelosPorOrigen");
            }
        });
        vuelosPorDestinoPlazasLibresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("vuelosPorDestinoPlazasLibres");
            }
        });
        vuelosPorFechaPlazasLibresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("vuelosPorFechaPlazasLibres");
            }
        });
        vuelosPorPasajeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("vuelosPorPasajero");
            }
        });
        pasajerosPorVueloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("pasajerosPorVuelo");
            }
        });
        comprarBilleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("comprarBillete");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
