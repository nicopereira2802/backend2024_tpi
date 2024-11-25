package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Posicion;
import tp.backend.agencia.entities.Vehiculo;
import tp.backend.agencia.repositories.VehiculoRepository;
import tp.backend.agencia.services.interfaces.VehiculoService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/agencia/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable int id) {
        try{
            Vehiculo result = vehiculoService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);

        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAllVehiculo() {
        List<Vehiculo> vehiculos = vehiculoService.findAll();
        if (vehiculos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

}
