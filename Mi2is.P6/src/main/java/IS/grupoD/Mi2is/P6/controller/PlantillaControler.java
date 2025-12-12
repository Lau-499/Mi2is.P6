package IS.grupoD.Mi2is.P6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PlantillaControler {

    @Autowired //para inyectar el servicio
    private PlantillaControler serviceCuenta;
    @GetMapping("/plantillas")
    public String mostrarPlantilla(@PathVariable long id, Model model) {

        model.addAttribute("mensaje", serviceCuenta.getPlantilla(id)());
        return "index";
    }
}
