package proyecto_final.backend.Models;

public class Empresa {
    private String cod_empresa;
    private String nombre_empresa;

    public Empresa(){
    }

    public Empresa(String Cod_empresa, String Nombre_empresa){
        cod_empresa = Cod_empresa;
        nombre_empresa = Nombre_empresa;
    }

    public String getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }
}

