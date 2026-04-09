package com.tech_challange.grupo35.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
public class CustomerEntity extends UserEntity {

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

}
