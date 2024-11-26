package tp.backend.agencia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Zonas_restringidas")
public class ZonaRestringida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LATITUD_LIMITE", nullable = false)
    private Double latitudLimite;

    @Column(name = "LONGITUD", nullable = false)
    private Double longitudLimite;

    @OneToMany(mappedBy = "ZonaRestringida", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Prueba> pruebas = new HashSet<>();

    public ZonaRestringida(){}
    public ZonaRestringida(Integer id, Double latitudLimite, Double longitudLimite) {
        this.id = id;
        this.latitudLimite = latitudLimite;
        this.longitudLimite = longitudLimite;
    }
}
