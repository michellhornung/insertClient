package com.hornung.crud.clients.exceptions;

/**
 * Exceção lançada quando o ID do cliente não é válido (não existe no banco de dados).
 */
public class ClientIdNotIsValidException extends RuntimeException {

    private static final String ERROR = "Esse ID não existe no banco de dados";

    /**
     * Construtor padrão que cria uma nova instância da exceção com a mensagem de erro padrão.
     */
    public ClientIdNotIsValidException() {
        super(ERROR);
    }
}
