package IS.grupoD.Mi2is.P6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import IS.grupoD.Mi2is.P6.model.UsuarioService;


@Controller
public class PlantillaController {

    private final UsuarioService usuarioService;

    // Inyección por constructor (mejor práctica)
    public PlantillaController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Ruta que devuelve un HTML, igual que tu ejemplo
    @GetMapping("/plantillas/{id}")
    public String mostrarPlantilla(@PathVariable long id, Model model) {

        // Obtenemos el usuario por id y pasamos datos al HTML
        var usuario = usuarioService.getUsuarioById(id)
                .orElse(null);

        model.addAttribute("usuario", usuario);

        return "plantilla"; // /templates/plantilla.html
    }
}
