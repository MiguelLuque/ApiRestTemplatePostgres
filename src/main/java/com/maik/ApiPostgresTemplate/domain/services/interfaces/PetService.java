package com.maik.ApiPostgresTemplate.domain.services.interfaces;

import com.maik.ApiPostgresTemplate.domain.entities.Pet;
import com.maik.ApiPostgresTemplate.models.dto.PetDTO;

import java.util.List;

public interface PetService {

    List<PetDTO> findAll();

    Pet findById(Long id);

    Pet findByName(String name);

    Pet save(Pet pet);

    void delete(Long id);

}
