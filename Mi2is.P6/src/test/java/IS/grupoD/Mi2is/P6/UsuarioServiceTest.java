package IS.grupoD.Mi2is.P6;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(mmedico, result1);
        assertEquals(ppaciente, result2);
        verify(repositoryUsuario).findById(1L);
        verify(repositoryUsuario).findById(2L);
    }

    @Test
    @DisplayName("Comprueba que se puede añadir un usuario")
    public void updateCuenta_cuentaExistente_cuentaActualizada() {
        //Arrange
        Medico Medicooo = new Medico("Anita", "Gomez", "abcd", "Cirugía","Hospital Central");
        when(repositoryUsuario)
    }



    
}
