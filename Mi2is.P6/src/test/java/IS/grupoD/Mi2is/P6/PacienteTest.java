package IS.grupoD.Mi2is.P6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import IS.grupoD.Mi2is.P6.model.Paciente;


public class PacienteTest {

   private Paciente paciente;
   
    @BeforeEach
    public void setUp() {
        paciente = new Paciente();

    }

    @Test
    @DisplayName("Test de creación de Paciente")
    public void Paciente_Constructor_Correcto() {

        // Arrange
        String nombre = "Juan";
        String apellidos = "Perez";
        String contrasenya = "password123";
        String nss = "1234567890";
        String dni = "12345678A";
        String email = "juan.perez@example.com";
        String telefono = "600123456";
        LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1);

        // Act
        Paciente paciente_con_nombre = new Paciente(nombre, apellidos, contrasenya, nss, dni, email, telefono, fechaNacimiento);
        String nombre_obtained = paciente_con_nombre.getNombre();
        String apellidos_obtained = paciente_con_nombre.getApellidos();
        String contrasenya_obtained = paciente_con_nombre.getContrasenya();
        String nss_obtained = paciente_con_nombre.getNss();
        String dni_obtained = paciente_con_nombre.getDni();
        String email_obtained = paciente_con_nombre.getEmail();
        String telefono_obtained = paciente_con_nombre.getTelefono();
        LocalDate fechaNacimiento_obtained = paciente_con_nombre.getFechaNacimiento();

        // Assert
        assertEquals(nombre, nombre_obtained);
        assertEquals(apellidos, apellidos_obtained);
        assertEquals(contrasenya, contrasenya_obtained);
        assertEquals(nss, nss_obtained);
        assertEquals(dni, dni_obtained);
        assertEquals(email, email_obtained);
        assertEquals(telefono, telefono_obtained);
        assertEquals(fechaNacimiento, fechaNacimiento_obtained);
        
    }
    
    @Test
    @DisplayName("Comprueba que el nombre se obtiene correctamente")
    public void nombre_getNombre_Correcto() {
        // Arrange
        String nombre = "Juan";
        paciente.setNombre(nombre);
        
        // Act
        String nombre_obtained = paciente.getNombre();

        // Assert
        assertEquals(nombre, nombre_obtained);   
        
        
    }

    @Test
    @DisplayName("Comprueba que los apellidos se obtienen correctamente")
    public void apellidos_getApellidos_Correcto() {
        // Arrange
        String apellidos = "Perez";
        paciente.setApellidos(apellidos);
        
        // Act
        String apellidos_obtained = paciente.getApellidos();

        // Assert
        assertEquals(apellidos, apellidos_obtained);   
    }
    @Test
    @DisplayName("Comprueba que la contrasenya se obtiene correctamente")   
    public void contrasenya_getContrasenya_Correcto() {
        // Arrange
        String contrasenya = "abc123";
        paciente.setContrasenya(contrasenya);
        
        // Act
        String contrasenya_obtained = paciente.getContrasenya();

        // Assert
        assertEquals(contrasenya, contrasenya_obtained);   
    }

    @Test
    @DisplayName("Comprueba que el NSS se obtiene correctamente")
    public void nss_getNss_Correcto() {
        // Arrange
        String nss = "1234567890";
        paciente.setNss(nss);
        
        // Act
        String nss_obtained = paciente.getNss();

        // Assert
        assertEquals(nss, nss_obtained);   
    }

    @Test
    @DisplayName("Comprueba que el DNI se obtiene correctamente")
    public void dni_getDni_Correcto() {
        // Arrange
        String dni = "12345678A";
        paciente.setDni(dni);

        // Act
        String dni_obtained = paciente.getDni();
        
        // Assert
        assertEquals(dni, dni_obtained);
    }


    @Test
    @DisplayName("Comprueba que el email se obtiene correctamente")
    public void email_getEmail_Correcto() {
        // Arrange
        String email = "juan.perez@example.com";
        paciente.setEmail(email);
        // Act
        String email_obtained = paciente.getEmail();
        // Assert
        assertEquals(email, email_obtained);
    }   

    @Test
    @DisplayName("Comprueba que el telefono se obtiene correctamente")
    public void telefono_getTelefono_Correcto() {
        // Arrange
        String telefono = "600123456";
        paciente.setTelefono(telefono);
        
        // Act
        String telefono_obtained = paciente.getTelefono();

        // Assert
        assertEquals(telefono, telefono_obtained);   
    }

    @Test
    @DisplayName("Comprueba que la fecha de nacimiento se obtiene correctamente")   
    public void fechaNacimiento_getFechaNacimiento_Correcto() {
        // Arrange
        LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1);
        paciente.setFechaNacimiento(fechaNacimiento);
        
        // Act
        LocalDate fechaNacimiento_obtained = paciente.getFechaNacimiento();

        // Assert
        assertEquals(fechaNacimiento, fechaNacimiento_obtained);   
    }

}
