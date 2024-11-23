package tp.backend.agencia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.agencia.entities.Vehiculo;
import tp.backend.agencia.repositories.VehiculoRepository;

import java.util.List;

@RestController
public class VehiculoController {
    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @GetMapping("/vehiculos")
    public List<Vehiculo> getVehiculos() {
        return vehiculoRepository.findAll();
    }
}
