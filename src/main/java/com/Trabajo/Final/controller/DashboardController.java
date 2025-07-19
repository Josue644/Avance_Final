package com.Trabajo.Final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Trabajo.Final.dto.MatriculaDTO;
import com.Trabajo.Final.model.Docente;
import com.Trabajo.Final.service.DatosMatriculaService;
import com.Trabajo.Final.service.DocenteService;

@Controller
public class DashboardController {

    @Autowired
    private DatosMatriculaService datosMatriculaService;

    @Autowired
    private DocenteService docenteService;

    // Mostrar Dashboard
    @GetMapping("/dashboard")
    public String obtenerDashboard(Model model) {
        List<MatriculaDTO> matriculas = datosMatriculaService.obtenerMatrículas(); 
        model.addAttribute("matriculas", matriculas);

        List<Docente> docentes = docenteService.getAllDocentes();   
        model.addAttribute("docentes", docentes);

        return "dashboard";
    }

    // Registrar docente
    @PostMapping("/docentes")
    public String registrarDocente(@ModelAttribute Docente docente) {
        docenteService.saveDocente(docente);
        return "redirect:/dashboard";
    }

    // Editar docente
    @PostMapping("/docentes/editar")
    public String editarDocente(@ModelAttribute Docente docente) {
        docenteService.saveDocente(docente); // hace update si ya existe
        return "redirect:/dashboard";
    }

    // Eliminar docente
    @GetMapping("/docentes/eliminar/{id}")
    public String eliminarDocente(@PathVariable Long id) {
        docenteService.deleteDocenteById(id);
        return "redirect:/dashboard";
    }

    // Editar matrícula
    @PostMapping("/dashboard/editar")
    public String editarMatricula(@ModelAttribute MatriculaDTO matriculaDto) {
        datosMatriculaService.actualizarMatricula(matriculaDto);
        return "redirect:/dashboard";
    }

    // Eliminar matrícula
    @GetMapping("/dashboard/eliminar/{id}")
    public String eliminarMatricula(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {
        try {
            datosMatriculaService.eliminarMatricula(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar matrícula con ID(" + id + "): " + e.getMessage());
            redirectAttributes.addFlashAttribute(
                "deleteError",
                "No se pudo eliminar la matrícula con ID " + id
            );
        }
        return "redirect:/dashboard";
    }
    
}
