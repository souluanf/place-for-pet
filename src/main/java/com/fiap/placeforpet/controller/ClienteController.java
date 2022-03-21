package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.domain.dto.ClienteDto;
import com.fiap.placeforpet.domain.entity.Cliente;
import com.fiap.placeforpet.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {

        this.clienteService = clienteService;
    }

    @GetMapping(value = "{id}")
    public Cliente findById(@PathVariable Long id) {

        return clienteService.getById(id);
    }

    @GetMapping
    public List<Cliente> getAll() {

        return clienteService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(
            @RequestBody ClienteDto clienteDto) {

        return clienteService.create(clienteDto);
    }

    @PutMapping(value = "{id}")
    public Cliente update(
            @RequestBody Cliente cliente)   {
        return clienteService.update(cliente);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id)  {

        clienteService.delete(id);
    }

}
