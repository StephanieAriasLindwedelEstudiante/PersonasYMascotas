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

    @GetMapping("/mascotas/lista")
    public String ListarMascotas(Model modelo) {
        modelo.addAttribute("mascotas", mascotaService.listarMascotas());
        return "mascotas/lista";
    }

    @GetMapping("/mascotas/formulario")
    public String mostrarFormularioDeNuevaMascota(Model modelo) {
        modelo.addAttribute("mascota", new Mascota());
        return "mascotas/formulario";
    }

    @GetMapping("/mascotas/editar/{id}")
    public String editarMascota(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("mascota", mascotaService.BuscarMascotaPorId(id));
        return "mascotas/formulario";
    }

    @PostMapping("/mascotas/guardar")
    public String guardarMascota(Mascota mascota) {
        mascotaService.guardarMascota(mascota);
        return "redirect:/mascotas/lista";
    }

    @GetMapping("/mascotas/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return "redirect:/mascotas/lista";
    }
}
