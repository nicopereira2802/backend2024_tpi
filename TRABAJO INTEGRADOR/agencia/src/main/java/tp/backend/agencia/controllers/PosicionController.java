package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Posicion;

import tp.backend.agencia.services.interfaces.PosicionService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/agencia/posiciones")
@RequiredArgsConstructor
public class PosicionController {

    private final PosicionService posicionService;

    @GetMapping("/{id}")
    public ResponseEntity<Posicion> getPosicionById(@PathVariable int id) {
        try{
            Posicion result = posicionService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);

        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Posicion>> getAllPosicion() {
        List<Posicion> posiciones = posicionService.findAll();
        if (posiciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posiciones, HttpStatus.OK);
    }

}
