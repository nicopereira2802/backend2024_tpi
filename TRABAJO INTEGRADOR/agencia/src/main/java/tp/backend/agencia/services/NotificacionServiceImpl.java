package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.entities.Notificacion;
import tp.backend.agencia.entities.Vehiculo;
import tp.backend.agencia.repositories.NotificacionRepository;
import tp.backend.agencia.services.interfaces.NotificacionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionServiceImpl extends ServiceImpl<Notificacion, Integer> implements NotificacionService {

    private final NotificacionRepository notificacionRepository;

    @Override
    public void create(Notificacion entity) { this.notificacionRepository.save(entity); }

    @Override
    public Notificacion findById(Integer id) {return this.notificacionRepository.findById(id).orElseThrow();}

    @Override
    public void update(Notificacion entity) { this.notificacionRepository.save(entity); }

    @Override
    public Notificacion delete(Integer id) {
        Notificacion notificacion = this.notificacionRepository.findById(id).orElse(null);
        this.notificacionRepository.delete(notificacion);
        return notificacion;
    }

    @Override
    public List<Notificacion> findAll(){
        return this.notificacionRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {return notificacionRepository.existsById(id);}
}
