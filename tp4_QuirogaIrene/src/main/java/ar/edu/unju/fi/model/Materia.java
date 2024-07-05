package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private int codigo;
    private String nombre;
    private String curso;
    private int cantidadDeHoras;
    private boolean modalidad;
    private String docente;
    private String carrera;

    public Materia() {
	}
    // Constructor
    public Materia(int codigo, String nombre, String curso, int cantidadDeHoras, boolean modalidad, String docente, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.curso = curso;
        this.cantidadDeHoras = cantidadDeHoras;
        this.modalidad = modalidad;
        this.docente = docente;
        this.carrera = carrera;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public boolean getModalidad() {
        return modalidad;
    }

    public void setModalidad(boolean modalidad) {
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
