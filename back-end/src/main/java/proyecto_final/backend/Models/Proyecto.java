package proyecto_final.backend.Models;

public class Proyecto {
    private String cod_proyecto;
    private String tipo_proyecto;
    private String titulo_proyecto;
    private int cod_profesor;
    private String fecha_entrega;
    private String fecha_verificacion;
    private String fecha_evaluacion;
    private String fecha_aprobacion;
    private String fecha_sustentacion;

    public Proyecto(){
    }

    public Proyecto(String Cod_proyecto, String Tipo_proyecto, String Titulo_proyecto, int Cod_profesor,
    String Fecha_entrega, String Fecha_verificacion, String Fecha_evaluacion, String Fecha_aprobacion,
    String Fecha_sustentacion){
        cod_proyecto = Cod_proyecto;
        tipo_proyecto = Tipo_proyecto;
        titulo_proyecto = Titulo_proyecto;
        cod_profesor = Cod_profesor;
        fecha_entrega = Fecha_entrega;
        fecha_verificacion = Fecha_verificacion;
        fecha_evaluacion = Fecha_evaluacion;
        fecha_aprobacion = Fecha_aprobacion;
        fecha_sustentacion = Fecha_sustentacion;
    }

    public String getCod_proyecto() {
        return cod_proyecto;
    }

    public void setCod_proyecto(String cod_proyecto) {
        this.cod_proyecto = cod_proyecto;
    }

    public String getTipo_proyecto() {
        return tipo_proyecto;
    }

    public void setTipo_proyecto(String tipo_proyecto) {
        this.tipo_proyecto = tipo_proyecto;
    }

    public String getTitulo_proyecto() {
        return titulo_proyecto;
    }

    public void setTitulo_proyecto(String titulo_proyecto) {
        this.titulo_proyecto = titulo_proyecto;
    }

    public int getCod_profesor() {
        return cod_profesor;
    }

    public void setCod_profesor(int cod_profesor) {
        this.cod_profesor = cod_profesor;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getFecha_verificacion() {
        return fecha_verificacion;
    }

    public void setFecha_verificacion(String fecha_verificacion) {
        this.fecha_verificacion = fecha_verificacion;
    }

    public String getFecha_evaluacion() {
        return fecha_evaluacion;
    }

    public void setFecha_evaluacion(String fecha_evaluacion) {
        this.fecha_evaluacion = fecha_evaluacion;
    }

    public String getFecha_aprobacion() {
        return fecha_aprobacion;
    }

    public void setFecha_aprobacion(String fecha_aprobacion) {
        this.fecha_aprobacion = fecha_aprobacion;
    }

    public String getFecha_sustentacion() {
        return fecha_sustentacion;
    }

    public void setFecha_sustentacion(String fecha_sustentacion) {
        this.fecha_sustentacion = fecha_sustentacion;
    }
}
