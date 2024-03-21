package com.hornung.crud.clients.exceptions;

import java.time.Instant;

/**
 * Classe que representa um objeto de exceção genérico com informações padrão.
 */
public class GenericStandardException {

    private Instant timestamp = Instant.now(); // Horário em que a exceção ocorreu
    private Integer status; // Código de status HTTP
    private String error; // Mensagem de erro
    private String path; // Caminho do endpoint onde a exceção ocorreu

    /**
     * Construtor para criar um novo objeto de exceção genérico com as informações fornecidas.
     *
     * @param status O código de status HTTP.
     * @param error  A mensagem de erro.
     * @param path   O caminho do endpoint onde a exceção ocorreu.
     */
    public GenericStandardException(Integer status, String error, String path) {
        this.status = status;
        this.error = error;
        this.path = path;
    }

    /**
     * Obtém o horário em que a exceção ocorreu.
     *
     * @return O horário em que a exceção ocorreu.
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * Obtém o código de status HTTP.
     *
     * @return O código de status HTTP.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Define o código de status HTTP.
     *
     * @param status O código de status HTTP.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Obtém a mensagem de erro.
     *
     * @return A mensagem de erro.
     */
    public String getError() {
        return error;
    }

    /**
     * Define a mensagem de erro.
     *
     * @param error A mensagem de erro.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Obtém o caminho do endpoint onde a exceção ocorreu.
     *
     * @return O caminho do endpoint onde a exceção ocorreu.
     */
    public String getPath() {
        return path;
    }

    /**
     * Define o caminho do endpoint onde a exceção ocorreu.
     *
     * @param path O caminho do endpoint onde a exceção ocorreu.
     */
    public void setPath(String path) {
        this.path = path;
    }
}
