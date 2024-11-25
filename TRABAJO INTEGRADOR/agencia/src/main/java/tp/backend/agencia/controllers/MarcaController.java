package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Marca;
import tp.backend.agencia.repositories.MarcaRepository;
import tp.backend.agencia.services.interfaces.MarcaService;

import java.util.NoSuchElementException;

import java.util.List;

@RestController
@RequestMapping("/api/agencia/marca")
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




}
