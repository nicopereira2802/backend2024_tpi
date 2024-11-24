package tp.backend.agencia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Prueba;
import tp.backend.agencia.repositories.PruebaRepository;

import java.util.List;

@RestController
public class PruebaController {
    private final PruebaRepository pruebaRepository;

    public PruebaController(PruebaRepository pruebaRepository) {
        this.pruebaRepository = pruebaRepository;
    }

    @GetMapping("/pruebas")
    public List<Prueba> getPruebas() {return pruebaRepository.findAll();}
}
