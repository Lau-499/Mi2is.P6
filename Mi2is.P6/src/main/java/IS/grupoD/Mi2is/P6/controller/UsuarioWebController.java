package IS.grupoD.Mi2is.P6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import IS.grupoD.Mi2is.P6.model.Usuario;
import IS.grupoD.Mi2is.P6.model.UsuarioService;

@Controller
public class UsuarioWebController {

    private final UsuarioService usuarioService;

    public UsuarioWebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario/form")
    public String showForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario";
    }

    @PostMapping("/usuario/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.addUsuario(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/usuario/lista")
    public String lista(Model model) {
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "lista_usuarios";
    }
}
