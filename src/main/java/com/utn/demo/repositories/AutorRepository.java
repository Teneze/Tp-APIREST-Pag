package com.utn.demo.repositories;

import com.utn.demo.entities.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long> {
}
