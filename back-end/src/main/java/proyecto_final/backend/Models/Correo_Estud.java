package proyecto_final.backend.Models;

public class Correo_Estud {
    private String cedula;
    private String correo;

    public Correo_Estud(){
    }

    public Correo_Estud(String Cedula, String Correo){
        cedula = Cedula;
        correo = Correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
