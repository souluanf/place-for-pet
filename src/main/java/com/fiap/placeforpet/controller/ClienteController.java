package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.domain.dto.ClienteDto;
import com.fiap.placeforpet.domain.entity.Cliente;
import com.fiap.placeforpet.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

        private ClienteService clienteService;

        public ClienteController(ClienteService clienteService){
            this.clienteService = clienteService;
        }

        @GetMapping
        public List<ClienteDto> getAllCliente() {
              return clienteService.getAll();
        }

        @GetMapping(value = {"id"})
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

        @DeleteMapping
        public void deleteCliente(@PathVariable String id) {
            // TODO: 06/03/2022 implementar a busca pelo id e depois o delete
        }


}
