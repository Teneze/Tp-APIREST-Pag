package com.utn.demo.services;

import com.utn.demo.entities.Base;
import com.utn.demo.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    @Autowired
    protected BaseRepository<E,ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional //Van a hacer transacciones con la base de datos.
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    //Implementación del metodo para realizar la paginación de forma generica
    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            //Optional porque no sabemos si lo que buscamos esta en la base de datos
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = (E) baseRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            E entidadUp = entityOptional.get();
            entidadUp = (E) baseRepository.save(entity);
            return entidadUp;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
