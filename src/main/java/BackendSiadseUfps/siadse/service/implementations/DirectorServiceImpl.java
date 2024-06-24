package BackendSiadseUfps.siadse.service.implementations;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BackendSiadseUfps.siadse.dto.SemilleroDTO;
import BackendSiadseUfps.siadse.dto.UserDTO;
import BackendSiadseUfps.siadse.entity.Semillero;
import BackendSiadseUfps.siadse.entity.User;
import BackendSiadseUfps.siadse.repository.SemilleroRepository;
import BackendSiadseUfps.siadse.repository.UserRepository;
import BackendSiadseUfps.siadse.service.interfaces.DirectorService;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private SemilleroRepository semilleroRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SemilleroDTO crearSemillero(SemilleroDTO semilleroDTO) {
        Semillero semillero = modelMapper.map(semilleroDTO, Semillero.class);
        semillero = semilleroRepository.save(semillero);
        return modelMapper.map(semillero, SemilleroDTO.class);
    }

    @Override
    public SemilleroDTO actualizarSemillero(Integer semilleroId, SemilleroDTO semilleroDTO) {
        Semillero semillero = semilleroRepository.findById(semilleroId)
                .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
        semillero.setNombre(semilleroDTO.getNombre());
        semillero.setDescripcion(semilleroDTO.getDescripcion());
        semillero = semilleroRepository.save(semillero);
        return modelMapper.map(semillero, SemilleroDTO.class);
    }

    @Override
    public void eliminarSemillero(Integer semilleroId) {
        if (semilleroRepository.existsById(semilleroId)) {
            semilleroRepository.deleteById(semilleroId);
        } else {
            throw new RuntimeException("Semillero no encontrado");
        }
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
    public List<UserDTO> obtenerMiembros(Integer semilleroId) {
        Semillero semillero = semilleroRepository.findById(semilleroId)
                .orElseThrow(() -> new RuntimeException("Semillero no encontrado"));
        return semillero.getMiembros().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean inscribirMiembro(Integer semilleroId, String codigo, UserDTO userDTO) {
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
}
