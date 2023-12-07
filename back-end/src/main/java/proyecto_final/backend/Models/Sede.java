package proyecto_final.backend.Models;

public class Sede {
    private String cod_sede;
    private String nombre_sede;
    private String ubicacion;

    public Sede(){
    }

    public Sede(String Cod_sede, String Nombre_sede, String Ubicacion){
        cod_sede = Cod_sede;
        nombre_sede = Nombre_sede;
        ubicacion = Ubicacion;
    }

    public String getCod_sede() {
        return cod_sede;
    }

    public void setCod_sede(String cod_sede) {
        this.cod_sede = cod_sede;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
