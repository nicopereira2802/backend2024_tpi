package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.backend.agencia.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
