package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.backend.agencia.entities.Interesado;

public interface InteresadoRepository extends JpaRepository<Interesado, Integer> {
}
