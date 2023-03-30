package Vista.crudVuelo;

import Controlador.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mostrarTodosLosVuelos {
    private JButton salirButton;
    private JTable resultado;
    private JPanel panel1;
    private JTextArea error;

    public mostrarTodosLosVuelos() {
        String[] columanas = {
                "CODIGO DEL VUELO", "FECHA DE SALIDA", "DESTINO", "PROCEDENCIA", "PLAZAS TURISTA", "PLAZAS PRIMERA"
        };
        DefaultTableModel model = new DefaultTableModel();
        try {
            String[][] filas = Main.mostrarTodosLosVuelos();
            Main.annadirColumnas(model, columanas);
            Main.annadirFilas(model, columanas, filas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resultado.setModel(model);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("mostrarTodosLosVuelos");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}