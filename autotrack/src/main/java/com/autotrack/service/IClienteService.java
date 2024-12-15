package com.autotrack.service;

import com.autotrack.domain.Cliente;

public interface IClienteService {
    public void guardarCliente(Cliente cliente);
    public void eliminarCliente(Integer id);
    public Cliente buscarCliente(Integer id);


}
