package com.utn.demo.repositories;

import com.utn.demo.entities.Domicilio;
import com.utn.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {


    //Metodo de Query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    //Aplicamos la paginación
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //JPQL - Utilizando Parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    List<Persona> search(String filtro);
    //Aplicamos la paginación
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    Page<Persona> search(String filtro, Pageable pageable);

    /*JPQL - Utilizando Parametros nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    List<Persona> searchNombrado(@Param("filtro")String filtro)
    //Aplicamos la paginación
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    Page<Persona> searchNombrado(@Param("filtro")String filtro)*/

    //Nativo
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%'",
            nativeQuery = true
    )
    List<Persona> searchNative(String filtro);
    @Query( //Aplicamos la paginación
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM persona", //En este tipo no es automática la paginación por lo que countQuery nos permite realizar un conteo de la cantidad de páginas
            nativeQuery = true
    )
    Page<Persona> searchNative(String filtro, Pageable pageable);

}
