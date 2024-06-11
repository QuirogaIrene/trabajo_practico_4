package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	
	
	/*Devuelve un arrayList de objetos de la clase Carrera*/
	public static List <Carrera> getCarreras(){
		if(carreras.isEmpty()) {
			carreras.add(new Carrera ((int)1,"A.P.U",(byte)3, true));
			carreras.add(new Carrera ((int)2,"Ingenieria Informatica",(byte)5,true));
			carreras.add(new Carrera ((int)3,"Ingenieria Quimica",(byte)5,true));
			
		}
		return carreras;
	}
	
	
	
	/*Agrega un objeto Carrera al arrayList de carreras*/
	
	public static void agregarCarrera(Carrera carrera) {
		carreras.add(carrera);
	}
	
	
	
	/*elimina un objeto carrera del arrayList de carreras*/
	
	public static void eliminarCarrera (int codigoCarrera) {
		Iterator<Carrera> iterator = carreras.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().getCodigo()== codigoCarrera) {
				iterator.remove();
			}
		}
	}
	
	
	
	/*modifica un objeto carrera con los nuevos valores enviados en @param carrera objeto con valores  de atributos modificados*/
	
	public static void modificarCarrera(Carrera carrera) {
		for (Carrera carre: carreras) {
			if (carre.getCodigo() == carrera.getCodigo()) {
				carre.setNombre(carrera.getNombre());
				carre.setCantidadAnios(carrera.getCantidadAnios());
				carre.setEstado(carrera.getEstado());
			}else {
				System.out.println("No se encuentra el codigo de carrera");
			}
		}
		
	}
	
	
	
	/*Busca un objeto carrera dentro del arrayList, el criterio es por @param  codigo el codigo a buscar en el arrayList carreras @return*/
	
	public static Carrera buscarCarrera (int codigo) {
		Predicate <Carrera> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Carrera> carrera= carreras.stream().filter(filterCodigo).findFirst();
		
		if(carrera.isPresent()) {
			return carrera.get();
		}else {
			return null;
		}
	}
}
