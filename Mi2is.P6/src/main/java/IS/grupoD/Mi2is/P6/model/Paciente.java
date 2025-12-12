package IS.grupoD.Mi2is.P6.model;

import java.time.LocalDate;

public class Paciente {
    
    private String nss;
    public String getNss() {
        return nss;
    }
    public void setNss(String nss) {
        this.nss = nss;
    }

    private String dni;
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    private String telefono;
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private LocalDate fechaNacimiento;
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


}
