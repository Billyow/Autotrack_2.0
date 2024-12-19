package com.autotrack.controller;

import com.autotrack.domain.Cita;
import com.autotrack.domain.Cliente;
import com.autotrack.service.ICitaService;
import com.autotrack.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/autotrack/api/v1")
public class CitasController {
    @Autowired
    private ICitaService citaService;

    @GetMapping("/cita/{fecha}")
    public ResponseEntity<?> getCitaByFecha(@PathVariable String fecha) throws ParseException {
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = formatter.parse(fecha);
            return ResponseEntity.ok(citaService.getCitaByFecha(date));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/citas/{documento}")
    public List<Cita> getCitaByDocumento(@PathVariable String documento) {
        return citaService.getCitasByDocumento(documento);
    }

    @PostMapping( "/cita")
    public ResponseEntity<?> insertCita(@RequestBody Cita cita) {
        try{
            return ResponseEntity.ok(citaService.insertCita(cita));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/cita")
    public Cita updateCita(@RequestBody Cita cita) {
        return citaService.updateCita(cita);
    }

}
