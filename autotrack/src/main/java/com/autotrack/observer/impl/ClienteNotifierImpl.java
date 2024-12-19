package com.autotrack.observer.impl;

import com.autotrack.domain.Cita;
import com.autotrack.domain.Cliente;
import com.autotrack.observer.CitaObserver;
import org.springframework.stereotype.Component;

@Component
public class ClienteNotifierImpl implements CitaObserver {

    @Override
    public void onCitaTerminada(Cita cita) {
        Cliente cliente = cita.getCliente();
        String mensaje = "Hola " + cliente.getNombre() + ", tu cita con el mecánico " +
                cita.getMecanico().getNombre() + " ha sido completada.";
        enviarNotificacion(cliente.getCorreo(), mensaje);
    }

    private void enviarNotificacion(String correo, String mensaje) {
        System.out.println("Enviando correo a: " + correo);
        System.out.println("Mensaje: " + mensaje);
    }
}
