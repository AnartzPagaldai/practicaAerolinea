package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class crudPasajeros {
    private JPanel panel1;
    private JButton salirButton;
    private JButton crudVuelosButton;
    private JButton crudPasajerosButton;
    private JButton consultasButton;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton mostrarPasajeroButton;
    private JButton eliminarPasajeroButton;
    private JButton mostrarTodosLosPasajerosButton;
    private JButton comprarBilleteButton;

    public crudPasajeros() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("crudPasajeros");
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
                Main.crearVentana("insertarPasajero");
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("actualizarPasajero");
            }
        });
        mostrarPasajeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("mostrarPasajero");
            }
        });
        eliminarPasajeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("eliminarPasajero");
            }
        });
        mostrarTodosLosPasajerosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentana("mostrarTodosLosPasajeros");
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
