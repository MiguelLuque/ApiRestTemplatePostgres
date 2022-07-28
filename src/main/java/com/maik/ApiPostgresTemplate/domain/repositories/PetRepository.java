package com.maik.ApiPostgresTemplate.domain.repositories;

import com.maik.ApiPostgresTemplate.domain.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
