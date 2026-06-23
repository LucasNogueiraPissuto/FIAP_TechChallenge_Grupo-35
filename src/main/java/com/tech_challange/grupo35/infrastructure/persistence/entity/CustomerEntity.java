package com.tech_challange.grupo35.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class CustomerEntity extends UserEntity {

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
}
