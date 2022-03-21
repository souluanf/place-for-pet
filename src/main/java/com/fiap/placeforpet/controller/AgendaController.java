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

    @GetMapping(value = "{id}")
    public Agenda findById(@PathVariable Long id) {

        return agendaService.getById(id);
    }

    @GetMapping
    public List<Agenda> getAll() {

        return agendaService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda create(
            @RequestBody AgendaDto agendaDto) {

        return agendaService.create(agendaDto);
    }

    @PutMapping(value = "{id}")
    public Agenda update(
            @RequestBody Agenda agenda)   {
        return agendaService.update(agenda);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id)  {

        agendaService.delete(id);
    }

}
