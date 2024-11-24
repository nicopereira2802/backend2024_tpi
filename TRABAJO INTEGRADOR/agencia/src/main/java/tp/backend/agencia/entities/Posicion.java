package tp.backend.agencia.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Posiciones")
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;


    @Column(name = "FECHA_HORA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(name = "LATITUD", nullable = false)
    private Double latitud;

    @Column(name = "LONGITUD", nullable = false)
    private Double longitud;

    @ManyToOne
    @JoinColumn(name = "ID_VEHICULO", nullable = false) // Define la FK hacia Vehiculos
    private Vehiculo vehiculo;


    public Posicion(){}
    public Posicion(Integer id, Date fechaHora, Double latitud, Double longitud) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getId() {
        return id;
    }


    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}