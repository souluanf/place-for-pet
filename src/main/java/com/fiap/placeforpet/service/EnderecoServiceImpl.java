package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.EnderecoDto;
import com.fiap.placeforpet.domain.entity.Endereco;
import com.fiap.placeforpet.repository.EnderecoRepository;
import com.fiap.placeforpet.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public EnderecoDto create(Endereco endereco) {
        return new EnderecoDto(enderecoRepository.save(endereco));
    }


    public EnderecoDto update(Endereco endereco) {
        this.getById(endereco.getId());
        Endereco save = enderecoRepository.save(endereco);
        return new EnderecoDto(save);
    }

    @Override
    public void delete(long id) {
        this.getById(id);
        enderecoRepository.deleteById(id);

    }

    @Override
    public List<EnderecoDto> getAll() {
        List<Endereco> enderecoList = enderecoRepository.findAll();
        return enderecoList.stream().map(EnderecoDto::new).collect(Collectors.toList());
    }

    @Override
    public EnderecoDto getById(long id) {
        Optional<Endereco> optionalEnderecoDto = enderecoRepository.findById(id);
        return optionalEnderecoDto.map(EnderecoDto::new).orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado"));
    }
}
