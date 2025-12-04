package IS.grupoD.Mi2is.P6.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public java.util.List<Usuario> getAllUsuarios() {
        return repositoryUsuario.findAll();
    }
    

    public Usuario addUsuario(Usuario u) {
        if (u == null) {
            throw new IllegalArgumentException("Usuario cannot be null");
        }
        return repositoryUsuario.saveAndFlush(u);
    }
}