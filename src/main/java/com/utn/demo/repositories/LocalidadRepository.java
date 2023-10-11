package com.utn.demo.repositories;

import com.utn.demo.entities.Domicilio;
import com.utn.demo.entities.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {
}
