package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.dto.EnderecoDto;
import com.fiap.placeforpet.entity.Endereco;
import com.fiap.placeforpet.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping(value = "{id}")
    public Endereco findById(@PathVariable Long id) {
        return enderecoService.getById(id);
    }

    @GetMapping
    public List<Endereco> getAll() {
        return enderecoService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco create(@RequestBody EnderecoDto enderecoDto) {
        return enderecoService.create(enderecoDto);
    }

    @PutMapping(value = "{id}")
    public Endereco update(
            @PathVariable Long id,
            @RequestBody EnderecoDto enderecoDto)   {
        return enderecoService.update(id, enderecoDto);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)  {
        enderecoService.delete(id);
    }

}
