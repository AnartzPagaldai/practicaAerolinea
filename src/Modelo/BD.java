package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {

    private static Connection con;
    public static void abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practicaaerolinea","root",
                    "usbw");
        } catch (Exception e) {
            System.out.println(" Problemas con la base de datos " +
                    e.getMessage());
        }
    }
    public static void cerrarConexion() {
        try {
            con.close();
        }
        catch (Exception e) {
            System.out.println(" Problemas con la base de datos " +
                    e.getMessage());
        }
    }

    public static Connection getCon() {
        return con;
    }
}
