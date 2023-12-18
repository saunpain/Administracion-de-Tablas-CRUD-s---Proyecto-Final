package proyecto_final.backend.Models;

public class Sede {
    private String cod_sedeNuevo;
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

    public Sede(String Cod_sede, String Cod_sedeNuevo, String Nombre_sede, String Ubicacion){
        cod_sede = Cod_sede;
        cod_sedeNuevo = Cod_sedeNuevo;
        nombre_sede = Nombre_sede;
        ubicacion = Ubicacion;
    }

    public String getCod_sede() {
        return cod_sede;
    }

    public void setCod_sede(String cod_sede) {
        this.cod_sede = cod_sede;
    }

    public String getCod_sedeNuevo() {
        return cod_sedeNuevo;
    }

    public void setCod_sedeNuevo(String cod_sedeNuevo) {
        this.cod_sedeNuevo = cod_sedeNuevo;
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
