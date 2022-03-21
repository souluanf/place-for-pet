package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.EspacoDto;
import com.fiap.placeforpet.domain.entity.Espaco;

import java.util.List;

public interface EspacoService {
    Espaco create(EspacoDto espacoDto);
    Espaco update(Espaco espaco);
    void delete(Long id);
    List<Espaco> getAll();
    Espaco getById(Long id);
}