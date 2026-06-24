package com.proyectocrud.personasymascotas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectocrud.personasymascotas.model.Persona;
import com.proyectocrud.personasymascotas.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    public Persona BuscarPersonaPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona eliminarPersona(Long id) {
        personaRepository.deleteById(id);
        return null;
    }
}
