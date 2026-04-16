package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwnerEntity, UUID> {

    boolean existsByCnpj(String cnpj);
}
