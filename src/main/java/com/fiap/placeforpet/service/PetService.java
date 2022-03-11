package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.PetDto;
import com.fiap.placeforpet.domain.entity.Pet;

import java.util.List;

public interface PetService {
    PetDto create(Pet pet);

    PetDto update(Pet pet);

    void delete(long id);

    List<PetDto> getAll();

    PetDto getById(long id);
}