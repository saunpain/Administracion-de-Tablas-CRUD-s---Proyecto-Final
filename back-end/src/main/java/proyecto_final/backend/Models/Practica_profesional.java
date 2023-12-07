package proyecto_final.backend.Models;

public class Practica_profesional {
    private String cod_proyecto;
    private int cod_supervisor;

    public Practica_profesional(){
    }

    public Practica_profesional(String Cod_proyecto, int Cod_supervisor){
        cod_proyecto = Cod_proyecto;
        cod_supervisor = Cod_supervisor;
    }

    public String getCod_proyecto() {
        return cod_proyecto;
    }

    public void setCod_proyecto(String cod_proyecto) {
        this.cod_proyecto = cod_proyecto;
    }

    public int getCod_supervisor() {
        return cod_supervisor;
    }

    public void setCod_supervisor(int cod_supervisor) {
        this.cod_supervisor = cod_supervisor;
    }
}
