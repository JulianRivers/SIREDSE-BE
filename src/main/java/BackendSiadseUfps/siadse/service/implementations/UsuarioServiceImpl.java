package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.entity.Usuario;
import BackendSiadseUfps.siadse.repository.UsuarioRepository;
import BackendSiadseUfps.siadse.service.interfaces.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	 private final UsuarioRepository usuarioRepository;

	    @Autowired
	    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
	        this.usuarioRepository = usuarioRepository;
	    }

	    @Override
	    public Usuario guardarUsuario(Usuario usuario) {
	        return usuarioRepository.save(usuario);
	    }

	    @Override
	    public Usuario obtenerUsuarioPorId(Long id) {
	        return usuarioRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Usuario obtenerUsuarioPorEmail(String email) {
	        return usuarioRepository.findByEmail(email);
	    }

}
