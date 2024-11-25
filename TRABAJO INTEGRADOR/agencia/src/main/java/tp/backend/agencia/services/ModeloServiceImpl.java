package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Modelo;
import tp.backend.agencia.repositories.ModeloRepository;
import tp.backend.agencia.services.interfaces.ModeloService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeloServiceImpl extends ServiceImpl<Modelo, Integer> implements ModeloService {

    private final ModeloRepository modeloRepository;

    @Override
    public void create(Modelo entity) {
        this.modeloRepository.save(entity);
    }

    @Override
    public void update(Modelo entity) {
        this.modeloRepository.save(entity);


    }

    @Override
    public Modelo delete(Integer id) {
        Modelo entity = this.modeloRepository.findById(id).orElse(null);
        this.modeloRepository.deleteById(id);
        return entity;
    }

    @Override
    public Modelo findById(Integer id) {
        return this.modeloRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Modelo> findAll() {
        return this.modeloRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.modeloRepository.existsById(id);
    }
}
