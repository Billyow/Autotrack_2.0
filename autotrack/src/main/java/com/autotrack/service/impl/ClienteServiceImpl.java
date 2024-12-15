package com.autotrack.service.impl;

import com.autotrack.domain.Cliente;
import com.autotrack.repository.ClienteRepository;
import com.autotrack.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepository.borrarLogicamente(id);
    }




    @Override
    public Cliente buscarCliente(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
