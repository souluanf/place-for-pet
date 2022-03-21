package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.domain.dto.ClienteDto;
import com.fiap.placeforpet.domain.entity.Cliente;
import com.fiap.placeforpet.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private ObjectMapper objectMapper;

    public ClienteServiceImpl(
            ClienteRepository clienteRepository,
            ObjectMapper objectMapper
    ){
        this.clienteRepository = clienteRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Cliente getById(Long id) {

        Cliente cliente = getClienteById(id);
        return new Cliente(cliente);
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream().map(Cliente::new).collect(Collectors.toList());
    }

    @Override
    public Cliente create(ClienteDto clienteDto) {

        Cliente cliente = objectMapper.convertValue(clienteDto, Cliente.class);
        Cliente clienteSaved = clienteRepository.save(cliente);
        return new Cliente(clienteSaved);
    }

    public Cliente update(Cliente cliente) {
        this.getById(cliente.getId());
        Cliente save = clienteRepository.save(cliente);
        return save;
    }

    @Override
    public void delete(Long id) {
        Cliente cliente = getClienteById(id);
        clienteRepository.deleteById(id);
    }

    private Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente.nao.encontrada"));
    }
}
