package proyecto_final.backend.Models;

public class Telf_Estud {
    private String cedula;
    private String telefono;

    public Telf_Estud(){
    }

    public Telf_Estud(String Cedula, String Telefono){
        cedula = Cedula;
        telefono = Telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
