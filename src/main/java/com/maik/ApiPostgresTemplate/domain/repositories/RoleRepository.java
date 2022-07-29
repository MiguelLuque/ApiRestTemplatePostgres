package com.maik.ApiPostgresTemplate.domain.repositories;

import com.maik.ApiPostgresTemplate.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}