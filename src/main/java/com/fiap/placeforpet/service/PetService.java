package com.fiap.placeforpet.service;

import com.fiap.placeforpet.dto.PetDto;
import com.fiap.placeforpet.entity.Pet;

import java.util.List;

public interface PetService {

    Pet create(PetDto petDto);
    Pet update(Long id, PetDto petDto);
    void delete(Long id);
    List<Pet> getAll();
    Pet getById(Long id);
}