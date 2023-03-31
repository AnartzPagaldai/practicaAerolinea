package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class crudVuelos {
    private JPanel panel1;
    private JButton salirButton;
    private JButton crudVuelosButton;
    private JButton crudPasajerosButton;
    private JButton consultasButton;
    private JButton crearButton;
    private JButton artualizarButton;
    private JButton mostrarVueloButton;
    private JButton eliminarVueloButton;
    private JButton mostrarTodosLosVuelosButton;
    private JButton comprarBilleteButton;

    public crudVuelos() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("crudVuelos");
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
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("crearVuelos");
            }
        });
        artualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("actualizarVuelo");
            }
        });
        mostrarVueloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("mostrarVuelo");
            }
        });
        eliminarVueloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("eliminarVuelo");
            }
        });
        mostrarTodosLosVuelosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("mostrarTodosLosVuelos");
            }
        });
        consultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("consultas");
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
