package proyecto_final.backend.Models;

public class Tipo_usuario {
    private int cod_tipo;
    private String tipo;

    public Tipo_usuario(){
    }

    public Tipo_usuario(int Cod_tipo, String Tipo){
        cod_tipo = Cod_tipo;
        tipo = Tipo;
    }

    public int getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(int cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
