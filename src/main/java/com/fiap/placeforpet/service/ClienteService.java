package com.fiap.placeforpet.service;

import com.fiap.placeforpet.dto.ClienteDto;
import com.fiap.placeforpet.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente create(ClienteDto clienteDto);
    Cliente update(Cliente cliente);
    void delete (Long id);
    List<Cliente>getAll();
    Cliente getById(Long id);
}
