package proyecto_final.backend.Models;

public class Estudiante {
    private String cedula;
    private String pri_nom;
    private String seg_nom;
    private String pri_apellido;
    private String seg_apellido;
    private int anio_cursa;
    private String semestre;
    private float indice;
    private String cod_proyecto;
    private String cod_carrera;
    private String cod_sede;

    public Estudiante(){
    }

    public Estudiante(String Cedula, String Pri_nom, String Seg_nom, String Pri_apellido, 
    String Seg_apellido, int Anio_cursa, String Semestre, float Indice, String Cod_proyecto, 
    String Cod_carrera, String Cod_sede)
    {
        cedula = Cedula;
        pri_nom = Pri_nom;
        seg_nom = Seg_nom;
        pri_apellido = Pri_apellido;
        seg_apellido = Seg_apellido;
        anio_cursa = Anio_cursa;
        semestre = Semestre;
        indice = Indice;
        cod_proyecto = Cod_proyecto;
        cod_carrera = Cod_carrera;
        cod_sede = Cod_sede;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPri_nom() {
        return pri_nom;
    }

    public void setPri_nom(String pri_nom) {
        this.pri_nom = pri_nom;
    }

    public String getSeg_nom() {
        return seg_nom;
    }

    public void setSeg_nom(String seg_nom) {
        this.seg_nom = seg_nom;
    }

    public String getPri_apellido() {
        return pri_apellido;
    }

    public void setPri_apellido(String pri_apellido) {
        this.pri_apellido = pri_apellido;
    }

    public String getSeg_apellido() {
        return seg_apellido;
    }

    public void setSeg_apellido(String seg_apellido) {
        this.seg_apellido = seg_apellido;
    }

    public int getAnio_cursa() {
        return anio_cursa;
    }

    public void setAnio_cursa(int anio_cursa) {
        this.anio_cursa = anio_cursa;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public float getIndice() {
        return indice;
    }

    public void setIndice(float indice) {
        this.indice = indice;
    }

    public String getCod_proyecto() {
        return cod_proyecto;
    }

    public void setCod_proyecto(String cod_proyecto) {
        this.cod_proyecto = cod_proyecto;
    }

    public String getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(String cod_carrera) {
        this.cod_carrera = cod_carrera;
    }

    public String getCod_sede() {
        return cod_sede;
    }

    public void setCod_sede(String cod_sede) {
        this.cod_sede = cod_sede;
    }
}
