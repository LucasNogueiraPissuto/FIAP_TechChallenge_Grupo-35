package com.tech_challange.grupo35.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends User {

    private String cpf;
}
