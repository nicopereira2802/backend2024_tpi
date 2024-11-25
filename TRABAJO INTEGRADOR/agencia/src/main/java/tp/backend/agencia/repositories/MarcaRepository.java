package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import tp.backend.agencia.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
