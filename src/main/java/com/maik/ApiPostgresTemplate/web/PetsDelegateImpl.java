package com.maik.ApiPostgresTemplate.web;

import com.maik.ApiPostgresTemplate.api.PetsApiDelegate;
import com.maik.ApiPostgresTemplate.domain.entities.Pet;
import com.maik.ApiPostgresTemplate.domain.repositories.PetRepository;
import com.maik.ApiPostgresTemplate.domain.services.interfaces.PetService;
import com.maik.ApiPostgresTemplate.models.dto.PetDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PetsDelegateImpl implements PetsApiDelegate {

    private final PetService petService;

    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR"})
    @Override
    public ResponseEntity<List<PetDTO>> findAllPets() {
        return ResponseEntity.ok(petService.findAll());
    }
}
