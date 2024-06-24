package BackendSiadseUfps.siadse.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import BackendSiadseUfps.siadse.dto.UserDTO;
import BackendSiadseUfps.siadse.entity.RevokedToken;
import BackendSiadseUfps.siadse.entity.Role;
import BackendSiadseUfps.siadse.entity.User;
import BackendSiadseUfps.siadse.repository.RevokedTokenRepository;
import BackendSiadseUfps.siadse.repository.RoleRepository;
import BackendSiadseUfps.siadse.repository.UserRepository;
import BackendSiadseUfps.siadse.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RevokedTokenRepository revokedTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserDTO userDTO) {
        Role studentRole = roleRepository.findById(3L).orElseThrow(() -> new RuntimeException("Role ESTUDIANTE no encontrado"));
        return createUser(userDTO, studentRole);
    }

   

    private User createUser(UserDTO userDTO, Role role) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCodigoUniversidad(userDTO.getCodigoUniversidad());
        user.setSemestreActual(userDTO.getSemestreActual());
        user.setEdad(userDTO.getEdad());
        user.setDireccionResidencia(userDTO.getDireccionResidencia());
        user.setCelular(userDTO.getCelular());
        user.setRole(role);
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public void logoutUser(String token) {
        RevokedToken revokedToken = new RevokedToken();
        revokedToken.setToken(token);
        revokedTokenRepository.save(revokedToken);
    }
}
