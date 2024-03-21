package com.hornung.crud.clients.exceptions;

/**
 * Exceção lançada quando o número de telefone não pode estar vazio.
 */
public class CellphoneCanNotEmptyException extends RuntimeException {

    private static final String ERROR = "O número de telefone não pode ser vazio";

    /**
     * Construtor padrão que cria uma nova instância da exceção com a mensagem de erro padrão.
     */
    public CellphoneCanNotEmptyException() {
        super(ERROR);
    }
}
