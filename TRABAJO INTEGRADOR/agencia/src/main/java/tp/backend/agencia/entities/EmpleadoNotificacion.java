package tp.backend.agencia.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import tp.backend.agencia.support.EmpleadoNotificacionId;

import java.io.Serializable;

@Entity
@Data
@Table(name = "Empleado_notificacion")
public class EmpleadoNotificacion implements Serializable {
    @EmbeddedId
    private EmpleadoNotificacionId id;

    @ManyToOne
    @JoinColumn(name = "NOTIFICACION_ID", nullable = false, insertable = false, updatable = false)
    @MapsId("notifId")
    @ToString.Exclude
    private Notificacion notificacion;

    @ManyToOne
    @JoinColumn(name = "EMPLEADO_ID", nullable = false, insertable = false, updatable = false)
    @MapsId("empId")
    @ToString.Exclude
    private Empleado empleado;

}
