package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.dto.PetDto;
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

    public PetServiceImpl(PetRepository petRepository, ObjectMapper objectMapper){
        this.petRepository = petRepository;
        this.objectMapper = objectMapper;
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
        return petRepository.save(pet);
    }

    public Pet update(Pet pet) {
        getById(pet.getId());
        return petRepository.save(pet);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        petRepository.deleteById(id);
    }
}
