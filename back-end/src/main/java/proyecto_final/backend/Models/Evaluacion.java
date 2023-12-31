package proyecto_final.backend.Models;

public class Evaluacion {
    private String fecha_evaluacionNueva;
    private String fecha_evaluacion;
    private String cod_proyecto;
    private String evaluacion;

    public Evaluacion(){
    }

    public Evaluacion(String Fecha_evaluacion, String Cod_proyecto, String Evaluacion){
        fecha_evaluacion = Fecha_evaluacion;
        cod_proyecto = Cod_proyecto;
        evaluacion = Evaluacion;
    }

    public Evaluacion(String Fecha_evaluacion, String Fecha_evaluacionNueva, String Cod_proyecto, String Evaluacion){
        fecha_evaluacion = Fecha_evaluacion;
        fecha_evaluacionNueva = Fecha_evaluacionNueva;
        cod_proyecto = Cod_proyecto;
        evaluacion = Evaluacion;
    }

    public String getFecha_evaluacion() {
        return fecha_evaluacion;
    }

    public void setFecha_evaluacion(String fecha_evaluacion) {
        this.fecha_evaluacion = fecha_evaluacion;
    }

    public String getFecha_evaluacionNueva() {
        return fecha_evaluacionNueva;
    }

    public void setFecha_evaluacionNueva(String fecha_evaluacionNueva) {
        this.fecha_evaluacionNueva = fecha_evaluacionNueva;
    }

    public String getCod_proyecto() {
        return cod_proyecto;
    }

    public void setCod_proyecto(String cod_proyecto) {
        this.cod_proyecto = cod_proyecto;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }
}
