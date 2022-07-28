package com.maik.ApiPostgresTemplate.domain.services;

import com.maik.ApiPostgresTemplate.domain.entities.Pet;
import com.maik.ApiPostgresTemplate.domain.mappers.PetMapper;
import com.maik.ApiPostgresTemplate.domain.repositories.PetRepository;
import com.maik.ApiPostgresTemplate.domain.services.interfaces.PetService;
import com.maik.ApiPostgresTemplate.models.dto.PetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public List<PetDTO> findAll() {
        return petMapper.toDto(petRepository.findAll());
    }

    @Override
    public Pet findById(Long id) {
        return null;
    }

    @Override
    public Pet findByName(String name) {
        return null;
    }

    @Override
    public Pet save(Pet pet) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
