package com.hornung.crud.clients.dtos.request;

/**
 * DTO (Data Transfer Object) para representar os dados de endereço recebidos em uma solicitação de registro.
 */
public class AddressRegisterRequestDTO {

    private String neighborhood;
    private String address;

    /**
     * Obtém o bairro do endereço.
     *
     * @return O bairro do endereço.
     */
    public String getNeighborhood() {
        return neighborhood;
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

    /**
     * Define o bairro do endereço.
     *
     * @param neighborhood O bairro do endereço a ser definido.
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}