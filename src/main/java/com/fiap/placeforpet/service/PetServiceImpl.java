package com.fiap.placeforpet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.placeforpet.domain.dto.PetDto;
import com.fiap.placeforpet.domain.entity.Pet;
import com.fiap.placeforpet.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;
    private ObjectMapper objectMapper;

    public PetServiceImpl(
            PetRepository petRepository,
            ObjectMapper objectMapper
    ){
        this.petRepository = petRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Pet getById(Long id) {

        Pet pet = getPetById(id);
        return new Pet(pet);
    }

    @Override
    public List<Pet> getAll() {
        List<Pet> petList = petRepository.findAll();
        return petList.stream().map(Pet::new).collect(Collectors.toList());
    }

    @Override
    public Pet create(PetDto petDto) {

        Pet pet = objectMapper.convertValue(petDto, Pet.class);
        Pet petSaved = petRepository.save(pet);
        return new Pet(petSaved);
    }

    public Pet update(Pet pet) {
        this.getById(pet.getId());
        Pet save = petRepository.save(pet);
        return save;
    }

    @Override
    public void delete(Long id) {
        Pet pet = getPetById(id);
        petRepository.deleteById(id);
    }

    private Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "pet.nao.encontrada"));
    }
}
