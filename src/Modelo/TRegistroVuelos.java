package Modelo;

import Controlador.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TRegistroVuelos {

    private static Connection con;
    static ArrayList<String> tipoPlaza = new ArrayList<>();

    private static void abriConexion() {
        BD.abrirConexion();
        con = BD.getCon();
    }
    public static void pasajerosPorVuelo(Vuelo vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement(
                    "select p.*, r.tipoPlaza from pasajeros p, registrovuelos r" +
                            " where r.cod_vuelo = ? and p.dni = r.dni");
            ps.setString(1,vuelo.getCod_vuelo());
            ResultSet result = ps.executeQuery();
            ArrayList<Pasajero> pasajeros = new ArrayList<>();
            while (result.next()) {
                pasajeros.add(new Pasajero(
                        result.getString("dni"),
                        result.getString("nombre")
                ));
                tipoPlaza.clear();
                tipoPlaza.add(result.getString("tipoPlaza"));
            }
            vuelo.setPasajeros(pasajeros);
            BD.cerrarConexion();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<String> getTipoPlaza() {
        return tipoPlaza;
    }

    public static boolean inserRegistro(String[] objetoRegistro) {
        try {
            abriConexion();
            PreparedStatement p = con.prepareStatement("(select max(id) + 1 a from registroVuelos)");
            ResultSet resultSet = p.executeQuery();
            int id = 0;
            if (resultSet.next())
                id = resultSet.getInt("a");
            PreparedStatement ps = con.prepareStatement("insert into registroVuelos values (?, ?, ? , ?) ");
            ps.setInt(1, id);
            ps.setString(2, objetoRegistro[0]);
            ps.setString(3, objetoRegistro[1]);
            ps.setString(4, objetoRegistro[2]);
            int result = ps.executeUpdate();
            BD.cerrarConexion();
            return result != 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validarPasajeroMismoVuelo(String dni, String cod_vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("select id from registroVuelos where dni = ? and cod_vuelo = ?");
            ps.setString(1, dni);
            ps.setString(2, cod_vuelo);
            ResultSet result = ps.executeQuery();
            boolean bool = result.next();
            BD.cerrarConexion();
            return bool;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean[] validarAsientosLibres(Vuelo vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("select cod_vuelo from vuelos where 0 <= ? - (select count(*) from registroVuelos where cod_vuelo = ? and tipoPlaza = 'plazasTuristas')");
            ps.setInt(1, vuelo.getPlazaTurista());
            ps.setString(2, vuelo.getCod_vuelo());
            ResultSet result = ps.executeQuery();
            boolean bool[] = new boolean[2];
            bool[0] = result.next();

            ps = con.prepareStatement("select cod_vuelo from vuelos where 0 <= ? - (select count(*) from registroVuelos where cod_vuelo = ? and tipoPlaza = 'plazasPrimera')");
            ps.setInt(1,vuelo.getPlazaPrimera());
            ps.setString(2,vuelo.getCod_vuelo());
            result = ps.executeQuery();
            bool[1] = result.next();
            BD.cerrarConexion();
            return bool;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new boolean[]{false, false};
        }
    }

    public static void vuelosPorPasajero(Pasajero pasajero) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement(
                    "select v.* from vuelos v, registrovuelos r" +
                            " where r.dni = ? and v.cod_vuelo = r.cod_vuelo");
            ps.setString(1,pasajero.getDni());
            ResultSet result = ps.executeQuery();
            ArrayList<Vuelo> vuelos = new ArrayList<>();
            while (result.next()) {
                vuelos.add(Main.getVuelo(result));
            }
            pasajero.setVuelos(vuelos);
            BD.cerrarConexion();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
