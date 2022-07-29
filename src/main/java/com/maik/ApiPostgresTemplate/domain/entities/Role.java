package com.maik.ApiPostgresTemplate.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }

}