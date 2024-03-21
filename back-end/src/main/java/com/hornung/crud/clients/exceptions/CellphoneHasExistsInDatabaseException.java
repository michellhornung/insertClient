package com.hornung.crud.clients.exceptions;

/**
 * Exceção lançada quando o número de telefone já existe no banco de dados.
 */
public class CellphoneHasExistsInDatabaseException extends RuntimeException {

    /**
     * Construtor que cria uma nova instância da exceção com uma mensagem personalizada indicando que o número de telefone já existe.
     *
     * @param cell O número de telefone que já existe no banco de dados.
     */
    public CellphoneHasExistsInDatabaseException(String cell) {
        super(String.format("O número %s de telefone já existe", cell));
    }
}
