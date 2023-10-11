package com.utn.demo.services;

import com.utn.demo.entities.Base;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
//Esta es la capa de servicios la cual se va a comunicar con los Repositorios
public interface  BaseService<E extends Base, ID extends Serializable> { //Hacemos la entidad generica, puede recibir cualquier entidad

    public List<E> findAll() throws Exception; //Nos proporciona una lista de las personas(cualquier entidad) que se encuentran en la BD
    public Page<E> findAll(Pageable pageable) throws Exception; //creamos un nuevo método el cual nos va a permitir devolver los datos paginados
    public E findById(ID id) throws Exception; //Este metodo lo que hace es obtener una entidad segun el id que reciba
    public E save(E entity) throws Exception; //Se produce un guardado de la entidad
    public E update(ID id, E entity) throws Exception; //El metodo recibe el id de la persona que queremos actualizar y la entidad de la persona actualizada
    public boolean delete(ID id) throws Exception;



}
