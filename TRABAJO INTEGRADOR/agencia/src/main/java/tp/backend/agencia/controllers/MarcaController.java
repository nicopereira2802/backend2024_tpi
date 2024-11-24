package tp.backend.agencia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Marca;
import tp.backend.agencia.repositories.MarcaRepository;


import java.util.List;

@RestController
public class MarcaController {
    private final MarcaRepository marcaRepository;

    public MarcaController(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @GetMapping("/marcas")
    public List<Marca> getMarcas() {
        return marcaRepository.findAll();
    }
}
