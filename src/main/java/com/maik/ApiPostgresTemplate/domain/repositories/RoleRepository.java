package com.maik.ApiPostgresTemplate.domain.repositories;

import com.maik.ApiPostgresTemplate.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}