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

    @Override
    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR", "ROLE_CUSTOMER"})
    public ResponseEntity<PetDTO> createPet(PetDTO body) {
        return ResponseEntity.created(null).body(petService.save(body));
    }

    @Override
    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR", "ROLE_CUSTOMER"})
    public ResponseEntity<List<PetDTO>> deletePet(Long petId) {
        petService.delete(petId);
        return ResponseEntity.ok().build();
    }

    @Override
    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR", "ROLE_CUSTOMER"})
    public ResponseEntity<PetDTO> findPetById(Long petId) {
        return ResponseEntity.ok(petService.findById(petId));
    }

    @Override
    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR", "ROLE_CUSTOMER"})
    public ResponseEntity<PetDTO> updatePet(PetDTO body) {
        return ResponseEntity.ok(petService.update(body));
    }
}
