package com.fiap.placeforpet.config;

import com.fiap.placeforpet.entity.Agenda;
import com.fiap.placeforpet.entity.Cliente;
import com.fiap.placeforpet.entity.Endereco;
import com.fiap.placeforpet.entity.Pet;
import com.fiap.placeforpet.repository.AgendaRepository;
import com.fiap.placeforpet.repository.ClienteRepository;
import com.fiap.placeforpet.repository.EnderecoRepository;
import com.fiap.placeforpet.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Instantiation implements CommandLineRunner {

    final EnderecoRepository enderecoRepository;
    final ClienteRepository clienteRepository;
    final PetRepository petRepository;
    final AgendaRepository agendaRepository;

    public Instantiation(EnderecoRepository enderecoRepository, ClienteRepository clienteRepository, PetRepository petRepository, AgendaRepository agendaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
        this.petRepository = petRepository;
        this.agendaRepository = agendaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var cliente = new Cliente(null, "Romildo", "99999-9999", "teste@teste.com", null, null);
        var endereco = new Endereco(null, "Rua Romis", "Casa 1", "01234-567", "Teste City", "Teste", "TT", cliente);
        var pet = new Pet(null, "Bill", "RND", null, cliente);
        var agenda = new Agenda(null, LocalDate.now(), pet);

        clienteRepository.save(cliente);
        enderecoRepository.save(endereco);
        petRepository.save(pet);
        agendaRepository.save(agenda);

    }
}
