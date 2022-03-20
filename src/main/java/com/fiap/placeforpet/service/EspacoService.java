package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.EspacoDto;
import com.fiap.placeforpet.domain.entity.Espaco;

import java.time.LocalDate;
import java.util.List;

public interface EspacoService {
    EspacoDto create(Espaco espaco);

    EspacoDto update(Espaco espaco);

    void delete(long id);

    List<EspacoDto> getAll();

    EspacoDto getById(long id);

    Integer getCapacidadeByData(LocalDate data);
}