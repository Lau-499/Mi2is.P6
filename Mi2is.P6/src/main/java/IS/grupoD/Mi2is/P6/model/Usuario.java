package IS.grupoD.Mi2is.P6.model;

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
    
    public boolean login;
    public boolean isLogin() {
        return login;
    }
    public void setLogin(boolean login) {
        this.login = login;
    }


    public void IniciarSesion(Long ID, String password) {
        if (this.id == ID && this.contrasenya.equals(password)) {
            System.out.println("Inicio de sesión exitoso.");
            this.login = true;
        } else {
            System.out.println("ID o contraseña incorrectos.");
            this.login = false;
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
        this.login = false;
    }
    //hola caracola
    private string holacaracola;
    
}
