package BackendSiadseUfps.siadse.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import BackendSiadseUfps.siadse.dto.ProjectDTO;
import BackendSiadseUfps.siadse.entity.Project;
import BackendSiadseUfps.siadse.entity.Semillero;
import BackendSiadseUfps.siadse.entity.User;
import BackendSiadseUfps.siadse.repository.ProjectRepository;
import BackendSiadseUfps.siadse.repository.SemilleroRepository;
import BackendSiadseUfps.siadse.repository.UserRepository;
import BackendSiadseUfps.siadse.service.interfaces.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService {
    private final ModelMapper modelMapper;
    private final ProjectRepository projectRepository;
    private final SemilleroRepository semilleroRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectServiceImpl(ModelMapper modelMapper, ProjectRepository projectRepository,
                              SemilleroRepository semilleroRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
        this.semilleroRepository = semilleroRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        
        // Asignar semillero existente al proyecto
        if (projectDTO.getSemillero() != null) {
            Semillero semillero = semilleroRepository.findById(projectDTO.getSemillero().getId())
                    .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
            project.setSemillero(semillero);
        }

        // Asignar líder del proyecto existente
        if (projectDTO.getProjectLeader() != null) {
            User projectLeader = userRepository.findById(projectDTO.getProjectLeader().getId())
                    .orElseThrow(() -> new RuntimeException("Líder del proyecto no encontrado"));
            project.setProjectLeader(projectLeader);
        }

        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO getProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        modelMapper.map(projectDTO, project);
        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

	@Override
	public void guardar(ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProjectDTO buscarPorId(Long idSolicitud) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Project findProjectByLeaderId(Integer leaderId) {
        return projectRepository.findByProjectLeaderId(leaderId);
    }
}