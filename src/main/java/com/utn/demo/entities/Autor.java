package com.utn.demo.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Autor extends Base {

    private String nombre;
    private String apellido;
    private String biografia;

}
