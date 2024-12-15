package com.autotrack.domain;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class Cita {
    @Id
    private int idCita;
    private Date fechaCita;
    private Cliente cliente;
    private Mecanico mecanico;


}
