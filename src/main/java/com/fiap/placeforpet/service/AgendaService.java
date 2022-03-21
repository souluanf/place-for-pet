package com.fiap.placeforpet.service;

import com.fiap.placeforpet.dto.AgendaDto;
import com.fiap.placeforpet.entity.Agenda;

import java.util.List;

public interface AgendaService {
    Agenda create(AgendaDto agendaDto);
    Agenda update(Agenda agenda);
    void delete (Long id);
    List<Agenda>getAll();
    Agenda getById(Long id);
}