package tp.backend.agencia.services;


import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Marca;
import tp.backend.agencia.repositories.MarcaRepository;
import tp.backend.agencia.services.interfaces.MarcaService;

import java.util.List;

@Service
public class MarcaServiceImpl extends ServiceImpl<Marca, Integer> implements MarcaService{
/*
estoy inyectando
 */
    private final MarcaRepository marcaRepository;

    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }


    @Override
    public void create(Marca entity) {
        this.marcaRepository.save(entity);
    }

    @Override
    public void update(Marca entity) {
        this.marcaRepository.save(entity);

    }

    @Override
    public Marca delete(Integer id) {
        Marca marca = findById(id);
        this.marcaRepository.delete(marca);
        return marca;
    }

    @Override
    public Marca findById(Integer id) {
        return this.marcaRepository.findById(id).orElseThrow();
        /*
        tira una excepcion no such element exception
        osea no existe lo que buscamos
         */
    }

    @Override
    public List<Marca> findAll() {
        return this.marcaRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.marcaRepository.existsById(id);
    }
}
