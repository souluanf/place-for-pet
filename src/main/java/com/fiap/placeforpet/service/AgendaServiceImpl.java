package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.domain.dto.AgendaDto;
import com.fiap.placeforpet.domain.entity.Agenda;
import com.fiap.placeforpet.repository.AgendaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

    private AgendaRepository agendaRepository;
    private ObjectMapper objectMapper;

    public AgendaServiceImpl(
            AgendaRepository agendaRepository,
            ObjectMapper objectMapper
    ){
        this.agendaRepository = agendaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Agenda getById(Long id) {

        Agenda agenda = getAgendaById(id);
        return new Agenda(agenda);
    }

    @Override
    public List<Agenda> getAll() {
        List<Agenda> agendaList = agendaRepository.findAll();
        return agendaList.stream().map(Agenda::new).collect(Collectors.toList());
    }

    @Override
    public Agenda create(AgendaDto agendaDto) {

        Agenda agenda = objectMapper.convertValue(agendaDto, Agenda.class);
        Agenda agendaSaved = agendaRepository.save(agenda);
        return new Agenda(agendaSaved);
    }

    public Agenda update(Agenda agenda) {
        this.getById(agenda.getId());
        Agenda save = agendaRepository.save(agenda);
        return save;
    }

    @Override
    public void delete(Long id) {
        Agenda agenda = getAgendaById(id);
        agendaRepository.deleteById(id);
    }

    private Agenda getAgendaById(Long id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "agenda.nao.encontrada"));
    }
}
