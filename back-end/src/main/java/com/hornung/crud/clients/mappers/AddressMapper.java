package com.hornung.crud.clients.mappers;

import com.hornung.crud.clients.dtos.request.AddressRegisterRequestDTO;
import com.hornung.crud.clients.dtos.response.AddressRegisterResponseDTO;
import com.hornung.crud.clients.entities.Address;

/**
 * Classe responsável por mapear objetos relacionados a endereço entre diferentes formatos.
 */
public class AddressMapper {

    /**
     * Converte um objeto AddressRegisterRequestDTO em um objeto Address.
     *
     * @param request O objeto AddressRegisterRequestDTO a ser convertido.
     * @return Um objeto Address com base nos dados do objeto AddressRegisterRequestDTO.
     */
    public static Address fromRequest(AddressRegisterRequestDTO request) {
        return new Address(request.getNeighborhood(), request.getAddress());
    }

    /**
     * Converte um objeto Address em um objeto AddressRegisterResponseDTO.
     *
     * @param entity O objeto Address a ser convertido.
     * @return Um objeto AddressRegisterResponseDTO com base nos dados do objeto Address.
     */
    public static AddressRegisterResponseDTO fromEntity(Address entity) {
        return new AddressRegisterResponseDTO(entity.getNeighborhood(), entity.getAddress());
    }
}
