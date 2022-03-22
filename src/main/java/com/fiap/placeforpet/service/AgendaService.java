package com.fiap.placeforpet.service;

import com.fiap.placeforpet.dto.AgendaDto;
import com.fiap.placeforpet.entity.Agenda;

import java.util.List;
public interface AgendaService {
    Agenda getById(Long id);
    List<Agenda>getAll();
    Agenda create(AgendaDto agendaDto);
    Agenda update(Long id, AgendaDto agendaDto);
    void delete (Long id);
}
