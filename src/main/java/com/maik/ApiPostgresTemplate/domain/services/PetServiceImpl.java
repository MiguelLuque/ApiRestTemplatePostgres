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
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public PetDTO findById(Long id) {
        return petRepository.findById(id).map(petMapper::toDto).orElseThrow(() -> new NoSuchElementException("Pet not found"));
    }

    @Override
    public PetDTO findByName(String name) {
        return petRepository.findByName(name).map(petMapper::toDto).orElseThrow(() -> new NoSuchElementException("Pet not found"));
    }

    @Override
    public PetDTO save(PetDTO PetDTO) {

        Pet pet = petMapper.toEntity(PetDTO);

        if(pet.getId() != null && checkIfPetExists(pet.getId()).isPresent()) {
            throw new IllegalArgumentException("Pet already exists");
        }
        Pet newPet = petRepository.save(pet);
        return petMapper.toDto(newPet);
    }

    @Override
    public PetDTO update(PetDTO petDTO) {
        Pet pet = petMapper.toEntity(petDTO);
        if(!checkIfPetExists(pet.getId()).isPresent()) {
            throw new IllegalArgumentException("Pet not found");
        }
        //check if is null
        if(pet.getId() == null) {
            throw new IllegalArgumentException("Pet id cannot be null");
        }
        pet = petRepository.save(pet);
        return petMapper.toDto(pet);
    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    private Optional<Pet> checkIfPetExists(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        return petRepository.findById(id);
    }


}
