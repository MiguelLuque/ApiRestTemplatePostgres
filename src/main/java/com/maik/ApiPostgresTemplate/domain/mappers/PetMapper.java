package com.maik.ApiPostgresTemplate.domain.mappers;

import com.maik.ApiPostgresTemplate.domain.entities.Pet;
import com.maik.ApiPostgresTemplate.models.dto.PetDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    /**
     * To dto.
     *
     * @param target the target
     * @return the pet dto
     */
    PetDTO toDto(Pet target);

    /**
     * To dto.
     *
     * @param target the target
     * @return the pet dto
     */
    Pet toEntity(PetDTO target);

    List<PetDTO> toDto(List<Pet> target);

    List<Pet> toEntity(List<PetDTO> target);
}

    
    