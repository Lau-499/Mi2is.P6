package IS.grupoD.Mi2is.P6;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    private String contrasenya;
    public String getContrasenya() {
        return contrasenya;
    }
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private String apellidos;
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void IniciarSesion(Long ID, String password) {
        if (this.id == ID && this.contrasenya.equals(password)) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("ID o contraseña incorrectos.");
        }
    }

    public void RegistrarUsuario(Long ID, String password, String nombre, String apellidos) {
        this.id = ID;
        this.contrasenya = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        System.out.println("Usuario registrado exitosamente.");
    }

    public void CerrarSesion() {
        System.out.println("Sesión cerrada.");
    }

}
