package com.proyectocrud.personasymascotas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectocrud.personasymascotas.model.Mascota;
import com.proyectocrud.personasymascotas.repository.MascotaRepository;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    public Mascota BuscarMascotaPorId(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
        return null;
    }
}
