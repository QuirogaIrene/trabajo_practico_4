package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {
	private static List<Docente> docentes = new ArrayList<Docente>();
	
	
	/*Devuelve un arrayList de objetos de la clase Docente*/
	public static List <Docente> getDocentes(){
		if(docentes.isEmpty()) {
			docentes.add(new Docente ("2776", "Ariel Alejandro", "Vega", "arielVega@gmail.com" ,"388123456"));
			docentes.add(new Docente ("2776", "Juan Carlos", "Rodriguez", "JuanRodriguez@gmail.com" ,"388654321"));
			docentes.add(new Docente ("2776", "Carolina", "Apaza", "CarolinaApaza@gmail.com" ,"388546213"));
			
		}
		return docentes;
	}
	
	
	
	/*Agrega un objeto Docente al arrayList de docentes*/
	
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	
	
	
	/*elimina un objeto docente del arrayList de docentes*/
	
	public static void eliminarDocente (String legajoDocente) {
		Iterator<Docente> iterator = docentes.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().getLegajo()== legajoDocente) {
				iterator.remove();
			}
		}
	}
	
	
	
	/*modifica un objeto docente con los nuevos valores enviados en @param docente objeto con valores  de atributos modificados*/
	
	public static void modificarDocente(Docente docente) {
		for (Docente doce: docentes) {
			if (doce.getLegajo() == docente.getLegajo()) {
				doce.setNombre(docente.getNombre());
				doce.setApellido(docente.getApellido());
				doce.setEmail(docente.getEmail());
				doce.setTelefono(docente.getTelefono());

			}else {
				System.out.println("No se encuentra el legajo del Docente");
			}
		}
		
	}
	
	
	
	/*Busca un objeto docente dentro del arrayList, el criterio es por @param  legajo, el legajo a buscar en el arrayList docentes @return*/
	
	public static Docente buscarDocente (String legajo) {
		Predicate <Docente> filterLegajo = l -> l.getLegajo() == legajo;
		Optional<Docente> docente= docentes.stream().filter(filterLegajo).findFirst();
		
		if(docente.isPresent()) {
			return docente.get();
		}else {
			return null ;
		}
	}
}
