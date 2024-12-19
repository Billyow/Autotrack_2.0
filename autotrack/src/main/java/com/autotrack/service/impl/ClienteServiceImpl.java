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
    public Cliente getClientebyDocumento(String documento) {
        return clienteRepository.findClienteByDocumento(documento);
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
//        clienteRepository.(id);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
