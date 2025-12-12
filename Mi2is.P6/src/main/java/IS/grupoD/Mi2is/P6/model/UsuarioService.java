package IS.grupoD.Mi2is.P6.model;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final RepositoryUsuario repositoryUsuario;

    public UsuarioService(RepositoryUsuario repositoryUsuario) {
        this.repositoryUsuario = repositoryUsuario;
    }

    public List<Usuario> getAllUsuarios() {
        return repositoryUsuario.findAll();
    }

    public Usuario addUsuario(Usuario u) {
        if (u == null) {
            throw new IllegalArgumentException("Usuario cannot be null");
        }
        return repositoryUsuario.save(u);
    }
}