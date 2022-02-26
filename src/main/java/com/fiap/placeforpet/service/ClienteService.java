package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente create(Cliente cliente);
    void update(long id);
    void delete (Cliente cliente);
    List<Cliente>getAll();
    Cliente getById(long id);
}
