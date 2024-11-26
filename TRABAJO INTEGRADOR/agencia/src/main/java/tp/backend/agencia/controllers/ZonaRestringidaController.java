package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.ZonaRestringida;
import tp.backend.agencia.services.interfaces.ZonaRestringidaService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/agencia/zonasRestringidas")
@RequiredArgsConstructor
public class ZonaRestringidaController {

    private final ZonaRestringidaService zonaRestringidaService;

    @GetMapping("/{id}")
    public ResponseEntity<ZonaRestringida> getZonaRestringidaById(@PathVariable int id){
        try{
            ZonaRestringida result = zonaRestringidaService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ZonaRestringida>> getAllZonaRestringida() {
        List<ZonaRestringida> zonasRestringidas = zonaRestringidaService.findAll();
        if(zonasRestringidas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(zonasRestringidas, HttpStatus.OK);
    }
}
