package com.autotrack.service;

import com.autotrack.domain.Cita;

import java.util.Date;
import java.util.List;

public interface ICitaService {
    public List<Cita> getCitasByDocumento(String documento);
    public Cita getCitaByFecha(Date fecha);
    public Cita insertCita(Cita cita);
    public Cita updateCita(Cita cita);
}
