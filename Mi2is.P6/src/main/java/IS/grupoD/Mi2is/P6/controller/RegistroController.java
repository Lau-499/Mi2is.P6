package IS.grupoD.Mi2is.P6.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import IS.grupoD.Mi2is.P6.model.Medico;
import IS.grupoD.Mi2is.P6.model.Paciente;
import IS.grupoD.Mi2is.P6.model.UsuarioService;

@Controller
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register/choice")
    public String chooseRole(@RequestParam String nombre,
            @RequestParam String apellidos,
            @RequestParam String contrasenya,
            @RequestParam String role,
            RedirectAttributes ra) {
        ra.addAttribute("nombre", nombre);
        ra.addAttribute("apellidos", apellidos);
        ra.addAttribute("contrasenya", contrasenya);
        if ("medico".equalsIgnoreCase(role)) {
            return "redirect:/register/medico";
        }
        return "redirect:/register/paciente";
    }

    @GetMapping("/register/medico")
    public String showMedicoForm(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String contrasenya,
            Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellidos", apellidos);
        model.addAttribute("contrasenya", contrasenya);
        return "register_medico";
    }

    @PostMapping("/register/medico")
    public String submitMedico(@RequestParam String nombre,
            @RequestParam String apellidos,
            @RequestParam String contrasenya,
            @RequestParam String especialidad,
            @RequestParam String centroMedico,
            RedirectAttributes ra) {
        Medico m = new Medico(nombre, apellidos, contrasenya, especialidad, centroMedico);
        var saved = usuarioService.addUsuario(m);
        ra.addAttribute("id", saved.getId());
        return "redirect:/usuarioid/{id}";
    }

    @GetMapping("/register/paciente")
    public String showPacienteForm(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String contrasenya,
            Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellidos", apellidos);
        model.addAttribute("contrasenya", contrasenya);
        return "register_paciente";
    }

    @PostMapping("/register/paciente")
    public String submitPaciente(@RequestParam String nombre,
            @RequestParam String apellidos,
            @RequestParam String contrasenya,
            @RequestParam String nss,
            @RequestParam String dni,
            @RequestParam String email,
            @RequestParam String telefono,
            @RequestParam String fechaNacimiento,
            RedirectAttributes ra) {
        LocalDate fecha = null;
        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (Exception e) {
            // ignore
        }
        Paciente p = new Paciente(nombre, apellidos, contrasenya, nss, dni, email, telefono, fecha);
        var saved = usuarioService.addUsuario(p);
        ra.addAttribute("id", saved.getId());
        return "redirect:/usuarioid/{id}";
    }
}
