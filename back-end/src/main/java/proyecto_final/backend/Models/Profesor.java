package proyecto_final.backend.Models;

public class Profesor {
    private int cod_profesorNuevo;

    private int cod_profesor;
    private String nombre_prof;
    private String apellido_prof;
    private String tipo_prof;
    private String cod_depto;
    private String telefono_profesor;
    private String correo_profesor;
    private String Cedula_profesor;

    public Profesor(){
    }

    public Profesor(int Cod_profesor, String Nombre_prof, String Apellido_prof,
    String Tipo_prof, String Cod_depto, String Telefono_profesor, 
    String Correo_profesor, String cedula_profesor){
        cod_profesor = Cod_profesor;
        nombre_prof = Nombre_prof;
        apellido_prof = Apellido_prof;
        tipo_prof = Tipo_prof;
        cod_depto = Cod_depto;
        telefono_profesor = Telefono_profesor;
        correo_profesor = Correo_profesor;
        Cedula_profesor = cedula_profesor;
    }

    public Profesor(int Cod_profesor, int Cod_ProfesorNuevo, String Nombre_prof, String Apellido_prof,
    String Tipo_prof, String Cod_depto, String Telefono_profesor, 
    String Correo_profesor, String cedula_profesor){
        cod_profesor = Cod_profesor;
        cod_profesorNuevo = Cod_ProfesorNuevo;
        nombre_prof = Nombre_prof;
        apellido_prof = Apellido_prof;
        tipo_prof = Tipo_prof;
        cod_depto = Cod_depto;
        telefono_profesor = Telefono_profesor;
        correo_profesor = Correo_profesor;
        Cedula_profesor = cedula_profesor;
    }

    public int getCod_profesor() {
        return cod_profesor;
    }

    public void setCod_profesor(int cod_profesor) {
        this.cod_profesor = cod_profesor;
    }

    public String getNombre_prof() {
        return nombre_prof;
    }

    public void setNombre_prof(String nombre_prof) {
        this.nombre_prof = nombre_prof;
    }

    public String getApellido_prof() {
        return apellido_prof;
    }

    public void setApellido_prof(String apellido_prof) {
        this.apellido_prof = apellido_prof;
    }

    public String getTipo_prof() {
        return tipo_prof;
    }

    public void setTipo_prof(String tipo_prof) {
        this.tipo_prof = tipo_prof;
    }

    public String getCod_depto() {
        return cod_depto;
    }

    public void setCod_depto(String cod_depto) {
        this.cod_depto = cod_depto;
    }
    
    public String getTelefono_profesor() {
        return telefono_profesor;
    }

    public void setTelefono_profesor(String telefono_profesor) {
        this.telefono_profesor = telefono_profesor;
    }

    public String getCorreo_profesor() {
        return correo_profesor;
    }

    public void setCorreo_profesor(String correo_profesor) {
        this.correo_profesor = correo_profesor;
    }

    public String getCedula_profesor() {
        return Cedula_profesor;
    }

    public void setCedula_profesor(String cedula_profesor) {
        Cedula_profesor = cedula_profesor;
    }

    public int getCod_profesorNuevo() {
        return cod_profesorNuevo;
    }

    public void setCod_profesorNuevo(int cod_profesorNuevo) {
        this.cod_profesorNuevo = cod_profesorNuevo;
    }
}
