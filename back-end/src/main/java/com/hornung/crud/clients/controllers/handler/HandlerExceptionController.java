package com.hornung.crud.clients.controllers.handler;

import com.hornung.crud.clients.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Classe que manipula exceções globais para fornecer respostas padronizadas.
 */
@RestControllerAdvice
public class HandlerExceptionController {

    /**
     * Manipula a exceção CellphoneNotIsValidException.
     *
     * @param e       A exceção CellphoneNotIsValidException.
     * @param request O HttpServletRequest.
     * @return Uma ResponseEntity contendo uma resposta padronizada e o status HTTP correspondente.
     */
    @ExceptionHandler(CellphoneNotIsValidException.class)
    public ResponseEntity<GenericStandardException> cellphoneNotIsValid(CellphoneNotIsValidException e, HttpServletRequest request) {
        return genericHandlingException(e, HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
    }

    /**
     * Manipula a exceção CellphoneCanNotEmptyException.
     *
     * @param e       A exceção CellphoneCanNotEmptyException.
     * @param request O HttpServletRequest.
     * @return Uma ResponseEntity contendo uma resposta padronizada e o status HTTP correspondente.
     */
    @ExceptionHandler(CellphoneCanNotEmptyException.class)
    public ResponseEntity<GenericStandardException> cellphoneCanNotEmpty(CellphoneCanNotEmptyException e, HttpServletRequest request) {
        return genericHandlingException(e, HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
    }

    /**
     * Manipula a exceção CellphoneHasExistsInDatabaseException.
     *
     * @param e       A exceção CellphoneHasExistsInDatabaseException.
     * @param request O HttpServletRequest.
     * @return Uma ResponseEntity contendo uma resposta padronizada e o status HTTP correspondente.
     */
    @ExceptionHandler(CellphoneHasExistsInDatabaseException.class)
    public ResponseEntity<GenericStandardException> cellphoneHasExistsInDatabase(CellphoneHasExistsInDatabaseException e, HttpServletRequest request) {
        return genericHandlingException(e, HttpStatus.CONFLICT.value(), request.getRequestURI());
    }

    /**
     * Manipula a exceção NameIsNotValidException.
     *
     * @param e       A exceção NameIsNotValidException.
     * @param request O HttpServletRequest.
     * @return Uma ResponseEntity contendo uma resposta padronizada e o status HTTP correspondente.
     */
    @ExceptionHandler(NameIsNotValidException.class)
    public ResponseEntity<GenericStandardException> cellphoneHasExistsInDatabase(NameIsNotValidException e, HttpServletRequest request) {
        return genericHandlingException(e, HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
    }

    /**
     * Manipula a exceção ClientIdNotIsValidException.
     *
     * @param e       A exceção ClientIdNotIsValidException.
     * @param request O HttpServletRequest.
     * @return Uma ResponseEntity contendo uma resposta padronizada e o status HTTP correspondente.
     */
    @ExceptionHandler(ClientIdNotIsValidException.class)
    public ResponseEntity<GenericStandardException> clientIdNotIsValid(ClientIdNotIsValidException e, HttpServletRequest request) {
        return genericHandlingException(e, HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
    }

    /**
     * Manipula a exceção NameNotContaisMinimumCharactersException.
     *
     * @param e       A exceção NameNotContaisMinimumCharactersException.
     * @param request O HttpServletRequest.
     * @return Uma ResponseEntity contendo uma resposta padronizada e o status HTTP correspondente.
     */
    @ExceptionHandler(NameNotContaisMinimumCharactersException.class)
    public ResponseEntity<GenericStandardException> nameNotContaisMinimumCharacters(NameNotContaisMinimumCharactersException e, HttpServletRequest request) {
        return genericHandlingException(e, HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
    }

    /**
     * Método privado para encapsular a lógica comum de manipulação de exceções.
     *
     * @param e      A exceção.
     * @param status O status HTTP a ser retornado.
     * @param path   O caminho da solicitação.
     * @return Uma ResponseEntity contendo uma resposta padronizada e o status HTTP correspondente.
     */
    private ResponseEntity<GenericStandardException> genericHandlingException(Throwable e, Integer status, String path) {
        return ResponseEntity.status(status).body(new GenericStandardException(status, e.getMessage(), path));
    }
}
