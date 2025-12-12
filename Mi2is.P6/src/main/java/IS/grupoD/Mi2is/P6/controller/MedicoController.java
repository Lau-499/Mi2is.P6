package IS.grupoD.Mi2is.P6.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import IS.grupoD.Mi2is.P6.model.Medico;
import IS.grupoD.Mi2is.P6.model.UsuarioService;

@RestController
public class MedicoController {
  private final UsuarioService usuarioService;
  public MedicoController(UsuarioService usuarioService){ this.usuarioService = usuarioService; }

  @PostMapping("/medicos")
  public Medico add(@RequestBody Medico m){
    return (Medico) usuarioService.addUsuario(m);
  }
}
