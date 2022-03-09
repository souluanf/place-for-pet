package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.ClienteDto;
import com.fiap.placeforpet.domain.entity.Cliente;
import com.fiap.placeforpet.repository.ClienteRepository;
import com.fiap.placeforpet.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

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
    public void delete(Cliente cliente) {

    }

    @Override
    public List<ClienteDto> getAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        List<ClienteDto> clienteDtoList = clienteList.stream().map(ClienteDto::new).collect(Collectors.toList());
        return clienteDtoList;

    }

    @Override
    public ClienteDto getById(long id) {
        Optional<Cliente> optionalClienteDto = clienteRepository.findById(id);
        return optionalClienteDto.map(ClienteDto::new).orElseThrow(()-> new ObjectNotFoundException("Objeto Não Encontrado")) ;

    }
}
