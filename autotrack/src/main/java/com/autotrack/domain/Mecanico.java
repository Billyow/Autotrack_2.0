package com.autotrack.domain;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class Mecanico {
    @Id
    private int idMecanico;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String trabajo;
}
