package com.hornung.crud.clients.dtos.response;

/**
 * DTO (Data Transfer Object) para representar os dados de resposta de um endereço.
 */
public class AddressRegisterResponseDTO {

    private String neighborhood;
    private String address;

    /**
     * Construtor para criar uma instância de AddressRegisterResponseDTO com o bairro e endereço especificados.
     *
     * @param neighborhood O bairro do endereço.
     * @param address      O endereço.
     */
    public AddressRegisterResponseDTO(String neighborhood, String address) {
        this.neighborhood = neighborhood;
        this.address = address;
    }

    /**
     * Obtém o bairro do endereço.
     *
     * @return O bairro do endereço.
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Define o bairro do endereço.
     *
     * @param neighborhood O bairro do endereço a ser definido.
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * Obtém o endereço.
     *
     * @return O endereço.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define o endereço.
     *
     * @param address O endereço a ser definido.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}