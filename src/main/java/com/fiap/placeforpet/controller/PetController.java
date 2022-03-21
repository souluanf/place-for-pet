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

    @GetMapping(value = "{id}")
    public Pet findById(@PathVariable Long id) {

        return petService.getById(id);
    }

    @GetMapping
    public List<Pet> getAll() {

        return petService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet create(
            @RequestBody PetDto petDto) {

        return petService.create(petDto);
    }

    @PutMapping(value = "{id}")
    public Pet update(
            @RequestBody Pet pet)   {
        return petService.update(pet);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id)  {

        petService.delete(id);
    }

}
