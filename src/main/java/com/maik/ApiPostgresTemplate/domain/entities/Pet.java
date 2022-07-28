package com.maik.ApiPostgresTemplate.domain.entities;

import com.maik.ApiPostgresTemplate.models.dto.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, length = 80)
    private String name;
    @NotBlank
    @Column(nullable = false, length = 80)
    private String type;
    private String breed;
    @NotBlank
    @Column(nullable = false, length = 30)
    private String color;
    @Enumerated(EnumType.STRING)
    private PetDTO.SizeEnum size;
    private Integer age;
}
