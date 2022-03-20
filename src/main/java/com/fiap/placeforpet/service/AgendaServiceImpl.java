package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.AgendaDto;
import com.fiap.placeforpet.domain.entity.Agenda;
import com.fiap.placeforpet.repository.AgendaRepository;
import com.fiap.placeforpet.service.exception.ScheduleUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final EspacoService espacoService;

    public AgendaServiceImpl(AgendaRepository agendaRepository, EspacoService espacoService) {
        this.agendaRepository = agendaRepository;
        this.espacoService = espacoService;
    }

    @Override
    public AgendaDto create(Agenda agenda) {
        if (espacoService.getCapacidadeByData(agenda.getDataAgenda())>0)
            agenda = agendaRepository.save(agenda);
        else
            throw new ResponseStatusException(HttpStatus.OK,"Agenda Lotada");
        return new AgendaDto(agenda);
    }


    public AgendaDto update(Agenda agenda) {
        this.getById(agenda.getId());
        Agenda save = agendaRepository.save(agenda);
        return new AgendaDto(save);
    }

    @Override
    public void delete(long id) {
        this.getById(id);
        agendaRepository.deleteById(id);
    }

    @Override
    public List<AgendaDto> getAll() {
        List<Agenda> agendaList = agendaRepository.findAll();
        return agendaList.stream().map(AgendaDto::new).collect(Collectors.toList());
    }

    @Override
    public AgendaDto getById(long id) {
        Optional<Agenda> optionalAgendaDto = agendaRepository.findById(id);
        return optionalAgendaDto.map(AgendaDto::new).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
