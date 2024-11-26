package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.backend.agencia.entities.Prueba;

import tp.backend.agencia.services.interfaces.PruebaService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/agencia/pruebas")
@RequiredArgsConstructor
public class PruebaController {
    private final PruebaService pruebaService;

    @GetMapping("/{id}")
    public ResponseEntity<Prueba> getPruebaById(@PathVariable int id) {
        try{
            Prueba result = pruebaService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);

        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Prueba>> getAllPrueba() {
        List<Prueba> pruebas = pruebaService.findAll();
        if (pruebas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pruebas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addPrueba(@RequestBody Prueba prueba) {
        try{
            this.pruebaService.create(prueba);
            return new ResponseEntity<>(prueba, HttpStatus.CREATED);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
}
