package tp.backend.agencia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Posicion;
import tp.backend.agencia.repositories.PosicionRepository;

import java.util.List;

@RestController
public class PosicionController {
    private final PosicionRepository posicionRepository;
    public PosicionController(PosicionRepository posicionRepository) {
        this.posicionRepository = posicionRepository;
    }

    @GetMapping("/posiciones")
    public List<Posicion> getPosiciones(){return posicionRepository.findAll();}
}
