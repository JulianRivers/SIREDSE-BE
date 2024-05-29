package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.dto.CapacitacionesDTO;
import BackendSiadseUfps.siadse.entity.Capacitaciones;

import java.util.List;
import java.util.Optional;

public interface CapacitacionesService {



    Optional<Capacitaciones> buscarCapacitacionesPorId(Integer id);

    Capacitaciones crearCapacitaciones(CapacitacionesDTO capacitacionesDTO);

}
