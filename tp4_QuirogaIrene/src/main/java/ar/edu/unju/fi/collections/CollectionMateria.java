package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;

@Component
public class CollectionMateria {
    private static List<Materia> materias = new ArrayList<>();

    /* Devuelve un arrayList de objetos de la clase Materia */
    public static List<Materia> getMaterias() {
        if (materias.isEmpty()) {
            materias.add(new Materia(1, "Base de Datos", "Aula 12", 6, true, "Jose Javier", "A.P.U."));
            materias.add(new Materia(2, "Programacion Visual", "Aula 15", 6, false, "Juan Carlos Rodriguez", "A.P.U."));
            materias.add(new Materia(3, "Algebra y Geometria Analitica", "Anfiteatro", 4, true, "Tarifa", "Ingenieria Quimica"));
        }
        return materias;
    }

    /* Agrega un objeto Materia al arrayList de materias */
    public static void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    /* Elimina un objeto materia del arrayList de materias */
    public static void eliminarMateria(int codigoMateria) {
        Iterator<Materia> iterator = materias.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCodigo() == codigoMateria) {
                iterator.remove();
            }
        }
    }

    /* Modifica un objeto materia con los nuevos valores enviados en @param materia objeto con valores de atributos modificados */
    public static void modificarMateria(Materia materia) {
        for (Materia mate : materias) {
            if (mate.getCodigo() == materia.getCodigo()) {
                mate.setNombre(materia.getNombre());
                mate.setCurso(materia.getCurso());
                mate.setCantidadDeHoras(materia.getCantidadDeHoras());
                mate.setModalidad(materia.getModalidad());
                mate.setDocente(materia.getDocente());
                mate.setCarrera(materia.getCarrera());
                return; // Termina el método después de modificar
            }
        }
        System.out.println("No se encuentra el código de Materia");
    }

    /* Busca un objeto materia dentro del arrayList, el criterio es por @param codigo, el código a buscar en el arrayList materias @return */
    public static Materia buscarMateria(int codigo) {
        Predicate<Materia> filterCodigo = m -> m.getCodigo() == codigo;
        Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();

        return materia.orElse(null);
    }
}
