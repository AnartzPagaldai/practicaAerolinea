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
    ActionListener acionComBox;
    ActionListener acionVuelo;

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
        vueloComboBox.addItem(""); vueloComboBox.setSelectedItem("");
        registraBillete();
        //TODO CAMBIAR NOMBRE A RESGISTRARBILLETE Y HACER UNA VALIDACION DE QUE ESE PASAJERO YA TIENE PLAZA EN ESE VUELO
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
        acionComBox = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registraBillete();
            }
        };
        destinoComboBox.addActionListener(acionComBox);
        procedenciaComboBox.addActionListener(acionComBox);
        fechaSalidaComboBox.addActionListener(acionComBox);
        acionVuelo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!primeraRadioButton.isSelected() && !turistaRadioButton.isSelected()) {
                    turistaRadioButton.setSelected(true);
                }
                registraBillete();
                removAction();
                fechaSalidaComboBox.setSelectedIndex(1);
                destinoComboBox.setSelectedIndex(1);
                procedenciaComboBox.setSelectedIndex(1);
                addAction();
                comboBoxEnable(true);
            }
        };
        vueloComboBox.addActionListener(acionVuelo);
    }
    public void registraBillete() {
        try {
            String destinoElegino = (String) destinoComboBox.getSelectedItem();
            String procedenciaElegida = (String) procedenciaComboBox.getSelectedItem();
            String fechaElegida = (String) fechaSalidaComboBox.getSelectedItem();
            String vueloElegino = (String) vueloComboBox.getSelectedItem();
            String[][] vuelos = Main.registrarBillete((primeraRadioButton.isSelected())? "plazasPrimera" : "plazasTuristas",
                    destinoElegino, procedenciaElegida, fechaElegida, vueloElegino);
            removAction();
            rellenarComboBox(destinoComboBox, vuelos, 2, destinoElegino);
            rellenarComboBox(procedenciaComboBox, vuelos, 3, procedenciaElegida);
            rellenarComboBox(fechaSalidaComboBox, vuelos, 1, fechaElegida);
            rellenarComboBox(vueloComboBox, vuelos, 0, vueloElegino);
            addAction();
        }
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage() + "\n quieres seguir con los datos ya guardados o con el tipo de plaza " + ((primeraRadioButton.isSelected())? "primera" : "turista"));
        }

    }
    public void rellenarComboBox(JComboBox<String> comboBox, String[][] datos, int posicionDato, String item) {
        int length = comboBox.getItemCount();
        for (int i = 1; i < length; i++) {
            comboBox.removeItemAt(1);
        }
        for (String[] dato : datos) {
            comboBox.addItem(dato[posicionDato]);
        }
        comboBox.setSelectedItem(item);
    }
    public void comboBoxEnable(boolean bool) {
        destinoComboBox.setEnabled(bool);
        procedenciaComboBox.setEnabled(bool);
        fechaSalidaComboBox.setEnabled(bool);
    }
    public void removAction() {
        destinoComboBox.removeActionListener(acionComBox);
        procedenciaComboBox.removeActionListener(acionComBox);
        fechaSalidaComboBox.removeActionListener(acionComBox);
        vueloComboBox.removeActionListener(acionVuelo);
    }

    public void addAction() {
        destinoComboBox.addActionListener(acionComBox);
        procedenciaComboBox.addActionListener(acionComBox);
        fechaSalidaComboBox.addActionListener(acionComBox);
        vueloComboBox.addActionListener(acionVuelo);
    }
}
