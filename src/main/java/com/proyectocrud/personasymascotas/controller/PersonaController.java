package com.proyectocrud.personasymascotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectocrud.personasymascotas.model.Persona;
import com.proyectocrud.personasymascotas.service.PersonaService;

@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas/listap")
    public String ListarPersonas(Model modelo) {
        modelo.addAttribute("personas", personaService.listarPersonas());
        return "personas/listap";
    }

    @GetMapping("/personas/formulariop")
    public String mostrarFormularioDeNuevaPersona(Model modelo) {
        modelo.addAttribute("persona", new Persona());
        return "personas/formulariop";
    }

    @GetMapping("/personas/editar/{id}")
    public String editarPersona(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("persona", personaService.BuscarPersonaPorId(id));
        return "personas/formulariop";
    }

    @PostMapping("/personas/guardar")
    public String guardarPersona(Persona persona) {
        personaService.guardarPersona(persona);
        return "redirect:/personas/listap";
    }

    @GetMapping("/personas/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return "redirect:/personas/listap";
    }

}
