package com.hornung.crud.clients.exceptions;

/**
 * Exceção lançada quando o nome não contém o número mínimo de caracteres necessários.
 */
public class NameNotContaisMinimumCharactersException extends RuntimeException {

    private static final String ERROR = "O nome precisa conter 10 ou mais caracteres";

    /**
     * Construtor padrão que cria uma nova instância da exceção com a mensagem de erro padrão.
     */
    public NameNotContaisMinimumCharactersException() {
        super(ERROR);
    }
}
