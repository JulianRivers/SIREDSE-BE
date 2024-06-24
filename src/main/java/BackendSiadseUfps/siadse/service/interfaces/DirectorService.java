package BackendSiadseUfps.siadse.service.interfaces;



import java.util.List;

import BackendSiadseUfps.siadse.dto.SemilleroDTO;
import BackendSiadseUfps.siadse.dto.UserDTO;

public interface DirectorService {
    SemilleroDTO crearSemillero(SemilleroDTO semilleroDTO);
    SemilleroDTO actualizarSemillero(Integer semilleroId, SemilleroDTO semilleroDTO);
    void eliminarSemillero(Integer semilleroId);
    SemilleroDTO asignarDirector(Integer semilleroId, Integer directorId);
    List<UserDTO> obtenerMiembros(Integer semilleroId);
    boolean inscribirMiembro(Integer semilleroId, String codigo, UserDTO userDTO);
}
