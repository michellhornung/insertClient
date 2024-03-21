package com.hornung.crud.clients.builders.dto;

import com.hornung.crud.clients.dtos.response.AddressRegisterResponseDTO;
import com.hornung.crud.clients.dtos.response.ClientRegisterResponseDTO;

import java.util.List;

/**
 * Builder para criar instâncias de ClientRegisterResponseDTO.
 */
public class ClientRegisterResponseDTOBuilder {

    private ClientRegisterResponseDTO dto;

    /**
     * Construtor privado para impedir a instanciação direta do builder.
     */
    private ClientRegisterResponseDTOBuilder() {
        this.dto = new ClientRegisterResponseDTO();
    }

    /**
     * Método estático para obter uma instância de ClientRegisterResponseDTOBuilder.
     *
     * @return Uma nova instância de ClientRegisterResponseDTOBuilder.
     */
    public static ClientRegisterResponseDTOBuilder builder() {
        return new ClientRegisterResponseDTOBuilder();
    }

    /**
     * Define o ID do cliente.
     *
     * @param id O ID do cliente.
     * @return O próprio builder para permitir a construção encadeada.
     */
    public ClientRegisterResponseDTOBuilder id(Long id) {
        this.dto.setId(id);
        return this;
    }

    /**
     * Constrói e retorna uma instância de ClientRegisterResponseDTO.
     *
     * @return A instância de ClientRegisterResponseDTO construída.
     */
    public ClientRegisterResponseDTO build() {
        return this.dto;
    }

    /**
     * Define o nome do cliente.
     *
     * @param name O nome do cliente.
     * @return O próprio builder para permitir a construção encadeada.
     */
    public ClientRegisterResponseDTOBuilder name(String name) {
        this.dto.setName(name);
        return this;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param address O endereço do cliente.
     * @return O próprio builder para permitir a construção encadeada.
     */
    public ClientRegisterResponseDTOBuilder address(AddressRegisterResponseDTO address) {
        this.dto.setAddress(address);
        return this;
    }

    /**
     * Define os números de telefone celular do cliente.
     *
     * @param cellphones A lista de números de telefone celular do cliente.
     * @return O próprio builder para permitir a construção encadeada.
     */
    public ClientRegisterResponseDTOBuilder cellphones(List<String> cellphones) {
        this.dto.setCellphones(cellphones);
        return this;
    }
}
