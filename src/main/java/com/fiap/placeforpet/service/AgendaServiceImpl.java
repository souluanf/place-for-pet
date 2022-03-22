package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.dto.AgendaDto;
import com.fiap.placeforpet.entity.Agenda;
import com.fiap.placeforpet.entity.Pet;
import com.fiap.placeforpet.repository.AgendaRepository;
import com.fiap.placeforpet.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final ObjectMapper objectMapper;
    private final PetService petService;

    public AgendaServiceImpl(AgendaRepository agendaRepository, ObjectMapper objectMapper,PetService petService){
        this.agendaRepository = agendaRepository;
        this.objectMapper = objectMapper;
        this.petService = petService;
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
        agenda.setPet(petService.getById(agendaDto.getPetId()));
        return agendaRepository.save(agenda);
    }

    public Agenda update(Long id, AgendaDto agendaDto) {
        this.getById(id);
        Agenda agenda = objectMapper.convertValue(agendaDto, Agenda.class);
        agenda.setPet(petService.getById(agendaDto.getPetId()));
        agenda.setId(id);
        return agendaRepository.save(agenda);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        agendaRepository.deleteById(id);
    }

}