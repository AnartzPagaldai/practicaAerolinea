package Controlador;

import Modelo.Pasajero;
import Modelo.TPasajeros;
import Modelo.TVuelos;
import Modelo.Vuelo;
import Vista.crudPasajero.*;
import Vista.crudPasajeros;
import Vista.crudVuelo.*;
import Vista.crudVuelos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Main {
    static JFrame crudVuelos = new JFrame("crud vuelos");
    static JFrame crudPasajeros = new JFrame("crud pasajeros");
    static JFrame crearVuelos = new JFrame("crear vuelos");
    static JFrame insertarPasajero = new JFrame("insertar pasajero");
    static JFrame actualizarPasajero = new JFrame("actualizar pasajero");
    static JFrame mostrarPasajero = new JFrame("mostrar pasajero");
    static JFrame eliminarPasajero = new JFrame("eliminar pasajero");
    static JFrame actualizarVuelo = new JFrame("actualizar vuelo");
    static JFrame mostrarVuelo = new JFrame("mostrarVuelo");

    static JFrame eliminarVuelo = new JFrame("eliminar vuelo");
    static JFrame mostrarTodosLosVuelos = new JFrame("mostrar todos los vuelos");

    static JFrame mostrarTodosLosPasajeros = new JFrame("mostrar todos los pasajeros");
    public static void main(String[] args) {
        crearVentana("crudVuelos");

    }
    public static void crearVentana(String nombreVista) {
        JFrame jFrame = null;
        JPanel panel1 = null;
        switch (nombreVista) {
            case "crudVuelos" -> {
                crudPasajeros.dispose();
                jFrame = crudVuelos ; panel1 = new crudVuelos().getPanel1();
            }
            case "crudPasajeros" -> {
                crudVuelos.dispose();
                jFrame = crudPasajeros; panel1 = new crudPasajeros().getPanel1();
            }
            case "crearVuelos" -> { jFrame = crearVuelos; panel1 = new crearVuelo().getPanel1(); }
            case "insertarPasajero" -> { jFrame = insertarPasajero; panel1 = new insertarPasajero().getPanel1(); }
            case "actualizarPasajero" -> { jFrame = actualizarPasajero; panel1 = new actualizarPasajero().getPanel1();}
            case "mostrarPasajero" -> { jFrame = mostrarPasajero; panel1 = new mostrarPasajero().getPanel1();}
            case "eliminarPasajero" -> { jFrame = eliminarPasajero; panel1 = new eliminarPasajero().getPanel1();}
            case "mostrarTodosLosPasajeros" -> { jFrame = mostrarTodosLosPasajeros; panel1 = new mostrarTodosLosPasajeros().getPanel1();}
            case "actualizarVuelo" -> { jFrame = actualizarVuelo; panel1 = new actualizarVuelo().getPanel1();}
            case "mostrarVuelo" -> { jFrame = mostrarVuelo; panel1 = new mostrarVuelo().getPanel1();}
            case "eliminarVuelo" -> { jFrame = eliminarVuelo; panel1 = new eliminarVuelo().getPanel1();}
            case "mostrarTodosLosVuelos" -> { jFrame = mostrarTodosLosVuelos; panel1 = new mostrarTodosLosVuelos().getPanel1();}
            //case "eliminarPasajero" -> { jFrame = eliminarPasajero; panel1 = new eliminarPasajero().getPanel1();}
        }
        jFrame.setContentPane(panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        //el los update molaria poner un boton para poder poner el valor por que tine ya
    }



    public static void dispose(String nombreVista) {
        switch (nombreVista) {
            case "crudVuelos" -> crudVuelos.dispose();
            case "crudPasajeros" -> crudPasajeros.dispose();
            case "crearVuelos" -> crearVuelos.dispose();
            case "insertarPasajero" -> insertarPasajero.dispose();
            case "actualizarPasajero" -> actualizarPasajero.dispose();
            case "eliminarPasajero" -> eliminarPasajero.dispose();
            case "mostrarTodosLosPasajeros" -> mostrarTodosLosPasajeros.dispose();
            case "mostrarPasajero" -> mostrarPasajero.dispose();
            case "actualizarVuelo" -> actualizarVuelo.dispose();
            case "mostrarVuelo" -> mostrarVuelo.dispose();
            case "eliminarVuelo" -> eliminarVuelo.dispose();
            case "mostrarTodosLosVuelos" -> mostrarTodosLosVuelos.dispose();
        }
    }

    public static String crearVuelo(String[] datos) throws Exception {
       Vuelo vuelo = new Vuelo(datos[0],transfomarYvalidarFecha(datos[1]),datos[2],datos[3],
                                Integer.parseInt(datos[4]),Integer.parseInt(datos[5]));
       if (!TVuelos.crearVuelo(vuelo)) {
           throw new Exception("ERROR no se a insertado el vuelo");
       }
       return "se insertado el vuelo";
    }

    public static void validarCodigo(String cod_vuelo, boolean consultarBase) throws Exception {
        if (validarPatrones(cod_vuelo, "[A-Z]{3}[0-9]-[0-9]{5}")) {
            throw new Exception("formato de codigo erroneo");
        }
        if (consultarBase) {
            if(!TVuelos.validarCodigo(cod_vuelo))
                throw new Exception("ese codigo no esta en la base de datos");
        }
    }
    public static void validarDni(String dni, boolean consultarBase) throws Exception {
        if (validarPatrones(dni, "[0-9]{8}[A-Z a-z]")) {
            throw new Exception("formato de dni erroneo");
        }
        if (consultarBase) {
            if(!TPasajeros.validarDni(dni))
                throw new Exception("ese dni no esta en la base de datos");
        }
    }

    public static boolean validarPatrones(String dato, String patron) {
        return !Pattern.compile(patron).matcher(dato).matches();
    }

    public static LocalDate transfomarYvalidarFecha(String fechaSalida) throws Exception {
        try {
            return LocalDate.parse(fechaSalida, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch (Exception e) {
            throw new Exception("fecha erronea");
        }
    }

    public static void validarVacios(String[] datos) throws Exception {
        for (String dato : datos) {
            if (dato.equals("")) {
                throw new Exception("no puede haber ningun canpo vacio");
            }
        }
    }

    public static String insertarPasajero(String[] datos) throws Exception{
        if (!TPasajeros.inserTarpasajero(new Pasajero(datos[0], datos[1]))) {
             throw new Exception("ERROR el pasajero no se a insrtardo");
        }
        return "se a insertado el pasajero";
    }

    public static String actualizarPasajero(String dni, String nombre) throws Exception {
        if (!TPasajeros.actualizarPasajero(new Pasajero(dni, nombre))){
            throw new Exception("ERROR el pasajero no se actualizado");
        }
        return "pasajero actualizado";
    }

    public static String mostrarPasajero(String dni) throws Exception{
        try {
            return TPasajeros.mostrarPasajero(dni).toString();
        }
        catch (Exception e) {
            throw new Exception("ERROR no se a podido selecionar\n" + e.getMessage());
        }

    }

    public static String eliminarPasajero(String dni) throws Exception{
        if (!TPasajeros.eliminarPasajero(dni)) {
            throw new Exception("ERROR el pasajero no se a elminado");
        }
        return "pasajero eliminado";
    }

    public static String[][] mostrarTodosLosPasajeros() throws Exception{
        ArrayList<Pasajero> pasajeros = TPasajeros.mostrarTodosLosPasajeros();
       if (pasajeros == null) {
            throw new Exception("ERROR no se a podido hace la selecion");
       }
        String[][] resultado = new String[pasajeros.size()][2];

       for (int i = 0; i < pasajeros.size(); i++) {
           resultado[i][0] = pasajeros.get(i).getDni();
           resultado[i][1] = pasajeros.get(i).getNombre();
       }

        return resultado;
    }

    public static String actualizarVuelo(String[] datos) throws Exception{

        Vuelo vuelo = new Vuelo(datos[0],transfomarYvalidarFecha(datos[1]),datos[2],datos[3],Integer.parseInt(datos[4]),Integer.parseInt(datos[5]));

        if (!TVuelos.actualizarVuelo(vuelo)) {
            throw new Exception("ERROR no se a podido actualizar el vuelo");
        }
        return "vuelo actualizado";

    }

    public static String[] mostrarVuelo(String cod_vuelo) throws Exception {
        Vuelo vuelo = TVuelos.mostrarVuelo(cod_vuelo);
        if (vuelo != null) {
            return new String[]{
                    vuelo.getCod_vuelo(),
                    String.valueOf(vuelo.getFechaSalida()),vuelo.getDestino(),
                    vuelo.getProcedencia(), String.valueOf(vuelo.getPlazaTurista()),
                    String.valueOf(vuelo.getPlazaPrimera())
            };
        } else {
            throw new Exception("Error no se a podido selecionar");
        }
    }

    public static void annadirColumnas(DefaultTableModel model, String[] columnas) {
        for (String columna : columnas) {
            model.addColumn(columna);
        }
    }

    public static void annadirFilas(DefaultTableModel model, String[] columanas, String[][] filas) {
        model.addRow(columanas);
        for (String[] fila : filas) {
            model.addRow(fila);
        }
    }

    public static String eliminarVuelo(String cod_vuelo) throws Exception {
        if (!TVuelos.eliminarVuelo(cod_vuelo)) {
            throw new Exception("ERROR");
        }
        return "Vuelo eliminado";
    }

    public static String[][] mostrarTodosLosVuelos() throws Exception {
        ArrayList<Vuelo> vuelos = TVuelos.mostrarTodosLosVuelos();
        String[][] resultado = new String[vuelos.size()][6];
        if (vuelos == null) {
            throw new Exception("ERROR no se an selecianado los vuelos");
        }
        for (int i = 0; i < vuelos.size(); i++) {
            resultado[i][0] = vuelos.get(i).getCod_vuelo();
            resultado[i][1] = String.valueOf(vuelos.get(i).getFechaSalida());
            resultado[i][2] = vuelos.get(i).getDestino();
            resultado[i][3] = vuelos.get(i).getProcedencia();
            resultado[i][4] = String.valueOf(vuelos.get(i).getPlazaTurista());
            resultado[i][5] = String.valueOf(vuelos.get(i).getPlazaPrimera());

        }
        return resultado;
    }
}