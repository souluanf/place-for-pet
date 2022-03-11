package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.domain.dto.PrecoDto;
import com.fiap.placeforpet.domain.entity.Preco;
import com.fiap.placeforpet.service.PrecoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preco")
public class PrecoController {

    private final PrecoService precoService;

    public PrecoController(PrecoService precoService) {
        this.precoService = precoService;
    }

    @GetMapping
    public List<PrecoDto> getAllPreco() {
        return precoService.getAll();
    }

    @GetMapping(value = "{id}")
    public PrecoDto findById(@PathVariable Long id) {
        return precoService.getById(id);
    }

    @PostMapping
    public PrecoDto insertPreco(@RequestBody PrecoDto precoDto) {
        return precoService.create(new Preco(precoDto));
    }

    @PutMapping(value = "{id}")
    public PrecoDto updatePreco(@RequestBody PrecoDto precoDto, @PathVariable Long id) {
        Preco preco = new Preco(precoDto);
        preco.setId(id);
        return precoService.update(preco);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePreco(@PathVariable Long id) {
        precoService.delete(id);

    }

}
