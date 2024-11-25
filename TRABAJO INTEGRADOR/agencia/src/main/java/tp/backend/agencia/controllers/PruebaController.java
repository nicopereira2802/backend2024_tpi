package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
