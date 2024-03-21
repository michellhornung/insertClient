package com.hornung.crud.clients.controllers;

import com.hornung.crud.clients.dtos.request.ClientEditRequestDTO;
import com.hornung.crud.clients.dtos.request.ClientRegisterRequestDTO;
import com.hornung.crud.clients.dtos.response.ClientRegisterResponseDTO;
import com.hornung.crud.clients.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para operações relacionadas a clientes.
 */
@RestController
@RequestMapping(path = "/v1/client")
public class ClientController {

    private final ClientService CLIENT_SERVICE;

    /**
     * Construtor para ClientController.
     *
     * @param clientService O serviço do cliente
     */
    @Autowired
    public ClientController(ClientService clientService) {
        this.CLIENT_SERVICE = clientService;
    }

    /**
     * Registra um novo cliente.
     *
     * @param request Os dados do cliente a serem registrados
     * @return Uma resposta HTTP com o DTO de resposta do cliente registrado
     */
    @PostMapping
    public ResponseEntity<ClientRegisterResponseDTO> register(@RequestBody @Valid ClientRegisterRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CLIENT_SERVICE.registerClient(request));
    }

    /**
     * Edita as informações de um cliente existente.
     *
     * @param request Os novos dados do cliente
     * @return Uma resposta HTTP indicando o status da operação
     */
    @PutMapping
    public ResponseEntity<Void> editClient(@RequestBody @Valid ClientEditRequestDTO request) {
        CLIENT_SERVICE.editClient(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Exclui um cliente pelo ID.
     *
     * @param id O ID do cliente a ser excluído
     * @return Uma resposta HTTP indicando o status da operação
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        CLIENT_SERVICE.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Lista todos os clientes.
     *
     * @return Uma resposta HTTP com uma lista de DTOs de resposta de clientes
     */
    @GetMapping
    public ResponseEntity<List<ClientRegisterResponseDTO>> listAll() {
        return ResponseEntity.ok().body(CLIENT_SERVICE.listAll());
    }
}
