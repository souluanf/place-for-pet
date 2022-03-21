package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.dto.ClienteDto;
import com.fiap.placeforpet.entity.Cliente;
import com.fiap.placeforpet.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ObjectMapper objectMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ObjectMapper objectMapper){
        this.clienteRepository = clienteRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Cliente getById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente.nao.encontrada"));
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente create(ClienteDto clienteDto) {
        Cliente cliente = objectMapper.convertValue(clienteDto, Cliente.class);
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        getById(cliente.getId());
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        clienteRepository.deleteById(id);
    }


}
