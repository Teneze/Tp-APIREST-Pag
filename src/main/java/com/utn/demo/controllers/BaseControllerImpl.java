package com.utn.demo.controllers;

import com.utn.demo.entities.Base;
import com.utn.demo.entities.Persona;
import com.utn.demo.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {
    @Autowired
    protected S servicio;

    @GetMapping("")
    public ResponseEntity<?> getAll() {   //el ResponseEntity nos brinda el status o respuesta (si salio bien o mal) en formato JSON
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, intentelo nuevamente mas tarde.\"}");
        }
    }
    //Implementación de la paginación de forma generica
    @GetMapping("/page")
    public ResponseEntity<?> getAll(Pageable pageable) {   //el ResponseEntity nos brinda el status o respuesta (si salio bien o mal) en formato JSON
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, intentelo nuevamente mas tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, intentelo nuevamente mas tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, intentelo nuevamente mas tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id,entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, intentelo nuevamente mas tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, intentelo nuevamente mas tarde.\"}");
        }
    }
}
