package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Empleado;
import tp.backend.agencia.entities.Interesado;
import tp.backend.agencia.entities.Prueba;
import tp.backend.agencia.entities.Vehiculo;
import tp.backend.agencia.repositories.EmpleadoRepository;
import tp.backend.agencia.repositories.InteresadoRepository;
import tp.backend.agencia.repositories.PruebaRepository;
import tp.backend.agencia.repositories.VehiculoRepository;
import tp.backend.agencia.services.interfaces.PruebaService;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PruebaServiceImpl extends ServiceImpl<Prueba, Integer> implements PruebaService {
    private final PruebaRepository pruebaRepository;
    private final InteresadoRepository interesadoRepository;
    private final VehiculoRepository vehiculoRepository;
    private final EmpleadoRepository empleadoRepository;

    /*
    VALIDACIONES SI EXISTEN LOS OBJETOS
    */
    private void validarPrueba(Prueba prueba) {
        Interesado interesado = prueba.getInteresado();
        // Validar si el cliente está restringido
        if (interesado.getRestringido() != null && interesado.getRestringido()) {
            throw new IllegalArgumentException("El cliente está restringido y no puede realizar pruebas.");
        }
        // Validar si la licencia está vencida
        if (interesado.getFechaVencimientoLicencia() == null ||
                interesado.getFechaVencimientoLicencia().before(new Date())) {
            throw new IllegalArgumentException("La licencia del cliente está vencida o no válida.");
        }
        // Validar si el vehículo está en uso
        if (pruebaRepository.existsByVehiculoAndFechaHoraFinIsNull(prueba.getVehiculo())) {
            throw new IllegalArgumentException("El vehículo ya está en una prueba activa.");
        }
    }

    private void validarRelaciones(Prueba prueba) {
        if (!interesadoRepository.existsById(prueba.getInteresado().getId())) {
            throw new IllegalArgumentException("El interesado no existe.");
        }
        if (!vehiculoRepository.existsById(prueba.getVehiculo().getId())) {
            throw new IllegalArgumentException("El vehículo no existe.");
        }
        if (!empleadoRepository.existsById(prueba.getEmpleado().getLegajo())) {
            throw new IllegalArgumentException("El empleado no existe.");
        }
    }


    @Override
    public void create(Prueba entity) {

        if (entity.getFechaHoraInicio() == null) {
            entity.setFechaHoraInicio(new Date());
        }

        Interesado interesado = interesadoRepository.findById(entity.getInteresado().getId())
                .orElseThrow(() -> new IllegalArgumentException("El interesado no existe."));

        // Validar que el atributo 'restringido' no sea null
        if (interesado.getRestringido() == null) {
            throw new IllegalArgumentException("El atributo 'restringido' del interesado es null.");
        }
        entity.setInteresado(interesado);


        // Cargar y validar otros objetos relacionados
        Vehiculo vehiculo = vehiculoRepository.findById(entity.getVehiculo().getId())
                .orElseThrow(() -> new IllegalArgumentException("El vehículo no existe."));
        entity.setVehiculo(vehiculo);


        Empleado empleado = empleadoRepository.findById(entity.getEmpleado().getLegajo())
                .orElseThrow(() -> new IllegalArgumentException("El empleado no existe."));
        entity.setEmpleado(empleado);

        validarRelaciones(entity);
        validarPrueba(entity);

        this.pruebaRepository.save(entity);
    }

    @Override
    public void update(Prueba entity) {
        this.pruebaRepository.save(entity);
    }

    @Override
    public Prueba delete(Integer id) {
        Prueba entity = this.pruebaRepository.findById(id).orElse(null);
        this.pruebaRepository.delete(entity);
        return entity;
    }

    @Override
    public Prueba findById(Integer id) {
        return this.pruebaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prueba> findAll() {
        return this.pruebaRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return this.pruebaRepository.existsById(id);

    }

    // Busqueda de fechaHora NULL para punto 2
    public List<Prueba> findPruebasEnCurso() {
        return pruebaRepository.findByFechaHoraFinIsNull();
    }

    // Patch para punto 3
    public Prueba finalizarPrueba(Integer idPrueba, String comentario) {
        Prueba prueba = pruebaRepository.findById(idPrueba).orElseThrow(() -> new NoSuchElementException("La prueba no existe"));

        if (prueba.getFechaHoraFin() != null) {
            throw new IllegalArgumentException("La prueba ya está finalizo.");
        }

        prueba.setFechaHoraFin(new Date());
        prueba.setComentario(comentario);

        return pruebaRepository.save(prueba);
    }

}
