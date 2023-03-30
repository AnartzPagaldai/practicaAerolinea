package Vista.crudVuelo;

import Controlador.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mostrarVuelo {

    private JTextField cod_vuelo;
    private JButton aceptarButton;
    private JButton salirButton;
    private JPanel panel1;
    private JTable resultado;
    private JLabel error;

    public mostrarVuelo() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("mostrarVuelo");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    error.setText("");
                    Main.validarCodigo(cod_vuelo.getText(), true);
                    String[] datos = Main.mostrarVuelo(cod_vuelo.getText());
                    DefaultTableModel model = new DefaultTableModel();
                    String[] columanas = {
                            "CODIGO DEL VUELO", "FECHA DE SALIDA", "DESTINO", "PROCEDENCIA", "PLAZAS TURISTA", "PLAZAS PRIMERA"
                    };
                    Main.annadirColumnas(model, columanas);
                    Main.annadirFilas(model, columanas, new String[][]{datos});
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
