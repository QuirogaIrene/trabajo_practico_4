package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    
    @Autowired
    private Alumno alumno;

    @GetMapping("/listado")
    public String getAlumnosPage(Model model) {
        model.addAttribute("alumnos", CollectionAlumno.getAlumnos());
        model.addAttribute("titulo", "Alumnos");
        return "alumnos";
    }

    @GetMapping("/nuevo")
    public String getNuevoAlumnoPage(Model model) {
        boolean edi = false;
        model.addAttribute("alumno", alumno);
        model.addAttribute("edi", edi);
        model.addAttribute("titulo", "Nuevo Alumno");
        return "alumno";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        ModelAndView modelView = new ModelAndView("alumnos");
        CollectionAlumno.agregarAlumno(alumno);
        modelView.addObject("alumnos", CollectionAlumno.getAlumnos());
        return modelView;
    }

    @GetMapping("/modificar/{lu}")
    public String getModificarAlumnoPage(Model model, @PathVariable(value = "lu") String lu) {
        Alumno alumnoEncontrado = CollectionAlumno.buscarAlumno(lu);
        boolean edi = true;
        model.addAttribute("edi", edi);
        model.addAttribute("alumno", alumnoEncontrado);
        model.addAttribute("titulo", "Modificar Alumno");
        return "alumno";
    }

    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        CollectionAlumno.modificarAlumno(alumno);
        return "redirect:/alumno/listado";
    }

    @GetMapping("/eliminar/{lu}")
    public String eliminarAlumno(@PathVariable(value = "lu") String lu) {
        CollectionAlumno.eliminarAlumno(lu);
        return "redirect:/alumno/listado";
    }
}
