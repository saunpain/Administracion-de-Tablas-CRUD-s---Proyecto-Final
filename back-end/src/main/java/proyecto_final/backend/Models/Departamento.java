package proyecto_final.backend.Models;

public class Departamento {
    private String cod_depto;
    private String nombre_departamento;
    private int cod_profesor;

    public Departamento(){
    }

    public Departamento(String Cod_depto, String Nombre_departamento, int Cod_profesor){
        cod_depto = Cod_depto;
        nombre_departamento = Nombre_departamento;
        cod_profesor = Cod_profesor;
    }

    public String getCod_depto() {
        return cod_depto;
    }

    public void setCod_depto(String cod_depto) {
        this.cod_depto = cod_depto;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public int getCod_profesor() {
        return cod_profesor;
    }

    public void setCod_profesor(int cod_profesor) {
        this.cod_profesor = cod_profesor;
    }
}

