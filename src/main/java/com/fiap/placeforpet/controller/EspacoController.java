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

    @GetMapping
    public List<EspacoDto> getAllEspaco() {
        return espacoService.getAll();
    }

    @GetMapping(value = "{id}")
    public EspacoDto findById(@PathVariable Long id) {
        return espacoService.getById(id);
    }

    @PostMapping
    public EspacoDto insertEspaco(@RequestBody EspacoDto espacoDto) {
        return espacoService.create(new Espaco(espacoDto));
    }

    @PutMapping(value = "{id}")
    public EspacoDto updateEspaco(@RequestBody EspacoDto espacoDto, @PathVariable Long id) {
        Espaco espaco = new Espaco(espacoDto);
        espaco.setId(id);
        return espacoService.update(espaco);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEspaco(@PathVariable Long id) {
        espacoService.delete(id);

    }

}
