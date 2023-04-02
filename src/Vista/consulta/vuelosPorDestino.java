package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vuelosPorDestino {

    private JPanel panel1;
    private JButton salirButton;
    private JButton aceptarButton;
    private JTable resultado;
    private JLabel error;
    private JTextField destino;

    public vuelosPorDestino() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("vuelosPorDestino");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    error.setText("");
                    Main.validarVacios(destino.getText());
                    String[][] filas = Main.mostrarTodosLosVuelos("select * from vuelos where destino = '" + destino.getText() +"'");
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
