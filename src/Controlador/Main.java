package Controlador;

import Modelo.*;

import Vista.*;
import Vista.crudPasajero.*;
import Vista.crudVuelo.*;
import Vista.consulta.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
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
    static JFrame mostrarVuelo = new JFrame("mostrar vuelo");

    static JFrame eliminarVuelo = new JFrame("eliminar vuelo");
    static JFrame mostrarTodosLosVuelos = new JFrame("mostrar todos los vuelos");

    static JFrame mostrarTodosLosPasajeros = new JFrame("mostrar todos los pasajeros");

    static JFrame vuelosPorDestino = new JFrame("vuelos por destino");
    static JFrame vuelosPorOrigen = new JFrame("vuelos por origen");
    static JFrame vuelosPorDestinoPlazasLibres = new JFrame("vuelos por destino con plazas libres");
    static JFrame vuelosPorFechaPlazasLibres = new JFrame("vuelos por fecha con plazas libres");
    static JFrame vuelosPorPasajero = new JFrame("vuelos por pasajero");
    static JFrame pasajerosPorVuelo = new JFrame("pasajeros por vuelo");

    static JFrame consultas = new JFrame("consultas");

    static JFrame comprarBillete = new JFrame("comprarBillete");
    public static void main(String[] args) {
        crearVentana("crudVuelos");

    }
    public static void crearVentana(String nombreVista) {
        JFrame jFrame = null;
        JPanel panel1 = null;
        switch (nombreVista) {
            case "crudVuelos" -> {
                crudPasajeros.dispose(); consultas.dispose();
                jFrame = crudVuelos ; panel1 = new crudVuelos().getPanel1();
            }
            case "crudPasajeros" -> {
                crudVuelos.dispose(); consultas.dispose();
                jFrame = crudPasajeros; panel1 = new crudPasajeros().getPanel1();
            }
            case "consultas" -> {
                crudVuelos.dispose(); crudPasajeros.dispose();
                jFrame = consultas; panel1 = new consultas().getPanel1();
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
            case "vuelosPorDestino" -> { jFrame = vuelosPorDestino; panel1 = new vuelosPorDestino().getPanel1();}
            case "vuelosPorOrigen" -> { jFrame = vuelosPorOrigen; panel1 = new vuelosPorOrigen().getPanel1();}
            case "vuelosPorDestinoPlazasLibres" -> { jFrame = vuelosPorDestinoPlazasLibres; panel1 = new vuelosPorDestinoPlazarLibres().getPanel1();}
            case "vuelosPorFechaPlazasLibres" -> { jFrame = vuelosPorFechaPlazasLibres; panel1 = new vuelosPorFechaPlazasLibres().getPanel1();}
            case "vuelosPorPasajero" -> { jFrame = vuelosPorPasajero; panel1 = new vuelosPorPasajero().getPanel1();}
            case "pasajerosPorVuelo" -> { jFrame = pasajerosPorVuelo; panel1 = new pasajerosPorVuelo().getPanel1();}
            case "comprarBillete" -> { jFrame = comprarBillete; panel1 = new comprarBillete().getPanel1(); }
        }
        jFrame.setContentPane(panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }



    public static void dispose(String nombreVista) {
        switch (nombreVista) {
            case "crudVuelos" -> crudVuelos.dispose();
            case "crudPasajeros" -> crudPasajeros.dispose();
            case "consultas" -> consultas.dispose();
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
            case "vuelosPorDestino" -> vuelosPorDestino.dispose();
            case "vuelosPorOrigen" -> vuelosPorOrigen.dispose();
            case "vuelosPorDestinoPlazasLibres" -> vuelosPorDestinoPlazasLibres.dispose();
            case "vuelosPorFechaPlazasLibres" -> vuelosPorFechaPlazasLibres.dispose();
            case "vuelosPorPasajero" -> vuelosPorPasajero.dispose();
            case "pasajerosPorVuelo" -> pasajerosPorVuelo.dispose();
            case "comprarBillete" -> comprarBillete.dispose();
        }
    }

    public static String crearVuelo(String[] datos) throws Exception {
       Vuelo vuelo = new Vuelo(datos[0],transfomarYvalidarFecha(datos[1]),datos[2],datos[3],
                                Integer.parseInt(datos[4]),Integer.parseInt(datos[5]));
       return errorYreturn(!TVuelos.crearVuelo(vuelo),
               "ERROR no se a insertado el vuelo", "se insertado el vuelo");
    }

    public static void validarCodigo(String cod_vuelo, boolean consultarBase) throws Exception {
        lazarError(validarPatrones(cod_vuelo, "[A-Z]{3}[0-9]-[0-9]{5}"),"formato de codigo erroneo");
        if (consultarBase) {
            lazarError(!TVuelos.validarCodigo(cod_vuelo), "ese codigo no esta en la base de datos");
        }
    }
    public static void validarDni(String dni, boolean consultarBase) throws Exception {
        lazarError(validarPatrones(dni, "[0-9]{8}[A-Z a-z]"), "formato de dni erroneo");
        if (consultarBase) {
            lazarError(!TPasajeros.validarDni(dni), "ese dni no esta en la base de datos");
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
            validarVacios(dato);
        }
    }
    public static void validarVacios(String dato) throws Exception {
        lazarError(dato.equals(""), "no puede haber ningun campo vacio");
    }

    public static String insertarPasajero(String[] datos) throws Exception{
        return errorYreturn(!TPasajeros.inserTarpasajero(new Pasajero(datos[0], datos[1])),
                "ERROR el pasajero no se a insrtardo", "se a insertado el pasajero");
    }

    public static String actualizarPasajero(String dni, String nombre) throws Exception {
        return errorYreturn(!TPasajeros.actualizarPasajero(new Pasajero(dni, nombre)),
                "ERROR el pasajero no se a actualizado", "pasajero actualizado");
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
        return errorYreturn(!TPasajeros.eliminarPasajero(dni),
                "ERROR el pasajero no se a elminado", "pasajero eliminado");
    }

    public static String[][] mostrarTodosLosPasajeros() throws Exception{
        ArrayList<Pasajero> pasajeros = TPasajeros.mostrarTodosLosPasajeros();
        return devolverDatosDeObjeto(pasajeros, "ERROR no se a podido hace la selecion", 2);
    }

    public static String actualizarVuelo(String[] datos) throws Exception{
        Vuelo vuelo = new Vuelo(datos[0],transfomarYvalidarFecha(datos[1]),datos[2],datos[3],Integer.parseInt(datos[4]),Integer.parseInt(datos[5]));

        return errorYreturn(!TVuelos.actualizarVuelo(vuelo),
                "ERROR no se a podido actualizar el vuelo", "vuelo actualizado");
    }

    public static String[] mostrarVuelo(String cod_vuelo) throws Exception {
        Vuelo vuelo = TVuelos.mostrarVuelo(cod_vuelo);
        lazarError(vuelo == null, "ERROR");
        return arrayDeVuelos(vuelo);
    }

    public static void annadirColumnasYfilas(DefaultTableModel model, String[] columnas, String[][] filas) {
        for (String columna : columnas) {
            model.addColumn(columna);
        }
        model.addRow(columnas);
        for (String[] fila : filas) {
            model.addRow(fila);
        }
    }

    public static String eliminarVuelo(String cod_vuelo) throws Exception {
        return errorYreturn(!TVuelos.eliminarVuelo(cod_vuelo), "ERROR", "Vuelo eliminado");
    }

    public static String errorYreturn(boolean bool, String error, String mensajeRetorno) throws Exception {
        lazarError(bool, error);
        return mensajeRetorno;
    }
    public static void lazarError(boolean bool, String error) throws Exception {
        if (bool) {
            throw new Exception(error);
        }
    }

    public static String[][] mostrarTodosLosVuelos() throws Exception {
        ArrayList<Vuelo> vuelos = TVuelos.mostrarTodosLosVuelos();
        return devolverDatosDeObjeto(vuelos, "ERROR no se an selecianado los vuelos", 6);
    }

    public static <T> String[][] devolverDatosDeObjeto(ArrayList<T> objeto, String error, int num) throws Exception {
        lazarError(objeto == null, error);

        String[][] resultado = new String[objeto.size()][num];
        if ( num == 6 ) {
            ArrayList<Vuelo> vuelos = (ArrayList<Vuelo>) objeto;
            for (int i = 0; i < objeto.size(); i++) {
                resultado[i] = arrayDeVuelos(vuelos.get(i));
            }
        }
        else if (num == 2 || num == 3) {
            ArrayList<Pasajero> pasajeros = (ArrayList<Pasajero>) objeto;
            for (int i = 0; i < pasajeros.size(); i++) {
                resultado[i][0] = pasajeros.get(i).getDni();
                resultado[i][1] = pasajeros.get(i).getNombre();
            }
        }
        return resultado;
    }
    public static String[] arrayDeVuelos(Vuelo vuelo) {
        return new String[]{
                vuelo.getCod_vuelo(),
                String.valueOf(vuelo.getFechaSalida()),vuelo.getDestino(),
                vuelo.getProcedencia(), String.valueOf(vuelo.getPlazaTurista()),
                String.valueOf(vuelo.getPlazaPrimera())
        };
    }

    public static String[][] pasajerosPorVuelo(String cod_vuelo) throws Exception {
        ArrayList<Pasajero> pasajeros = TRegistroVuelos.pasajerosPorVuelo(cod_vuelo);
        System.out.println(pasajeros);

        String[][] datosVuelos = devolverDatosDeObjeto(pasajeros, "Error", 3);
        ArrayList<String> plazas = TRegistroVuelos.getTipoPlaza();
        for (int i = 0; i < datosVuelos.length; i++) {
            datosVuelos[i][2] = plazas.get(i);
        }

        return datosVuelos;
    }

    public static Vuelo getVuelo(ResultSet result) throws Exception {
         return new Vuelo(
                result.getString("cod_vuelo"),
                result.getDate("fechaSalida").toLocalDate(),
                result.getString("destino"),
                result.getString("procedencia"),
                result.getInt("plazasTuristas"),
                result.getInt("plazasPrimera")
        );
    }

    public static String[][] registrarBillete(String tipo, String destino, String procedencia, String fecha) {
        StringBuilder select = new StringBuilder("select * from vuelos where 0 < " + tipo + " - (select count(*) from registroVuelos)");
        if (!destino.equals("")) {
            select.append(" and destino = ").append(destino);
        }
        if (!procedencia.equals("")) {
            select.append(" and procendencia = ").append(procedencia);
        }
        if (!fecha.equals("")) {
            select.append(" and fechaSalida = cast('").append(fecha).append("' AS DATE)");
        }

        try {
            return devolverDatosDeObjeto(TVuelos.mostrarTodosLosVuelos(String.valueOf(select)), "error en billete", 6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
