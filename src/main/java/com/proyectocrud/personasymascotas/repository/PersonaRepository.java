package com.proyectocrud.personasymascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectocrud.personasymascotas.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
