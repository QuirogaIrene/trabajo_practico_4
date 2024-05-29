package ar.edu.unju.fi.model;

public class Materia {
	private String codigo;
    private String nombre;
    private String curso;
    private int cantidadDeHoras;
    private String modalidad;
    private String docente;
    private String carrera;

    // Constructor
    public Materia(String codigo, String nombre, String curso, int cantidadDeHoras, String modalidad, String docente, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.curso = curso;
        this.cantidadDeHoras = cantidadDeHoras;
        this.modalidad = modalidad;
        this.docente = docente;
        this.carrera = carrera;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCantidadDeHoras() {
        return cantidadDeHoras;
    }

    public void setCantidadDeHoras(int cantidadDeHoras) {
        this.cantidadDeHoras = cantidadDeHoras;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
	
}
