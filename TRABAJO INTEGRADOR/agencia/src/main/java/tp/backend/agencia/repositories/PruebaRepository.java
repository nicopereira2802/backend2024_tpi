package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.backend.agencia.entities.Prueba;
import tp.backend.agencia.entities.Vehiculo;

public interface PruebaRepository extends JpaRepository<Prueba, Integer> {
    boolean existsByVehiculoAndFechaHoraFinIsNull(Vehiculo vehiculo);
}
