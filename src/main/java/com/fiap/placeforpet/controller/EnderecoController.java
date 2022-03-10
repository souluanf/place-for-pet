package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.domain.dto.EnderecoDto;
import com.fiap.placeforpet.domain.entity.Endereco;
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

    @GetMapping
    public List<EnderecoDto> getAllEndereco() {
        return enderecoService.getAll();
    }

    @GetMapping(value = "{id}")
    public EnderecoDto findById(@PathVariable Long id) {
        return enderecoService.getById(id);
    }

    @PostMapping
    public EnderecoDto insertEndereco(@RequestBody EnderecoDto enderecoDto) {
        return enderecoService.create(new Endereco(enderecoDto));
    }

    @PutMapping(value = "{id}")
    public EnderecoDto updateEndereco(@RequestBody EnderecoDto enderecoDto, @PathVariable Long id) {
        Endereco endereco = new Endereco(enderecoDto);
        endereco.setId(id);
        return enderecoService.update(endereco);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEndereco(@PathVariable Long id) {
        enderecoService.delete(id);

    }

}
