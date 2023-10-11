package com.utn.demo.services;

import com.utn.demo.entities.Autor;
import com.utn.demo.repositories.AutorRepository;
import com.utn.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> implements AutorService{
    @Autowired
    private AutorRepository autorRepository;
    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }
}
