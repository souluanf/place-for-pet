package com.fiap.placeforpet.service;


import com.fiap.placeforpet.domain.dto.PetDto;
import com.fiap.placeforpet.domain.entity.Pet;
import com.fiap.placeforpet.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public PetDto create(Pet pet) {
        return new PetDto(petRepository.save(pet));
    }


    public PetDto update(Pet pet) {
        this.getById(pet.getId());
        Pet save = petRepository.save(pet);
        return new PetDto(save);
    }

    @Override
    public void delete(long id) {
        this.getById(id);
        petRepository.deleteById(id);

    }

    @Override
    public List<PetDto> getAll() {
        List<Pet> petList = petRepository.findAll();
        return petList.stream().map(PetDto::new).collect(Collectors.toList());
    }

    @Override
    public PetDto getById(long id) {
        Optional<Pet> optionalPetDto = petRepository.findById(id);
        return optionalPetDto.map(PetDto::new).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
