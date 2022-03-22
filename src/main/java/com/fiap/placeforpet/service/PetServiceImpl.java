package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.dto.AgendaDto;
import com.fiap.placeforpet.dto.PetDto;
import com.fiap.placeforpet.entity.Agenda;
import com.fiap.placeforpet.entity.Pet;
import com.fiap.placeforpet.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final ObjectMapper objectMapper;
    private ClienteService clienteService;

    public PetServiceImpl(PetRepository petRepository, ObjectMapper objectMapper,ClienteService clienteService){
        this.petRepository = petRepository;
        this.objectMapper = objectMapper;
        this.clienteService = clienteService;
    }

    @Override
    public Pet getById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "pet.nao.encontrada"));
    }

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet create(PetDto petDto) {
        Pet pet = objectMapper.convertValue(petDto, Pet.class);
        pet.setCliente(clienteService.getById(petDto.getClienteId()));
        return petRepository.save(pet);
    }

    public Pet update(Long id, PetDto petDto) {
        this.getById(id);
        Pet pet = objectMapper.convertValue(petDto, Pet.class);
        pet.setCliente(clienteService.getById(petDto.getClienteId()));
        pet.setId(id);
        return petRepository.save(pet);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        petRepository.deleteById(id);
    }
}