package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.entity.Cliente;
import com.fiap.placeforpet.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente create(Cliente cliente) {
        return null;
    }

    @Override
    public void update(long id) {
        var cliente = getById(id);

    }

    @Override
    public void delete(Cliente cliente) {

    }

    @Override
    public List<Cliente> getAll() {
        return null;
    }

    @Override
    public Cliente getById(long id)    {
        return clienteRepository.getById(id);
    }
}
