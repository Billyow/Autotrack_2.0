package com.autotrack.observer;

import com.autotrack.domain.Cita;

public interface CitaObserver {
    void onCitaTerminada(Cita cita);
}
