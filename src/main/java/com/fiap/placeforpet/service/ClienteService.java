package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.ClienteDto;
import com.fiap.placeforpet.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {
    ClienteDto create(Cliente cliente);
    ClienteDto update(Cliente cliente);
    void delete (Cliente cliente);
    List<ClienteDto>getAll();
    ClienteDto getById(long id);
}
