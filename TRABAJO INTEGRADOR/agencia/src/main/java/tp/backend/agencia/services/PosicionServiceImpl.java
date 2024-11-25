package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Posicion;
import tp.backend.agencia.repositories.PosicionRepository;
import tp.backend.agencia.services.interfaces.PosicionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PosicionServiceImpl extends ServiceImpl<Posicion, Integer> implements PosicionService {

    private final PosicionRepository posicionRepository;

    @Override
    public void create(Posicion entity) {
        this.posicionRepository.save(entity);
    }

    @Override
    public void update(Posicion entity) {
        this.posicionRepository.save(entity);
    }

    @Override
    public Posicion delete(Integer id) {
        Posicion entity = this.posicionRepository.findById(id).orElse(null);
        this.posicionRepository.delete(entity);
        return entity;
    }

    @Override
    public Posicion findById(Integer id) {
        return this.posicionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Posicion> findAll() {
        return this.posicionRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.posicionRepository.existsById(id);
    }
}
