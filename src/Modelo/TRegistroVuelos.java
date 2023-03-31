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
    public static ArrayList<Pasajero> pasajerosPorVuelo(String cod_vuelo) {
        try {
            abriConexion();
            PreparedStatement ps = con.prepareStatement(
                    "select p.*, r.tipoPlaza from pasajeros p, registrovuelos r" +
                            " where r.cod_vuelo = ? and p.dni = r.dni");
            ps.setString(1,cod_vuelo);
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
            BD.cerrarConexion();
            return pasajeros;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ArrayList<String> getTipoPlaza() {
        return tipoPlaza;
    }
}
