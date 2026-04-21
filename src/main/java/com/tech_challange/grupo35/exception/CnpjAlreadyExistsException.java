package com.tech_challange.grupo35.exception;

public class CnpjAlreadyExistsException extends RuntimeException {
    public CnpjAlreadyExistsException(String cnpj) {
        super("CNPJ já cadastrado " + cnpj);
    }
}
