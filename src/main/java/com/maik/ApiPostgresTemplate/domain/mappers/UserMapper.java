package com.maik.ApiPostgresTemplate.domain.mappers;

import com.maik.ApiPostgresTemplate.domain.entities.User;
import com.maik.ApiPostgresTemplate.models.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * To dto.
     *
     * @param target the target
     * @return the pet dto
     */
    UserDTO toDto(User target);

    /**
     * To dto.
     *
     * @param target the target
     * @return the pet dto
     */
    User toEntity(UserDTO target);

    List<UserDTO> toDto(List<User> target);

    List<User> toEntity(List<UserDTO> target);
}

    
    