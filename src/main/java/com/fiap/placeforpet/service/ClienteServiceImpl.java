package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.ClienteDto;
import com.fiap.placeforpet.domain.entity.Cliente;
import com.fiap.placeforpet.repository.ClienteRepository;
import com.fiap.placeforpet.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDto create(Cliente cliente) {
        return new ClienteDto(clienteRepository.save(cliente));
    }


    public ClienteDto update(Cliente cliente) {
        this.getById(cliente.getId());
        Cliente save = clienteRepository.save(cliente);
        return new ClienteDto(save);
    }

    @Override
    public void delete(long id) {
        this.getById(id);
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteDto> getAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    @Override
    public ClienteDto getById(long id) {
        Optional<Cliente> optionalClienteDto = clienteRepository.findById(id);
        return optionalClienteDto.map(ClienteDto::new).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
