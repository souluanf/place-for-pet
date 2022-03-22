package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.dto.AgendaDto;
import com.fiap.placeforpet.dto.ClienteDto;
import com.fiap.placeforpet.entity.Agenda;
import com.fiap.placeforpet.entity.Cliente;
import com.fiap.placeforpet.entity.Endereco;
import com.fiap.placeforpet.repository.ClienteRepository;
import com.fiap.placeforpet.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ObjectMapper objectMapper;
    private EnderecoService enderecoService;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ObjectMapper objectMapper, EnderecoService enderecoService) {
        this.clienteRepository = clienteRepository;
        this.objectMapper = objectMapper;
        this.enderecoService = enderecoService;
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
        cliente.setEndereco(enderecoService.getById(clienteDto.getEnderecoId()));
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, ClienteDto clienteDto) {
        this.getById(id);
        Cliente cliente = objectMapper.convertValue(clienteDto, Cliente.class);
        cliente.setEndereco(enderecoService.getById(clienteDto.getEnderecoId()));
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        Cliente cliente = getById(id);
        enderecoService.delete(cliente.getEndereco().getId());
    }
}
