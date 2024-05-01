package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.entity.CredencialesLogin;
import BackendSiadseUfps.siadse.entity.Usuario;
import BackendSiadseUfps.siadse.service.interfaces.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    @Autowired
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CredencialesLogin credenciales) {
        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(credenciales.getEmail());

        if (usuario != null && usuario.getPassword().equals(credenciales.getPassword())) {
            return new ResponseEntity<>("Login exitoso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }
}
