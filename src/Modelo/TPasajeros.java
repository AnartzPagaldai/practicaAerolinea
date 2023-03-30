package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TPasajeros {
    private static Connection con;

    private static void abriConexion() {
        BD.abrirConexion();
        con = BD.getCon();
    }

    public static boolean inserTarpasajero(Pasajero pasajero) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("insert into pasajeros values (?,?)");
            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            int r = ps.executeUpdate();
            BD.cerrarConexion();
            return r != 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean validarDni(String dni) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("select dni from pasajeros where dni = ?");
            ps.setString(1,dni);
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

    public static boolean actualizarPasajero(Pasajero p) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("update pasajeros set nombre = ? where dni = ?");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDni());
            int result = ps.executeUpdate();
            BD.cerrarConexion();
            return result != 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Object mostrarPasajero(String dni) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("select * from pasajeros where dni = ?");
            ps.setString(1,dni);
            ResultSet result = ps.executeQuery();
            Pasajero pasajero = null;
            if (result.next()) {
                pasajero = new Pasajero(
                        result.getString("dni"),
                        result.getString("nombre"));
            }
            BD.cerrarConexion();
            return pasajero;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean eliminarPasajero(String dni) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("delete from pasajeros where dni = ?");
            ps.setString(1,dni);
            int result = ps.executeUpdate();
            BD.cerrarConexion();
            return result != 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<Pasajero> mostrarTodosLosPasajeros() {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement("select * from pasajeros;");
            ResultSet result = ps.executeQuery();
            ArrayList<Pasajero> pasajeros = new ArrayList<>();
            while(result.next()) {
                pasajeros.add(new Pasajero(
                        result.getString("dni"),
                        result.getString("nombre")
                ));
            }
            BD.cerrarConexion();
            return pasajeros;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
