package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.backend.agencia.entities.Prueba;

import tp.backend.agencia.services.interfaces.PruebaService;

import java.util.List;
import java.util.Map;
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

    // Punto a
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

    //Punto b
    @GetMapping("/in-course")
    public ResponseEntity<List<Prueba>> getPruebasEnCurso() {
        List<Prueba> pruebasEnCurso = pruebaService.findPruebasEnCurso();
        if (pruebasEnCurso.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devuelve 204 si no hay pruebas en curso
        }
        return new ResponseEntity<>(pruebasEnCurso, HttpStatus.OK); // Devuelve 200 con la lista de pruebas en curso
    }

    //Punto c
    @PatchMapping("/{idPrueba}/end")
    public ResponseEntity<Prueba> finalizarPrueba(
            @PathVariable Integer idPrueba,
            @RequestBody Map<String, String> body) {
        try {
            String comentario = body.get("comentario");
            return ResponseEntity.ok(pruebaService.finalizarPrueba(idPrueba, comentario));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
