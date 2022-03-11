package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.AgendaDto;
import com.fiap.placeforpet.domain.entity.Agenda;

import java.util.List;

public interface AgendaService {
    AgendaDto create(Agenda agenda);
    AgendaDto update(Agenda agenda);
    void delete (long id);
    List<AgendaDto>getAll();
    AgendaDto getById(long id);
}