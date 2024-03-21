package com.hornung.crud.clients.services.validations.client.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação para marcação de métodos que realizam validações de dados de clientes.
 * Permite especificar os tipos de validações que serão executadas.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientDataValidation {

    /**
     * Retorna os tipos de validações que serão executadas.
     *
     * @return Os tipos de validações a serem executadas.
     */
    String[] value();
}
