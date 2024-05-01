package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.entity.Usuario;

public interface UsuarioService {
	Usuario guardarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Long id);
    Usuario obtenerUsuarioPorEmail(String email);
}
