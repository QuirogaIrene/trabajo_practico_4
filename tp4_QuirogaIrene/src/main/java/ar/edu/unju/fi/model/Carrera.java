package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
		private int codigo;
	    private String nombre;
	    private byte cantidadAnios;
	    private boolean estado;

	    
	    public Carrera() {
		}
	    // Constructor
	    public Carrera(int codigo, String nombre, byte cantidadAnios, boolean estado) {
	        this.codigo = codigo;
	        this.nombre = nombre;
	        this.cantidadAnios = cantidadAnios;
	        this.estado = estado;
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

	    public byte getCantidadAnios() {
	        return cantidadAnios;
	    }

	    public void setCantidadAnios(byte cantidadAnios) {
	        this.cantidadAnios = cantidadAnios;
	    }

	    public boolean getEstado() {
	        return estado;
	    }

	    public void setEstado(boolean estado) {
	        this.estado = estado;
	    }


	    
	   	
}
