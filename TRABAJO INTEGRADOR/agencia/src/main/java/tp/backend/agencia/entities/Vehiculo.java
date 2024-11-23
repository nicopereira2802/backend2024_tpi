package tp.backend.agencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    private int id;
    private String patente;
    private int anio;
    private int id_modelo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int modelo) {
        this.id_modelo = modelo;
    }
}
