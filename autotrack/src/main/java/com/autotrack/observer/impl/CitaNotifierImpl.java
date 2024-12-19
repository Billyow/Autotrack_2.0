package com.autotrack.observer.impl;

import com.autotrack.domain.Cita;
import com.autotrack.observer.CitaObserver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CitaNotifierImpl {
    private final List<CitaObserver> observers = new ArrayList<>();

    public void addObserver(CitaObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CitaObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Cita cita) {
        for (CitaObserver observer : observers) {
            observer.onCitaTerminada(cita);
        }
    }
}
