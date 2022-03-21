package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.domain.dto.EspacoDto;
import com.fiap.placeforpet.domain.entity.Espaco;
import com.fiap.placeforpet.service.EspacoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espaco")
public class EspacoController {

    private final EspacoService espacoService;

    public EspacoController(EspacoService espacoService) {

        this.espacoService = espacoService;
    }

    @GetMapping(value = "{id}")
    public Espaco findById(@PathVariable Long id) {

        return espacoService.getById(id);
    }

    @GetMapping
    public List<Espaco> getAll() {

        return espacoService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Espaco create(
            @RequestBody EspacoDto espacoDto) {

        return espacoService.create(espacoDto);
    }

    @PutMapping(value = "{id}")
    public Espaco update(
            @RequestBody Espaco espaco)   {
        return espacoService.update(espaco);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id)  {

        espacoService.delete(id);
    }

}
