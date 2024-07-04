package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {

    private static List<Docente> docentes = new ArrayList<>();

    public static List<Docente> getDocentes() {
        if (docentes.isEmpty()) {
            docentes.add(new Docente("323232", "Luis", "Saavedra", "luis@gmail.com", "2544254"));
            docentes.add(new Docente("121212", "Pedro", "Sanchez", "pepe@hotmail.com", "2255864"));
        }
        return docentes;
    }

    public static void agregarDocente(Docente docente) {
        docentes.add(docente);
    }

    public static Docente buscarDocente(String legajo) {
        Optional<Docente> docenteEncontrado = docentes.stream().filter(d -> d.getLegajo().equals(legajo)).findFirst();
        return docenteEncontrado.orElse(null);
    }

    public static void modificarDocente(Docente docente) {
        for (int i = 0; i < docentes.size(); i++) {
            if (docentes.get(i).getLegajo().equals(docente.getLegajo())) {
                docentes.set(i, docente);
                break;
            }
        }
    }

    public static void eliminarDocente(String legajo) {
        docentes.removeIf(d -> d.getLegajo().equals(legajo));
    }
}

