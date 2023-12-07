package proyecto_final.backend.Models;

public class Profesor {
    private int cod_profesor;
    private String nombre_prof;
    private String apellido_prof;
    private String tipo_prof;
    private String cod_depto;

    public Profesor(){
    }

    public Profesor(int Cod_profesor, String Nombre_prof, String Apellido_prof,
    String Tipo_prof, String Cod_depto){
        cod_profesor = Cod_profesor;
        nombre_prof = Nombre_prof;
        apellido_prof = Apellido_prof;
        tipo_prof = Tipo_prof;
        cod_depto = Cod_depto;
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

}
