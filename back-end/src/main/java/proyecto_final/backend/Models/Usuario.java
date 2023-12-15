package proyecto_final.backend.Models;

public class Usuario {
    private int cod_usuario;
    private String usuario;
    private String contrasena;
    private String creado;
    private int cod_tipo;

    public Usuario(){
    }

    public Usuario(int Cod_usuario, String Usuario, String Contrasena, String Creado, int Cod_tipo){
        cod_usuario = Cod_usuario;
        usuario = Usuario;
        contrasena = Contrasena;
        creado = Creado;
        cod_tipo = Cod_tipo;
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
}
