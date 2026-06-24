package com.proyectocrud.personasymascotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectocrud.personasymascotas.model.Mascota;
import com.proyectocrud.personasymascotas.service.MascotaService;

@Controller
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/")
    public String ListarMascotas(Model modelo) {
        modelo.addAttribute("mascotas", mascotaService.listarMascotas());
        return "lista";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioDeNuevaMascota(Model modelo) {
        modelo.addAttribute("mascota", new Mascota());
        return "formulario";
    }

    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("mascota", mascotaService.BuscarMascotaPorId(id));
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarMascota(Mascota mascota) {
        mascotaService.guardarMascota(mascota);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return "redirect:/";
    }
}
