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
    private JLabel resultado;
    ActionListener acionComBox;
    ActionListener acionVuelo;

    public JPanel getPanel1() {
        return panel1;
    }

    public comprarBillete() {
        turistaRadioButton.setSelected(true);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(turistaRadioButton);
        grupo.add(primeraRadioButton);
        destinoComboBox.addItem(""); destinoComboBox.setSelectedItem("");
        procedenciaComboBox.addItem(""); procedenciaComboBox.setSelectedItem("");
        fechaSalidaComboBox.addItem(""); fechaSalidaComboBox.setSelectedItem("");
        vueloComboBox.addItem(""); vueloComboBox.setSelectedItem("");
        filtrarVuelos();
        try {
            rellenarPasajeros(Main.mostrarTodosLosPasajeros());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("comprarBillete");
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarBillete(true);
            }
        });
        turistaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarVuelos();
            }
        });
        primeraRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarVuelos();
            }
        });
        acionComBox = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarVuelos();
                if (String.valueOf(fechaSalidaComboBox.getSelectedItem()).equals("") ||
                        String.valueOf(destinoComboBox.getSelectedItem()).equals("") ||
                        String.valueOf(procedenciaComboBox.getSelectedItem()).equals("")) {
                    vueloComboBox.setSelectedItem("");
                }
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
                filtrarVuelos();
                removAction();
                if (!String.valueOf(vueloComboBox.getSelectedItem()).equals("")) {
                    fechaSalidaComboBox.setSelectedIndex(1);
                    destinoComboBox.setSelectedIndex(1);
                    procedenciaComboBox.setSelectedIndex(1);
                }
                addAction();
            }
        };
        vueloComboBox.addActionListener(acionVuelo);
    }
    public void filtrarVuelos() {
        try {
            String destinoElegino = (String) destinoComboBox.getSelectedItem();
            String procedenciaElegida = (String) procedenciaComboBox.getSelectedItem();
            String fechaElegida = (String) fechaSalidaComboBox.getSelectedItem();
            String vueloElegino = (String) vueloComboBox.getSelectedItem();
            String[][] vuelos = Main.filtrarVuelos((primeraRadioButton.isSelected())? "plazasPrimera" : "plazasTuristas",
                    destinoElegino, procedenciaElegida, fechaElegida, vueloElegino);
            if (vuelos[0] == null && vuelos[1] == null && vuelos[2] == null && vuelos[3] == null )
                throw new Exception("no hay plazas libres con esas espcificaciones");
            removAction();
            rellenarComboBox(destinoComboBox, vuelos, 2, destinoElegino);
            rellenarComboBox(procedenciaComboBox, vuelos, 3, procedenciaElegida);
            rellenarComboBox(fechaSalidaComboBox, vuelos, 1, fechaElegida);
            rellenarComboBox(vueloComboBox, vuelos, 0, vueloElegino);
            addAction();
        }
        catch (Exception e) {
            if (1 == JOptionPane.showConfirmDialog(null, "no hay plazas libres con esas espcificaciones\n ¿quieres seguir con los datos ya guardados?")) {
                removAction();
                vaciarCombox();
                addAction();
                filtrarVuelos();
            } else {
                (primeraRadioButton.isSelected()? turistaRadioButton : primeraRadioButton).setSelected(true);
            }
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
    public void rellenarPasajeros(String[][] datos) {
        for (String[] dato : datos) {
            pasajerosComboBox.addItem(dato[0] + "    " + dato[1]);
        }
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

    public void registrarBillete(boolean bool) {
        try {
            resultado.setText("");
            if (bool) Main.validarPasajeroMismoVuelo(String.valueOf(pasajerosComboBox.getSelectedItem()).substring(0,9), (String) vueloComboBox.getSelectedItem());
            resultado.setText(Main.registrarBillete(
                    String.valueOf(pasajerosComboBox.getSelectedItem()).substring(0,9),
                    (String) vueloComboBox.getSelectedItem(), (primeraRadioButton.isSelected())? "plazasPrimera" : "plazasTuristas"));
        } catch (Exception ex) {
            if (ex.getMessage().equals("mismo")){
                if (0 == JOptionPane.showConfirmDialog(null, "ese pasajero ya tiene asiento en ese vuelo\n" +
                        "¿seguro que quieres comprar el billete para el mismo?")) {
                    registrarBillete(false);
                }
            }
            else
                resultado.setText(ex.getMessage());

        }

    }
    public void vaciarCombox() {
        destinoComboBox.setSelectedItem("");
        procedenciaComboBox.setSelectedItem("");
        fechaSalidaComboBox.setSelectedItem("");
        vueloComboBox.setSelectedItem("");
    }
}
