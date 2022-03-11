package com.fiap.placeforpet.service;


import com.fiap.placeforpet.domain.dto.PrecoDto;
import com.fiap.placeforpet.domain.entity.Preco;
import com.fiap.placeforpet.repository.PrecoRepository;
import com.fiap.placeforpet.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrecoServiceImpl implements PrecoService {

    private final PrecoRepository precoRepository;

    public PrecoServiceImpl(PrecoRepository precoRepository) {
        this.precoRepository = precoRepository;
    }

    @Override
    public PrecoDto create(Preco preco) {
        return new PrecoDto(precoRepository.save(preco));
    }


    public PrecoDto update(Preco preco) {
        this.getById(preco.getId());
        Preco save = precoRepository.save(preco);
        return new PrecoDto(save);
    }

    @Override
    public void delete(long id) {
        this.getById(id);
        precoRepository.deleteById(id);

    }

    @Override
    public List<PrecoDto> getAll() {
        List<Preco> precoList = precoRepository.findAll();
        return precoList.stream().map(PrecoDto::new).collect(Collectors.toList());
    }

    @Override
    public PrecoDto getById(long id) {
        Optional<Preco> optionalPrecoDto = precoRepository.findById(id);
        return optionalPrecoDto.map(PrecoDto::new).orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado"));
    }
}
