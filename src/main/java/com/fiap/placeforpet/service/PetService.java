package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.PetDto;
import com.fiap.placeforpet.domain.entity.Pet;

import java.util.List;

public interface PetService {

    Pet create(PetDto petDto);
    Pet update(Pet pet);
    void delete(Long id);
    List<Pet> getAll();
    Pet getById(Long id);
}