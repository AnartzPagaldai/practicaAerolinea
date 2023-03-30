package Vista.crudVuelo;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class actualizarVuelo {
    private JTextField cod_vuelo;
    private JTextField fechaSalida;
    private JTextField destino;
    private JTextField procedencia;
    private JSpinner plazasTurista;
    private JSpinner plazasPrimera;
    private JButton aceptarButton;
    private JButton salirButton;
    private JTextArea resultado;
    private JPanel panel1;
    private JCheckBox checkBoxfecha;
    private JCheckBox checkBoxDestino;
    private JCheckBox checkBoxProcedencia;
    private JCheckBox checkBoxTurista;
    private JCheckBox checkBoxPrimera;
    private JPanel panelActualizar;
    JCheckBox[] checkBoxes = {checkBoxfecha, checkBoxDestino, checkBoxProcedencia, checkBoxPrimera, checkBoxTurista};

    String[] datos2;
    public actualizarVuelo() {
        fechaSalida.setEnabled(false);
        destino.setEnabled(false);
        procedencia.setEnabled(false);
        plazasPrimera.setEnabled(false);
        plazasTurista.setEnabled(false);
        aceptarButton.setEnabled(false);
        setEnableCheckBox(false);
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("actualizarVuelo");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText("");
                try {
                    String[] datos = {cod_vuelo.getText().trim(),fechaSalida.getText().trim(),destino.getText().trim(),
                            procedencia.getText().trim(),plazasTurista.getValue().toString().trim(),plazasPrimera.getValue().toString().trim()};
                    Main.validarVacios(datos);
                    Main.validarCodigo(datos[0], true);
                    resultado.setText(Main.actualizarVuelo(datos));
                }
                catch (Exception e1) {
                    resultado.setText(e1.getMessage());
                }
            }
        });

        cod_vuelo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Main.validarCodigo(cod_vuelo.getText(),true);
                    datos2 = Main.mostrarVuelo(cod_vuelo.getText());
                    fechaSalida.setText(LocalDate.parse(datos2[1], DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    destino.setText(datos2[2]);
                    procedencia.setText(datos2[3]);
                    plazasPrimera.setValue(Integer.parseInt(datos2[4]));
                    plazasTurista.setValue(Integer.parseInt(datos2[5]));
                    resultado.setText("");
                    aceptarButton.setEnabled(true);
                    setEnableCheckBox(true);
                } catch (Exception ex) {
                    resultado.setText(ex.getMessage());
                }
            }
        });
        checkBoxfecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fnCheckbox(fechaSalida, checkBoxfecha.isSelected(), 1);
            }
        });
        checkBoxDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fnCheckbox(destino, checkBoxDestino.isSelected(), 2);
            }
        });
        checkBoxProcedencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fnCheckbox(procedencia, checkBoxProcedencia.isSelected(), 3);
            }
        });
        checkBoxTurista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fnCheckboxSpinner(plazasTurista, checkBoxTurista.isSelected(), 4);
            }
        });
        checkBoxPrimera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fnCheckboxSpinner(plazasPrimera, checkBoxPrimera.isSelected(), 5);
            }
        });
    }

    public void fnCheckbox(JTextField label, boolean bool, int posiscion) {
        label.setEnabled(bool);
        label.setText((bool)? "": datos2[posiscion]);
    }
    public void fnCheckboxSpinner(JSpinner label, boolean bool, int posiscion) {
        label.setEnabled(bool);
        label.setValue((bool)? 0: Integer.parseInt(datos2[posiscion]));
    }
    public JPanel getPanel1() {
        return panel1;
    }
    public void setEnableCheckBox(boolean bool) {
        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setEnabled(bool);
        }
    }
}
