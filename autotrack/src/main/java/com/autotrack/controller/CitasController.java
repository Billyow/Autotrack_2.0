package com.autotrack.controller;

import com.autotrack.domain.Cita;
import com.autotrack.domain.Cliente;
import com.autotrack.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autotrack/api/v1")
public class CitasController {
    @Autowired
    IClienteService clienteService;
    @GetMapping("/cita/{id}")
    public Cliente getCita(@PathVariable Integer id) {
        return clienteService.buscarCliente(id);
    }
    @RequestMapping( "/cita/c")
    public void insertCita(Long id) {
        Cliente cliente = new Cliente();
        cliente.setNombre("andres");
        cliente.setApellido("jr");
        cliente.setCorreo("1@gmail.com");
        cliente.setTelefono("44444");
        clienteService.guardarCliente(cliente);

    }
    @DeleteMapping("/cita/d/{id}")
    public void deleteCita(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
    }

    @PutMapping("/cita")
    public void updateCita(Long id) {

    }
}
