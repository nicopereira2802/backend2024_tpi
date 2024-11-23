package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.backend.agencia.entities.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
