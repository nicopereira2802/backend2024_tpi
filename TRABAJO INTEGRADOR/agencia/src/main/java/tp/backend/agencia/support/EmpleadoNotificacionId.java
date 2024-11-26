package tp.backend.agencia.support;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class EmpleadoNotificacionId implements Serializable {
    @Column(name = "ID_EMPLEADO")
    private Integer empId;

    @Column(name = "ID_NOTIFICACION")
    private Integer notifId;



}
