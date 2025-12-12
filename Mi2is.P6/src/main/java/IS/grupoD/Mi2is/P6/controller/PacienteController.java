package IS.grupoD.Mi2is.P6.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import IS.grupoD.Mi2is.P6.model.Paciente;
import IS.grupoD.Mi2is.P6.model.UsuarioService;

@RestController
public class PacienteController {
  private final UsuarioService usuarioService;
  public PacienteController(UsuarioService usuarioService){ this.usuarioService = usuarioService; }

  @PostMapping("/pacientes")
  public Paciente add(@RequestBody Paciente p){
    return (Paciente) usuarioService.addUsuario(p);
  }
}