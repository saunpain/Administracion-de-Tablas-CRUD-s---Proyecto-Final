package proyecto_final.backend.Models;

public class Proyecto_profesor_sustenta {
    private int cod_profesorNuevo;
    private int cod_profesor;
    private String cod_proyecto;
    private String lugar;
    private String nota_asignada;

    public Proyecto_profesor_sustenta(){
    }

    public Proyecto_profesor_sustenta(int Cod_profesor, String Cod_proyecto, String Lugar,
    String Nota_asignada){
        cod_profesor = Cod_profesor;
        cod_proyecto = Cod_proyecto;
        lugar = Lugar;
        nota_asignada = Nota_asignada;
    }

    public Proyecto_profesor_sustenta(int Cod_profesor, int Cod_profesorNuevo, String Cod_proyecto, String Lugar,
    String Nota_asignada){
        cod_profesor = Cod_profesor;
        cod_profesorNuevo = Cod_profesorNuevo;
        cod_proyecto = Cod_proyecto;
        lugar = Lugar;
        nota_asignada = Nota_asignada;
    }

    public int getCod_profesor() {
        return cod_profesor;
    }

    public void setCod_profesor(int cod_profesor) {
        this.cod_profesor = cod_profesor;
    }

    public int getCod_profesorNuevo() {
        return cod_profesorNuevo;
    }

    public void setCod_profesorNuevo(int cod_profesorNuevo) {
        this.cod_profesorNuevo = cod_profesorNuevo;
    }

    public String getCod_proyecto() {
        return cod_proyecto;
    }

    public void setCod_proyecto(String cod_proyecto) {
        this.cod_proyecto = cod_proyecto;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNota_asignada() {
        return nota_asignada;
    }

    public void setNota_asignada(String nota_asignada) {
        this.nota_asignada = nota_asignada;
    }
}
