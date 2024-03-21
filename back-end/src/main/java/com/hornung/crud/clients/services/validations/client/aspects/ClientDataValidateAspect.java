package com.hornung.crud.clients.services.validations.client.aspects;

import com.hornung.crud.clients.dtos.request.ClientEditRequestDTO;
import com.hornung.crud.clients.dtos.request.ClientRegisterRequestDTO;
import com.hornung.crud.clients.exceptions.*;
import com.hornung.crud.clients.repositories.ClientRepository;
import com.hornung.crud.clients.services.validations.CommonsPointcut;
import com.hornung.crud.clients.services.validations.client.annotations.ClientDataValidation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Aspecto para validação de dados do cliente.
 */
@Aspect
@Component
public class ClientDataValidateAspect extends CommonsPointcut {

    private final ClientRepository CLIENT_REPOSITORY;

    /**
     * Construtor para ClientDataValidateAspect.
     *
     * @param clientRepository Repositório do cliente
     */
    @Autowired
    public ClientDataValidateAspect(ClientRepository clientRepository) {
        this.CLIENT_REPOSITORY = clientRepository;
    }

    /**
     * Método de validação dos dados do cliente.
     *
     * @param joinPoint O ponto de junção do aspecto
     * @param validate  A anotação de validação do cliente
     */
    @Before("(inServiceLayer() && @annotation(validate))")
    public void clientDataValidate(JoinPoint joinPoint, ClientDataValidation validate) {

        ClientRegisterRequestDTO register = getArgs(joinPoint, ClientRegisterRequestDTO.class);
        ClientEditRequestDTO edit = getArgs(joinPoint, ClientEditRequestDTO.class);

        switch (validate.value()[0]) {
            case "REGISTER_VALIDATION":
                cellphoneHasEmpty(register.getCellphones());
                nameMinimumTenCharactersValidate(register.getName());
                cellphoneExistsValidation(register.getCellphones());
                cellphoneCanNotIsNullValidate(register.getCellphones());
                break;
            case "EDIT_VALIDATION":
                cellphoneHasEmpty(edit.getCellphones());
                nameMinimumTenCharactersValidate(edit.getName());
                cellphoneExistsValidation(edit.getCellphones());
                cellphoneCanNotIsNullValidate(edit.getCellphones());
                clientIdInvalidValidate(edit.getId());
                break;
            case "DELETE_VALIDATION":
                clientIdInvalidValidate(getArgs(joinPoint, Long.class));
                break;
        }
    }

    /**
     * Valida se o ID do cliente é inválido.
     *
     * @param id O ID do cliente
     * @throws ClientIdNotIsValidException Exceção lançada se o ID do cliente não for válido
     */
    public void clientIdInvalidValidate(Long id) {
        if (CLIENT_REPOSITORY.findById(id).isEmpty()) {
            throw new ClientIdNotIsValidException();
        }
    }

    /**
     * Valida se o nome possui pelo menos dez caracteres.
     *
     * @param name O nome a ser validado
     * @throws NameNotContaisMinimumCharactersException Exceção lançada se o nome não contiver o número mínimo de caracteres
     */
    public void nameMinimumTenCharactersValidate(String name) {
        if (name.length() < 10) {
            throw new NameNotContaisMinimumCharactersException();
        }
    }

    /**
     * Valida se o número de celular não pode ser nulo.
     *
     * @param cellphoneList A lista de números de celular a ser validada
     * @throws CellphoneNotIsValidException Exceção lançada se o número de celular não for válido
     */
    public void cellphoneCanNotIsNullValidate(List<String> cellphoneList) {
        if (cellphoneList.stream().anyMatch(Objects::isNull)) {
            throw new CellphoneNotIsValidException();
        }
    }

    /**
     * Valida se a lista de números de celular não está vazia.
     *
     * @param cellphoneList A lista de números de celular a ser validada
     * @throws CellphoneCanNotEmptyException Exceção lançada se a lista de números de celular estiver vazia
     */
    public void cellphoneHasEmpty(List<String> cellphoneList) {
        if (cellphoneList.isEmpty()) {
            throw new CellphoneCanNotEmptyException();
        }
    }

    /**
     * Valida se o número de celular já existe no banco de dados.
     *
     * @param cellphoneList A lista de números de celular a ser validada
     * @throws CellphoneHasExistsInDatabaseException Exceção lançada se o número de celular já existir no banco de dados
     */
    public void cellphoneExistsValidation(List<String> cellphoneList) {
        if (!cellphoneList.isEmpty() && anyMatchToExistsCellphone(cellphoneList)) {
            String existingCellphone = cellphoneList.stream()
                    .filter(cellphone -> CLIENT_REPOSITORY.findByCellphone(cellphone) != null)
                    .findFirst()
                    .orElse(null);

            if (existingCellphone != null) {
                throw new CellphoneHasExistsInDatabaseException(existingCellphone);
            }
        }
    }

    /**
     * Verifica se existe algum número de celular já existente no banco de dados.
     *
     * @param cellphones A lista de números de celular
     * @return true se algum número de celular já existir no banco de dados, senão false
     */
    public boolean anyMatchToExistsCellphone(List<String> cellphones) {
        return cellphones.stream().anyMatch(cell -> CLIENT_REPOSITORY.findByCellphone(cell) != null);
    }

    /**
     * Obtém os argumentos do ponto de junção.
     *
     * @param joinPoint O ponto de junção
     * @param classType O tipo da classe
     * @param <T>       O tipo genérico
     * @return Os argumentos do ponto de junção
     */
    private <T> T getArgs(JoinPoint joinPoint, Class<T> classType) {
        return classType.isInstance(joinPoint.getArgs()[0]) ? classType.cast(joinPoint.getArgs()[0]) : null;
    }
}
