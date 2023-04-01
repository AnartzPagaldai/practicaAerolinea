package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class comprarBillete {
    private JPanel panel1;
    private JButton aceptarButton;
    private JButton salirButton;
    private JRadioButton turistaRadioButton;
    private JRadioButton primeraRadioButton;
    private JComboBox<String> destinoComboBox;
    private JComboBox<String> pasajerosComboBox;
    private JComboBox<String> procedenciaComboBox;
    private JComboBox<String> fechaSalidaComboBox;
    private JComboBox<String> vueloComboBox;

    public JPanel getPanel1() {
        return panel1;
    }

    public comprarBillete() {
        comboBoxEnable(false);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(turistaRadioButton);
        grupo.add(primeraRadioButton);
        destinoComboBox.addItem(""); destinoComboBox.setSelectedItem("");
        procedenciaComboBox.addItem(""); procedenciaComboBox.setSelectedItem("");
        fechaSalidaComboBox.addItem(""); fechaSalidaComboBox.setSelectedItem("");

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("comprarBillete");
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        turistaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxEnable(true);
                registraBillete();
            }
        });
        primeraRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxEnable(true);
                registraBillete();
            }
        });
        destinoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registraBillete();
            }
        });
        procedenciaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registraBillete();
            }
        });
        fechaSalidaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registraBillete();
            }
        });
    }
    public void registraBillete() {
        String[][] vuelos = Main.registrarBillete((turistaRadioButton.isSelected())? "plazasTuristas" : "plazasPrimera",
                (String) destinoComboBox.getSelectedItem(), (String) procedenciaComboBox.getSelectedItem(),(String) fechaSalidaComboBox.getSelectedItem());
        rellenarComboBox(destinoComboBox, vuelos, 2);
        rellenarComboBox(procedenciaComboBox, vuelos, 3);
        rellenarComboBox(fechaSalidaComboBox, vuelos, 1);
    }
    public void rellenarComboBox(JComboBox<String> comboBox, String[][] datos, int posicionDato) {
        comboBox.removeAllItems();
        comboBox.addItem("");
        for (String[] dato : datos) {
            comboBox.addItem(dato[posicionDato]);
        }
    }
    public void comboBoxEnable(boolean bool) {
        destinoComboBox.setEnabled(bool);
        procedenciaComboBox.setEnabled(bool);
        fechaSalidaComboBox.setEnabled(bool);
    }
}
