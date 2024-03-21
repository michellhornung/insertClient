package com.hornung.crud.clients.mappers;

import com.hornung.crud.clients.builders.dto.ClientRegisterResponseDTOBuilder;
import com.hornung.crud.clients.builders.entity.ClientBuilder;
import com.hornung.crud.clients.dtos.request.ClientEditRequestDTO;
import com.hornung.crud.clients.dtos.request.ClientRegisterRequestDTO;
import com.hornung.crud.clients.dtos.response.ClientRegisterResponseDTO;
import com.hornung.crud.clients.entities.Cellphone;
import com.hornung.crud.clients.entities.Client;

/**
 * Classe responsável por mapear objetos relacionados a clientes entre diferentes formatos.
 */
public class ClientMapper {

    /**
     * Converte um objeto ClientRegisterRequestDTO em um objeto Client.
     *
     * @param request O objeto ClientRegisterRequestDTO a ser convertido.
     * @return Um objeto Client com base nos dados do objeto ClientRegisterRequestDTO.
     */
    public static Client fromRequest(ClientRegisterRequestDTO request) {
        return ClientBuilder.builder()
                .name(request.getName())
                .address(AddressMapper.fromRequest(request.getAddress()))
                .cellphones(request.getCellphones().stream().map(Cellphone::new).toList())
                .build();
    }

    /**
     * Converte um objeto Client em um objeto ClientRegisterResponseDTO.
     *
     * @param entity O objeto Client a ser convertido.
     * @return Um objeto ClientRegisterResponseDTO com base nos dados do objeto Client.
     */
    public static ClientRegisterResponseDTO fromEntity(Client entity) {
        return ClientRegisterResponseDTOBuilder.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(AddressMapper.fromEntity(entity.getAddress()))
                .cellphones(entity.getCellphoneList().stream().map(Cellphone::getNumber).toList())
                .build();
    }

    /**
     * Converte um objeto ClientEditRequestDTO em um objeto Client.
     *
     * @param request O objeto ClientEditRequestDTO a ser convertido.
     * @return Um objeto Client com base nos dados do objeto ClientEditRequestDTO.
     */
    public static Client fromRequest(ClientEditRequestDTO request) {
        return ClientBuilder.builder()
                .id(request.getId())
                .name(request.getName())
                .address(AddressMapper.fromRequest(request.getAddress()))
                .cellphones(request.getCellphones().stream().map(Cellphone::new).toList())
                .build();
    }
}