package Modelo;

import Controlador.Main;

import java.sql.*;
import java.util.ArrayList;

public class TVuelos {
    private static Connection con;

    private static void abriConexion() {
        BD.abrirConexion();
        con = BD.getCon();
    }
    public static boolean crearVuelo(Vuelo vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("insert into vuelos values (?,?,?,?,?,?)");
            ps.setString(1,vuelo.getCod_vuelo());
            ps.setDate(2, Date.valueOf(vuelo.getFechaSalida()));
            ps.setString(3,vuelo.getDestino());
            ps.setString(4,vuelo.getProcedencia());
            ps.setInt(5, vuelo.getPlazaTurista());
            ps.setInt(6, vuelo.getPlazaPrimera());
            int r = ps.executeUpdate();
            BD.cerrarConexion();
            return r != 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static boolean validarCodigo(String cod_vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("select cod_vuelo from vuelos where cod_vuelo = ?");
            ps.setString(1,cod_vuelo);
            ResultSet result = ps.executeQuery();
            boolean r = result.next();
            BD.cerrarConexion();
            return r;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean actualizarVuelo(Vuelo vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement(
                    "update vuelos set fechaSalida = ?, destino = ?, procedencia = ?, plazasTuristas = ?, plazasPrimera = ? where cod_vuelo = ?"
            );
            ps.setDate(1, Date.valueOf(vuelo.getFechaSalida()));
            ps.setString(2,vuelo.getDestino());
            ps.setString(3,vuelo.getProcedencia());
            ps.setInt(4, vuelo.getPlazaTurista());
            ps.setInt(5, vuelo.getPlazaPrimera());
            ps.setString(6, vuelo.getCod_vuelo());
            int r = ps.executeUpdate();
            BD.cerrarConexion();
            return r != 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Vuelo mostrarVuelo(String cod_vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("select * from vuelos where cod_vuelo = ?");
            ps.setString(1,cod_vuelo);
            ResultSet result = ps.executeQuery();
            Vuelo vuelo = null;
            if (result.next()) {
                vuelo = new Vuelo(
                        result.getString("cod_vuelo"),
                        result.getDate("fechaSalida").toLocalDate(),
                        result.getString("destino"),
                        result.getString("procedencia"),
                        result.getInt("plazasTuristas"),
                        result.getInt("plazasPrimera")
                );
            }
            BD.cerrarConexion();
            return vuelo;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean eliminarVuelo(String cod_vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("delete from vuelos where cod_vuelo = ?");
            ps.setString(1,cod_vuelo);
            int result = ps.executeUpdate();
            BD.cerrarConexion();
            return result != 0;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static ArrayList<Vuelo> mostrarTodosLosVuelos() {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("select * from vuelos;");
            ResultSet result = ps.executeQuery();
            ArrayList<Vuelo> vuelos = new ArrayList<>();
            while(result.next()) {
                vuelos.add(Main.getVuelo(result));
            }
            BD.cerrarConexion();
            return vuelos;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
