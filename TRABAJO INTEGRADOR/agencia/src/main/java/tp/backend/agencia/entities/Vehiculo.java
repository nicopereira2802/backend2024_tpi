package tp.backend.agencia.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PATENTE", nullable = false)
    private String patente;

    @ManyToOne
    @JoinColumn(name = "ID_MODELO", nullable = false)
    @JsonBackReference // Evita ciclos si Modelo tiene una referencia de vuelta
    private Modelo modelo;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Posicion> posiciones = new HashSet<>();

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Prueba> pruebas = new HashSet<>();

    public Vehiculo(){}
    public Vehiculo(Integer id, String patente, Modelo modelo) {
        this.id = id;
        this.patente = patente;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Set<Prueba> getPruebas() {
        return pruebas;
    }

    public void setPruebas(Set<Prueba> pruebas) {
        this.pruebas = pruebas;
    }

    public Set<Posicion> getPosicion() {
        return posiciones;
    }

    public void setPosicion(Set<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

}
