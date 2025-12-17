package IS.grupoD.Mi2is.P6;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import IS.grupoD.Mi2is.P6.model.Medico;

public class MedicoTest {
    
    private Medico medico;
    @BeforeEach
    public void setUp() {   
        medico = new Medico();
    }       

    @Test
    @DisplayName("Comprueba que el medico con un nombre se crea correctamente")
    public void medico_Constructor_Correcto() {
        // Arrange
        String nombre = "Juan";
        String apellidos = "Perez";
        String contrasenya = "abc123";
        String especialidad = "Cardiologia";
        String centroMedico = "Hospital Central";

        // Act
        Medico medico_con_nombre = new Medico(nombre, apellidos, contrasenya, especialidad, centroMedico);
        String nombre_obtained = medico_con_nombre.getNombre();
        String apellidos_obtained = medico_con_nombre.getApellidos();
        String contrasenya_obtained = medico_con_nombre.getContrasenya();
        String especialidad_obtained = medico_con_nombre.getEspecialidad();
        String centroMedico_obtained = medico_con_nombre.getCentroMedico();
        
        // Assert
        assertEquals(nombre, nombre_obtained);   
        assertEquals(apellidos, apellidos_obtained);   
        assertEquals(contrasenya, contrasenya_obtained);   
        assertEquals(especialidad, especialidad_obtained);   
        assertEquals(centroMedico, centroMedico_obtained);   
    }

    @Test
    @DisplayName("Comprueba que el nombre se obtiene correctamente")    
    public void nombre_getNombre_Correcto() {
        // Arrange
        String nombre = "Juan";
        medico.setNombre(nombre);
        
        // Act
        String nombre_obtained = medico.getNombre();

        // Assert
        assertEquals(nombre, nombre_obtained);   
    }

    @Test
    @DisplayName("Comprueba que los apellidos se obtienen correctamente")
    public void apellidos_getApellidos_Correcto() {
        // Arrange
        String apellidos = "Perez";
        medico.setApellidos(apellidos);
        
        // Act
        String apellidos_obtained = medico.getApellidos();

        // Assert
        assertEquals(apellidos, apellidos_obtained);   
    }

    @Test
    @DisplayName("Comprueba que la contrasenya se obtiene correctamente")
    public void contrasenya_getContrasenya_Correcto() {
        // Arrange
        String contrasenya = "abc123";
        medico.setContrasenya(contrasenya);
        
        // Act
        String contrasenya_obtained = medico.getContrasenya();

        // Assert
        assertEquals(contrasenya, contrasenya_obtained);   
    }

    @Test
    @DisplayName("Comprueba que la especialidad se obtiene correctamente")  
    public void especialidad_getEspecialidad_Correcto() {
        // Arrange
        String especialidad = "Cardiologia";
        medico.setEspecialidad(especialidad);
        
        // Act
        String especialidad_obtained = medico.getEspecialidad();

        // Assert
        assertEquals(especialidad, especialidad_obtained);   
    }

    @Test
    @DisplayName("Comprueba que el centro medico se obtiene correctamente")
    public void centroMedico_getCentroMedico_Correcto() {
        // Arrange
        String centroMedico = "Hospital Central";
        medico.setCentroMedico(centroMedico);
        
        // Act
        String centroMedico_obtained = medico.getCentroMedico();

        // Assert
        assertEquals(centroMedico, centroMedico_obtained);   
    }

}


