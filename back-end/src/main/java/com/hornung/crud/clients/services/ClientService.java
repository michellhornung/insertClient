package com.hornung.crud.clients.services;

import com.hornung.crud.clients.dtos.request.ClientEditRequestDTO;
import com.hornung.crud.clients.dtos.request.ClientRegisterRequestDTO;
import com.hornung.crud.clients.dtos.response.ClientRegisterResponseDTO;
import com.hornung.crud.clients.entities.Client;
import com.hornung.crud.clients.mappers.ClientMapper;
import com.hornung.crud.clients.repositories.ClientRepository;
import com.hornung.crud.clients.services.validations.client.annotations.ClientDataValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para operações relacionadas a clientes.
 */
@Service
public class ClientService {

    private final ClientRepository CLIENT_REPOSITORY;

    /**
     * Construtor para ClientService.
     *
     * @param clientRepository Repositório do cliente
     */
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.CLIENT_REPOSITORY = clientRepository;
    }

    /**
     * Registra um novo cliente.
     *
     * @param request Os dados do cliente a serem registrados
     * @return O DTO de resposta do cliente registrado
     */
    @Transactional
    @ClientDataValidation(value = {"REGISTER_VALIDATION"})
    public ClientRegisterResponseDTO registerClient(ClientRegisterRequestDTO request) {
        return ClientMapper.fromEntity(CLIENT_REPOSITORY.save(ClientMapper.fromRequest(request)));
    }

    /**
     * Retorna uma lista de todos os clientes registrados.
     *
     * @return Uma lista de DTOs de resposta de clientes
     */
    @Transactional(readOnly = true)
    public List<ClientRegisterResponseDTO> listAll() {
        return CLIENT_REPOSITORY.findAll().stream().map(ClientMapper::fromEntity).toList();
    }

    /**
     * Edita as informações de um cliente existente.
     *
     * @param request Os novos dados do cliente
     */
    @Transactional
    @ClientDataValidation(value = {"EDIT_VALIDATION"})
    public void editClient(ClientEditRequestDTO request) {
        ClientMapper.fromEntity(CLIENT_REPOSITORY.save(ClientMapper.fromRequest(request)));
    }

    /**
     * Exclui um cliente pelo ID.
     *
     * @param id O ID do cliente a ser excluído
     */
    @Transactional
    @ClientDataValidation(value = {"DELETE_VALIDATION"})
    public void deleteClient(Long id) {
        CLIENT_REPOSITORY.delete(this.findById(id).get());
    }

    /**
     * Localiza um cliente pelo ID.
     *
     * @param id O ID do cliente a ser localizado
     * @return Um objeto Optional contendo o cliente, se encontrado
     */
    @Transactional(readOnly = true)
    private Optional<Client> findById(Long id) {
        return CLIENT_REPOSITORY.findById(id);
    }
}
