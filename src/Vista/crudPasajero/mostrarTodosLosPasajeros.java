package Vista.crudPasajero;

import Controlador.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mostrarTodosLosPasajeros {
    private JTable resultado;
    private JPanel panel1;
    private JButton salirButton;
    private JLabel error;

    public mostrarTodosLosPasajeros() {
        rellenarTabla();

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("mostrarTodosLosPasajeros");
            }
        });
    }
    public void rellenarTabla() {
        try {
            error.setText("");
            String[][] filas = Main.mostrarTodosLosPasajeros();
            DefaultTableModel modelo = new DefaultTableModel();
            String[] columanas = {"DNI", "NOMBRE"};
            Main.annadirColumnas(modelo, columanas);
            Main.annadirFilas(modelo, columanas, filas);
            resultado.setModel(modelo);
        } catch (Exception e) {
            error.setText(e.getMessage());
        }
    }
    public JPanel getPanel1() {
        return panel1;
    }
}
