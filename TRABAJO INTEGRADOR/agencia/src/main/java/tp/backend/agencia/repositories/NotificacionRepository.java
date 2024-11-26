package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.backend.agencia.entities.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer>  {
}
