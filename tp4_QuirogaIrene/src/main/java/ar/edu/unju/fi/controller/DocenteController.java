package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @GetMapping("/listado")
    public String getDocentesPage(Model model) {
        model.addAttribute("docentes", CollectionDocente.getDocentes());
        model.addAttribute("titulo", "Docentes");
        return "docentes";
    }

    @GetMapping("/nuevo")
    public String getNuevaDocentePage(Model model) {
        model.addAttribute("docente", new Docente());
        model.addAttribute("edic", false);
        model.addAttribute("titulo", "Agregar Docente");
        return "docente";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
        ModelAndView modelView = new ModelAndView("redirect:/docente/listado");
        CollectionDocente.agregarDocente(docente);
        return modelView;
    }

    @GetMapping("/modificar/{legajo}")
    public String getModificarDocentePage(Model model, @PathVariable("legajo") String legajo) {
        Docente docenteEncontrado = CollectionDocente.buscarDocente(legajo);
        if (docenteEncontrado != null) {
            model.addAttribute("edic", true);
            model.addAttribute("docente", docenteEncontrado);
            model.addAttribute("titulo", "Modificar Docente");
            return "docente";
        } else {
            return "redirect:/docente/listado";
        }
    }

    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute("docente") Docente docente) {
        CollectionDocente.modificarDocente(docente);
        return "redirect:/docente/listado";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable("legajo") String legajo) {
        CollectionDocente.eliminarDocente(legajo);
        return "redirect:/docente/listado";
    }
}

