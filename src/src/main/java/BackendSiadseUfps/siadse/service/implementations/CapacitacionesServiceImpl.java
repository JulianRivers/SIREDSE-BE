package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.CapacitacionesDTO;
import BackendSiadseUfps.siadse.entity.Capacitaciones;
import BackendSiadseUfps.siadse.entity.Semillero;
import BackendSiadseUfps.siadse.repository.CapacitacionesRepository;
import BackendSiadseUfps.siadse.repository.SemilleroRepository;
import BackendSiadseUfps.siadse.service.interfaces.CapacitacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CapacitacionesServiceImpl implements CapacitacionesService {

    @Autowired
    private CapacitacionesRepository capacitacionesRepository;

    

    @Override
    public Optional<Capacitaciones> buscarCapacitacionesPorId(Integer id) {
        return capacitacionesRepository.findById(id);
    }

    

    @Override
    public Capacitaciones crearCapacitaciones(CapacitacionesDTO capacitacionesDTO) {
        Capacitaciones capacitaciones = new Capacitaciones();
        capacitaciones.setTitulo(capacitacionesDTO.getTitulo());
        capacitaciones.setFechai(capacitacionesDTO.getFechai());
        capacitaciones.setFechaf(capacitacionesDTO.getFechaf());
        capacitaciones.setModalidad(capacitacionesDTO.getModalidad());
        capacitaciones.setUbicacion(capacitacionesDTO.getUbicacion());
        capacitaciones.setCosto(capacitacionesDTO.getCosto());
        capacitaciones.setResponsable(capacitacionesDTO.getResponsable());
        capacitaciones.setCargo(capacitacionesDTO.getCargo());
        capacitaciones.setCorreo(capacitacionesDTO.getCorreo());
        capacitaciones.setTelefono(capacitacionesDTO.getTelefono());
        capacitaciones.setCupos(capacitacionesDTO.getCupos());
        capacitaciones.setObjetivos(capacitacionesDTO.getObjetivos());
        capacitaciones.setDescripcion(capacitacionesDTO.getDescripcion());
        capacitaciones.setLogo(capacitacionesDTO.getLogo());
        capacitaciones.setContenido(capacitacionesDTO.getContenido());

 

        return capacitacionesRepository.save(capacitaciones);
       
    }


}
