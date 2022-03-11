package com.fiap.placeforpet.controller;

import com.fiap.placeforpet.domain.dto.PetDto;
import com.fiap.placeforpet.domain.entity.Pet;
import com.fiap.placeforpet.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<PetDto> getAllPet() {
        return petService.getAll();
    }

    @GetMapping(value = "{id}")
    public PetDto findById(@PathVariable Long id) {
        return petService.getById(id);
    }

    @PostMapping
    public PetDto insertPet(@RequestBody PetDto petDto) {
        return petService.create(new Pet(petDto));
    }

    @PutMapping(value = "{id}")
    public PetDto updatePet(@RequestBody PetDto petDto, @PathVariable Long id) {
        Pet pet = new Pet(petDto);
        pet.setId(id);
        return petService.update(pet);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable Long id) {
        petService.delete(id);

    }

}
