package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vuelo {
    private String cod_vuelo, destino, procedencia;
    private LocalDate fechaSalida;
    private int plazaTurista, plazaPrimera;
    private ArrayList<Pasajero> pasajeros = new ArrayList<>();

    public Vuelo(String cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public Vuelo(String cod_vuelo, LocalDate fechaSalida, String destino, String procedencia, int plazaTurista, int plazaPrimera) {
        this.cod_vuelo = cod_vuelo;
        this.destino = destino;
        this.procedencia = procedencia;
        this.fechaSalida = fechaSalida;
        this.plazaTurista = plazaTurista;
        this.plazaPrimera = plazaPrimera;
    }

    public String getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(String cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getPlazaTurista() {
        return plazaTurista;
    }

    public void setPlazaTurista(int plazaTurista) {
        this.plazaTurista = plazaTurista;
    }

    public int getPlazaPrimera() {
        return plazaPrimera;
    }

    public void setPlazaPrimera(int plazaPrimera) {
        this.plazaPrimera = plazaPrimera;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }
}
