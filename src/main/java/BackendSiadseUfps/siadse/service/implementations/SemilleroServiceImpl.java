package BackendSiadseUfps.siadse.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BackendSiadseUfps.siadse.dto.ProjectDTO;
import BackendSiadseUfps.siadse.dto.SemilleroDTO;
import BackendSiadseUfps.siadse.dto.UserDTO;
import BackendSiadseUfps.siadse.entity.Project;
import BackendSiadseUfps.siadse.entity.Semillero;
import BackendSiadseUfps.siadse.entity.User;
import BackendSiadseUfps.siadse.repository.ProjectRepository;
import BackendSiadseUfps.siadse.repository.SemilleroRepository;
import BackendSiadseUfps.siadse.repository.UserRepository;
import BackendSiadseUfps.siadse.service.interfaces.SemilleroService;

@Service
public class SemilleroServiceImpl implements SemilleroService {

    @Autowired
    private SemilleroRepository semilleroRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SemilleroDTO crearSemillero(SemilleroDTO semilleroDTO) {
        Semillero semillero = modelMapper.map(semilleroDTO, Semillero.class);
        semillero = semilleroRepository.save(semillero);
        return modelMapper.map(semillero, SemilleroDTO.class);
    }

    @Override
    public SemilleroDTO asignarDirector(Integer semilleroId, Integer directorId) {
        Semillero semillero = semilleroRepository.findById(semilleroId)
                .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
        User director = userRepository.findById(directorId)
                .orElseThrow(() -> new RuntimeException("Director no encontrado"));
        semillero.setDirector(director);
        semillero = semilleroRepository.save(semillero);
        return modelMapper.map(semillero, SemilleroDTO.class);
    }

    @Override
    public ProjectDTO addProjectToSemillero(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        Semillero semillero = semilleroRepository.findById(projectDTO.getSemillero().getId())
                .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
        project.setSemillero(semillero);
        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public List<SemilleroDTO> getAllSeedbeds() {
        List<Semillero> semilleros = semilleroRepository.findAll();
        return semilleros.stream()
                .map(semillero -> modelMapper.map(semillero, SemilleroDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SemilleroDTO getSeedbedId(Integer id) {
        Semillero semillero = semilleroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
        return modelMapper.map(semillero, SemilleroDTO.class);
    }

    @Override
    public SemilleroDTO updateSeedbed(Integer id, SemilleroDTO seedbedDTO) {
        Semillero semillero = semilleroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
        modelMapper.map(seedbedDTO, semillero);
        semillero = semilleroRepository.save(semillero);
        return modelMapper.map(semillero, SemilleroDTO.class);
    }

    @Override
    public void deleteSeedbed(Integer id) {
        semilleroRepository.deleteById(id);
    }

    @Override
    public boolean inscribirse(Integer semilleroId, String codigo, UserDTO userDTO) {
        Semillero semillero = semilleroRepository.findById(semilleroId)
                .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
        if (!semillero.getCodigo().equals(codigo)) {
            return false; // Código incorrecto
        }
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        semillero.getMiembros().add(user);
        semilleroRepository.save(semillero);
        return true;
    }

    @Override
    public List<UserDTO> getMiembros(Integer semilleroId) {
        Semillero semillero = semilleroRepository.findById(semilleroId)
                .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
        return semillero.getMiembros().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}
