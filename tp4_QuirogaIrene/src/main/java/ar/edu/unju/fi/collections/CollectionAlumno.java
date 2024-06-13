package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class CollectionAlumno {
private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	
	/*Devuelve un arrayList de objetos de la clase Alumno*/
	public static List <Alumno> getAlumnos(){
		if(alumnos.isEmpty()) {
			alumnos.add(new Alumno ("1","456123","Kevin","Alfaro","KevinAlfaro1@gmail.com", "388123456","2024-06-12","Calle Luna 15"));
			alumnos.add(new Alumno ("2","456124","Joaquin","Armella","JoaquinArmella2@gmail.com","388654321","2023-05-11","Av. Sol 234"));
			alumnos.add(new Alumno ("3","456125","Fernando","Lopez","FernandoLopez364gmail.com","3884321654","2022-04-10","Pza. Estrella 8"));
			
		}
		return alumnos;
	}
	
	
	
	/*Agrega un objeto Alumno al arrayList de alumnos*/
	
	public static void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	
	
	/*elimina un objeto alumno del arrayList de alumnos*/
	
	public static void eliminarAlumno (String luAlumno) {
		Iterator<Alumno> iterator = alumnos.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().getLu()== luAlumno) {
				iterator.remove();
			}
		}
	}
	
	
	
	/*modifica un objeto Alumno con los nuevos valores enviados en @param Alumno objeto con valores  de atributos modificados*/
	
	public static void modificarAlumno(Alumno alumno) {
		for (Alumno alum: alumnos) {
			if (alum.getLu() == alumno.getLu()) {
				alum.setDni(alumno.getDni());
				alum.setNombre(alumno.getNombre());
				alum.setApellido(alumno.getApellido());	
				alum.setEmail(alumno.getEmail());
				alum.setTelefono(alumno.getTelefono());
				alum.setFechaNacimiento(alumno.getFechaNacimiento());
				alum.setDomicilio(alumno.getDomicilio());
				
			}else {
				System.out.println("No se encuentra la LU del Alumno");
			}
		}
		
	}
	
	
	
	/*Busca un objeto Alumno dentro del arrayList, el criterio es por @param  LU el LU a buscar en el arrayList alumnos @return*/
	
	public static Alumno buscarAlumno (String lu) {
		Predicate <Alumno> filterAlumno = a -> a.getLu() == lu;
		Optional<Alumno> alumno= alumnos.stream().filter(filterAlumno).findFirst();
		
		if(alumno.isPresent()) {
			return alumno.get();
		}else {
			return null ;
		}
	}
}
