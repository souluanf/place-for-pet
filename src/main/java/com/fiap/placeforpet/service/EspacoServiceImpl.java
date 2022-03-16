package com.fiap.placeforpet.service;


import com.fiap.placeforpet.domain.dto.EspacoDto;
import com.fiap.placeforpet.domain.entity.Espaco;
import com.fiap.placeforpet.repository.EspacoRepository;
import com.fiap.placeforpet.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspacoServiceImpl implements EspacoService {

    private final EspacoRepository espacoRepository;

    public EspacoServiceImpl(EspacoRepository espacoRepository) {
        this.espacoRepository = espacoRepository;
    }

    @Override
    public EspacoDto create(Espaco espaco) {
        return new EspacoDto(espacoRepository.save(espaco));
    }


    public EspacoDto update(Espaco espaco) {
        this.getById(espaco.getId());
        Espaco save = espacoRepository.save(espaco);
        return new EspacoDto(save);
    }

    @Override
    public void delete(long id) {
        this.getById(id);
        espacoRepository.deleteById(id);
    }

    @Override
    public List<EspacoDto> getAll() {
        List<Espaco> espacoList = espacoRepository.findAll();
        return espacoList.stream().map(EspacoDto::new).collect(Collectors.toList());
    }

    @Override
    public EspacoDto getById(long id) {
        Optional<Espaco> optionalEspacoDto = espacoRepository.findById(id);
        return optionalEspacoDto.map(EspacoDto::new).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
