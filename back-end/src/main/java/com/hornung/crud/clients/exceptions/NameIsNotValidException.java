package com.hornung.crud.clients.exceptions;

/**
 * Exceção lançada quando o número de telefone não pode estar vazio.
 */
public class NameIsNotValidException extends RuntimeException {

    private static final String ERROR = "O nome não é um valo válido";

    /**
     * Construtor padrão que cria uma nova instância da exceção com a mensagem de erro padrão.
     */
    public NameIsNotValidException() {
        super(ERROR);
    }
}
