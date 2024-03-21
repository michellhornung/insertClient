package com.hornung.crud.clients.exceptions;

/**
 * Exceção lançada quando o número de telefone não é válido (nulo).
 */
public class CellphoneNotIsValidException extends RuntimeException {

    private static final String ERROR = "O número de telefone não pode ser nulo";

    /**
     * Construtor padrão que cria uma nova instância da exceção com a mensagem de erro padrão.
     */
    public CellphoneNotIsValidException() {
        super(ERROR);
    }
}
