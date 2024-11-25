package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Prueba;
import tp.backend.agencia.repositories.PruebaRepository;
import tp.backend.agencia.services.interfaces.PruebaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PruebaServiceImpl extends ServiceImpl<Prueba, Integer> implements PruebaService {
    private final PruebaRepository pruebaRepository;

    @Override
    public void create(Prueba entity) {
        this.pruebaRepository.save(entity);
    }

    @Override
    public void update(Prueba entity) {
        this.pruebaRepository.save(entity);
    }

    @Override
    public Prueba delete(Integer id) {
        Prueba entity = this.pruebaRepository.findById(id).orElse(null);
        this.pruebaRepository.delete(entity);
        return entity;
    }

    @Override
    public Prueba findById(Integer id) {
        return this.pruebaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prueba> findAll() {
        return this.pruebaRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.pruebaRepository.existsById(id);
    }
}
