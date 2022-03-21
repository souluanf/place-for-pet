package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.dto.EnderecoDto;
import com.fiap.placeforpet.entity.Endereco;
import com.fiap.placeforpet.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository, ObjectMapper objectMapper){
        this.enderecoRepository = enderecoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Endereco getById(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "endereco.nao.encontrada"));
    }

    @Override
    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco create(EnderecoDto enderecoDto) {
        Endereco endereco = objectMapper.convertValue(enderecoDto, Endereco.class);
        return enderecoRepository.save(endereco);
    }

    public Endereco update(Endereco endereco) {
        this.getById(endereco.getId());
        return enderecoRepository.save(endereco);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        enderecoRepository.deleteById(id);
    }

}
