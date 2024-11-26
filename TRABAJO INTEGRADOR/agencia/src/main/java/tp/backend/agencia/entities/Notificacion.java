package tp.backend.agencia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Notificaciones")
@Data
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MENSAJE", nullable = false)
    private String mensaje;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "FECHA_Y_HORA", nullable = false)
    private LocalDateTime fehcaHora;
    @OneToMany(mappedBy = "notificacion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<EmpleadoNotificacion> notifPorEmpleado = new HashSet<>();

    public Notificacion(){}

    public Notificacion(Integer id, String mensaje, LocalDateTime fehcaHora) {
        this.id = id;
        this.mensaje = mensaje;
        this.fehcaHora = fehcaHora;
    }
}
