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

    public java.util.Optional<Usuario> getUsuarioById(Long id) {
        return repositoryUsuario.findById(id);
    }
    public Usuario addUsuario(Usuario u) {
        if (u == null) {
            throw new IllegalArgumentException("Usuario cannot be null");
        }
        return repositoryUsuario.save(u);
    }

    public Usuario updateUsuario(Long id, Usuario updatedData) {
        return repositoryUsuario.findById(id)
                .map(user -> {
                    user.setNombre(updatedData.getNombre());
                    user.setContrasenya(updatedData.getContrasenya());
                    user.setId(updatedData.getId());
                    user.setApellidos(updatedData.getApellidos());
                    return repositoryUsuario.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
    }

    public void deleteUsuario(Long id) {
        if (!repositoryUsuario.existsById(id)) {
            throw new RuntimeException("Usuario not found");
        }
        repositoryUsuario.deleteById(id);
    }
}