package com.hornung.crud.clients.dtos.request;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO (Data Transfer Object) para representar os dados de um cliente em uma solicitação de edição.
 */
public class ClientEditRequestDTO {

    private Long id;
    private String name;
    private AddressRegisterRequestDTO address;
    private List<String> cellphones = new ArrayList<>();

    /**
     * Adiciona um número de telefone celular à lista de números de telefone do cliente.
     *
     * @param cellphone O número de telefone celular a ser adicionado.
     */
    public void addCellphone(String cellphone) {
        this.cellphones.add(cellphone);
    }

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
    public AddressRegisterRequestDTO getAddress() {
        return address;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param address O endereço do cliente.
     */
    public void setAddress(AddressRegisterRequestDTO address) {
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