package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.service.interfaces.ConfiguracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import BackendSiadseUfps.siadse.entity.Configuracion;
import BackendSiadseUfps.siadse.dto.ConfiguracionDTO;
import BackendSiadseUfps.siadse.repository.ConfiguracionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {

    @Autowired
    private ConfiguracionRepository configuracionRepository;

    @Override
    public List<Configuracion> obtenerTodasLasConfiguraciones() {
        return configuracionRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public Optional<Configuracion> obtenerConfiguracionPorId(Integer id) {
=======
    public Optional<Configuracion> obtenerConfiguracionPorId(String id) {
>>>>>>> a37ec885e7975e2cc4292fb76b191a78432272b3
        return configuracionRepository.findById(id);
    }

    @Override
    public Configuracion obtenerConfiguracionUnica() {
        List<Configuracion> configuraciones = configuracionRepository.findAll();
        if (configuraciones.isEmpty()) {
            // Si no hay ninguna configuración, puedes crear una nueva o lanzar una excepción
            // Aquí lo crearemos por simplicidad
            return configuracionRepository.save(new Configuracion());
        } else {
            return configuraciones.get(0);
        }
    }

    @Override
    public Configuracion actualizarConfiguracion(ConfiguracionDTO configuracionDTO) {
        Configuracion configuracion = obtenerConfiguracionUnica();
        configuracion.setNombre(configuracionDTO.getNombre());
        configuracion.setDescripcion(configuracionDTO.getDescripcion());
        configuracion.setMision(configuracionDTO.getMision());
        configuracion.setVision(configuracionDTO.getVision());
        configuracion.setDepartamento(configuracionDTO.getDepartamento());
        configuracion.setDocente(configuracionDTO.getDocente());
        configuracion.setLider(configuracionDTO.getLider());
        return configuracionRepository.save(configuracion);
    }

    @Override
    public Configuracion guardarConfiguracion(ConfiguracionDTO configuracionDTO) {
        Configuracion configuracion = new Configuracion();
        configuracion.setNombre(configuracionDTO.getNombre());
        configuracion.setDescripcion(configuracionDTO.getDescripcion());
        configuracion.setMision(configuracionDTO.getMision());
        configuracion.setVision(configuracionDTO.getVision());
        configuracion.setDocente(configuracionDTO.getDocente());
        configuracion.setLider(configuracionDTO.getLider());
        return configuracionRepository.save(configuracion);
    }

    @Override
<<<<<<< HEAD
    public void eliminarConfiguracionPorId(Integer id) {
=======
    public void eliminarConfiguracionPorId(String id) {
>>>>>>> a37ec885e7975e2cc4292fb76b191a78432272b3
        configuracionRepository.deleteById(id);
    }
}
