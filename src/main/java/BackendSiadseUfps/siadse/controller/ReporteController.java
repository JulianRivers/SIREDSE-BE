package BackendSiadseUfps.siadse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSiadseUfps.siadse.dto.RoleDTO;
import BackendSiadseUfps.siadse.dto.UserDTO;
import BackendSiadseUfps.siadse.entity.User;
import BackendSiadseUfps.siadse.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = users.stream().map(this::convertToUserDTO).collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }
    
    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCodigoUniversidad(user.getCodigoUniversidad());
        userDTO.setSemestreActual(user.getSemestreActual());
        userDTO.setEdad(user.getEdad());
        userDTO.setDireccionResidencia(user.getDireccionResidencia());
        userDTO.setCelular(user.getCelular());
        
        if (user.getRole() != null) {
            userDTO.setRole(new RoleDTO(user.getRole().getId(), user.getRole().getName()));
        }
        return userDTO;
    }
}
