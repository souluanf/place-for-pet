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

    @GetMapping
    public List<ClienteDto> getAllCliente() {
        return clienteService.getAll();
    }

    @GetMapping(value = "{id}")
    public ClienteDto findById(@PathVariable Long id) {
        return clienteService.getById(id);
    }

    @PostMapping
    public ClienteDto insertCliente(@RequestBody ClienteDto clienteDto) {
        return clienteService.create(new Cliente(clienteDto));
    }

    @PutMapping(value = "{id}")
    public ClienteDto updateCliente(@RequestBody ClienteDto clienteDto, @PathVariable Long id) {
        Cliente cliente = new Cliente(clienteDto);
        cliente.setId(id);
        return clienteService.update(cliente);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);

    }

}
