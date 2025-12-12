package IS.grupoD.Mi2is.P6.model;

public class Medico extends Usuario {
        
    private String especialidad;
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    private String CentroMedico;
    public String getCentroMedico() {
        return CentroMedico;
    }      
    public void setCentroMedico(String centroMedico) {
        this.CentroMedico = centroMedico;
    }


    public Medico(String n, String a, String cc, String especialidad, String centroMedico) {
        this.setNombre(n);
        this.setApellidos(a);
        this.setContrasenya(cc);
        this.especialidad = especialidad;
        this.CentroMedico = centroMedico;
    }


    


    

}
