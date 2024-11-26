package tp.backend.agencia.services.interfaces;

import tp.backend.agencia.entities.Marca;
import tp.backend.agencia.entities.Prueba;

import java.util.List;

public interface PruebaService extends Service<Prueba,Integer>{
    List<Prueba> findPruebasEnCurso();
}
