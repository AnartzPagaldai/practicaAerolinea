package Modelo;

import java.util.ArrayList;

public class Pasajero {
    private String dni, nombre;
    private ArrayList<Vuelo> vuelos = new ArrayList<>();

    public Pasajero(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Pasajero(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + "\nNombre: "+ nombre;
    }
}
