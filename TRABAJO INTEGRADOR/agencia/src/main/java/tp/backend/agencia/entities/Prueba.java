package tp.backend.agencia.entities;

import jakarta.persistence.*;
import jdk.jfr.MemoryAddress;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Pruebas")
@Data
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FECHA_HORA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraInicio;

    @Column(name = "FECHA_HORA_FIN", nullable = true) // Puede ser null si la prueba está en curso
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFin;

    @Column(name = "COMENTARIOS", nullable = true) // Puede ser null
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "ID_EMPLEADO", nullable = false) // FK hacia Empleado
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "ID_VEHICULO", nullable = false) // FK hacia Vehiculo
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "ID_INTERESADO", nullable = false) // FK hacia Interesado
    private Interesado interesado;

    @ManyToOne
    @JoinColumn(name = "ID_ZONA_RESTRINGIDA", nullable = false)
    private ZonaRestringida zonaRestringida;

    public Prueba() {}

    public Prueba(Integer id, Date fechaHoraInicio, Date fechaHoraFin, String comentario, Empleado empleado, Vehiculo vehiculo, Interesado interesado, ZonaRestringida zonaRestringida) {
        this.id = id;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.comentario = comentario;
        this.empleado = empleado;
        this.vehiculo = vehiculo;
        this.interesado = interesado;
        this.zonaRestringida = zonaRestringida;
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }
}
