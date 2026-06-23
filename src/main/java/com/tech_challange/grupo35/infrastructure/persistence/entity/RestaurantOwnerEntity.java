package com.tech_challange.grupo35.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurant_owners")
public class RestaurantOwnerEntity extends UserEntity {

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;
}
