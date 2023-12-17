package proyecto_final.backend.Models;

public class Usuario {
    private int cod_usuario;
    private String usuario;
    private String contrasena;
    private String creado;
    private int cod_tipo;
    private String Cedula_profesor;
    private String Cedula_administrativo;
    private String Cedula_estudiante;

    public Usuario(){
    }

    public Usuario(int Cod_usuario, String Usuario, String Contrasena, String Creado, int Cod_tipo,
    String cedula_profesor, String cedula_administrativo, String cedula_estudiante){
        cod_usuario = Cod_usuario;
        usuario = Usuario;
        contrasena = Contrasena;
        creado = Creado;
        cod_tipo = Cod_tipo;
        Cedula_profesor = cedula_profesor;
        Cedula_administrativo = cedula_administrativo;
        Cedula_estudiante = cedula_estudiante;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public int getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(int cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public String getCedula_profesor() {
        return Cedula_profesor;
    }

    public void setCedula_profesor(String cedula_profesor) {
        Cedula_profesor = cedula_profesor;
    }

    public String getCedula_administrativo() {
        return Cedula_administrativo;
    }

    public void setCedula_administrativo(String cedula_administrativo) {
        Cedula_administrativo = cedula_administrativo;
    }

    public String getCedula_estudiante() {
        return Cedula_estudiante;
    }

    public void setCedula_estudiante(String cedula_estudiante) {
        Cedula_estudiante = cedula_estudiante;
    }
}
