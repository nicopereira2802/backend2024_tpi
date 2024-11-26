package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.backend.agencia.entities.Marca;
import tp.backend.agencia.services.interfaces.MarcaService;

import java.util.NoSuchElementException;

import java.util.List;

@RestController
@RequestMapping("/api/agencia/marcas")
@RequiredArgsConstructor
public class MarcaController {

    /*
    private final MarcaRepository marcaRepository;

    public MarcaController(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @GetMapping("/marcas")
    public List<Marca> getMarcas() {
        return marcaRepository.findAll();
    }

     */
    private final MarcaService marcaService;

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable int id) {
        try{
                Marca result = marcaService.findById(id);
                return new ResponseEntity<>(result, HttpStatus.OK);

        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Marca>> getAllMarcas() {
        List<Marca> marcas = marcaService.findAll();
        if (marcas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(marcas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addMarca(@RequestBody Marca marca) {
        try{
            this.marcaService.create(marca);
            return new ResponseEntity<>(marca, HttpStatus.CREATED);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Marca> deleteById(@PathVariable Integer id) {
        try{
            Marca marca = this.marcaService.delete(id);
            return ResponseEntity.ok(marca);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
