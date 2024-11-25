package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Empleado;
import tp.backend.agencia.repositories.EmpleadoRepository;
import tp.backend.agencia.services.interfaces.EmpleadoService;


import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl extends ServiceImpl<Empleado, Integer> implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    @Override
    public void create(Empleado entity) {
        this.empleadoRepository.save(entity);
    }

    @Override
    public void update(Empleado entity) {
        this.empleadoRepository.save(entity);
    }

    @Override
    public Empleado delete(Integer id) {
        Empleado entity = this.empleadoRepository.findById(id).orElse(null);
        this.empleadoRepository.delete(entity);
        return entity;
    }

    @Override
    public Empleado findById(Integer id) {
        return this.empleadoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Empleado> findAll() {
        return this.empleadoRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.empleadoRepository.existsById(id);
    }
}
