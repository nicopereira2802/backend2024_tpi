package tp.backend.agencia.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ResponseEntity<Object> addInteresado(@RequestBody Interesado interesado) {
        try{
            this.interesadoService.create(interesado);
            return new ResponseEntity<>(interesado, HttpStatus.CREATED);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Interesado> deleteById(@PathVariable Integer id) {
        try{
            Interesado interesado = this.interesadoService.delete(id);
            return ResponseEntity.ok(interesado);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

}
