package IS.grupoD.Mi2is.P6;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import IS.grupoD.Mi2is.P6.model.Medico;
import IS.grupoD.Mi2is.P6.model.Paciente;
import IS.grupoD.Mi2is.P6.model.UsuarioService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		
	}

	@Bean
    CommandLineRunner init(UsuarioService usuarioService) {
        return args -> {
            usuarioService.addUsuario(new Medico("N1", "A1", "CC1", "Cardiologia", "Centro1"));
            usuarioService.addUsuario(new Paciente("N2", "A2", "CC2", "NSS1", "DNI1",
                    "email1", "123456789", LocalDate.of(2000, 1, 1)));
        };
    }

}
