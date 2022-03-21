package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.dto.AgendaDto;
import com.fiap.placeforpet.entity.Agenda;
import com.fiap.placeforpet.repository.AgendaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final ObjectMapper objectMapper;

    public AgendaServiceImpl(AgendaRepository agendaRepository, ObjectMapper objectMapper){
        this.agendaRepository = agendaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Agenda getById(Long id) {
        return agendaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "agenda.nao.encontrada"));
    }

    @Override
    public List<Agenda> getAll() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda create(AgendaDto agendaDto) {
        Agenda agenda = objectMapper.convertValue(agendaDto, Agenda.class);
        return agendaRepository.save(agenda);
    }

    public Agenda update(Agenda agenda) {
        getById(agenda.getId());
        return agendaRepository.save(agenda);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        agendaRepository.deleteById(id);
    }


}
