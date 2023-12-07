package proyecto_final.backend.Models;

public class Supervisor {
    private int cod_supervisor;
    private String nombre_supervisor;
    private String apellido_supervisor;
    private String cod_empresa;

    public Supervisor(){
    }

    public Supervisor(int Cod_supervisor, String Nombre_supervisor, String Apellido_supervisor,
    String Cod_empresa){
        cod_supervisor = Cod_supervisor;
        nombre_supervisor = Nombre_supervisor;
        apellido_supervisor = Apellido_supervisor;
        cod_empresa = Cod_empresa;
    }

    public int getCod_supervisor() {
        return cod_supervisor;
    }

    public void setCod_supervisor(int cod_supervisor) {
        this.cod_supervisor = cod_supervisor;
    }

    public String getNombre_supervisor() {
        return nombre_supervisor;
    }

    public void setNombre_supervisor(String nombre_supervisor) {
        this.nombre_supervisor = nombre_supervisor;
    }

    public String getApellido_supervisor() {
        return apellido_supervisor;
    }

    public void setApellido_supervisor(String apellido_supervisor) {
        this.apellido_supervisor = apellido_supervisor;
    }

    public String getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }
}
