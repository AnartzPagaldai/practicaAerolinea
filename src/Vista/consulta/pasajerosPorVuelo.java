package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pasajerosPorVuelo {
    private JButton salirButton;
    private JButton aceptarButton;
    private JPanel panel1;
    private JTextField cod_vuelo;
    private JTable resultado;
    private JLabel error;

    public pasajerosPorVuelo() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("pasajerosPorVuelo");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    error.setText("");
                    Main.validarVacios(cod_vuelo.getText());
                    Main.validarCodigo(cod_vuelo.getText(), true);
                    String[][] filas = Main.pasajerosPorVuelo(cod_vuelo.getText());
                    DefaultTableModel model = new DefaultTableModel();
                    Main.annadirColumnasYfilas(model, new String[]{"DNI", "NOMBRE", "PLAZA"}, filas);
                    resultado.setModel(model);
                }
                catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

}
