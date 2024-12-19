package com.autotrack.service.impl;

import com.autotrack.domain.Cita;
import com.autotrack.domain.Cliente;
import com.autotrack.observer.CitaObserver;
import com.autotrack.observer.impl.CitaNotifierImpl;
import com.autotrack.repository.ICitaRepository;
import com.autotrack.service.ICitaService;
import com.autotrack.service.IClienteService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaRepository citaRepository;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private CitaNotifierImpl citaNotifier;

    @Autowired
    private CitaObserver clienteNotifier;

    @PostConstruct
    public void init() {
        // Registra el observador después de la inicialización del bean
        citaNotifier.addObserver(clienteNotifier);
    }

    @Override
    public List<Cita> getCitasByDocumento(String documento) {
        return citaRepository.findCitasByDocumentoCliente(documento);
    }

    @Override
    public Cita getCitaByFecha(Date fecha) {
        return citaRepository.findByFechaCita(fecha);
    }

    @Override
    @Transactional
    public Cita insertCita(Cita cita) throws RuntimeException {
        if (cita.getCliente().getDocumento() != null) {
            if (citaRepository.findByFechaCita(cita.getFechaCita()) == null) {
                Cliente cliente = clienteService.getClientebyDocumento(cita.getCliente().getDocumento());
                if (cliente != null) {
                    cita.setCliente(cliente);
                }
                return citaRepository.save(cita);
            }
            throw new RuntimeException("Ya existe una cita en ese horario: ".concat(cita.getFechaCita().toString()));
        } else {
            throw new RuntimeException("Documento es requerido");
        }
    }

    @Override
    @Transactional
    public Cita updateCita(Cita cita) {
        Optional<Cita> citaUpdate = citaRepository.findById(cita.getId());

        if (citaUpdate.isPresent()) {
            citaUpdate.get().setActivo(cita.isActivo());
            Cita updatedCita = citaRepository.save(citaUpdate.get());
            if (!updatedCita.isActivo()) {
                citaNotifier.notifyObservers(updatedCita);
            }
            return updatedCita;
        } else {
            throw new RuntimeException("Cita no encontrada");
        }
    }



}
