package Vista.consulta;

import Controlador.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vuelosPorFechaPlazasLibres {
    private JButton salirButton;
    private JButton aceptarButton;
    private JPanel panel1;
    private JTable resultado;
    private JLabel error;
    private JTextField fecha;
    private JRadioButton turistaRadioButton;
    private JRadioButton primeraRadioButton;

    public vuelosPorFechaPlazasLibres() {
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(turistaRadioButton);
        grupo.add(primeraRadioButton);
        turistaRadioButton.setSelected(true);
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose("vuelosPorFechaPlazasLibres");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    error.setText("");
                    Main.validarVacios(fecha.getText());
                    Main.transfomarYvalidarFecha(fecha.getText());
                    String tipo = (turistaRadioButton.isSelected())? "plazasTuristas" : "plazasPrimera";
                    String [][] filas = Main.mostrarTodosLosVuelos("select * from vuelos where fechaSalida =  STR_TO_DATE('"+fecha.getText()+"', '%d/%m/%Y') " +
                            "and 0 < " + tipo + " - (select count(*) from registroVuelos where cod_vuelo = vuelos.cod_vuelo and lower(tipoPlaza) = '" + tipo + "')");
                    DefaultTableModel model = new DefaultTableModel();
                    Main.annadirColumnasYfilas(model, new String[]{
                                    "CODIGO DEL VUELO", "FECHA DE SALIDA", "DESTINO", "PROCEDENCIA", "PLAZAS TURISTA", "PLAZAS PRIMERA"}
                            , filas);
                    resultado.setModel(model);
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
