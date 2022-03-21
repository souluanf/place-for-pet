package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.domain.dto.EnderecoDto;
import com.fiap.placeforpet.domain.entity.Endereco;
import com.fiap.placeforpet.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;
    private ObjectMapper objectMapper;

    public EnderecoServiceImpl(
            EnderecoRepository enderecoRepository,
            ObjectMapper objectMapper
    ){
        this.enderecoRepository = enderecoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Endereco getById(Long id) {

        Endereco endereco = getEnderecoById(id);
        return new Endereco(endereco);
    }

    @Override
    public List<Endereco> getAll() {
        List<Endereco> enderecoList = enderecoRepository.findAll();
        return enderecoList.stream().map(Endereco::new).collect(Collectors.toList());
    }

    @Override
    public Endereco create(EnderecoDto enderecoDto) {

        Endereco endereco = objectMapper.convertValue(enderecoDto, Endereco.class);
        Endereco enderecoSaved = enderecoRepository.save(endereco);
        return new Endereco(enderecoSaved);
    }

    public Endereco update(Endereco endereco) {
        this.getById(endereco.getId());
        Endereco save = enderecoRepository.save(endereco);
        return save;
    }

    @Override
    public void delete(Long id) {
        Endereco endereco = getEnderecoById(id);
        enderecoRepository.deleteById(id);
    }

    private Endereco getEnderecoById(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "endereco.nao.encontrada"));
    }
}
