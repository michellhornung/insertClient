package com.hornung.crud.clients.dtos.response;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO (Data Transfer Object) para representar os dados de resposta de um cliente registrado.
 */
public class ClientRegisterResponseDTO {

    private Long id;
    private String name;
    private AddressRegisterResponseDTO address;
    private List<String> cellphones = new ArrayList<>();

    /**
     * Obtém o nome do cliente.
     *
     * @return O nome do cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtém o ID do cliente.
     *
     * @return O ID do cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do cliente.
     *
     * @param id O ID do cliente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Define o nome do cliente.
     *
     * @param name O nome do cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o endereço do cliente.
     *
     * @return O endereço do cliente.
     */
    public AddressRegisterResponseDTO getAddress() {
        return address;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param address O endereço do cliente.
     */
    public void setAddress(AddressRegisterResponseDTO address) {
        this.address = address;
    }

    /**
     * Obtém a lista de números de telefone do cliente.
     *
     * @return A lista de números de telefone do cliente.
     */
    public List<String> getCellphones() {
        return cellphones;
    }

    /**
     * Define a lista de números de telefone do cliente.
     *
     * @param cellphones A lista de números de telefone do cliente.
     */
    public void setCellphones(List<String> cellphones) {
        this.cellphones = cellphones;
    }
}