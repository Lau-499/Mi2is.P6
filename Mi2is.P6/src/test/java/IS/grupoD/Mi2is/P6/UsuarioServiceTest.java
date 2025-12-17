package IS.grupoD.Mi2is.P6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import IS.grupoD.Mi2is.P6.model.Medico;
import IS.grupoD.Mi2is.P6.model.Paciente;
import IS.grupoD.Mi2is.P6.model.RepositoryUsuario;
import IS.grupoD.Mi2is.P6.model.Usuario;
import IS.grupoD.Mi2is.P6.model.UsuarioService;


@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    RepositoryUsuario repositoryUsuario;

    @InjectMocks
    private UsuarioService usuarioService;
    
    @Test
    @DisplayName("Comprueba que se pueden obtener todos los usuarios")
    public void getAllUsuarios_noUsuarios_obtieneListaVacia() {
        //Arrange

        //Act
        List<Usuario> result = usuarioService.getAllUsuarios();
        when(repositoryUsuario.findAll()).thenReturn(List.of());
        int size0obtained = result.size();

        //Assert
        assertEquals(0, size0obtained);
        verify(repositoryUsuario).findAll();
        
    }

    @Test
    @DisplayName("Comprueba que devuelve más de un usuario")
    public void getAllUsuarios_unUsuario_obtieneListaConUnUsuario() {
        //Arrange
        Paciente Paciente1 = new Paciente("Juan", "Perez", "1234", "NSS12345","DNI12345","JUAN@EMAIL.COM","1235456778", LocalDate.of(1990, 5, 20));
        Medico Medico1 = new Medico("Ana", "Gomez", "abcd", "Cirugía","Hospital Central");
        when(repositoryUsuario.findAll()).thenReturn(Arrays.asList(Paciente1, Medico1));

        //Act
        List<Usuario> result = usuarioService.getAllUsuarios();
        int size2obtained = result.size();

        //Assert
        assertEquals(2, size2obtained);
        verify(repositoryUsuario).findAll();
    }

    @Test
    @DisplayName("Comprueba que se puede obtener un usuario por ID")
    public void getUsuario_usuarioExistente_usuarioObtenido() {
        //Arrange
        Medico mmedico = new Medico("Ana", "Paez", "abcd", "Dermatología","Hospital Central");
        when(repositoryUsuario.findById(1L)).thenReturn(java.util.Optional.of(mmedico));
        Paciente ppaciente = new Paciente("Luis", "Martinez", "1234", "NSS67890","DNI67890","LUIS@EMAIL.COM","1235456778", LocalDate.of(1990, 5, 20));
        when(repositoryUsuario.findById(2L)).thenReturn(java.util.Optional.of(ppaciente));

        //Act
        Optional<Usuario> result1 = usuarioService.getUsuarioById(1L);
        Optional<Usuario> result2 = usuarioService.getUsuarioById(2L);

        //Assert
        assertTrue(result1.isPresent());
        assertEquals(mmedico, result1.get());
        assertTrue(result2.isPresent());
        assertEquals(ppaciente, result2.get());
        verify(repositoryUsuario).findById(1L);
        verify(repositoryUsuario).findById(2L);
    }

    @Test
    @DisplayName("Comprueba que se puede añadir un usuario")
    public void updateUsuario_cuentaExistente_usuarioActualizado() {
        //Arrange
        Medico Medicooo = new Medico("Anita", "Gomez", "abcd", "Cirugía","Hospital Central");
        when(repositoryUsuario.save(Medicooo)).thenReturn(Medicooo);
        Paciente Pacienteee = new Paciente("Luis", "Martinez", "1234", "NSS67890","DNI67890","LUIS@EMAIL.COM","1235456778", LocalDate.of(1990, 5, 20));
        when(repositoryUsuario.save(Pacienteee)).thenReturn(Pacienteee);

        //Act
        Usuario result = usuarioService.addUsuario(Medicooo);
        String expectedNombre = "Anita";
        String expectedApellidos = "Gomez";
        String expectedContrasenya = "abcd";
        String expectedEspecialidad = "Cirugía";
        String expectedCentroMedico = "Hospital Central";
        Usuario result2 = usuarioService.addUsuario(Pacienteee);
        String expectedNombre2 = "Luis";
        String expectedApellidos2 = "Martinez";
        String expectedContrasenya2 = "1234";
        String expectedNSS = "NSS67890";
        String expectedDNI = "DNI67890";
        String expectedEmail = "LUIS@EMAIL.COM";
        String expectedTelefono = "1235456778";
        LocalDate expectedFechaNacimiento = LocalDate.of(1990, 5, 20);

        // Assert
        assertEquals(expectedNombre, result.getNombre());
        assertEquals(expectedApellidos, result.getApellidos());
        assertEquals(expectedContrasenya, result.getContrasenya());
        assertEquals(expectedEspecialidad, ((Medico) result).getEspecialidad());
        assertEquals(expectedCentroMedico, ((Medico) result).getCentroMedico());
        verify(repositoryUsuario).save(Medicooo);
        
        assertEquals(expectedNombre2, result2.getNombre());
        assertEquals(expectedApellidos2, result2.getApellidos());
        assertEquals(expectedContrasenya2, result2.getContrasenya());
        assertEquals(expectedNSS, ((Paciente) result2).getNss());
        assertEquals(expectedDNI, ((Paciente) result2).getDni());
        assertEquals(expectedEmail, ((Paciente) result2).getEmail());
        assertEquals(expectedTelefono, ((Paciente) result2).getTelefono());
        assertEquals(expectedFechaNacimiento, ((Paciente) result2).getFechaNacimiento());
        verify(repositoryUsuario).save(Pacienteee);

    }

    @Test
    @DisplayName("Comprueba que se puede actualizar un paciente")
    public void updateUsuario_usuarioExistente_usuarioActualizado() {
        //Arrange
        Medico medi = new Medico("Maria", "Paez", "abcd", "Dermatología","Hospital Central");
        medi.setId(1L);
        when(repositoryUsuario.findById(1L)).thenReturn(java.util.Optional.of(medi));
        when(repositoryUsuario.save(medi)).thenReturn(medi);
        Paciente pac = new Paciente("Luis", "Martinez", "1234", "NSS67890","DNI67890","LUIS@EMAIL.COM","1235456778", LocalDate.of(1990, 5, 20));
        pac.setId(2L);
        when(repositoryUsuario.findById(2L)).thenReturn(java.util.Optional.of(pac));
        when(repositoryUsuario.save(pac)).thenReturn(pac);
        
        //Act
        medi.setEspecialidad("Pediatría");
        Usuario result = usuarioService.updateUsuario(1L, medi);
        pac.setEmail("f@mail.com");
        Usuario result2 = usuarioService.updateUsuario(2L, pac);

        //Assert
        assertEquals(result, medi);
        verify(repositoryUsuario).findById(1L);
        verify(repositoryUsuario).save(medi);
        assertEquals(result2, pac);
        verify(repositoryUsuario).findById(2L);
        verify(repositoryUsuario).save(pac);
    }

    @SuppressWarnings("null")
    @Test
    @DisplayName("Comprueba que no se puede actualizar un médico que no existe")
    public void updateUsuario_medicoNoExistente_lanzaExcepcion() {
        // Arrange
        Medico medicoNoExistente = new Medico("Carlos", "Lopez", "abcd", "Cardiología", "Hospital Norte");
        when(repositoryUsuario.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () ->
            usuarioService.updateUsuario(99L, medicoNoExistente)
        );

        verify(repositoryUsuario).findById(99L);
        verify(repositoryUsuario, never()).save(any());
    }

    @SuppressWarnings("null")
    @Test
    @DisplayName("Comprueba que no se puede actualizar un paciente que no existe")
    public void updateUsuario_pacienteNoExistente_lanzaExcepcion() {
        // Arrange
        Paciente pacienteNoExistente = new Paciente(
            "Sofia", "Ramirez", "1234",
            "NSS54321", "DNI54321",
            "SOFIA@EMAIL.COM", "1234567890",
            LocalDate.of(1995, 8, 15)
        );

        when(repositoryUsuario.findById(100L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () ->
            usuarioService.updateUsuario(100L, pacienteNoExistente)
        );

        verify(repositoryUsuario).findById(100L);
        verify(repositoryUsuario, never()).save(any());
    }



    @Test
    @DisplayName("Comprueba que no se puede eliminar un usuario a través del objeto usuario que no existe")
    public void deleteUsuario_usuarioNoExistente_lanzaExcepcion() {
        //Arrange
        Medico med = new Medico("Laura", "Sanchez", "abcd", "Neurología","Hospital Este");
        med.setId(50L);
        Paciente paci = new Paciente("Diego", "Torres", "1234", "NSS11223","DNI11223","DIEGO@EMAIL.COM","1234567890", LocalDate.of(1992, 10, 10));
        paci.setId(60L);

        when(repositoryUsuario.existsById(50L)).thenReturn(false);
        when(repositoryUsuario.existsById(60L)).thenReturn(false);

        //Act & Assert
        assertThrows(RuntimeException.class, () -> {
            usuarioService.deleteUsuario(med.getId());
            usuarioService.deleteUsuario(paci.getId());
        });
        verify(repositoryUsuario).existsById(50L);
        verify(repositoryUsuario, never()).deleteById(50L);
        verify(repositoryUsuario).existsById(60L);
        verify(repositoryUsuario, never()).deleteById(60L);
    }

    @Test
    @DisplayName("Comprueba que se puede eliminar un usuario a través del objeto usuario")
    public void deleteUsuario_usuarioExistente_usuarioEliminado() {
        //Arrange
        Medico med = new Medico("Laura", "Sanchez", "abcd", "Neurología","Hospital Este");
        med.setId(10L);
        Paciente paci = new Paciente("Diego", "Torres", "1234", "NSS11223","DNI11223","DIEGO@EMAIL.COM","1234567890", LocalDate.of(1992, 10, 10));
        paci.setId(20L);

        when(repositoryUsuario.existsById(10L)).thenReturn(true);
        when(repositoryUsuario.existsById(20L)).thenReturn(true);

        //Act
        usuarioService.deleteUsuario(med.getId());
        usuarioService.deleteUsuario(paci.getId());
        //Assert
        verify(repositoryUsuario).existsById(10L);
        verify(repositoryUsuario).deleteById(10L);
        verify(repositoryUsuario).existsById(20L);
        verify(repositoryUsuario).deleteById(20L);
    }

    @SuppressWarnings("null")
    @Test
    @DisplayName("Comprueba que no se puede eliminar un usuario por id si el id es null")
    public void deleteUsuario_idNull_lanzaExcepcion() {
        //Arrange
        Long id = null;

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.deleteUsuario(id);
        });
        verify(repositoryUsuario, never()).deleteById(id);

    }

    @Test
    @DisplayName("Comprueba que no se puede eliminar una cuenta con un id que no existe")
    public void deleteUsuario_idNoExistente_lanzaExcepcion() {
        //Arrange
        Long idNoExistente = 999L;
        when(repositoryUsuario.existsById(idNoExistente)).thenReturn(false);

        //Act & Assert
        assertThrows(RuntimeException.class, () -> {
            usuarioService.deleteUsuario(idNoExistente);
        });
        verify(repositoryUsuario).existsById(idNoExistente);
        verify(repositoryUsuario, never()).deleteById(idNoExistente);
    }

    @Test
    @DisplayName("Comprueba que se puede eliminar una cuenta con un id")
    public void deleteUsuario_idExistente_usuarioEliminado() {
        //Arrange
        Long idExistente = 1L;
        when(repositoryUsuario.existsById(idExistente)).thenReturn(true);

        //Act
        usuarioService.deleteUsuario(idExistente);

        //Assert
        verify(repositoryUsuario).deleteById(idExistente);
    }




    
}
