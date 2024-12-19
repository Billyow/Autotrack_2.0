package com.autotrack.service;

import com.autotrack.domain.Cliente;

public interface IClienteService {
    public Cliente getClientebyDocumento(String documento);
    public void guardarCliente(Cliente cliente);
    public void eliminarCliente(Long id);
    public Cliente buscarCliente(Long id);


}
