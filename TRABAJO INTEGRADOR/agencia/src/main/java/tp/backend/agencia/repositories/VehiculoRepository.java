package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.backend.agencia.entities.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
