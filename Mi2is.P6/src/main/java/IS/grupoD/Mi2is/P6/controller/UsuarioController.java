package IS.grupoD.Mi2is.P6.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import IS.grupoD.Mi2is.P6.model.Usuario;

import IS.grupoD.Mi2is.P6.model.UsuarioService;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // GET - List all
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {

        return usuarioService.getAllUsuarios();
    }

    // GET - Get by ID (only numeric IDs to avoid collisions with other paths)
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Create
    @PostMapping
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario u) {
        return ResponseEntity.ok(usuarioService.addUsuario(u));
    }

    // PUT - Update
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<Usuario> updateUsuario(
            @PathVariable Long id,
            @RequestBody Usuario u) {
        try {
            return ResponseEntity.ok(usuarioService.updateUsuario(id, u));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Delete
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        try {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
