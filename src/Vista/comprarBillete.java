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
    private JComboBox destinoComboBox;
    private JComboBox pasajerosComboBox;
    private JComboBox procedenciaComboBox;
    private JComboBox fechaSalidaComboBox;
    private JComboBox vueloComboBox;

    public JPanel getPanel1() {
        return panel1;
    }

    public comprarBillete() {
        comboBoxEnable(false);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(turistaRadioButton);
        grupo.add(primeraRadioButton);
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("comprarBillete");
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Main.resitarBillete();
            }
        });
        turistaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxEnable(true);
            }
        });
        primeraRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxEnable(true);
            }
        });
    }
    public void comboBoxEnable(boolean bool) {
        destinoComboBox.setEnabled(bool);
        procedenciaComboBox.setEnabled(bool);
        fechaSalidaComboBox.setEnabled(bool);
    }
}
