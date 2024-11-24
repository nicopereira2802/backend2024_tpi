package tp.backend.agencia.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.backend.agencia.entities.Interesado;
import tp.backend.agencia.repositories.InteresadoRepository;

import java.util.List;

@RestController
public class InteresadoController {
    private final InteresadoRepository interesadoRepository;

    public InteresadoController(InteresadoRepository interesadoRepository) {
        this.interesadoRepository = interesadoRepository;
    }

    @GetMapping("/interesados")
    public List<Interesado> getInteresados() {
        return interesadoRepository.findAll();
    }

}
