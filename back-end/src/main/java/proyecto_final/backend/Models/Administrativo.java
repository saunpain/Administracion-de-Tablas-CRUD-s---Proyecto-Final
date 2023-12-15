package proyecto_final.backend.Models;

public class Administrativo {
    private int cod_admin;
    private String nombre_admin;
    private String apellido_admin;
    private String telefono_admin;
    private String correo_admin;
    private int usuario;

    public Administrativo(){
    }

    public Administrativo(int Cod_admin, String Nombre_admin, String Apellido_admin, String Telefono_admin, String Correo_admin, int Usuario){
        cod_admin = Cod_admin;
        nombre_admin = Nombre_admin;
        apellido_admin = Apellido_admin;
        telefono_admin = Telefono_admin;
        correo_admin = Correo_admin;
        usuario = Usuario;
    }

    public int getCod_admin() {
        return cod_admin;
    }

    public void setCod_admin(int cod_admin) {
        this.cod_admin = cod_admin;
    }

    public String getNombre_admin() {
        return nombre_admin;
    }

    public void setNombre_admin(String nombre_admin) {
        this.nombre_admin = nombre_admin;
    }

    public String getApellido_admin() {
        return apellido_admin;
    }

    public void setApellido_admin(String apellido_admin) {
        this.apellido_admin = apellido_admin;
    }

    public String getTelefono_admin() {
        return telefono_admin;
    }

    public void setTelefono_admin(String telefono_admin) {
        this.telefono_admin = telefono_admin;
    }

    public String getCorreo_admin() {
        return correo_admin;
    }

    public void setCorreo_admin(String correo_admin) {
        this.correo_admin = correo_admin;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }


}
