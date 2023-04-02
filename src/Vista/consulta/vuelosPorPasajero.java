package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vuelosPorPasajero {
    private JButton salirButton;
    private JButton aceptarButton;
    private JPanel panel1;
    private JTable resultado;
    private JLabel error;
    private JTextField dni;

    public vuelosPorPasajero() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("vuelosPorPasajero");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    error.setText("");
                    Main.validarVacios(dni.getText());
                    Main.validarDni(dni.getText(), true);
                    String[][] filas = Main.vuelosPorPasajero(dni.getText());
                    DefaultTableModel model = new DefaultTableModel();
                    Main.annadirColumnasYfilas(model, new String[]{
                                    "CODIGO DEL VUELO", "FECHA DE SALIDA", "DESTINO", "PROCEDENCIA", "PLAZAS TURISTA", "PLAZAS PRIMERA"}
                            , filas);
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
