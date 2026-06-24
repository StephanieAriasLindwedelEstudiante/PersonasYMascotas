package com.proyectocrud.personasymascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectocrud.personasymascotas.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}
