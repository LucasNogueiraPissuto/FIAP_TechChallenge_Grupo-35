package com.tech_challange.grupo35.exception;

public class CpfAlreadyExistsException extends RuntimeException {
    public CpfAlreadyExistsException(String cpf) {
        super("CPF já cadastrado " + cpf);
    }
}
