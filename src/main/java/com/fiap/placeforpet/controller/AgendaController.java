package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.dto.AgendaDto;
import com.fiap.placeforpet.dto.EnderecoDto;
import com.fiap.placeforpet.entity.Agenda;
import com.fiap.placeforpet.entity.Endereco;
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
    public Agenda create(@RequestBody AgendaDto agendaDto) {

        Agenda agenda = agendaService.create(agendaDto);
        return agenda;
    }

    @PutMapping(value = "{id}")
    public Agenda update(
            @PathVariable Long id,
            @RequestBody AgendaDto agendaDto)   {
        return agendaService.update(id, agendaDto);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)  {
        agendaService.delete(id);
    }

}
