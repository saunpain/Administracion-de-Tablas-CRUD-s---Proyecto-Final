package proyecto_final.backend.Models;

public class Carrera {
    private String cod_carrera;
    private String nombre_carrera;
    private String cod_depto;

    public Carrera(){
    }

    public Carrera(String Cod_carrera, String Nombre_carrera, String Cod_depto){
        cod_carrera = Cod_carrera;
        nombre_carrera = Nombre_carrera;
        cod_depto = Cod_depto;
    }

    public String getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(String cod_carrera) {
        this.cod_carrera = cod_carrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getCod_depto() {
        return cod_depto;
    }

    public void setCod_depto(String cod_depto) {
        this.cod_depto = cod_depto;
    }
}
