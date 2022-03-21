package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.domain.dto.EspacoDto;
import com.fiap.placeforpet.domain.entity.Espaco;
import com.fiap.placeforpet.repository.EspacoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspacoServiceImpl implements EspacoService {

    private EspacoRepository espacoRepository;
    private ObjectMapper objectMapper;

    public EspacoServiceImpl(
            EspacoRepository espacoRepository,
            ObjectMapper objectMapper
    ){
        this.espacoRepository = espacoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Espaco getById(Long id) {

        Espaco espaco = getEspacoById(id);
        return new Espaco(espaco);
    }

    @Override
    public List<Espaco> getAll() {
        List<Espaco> espacoList = espacoRepository.findAll();
        return espacoList.stream().map(Espaco::new).collect(Collectors.toList());
    }

    @Override
    public Espaco create(EspacoDto espacoDto) {

        Espaco espaco = objectMapper.convertValue(espacoDto, Espaco.class);
        Espaco espacoSaved = espacoRepository.save(espaco);
        return new Espaco(espacoSaved);
    }

    public Espaco update(Espaco espaco) {
        this.getById(espaco.getId());
        Espaco save = espacoRepository.save(espaco);
        return save;
    }

    @Override
    public void delete(Long id) {
        Espaco espaco = getEspacoById(id);
        espacoRepository.deleteById(id);
    }

    private Espaco getEspacoById(Long id) {
        return espacoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "espaco.nao.encontrada"));
    }
}
