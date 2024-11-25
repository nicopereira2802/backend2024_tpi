package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Interesado;
import tp.backend.agencia.repositories.InteresadoRepository;
import tp.backend.agencia.services.interfaces.InteresadoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteresadoServiceImpl extends ServiceImpl<Interesado, Integer> implements InteresadoService {

    private final InteresadoRepository interesadoRepository;
    @Override
    public void create(Interesado entity) {
        this.interesadoRepository.save(entity);
    }

    @Override
    public void update(Interesado entity) {
        this.interesadoRepository.save(entity);
    }

    @Override
    public Interesado delete(Integer id) {
        Interesado entity = this.interesadoRepository.findById(id).orElse(null);
        this.interesadoRepository.delete(entity);
        return entity;
    }

    @Override
    public Interesado findById(Integer id) {
         return this.interesadoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Interesado> findAll() {
        return this.interesadoRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.interesadoRepository.existsById(id);
    }
}
