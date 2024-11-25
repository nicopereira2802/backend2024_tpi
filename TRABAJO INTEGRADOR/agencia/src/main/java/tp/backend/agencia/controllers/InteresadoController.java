package tp.backend.agencia.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Interesado;
import tp.backend.agencia.services.interfaces.InteresadoService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/agencia/interesados")
@RequiredArgsConstructor
public class InteresadoController {
    private final InteresadoService interesadoService;

    @GetMapping("/{id}")
    public ResponseEntity<Interesado> getInteresadoById(@PathVariable int id) {
        try{
            Interesado result = interesadoService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);

        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Interesado>> getAllInteresados() {
        List<Interesado> interesados = interesadoService.findAll();
        if (interesados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(interesados, HttpStatus.OK);
    }

}
