package proyecto_final.backend.Models;

public class Carrera {
    private String cod_carreraNuevo;
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

        public Carrera(String Cod_carrera, String Cod_carreraNuevo,String Nombre_carrera, String Cod_depto){
        cod_carrera = Cod_carrera;
        cod_carreraNuevo = Cod_carreraNuevo;
        nombre_carrera = Nombre_carrera;
        cod_depto = Cod_depto;
    }

    public String getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(String cod_carrera) {
        this.cod_carrera = cod_carrera;
    }

    public String getCod_carreraNuevo() {
        return cod_carreraNuevo;
    }

    public void setCod_carreraNuevo(String cod_carreraNuevo) {
        this.cod_carreraNuevo = cod_carreraNuevo;
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
