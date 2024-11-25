package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Vehiculo;
import tp.backend.agencia.repositories.VehiculoRepository;
import tp.backend.agencia.services.interfaces.VehiculoService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl extends ServiceImpl<Vehiculo, Integer> implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Override
    public void create(Vehiculo entity) {
        this.vehiculoRepository.save(entity);
    }

    @Override
    public void update(Vehiculo entity) {
        this.vehiculoRepository.save(entity);
    }

    @Override
    public Vehiculo delete(Integer id) {
        Vehiculo vehiculo = this.vehiculoRepository.findById(id).orElse(null);
        this.vehiculoRepository.delete(vehiculo);
        return vehiculo;
    }

    @Override
    public Vehiculo findById(Integer id) {
        return this.vehiculoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Vehiculo> findAll() {
        return this.vehiculoRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.vehiculoRepository.existsById(id);
    }
}
