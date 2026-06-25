package com.tech_challange.grupo35.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RestaurantOwner extends User {

    private String cnpj;
}
