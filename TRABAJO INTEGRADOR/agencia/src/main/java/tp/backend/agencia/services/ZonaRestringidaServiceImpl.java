package tp.backend.agencia.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.ZonaRestringida;
import tp.backend.agencia.repositories.ZonaRestringidaRepository;
import tp.backend.agencia.services.interfaces.ZonaRestringidaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZonaRestringidaServiceImpl extends ServiceImpl<ZonaRestringida, Integer> implements ZonaRestringidaService {
    private final ZonaRestringidaRepository zonaRestringidaRepository;

    @Override
    public void create(ZonaRestringida entity) {
        this.zonaRestringidaRepository.save(entity);
    }

    @Override
    public void update(ZonaRestringida entity) {
        this.zonaRestringidaRepository.save(entity);
    }

    @Override
    public ZonaRestringida delete(Integer id) {
        ZonaRestringida zonaRestringida = this.zonaRestringidaRepository.findById(id).orElse(null);
        this.zonaRestringidaRepository.delete(zonaRestringida);
        return zonaRestringida;
    }

    @Override
    public ZonaRestringida findById(Integer id) {
        return this.zonaRestringidaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ZonaRestringida> findAll() {
        return this.zonaRestringidaRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.zonaRestringidaRepository.existsById(id);
    }

}
