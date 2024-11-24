package tp.backend.agencia.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Modelos")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "ID_MARCA", nullable = false) // Aquí está la FK hacia Marca
    @JsonBackReference
    private Marca marca;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Permite que Modelo serialice los Vehiculos asociados
    private Set<Vehiculo> vehiculos = new HashSet<>();


    public Modelo(){}
    public Modelo(Integer id, String descripcion, Marca marca) {
        this.id = id;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}