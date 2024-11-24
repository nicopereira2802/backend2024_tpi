package tp.backend.agencia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Modelo;
import tp.backend.agencia.repositories.ModeloRepository;
import java.util.List;

@RestController
public class ModeloController {
    private final ModeloRepository modeloRepository;

    public ModeloController(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @GetMapping("/modelos")
    public List<Modelo> getModelos(){return modeloRepository.findAll();}
}
