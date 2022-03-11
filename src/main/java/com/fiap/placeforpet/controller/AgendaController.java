package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.domain.dto.AgendaDto;
import com.fiap.placeforpet.domain.entity.Agenda;
import com.fiap.placeforpet.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public List<AgendaDto> getAllAgenda() {
        return agendaService.getAll();
    }


    @GetMapping(value = "{id}")
    public AgendaDto findById(@PathVariable Long id) {
        return agendaService.getById(id);
    }

    @PostMappinggis
    public AgendaDto insertAgenda(@RequestBody AgendaDto agendaDto) {
        return agendaService.create(new Agenda(agendaDto));
    }

    @PutMapping(value = "{id}")
    public AgendaDto updateAgenda(@RequestBody AgendaDto agendaDto, @PathVariable Long id) {
        Agenda agenda = new Agenda(agendaDto);
        agenda.setId(id);
        return agendaService.update(agenda);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAgenda(@PathVariable Long id) {
        agendaService.delete(id);

    }

}

