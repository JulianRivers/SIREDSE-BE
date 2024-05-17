package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.dto.ConfiguracionDTO;
import BackendSiadseUfps.siadse.entity.Configuracion;

import java.util.List;
import java.util.Optional;

public interface ConfiguracionService {

    Configuracion obtenerConfiguracionUnica();

    Configuracion actualizarConfiguracion(ConfiguracionDTO configuracionDTO);
    List<Configuracion> obtenerTodasLasConfiguraciones();

<<<<<<< HEAD
    Optional<Configuracion> obtenerConfiguracionPorId(Integer id);

    Configuracion guardarConfiguracion(ConfiguracionDTO configuracionDTO);

    void eliminarConfiguracionPorId(Integer id);
=======
    Optional<Configuracion> obtenerConfiguracionPorId(String id);

    Configuracion guardarConfiguracion(ConfiguracionDTO configuracionDTO);

    void eliminarConfiguracionPorId(String id);
>>>>>>> a37ec885e7975e2cc4292fb76b191a78432272b3
}
