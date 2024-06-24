package BackendSiadseUfps.siadse.service.interfaces;

import java.util.List;

import BackendSiadseUfps.siadse.dto.ProjectDTO;
import BackendSiadseUfps.siadse.dto.SemilleroDTO;
import BackendSiadseUfps.siadse.dto.UserDTO;


public interface SemilleroService {
    SemilleroDTO crearSemillero(SemilleroDTO semilleroDTO);
    SemilleroDTO asignarDirector(Integer semilleroId, Integer directorId);
    ProjectDTO addProjectToSemillero(ProjectDTO projectDTO);
    List<SemilleroDTO> getAllSeedbeds();
    SemilleroDTO getSeedbedId(Integer id);
    SemilleroDTO updateSeedbed(Integer id, SemilleroDTO seedbedDTO);
    void deleteSeedbed(Integer id);
    SemilleroDTO getSemillero(Integer semilleroId);
    boolean inscribirse(Integer semilleroId, String codigo, UserDTO userDTO);
    List<UserDTO> getMiembros(Integer semilleroId);
}
