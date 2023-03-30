package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
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
                    Main.validarVacios(cod_vuelo.getText());
                    Main.validarCodigo(cod_vuelo.getText(), true);

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
