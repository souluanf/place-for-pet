package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.dto.ClienteDto;
import com.fiap.placeforpet.entity.Cliente;
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
    public Cliente create(@RequestBody ClienteDto clienteDto) {
        return clienteService.create(clienteDto);
    }

    @PutMapping(value = "{id}")
    public Cliente update(@PathVariable Long id,
                          @RequestBody ClienteDto clienteDto)   {
        return clienteService.update(id,clienteDto);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)  {
        clienteService.delete(id);
    }

}
