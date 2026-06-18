package com.tech_challange.grupo35.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "restaurant_owners")
public class RestaurantOwner extends User {

  @Column(name = "cnpj", nullable = false, unique = true)
  private String cnpj;
}
