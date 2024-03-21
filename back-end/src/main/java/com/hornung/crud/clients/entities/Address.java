package com.hornung.crud.clients.entities;

import jakarta.persistence.*;

/**
 * Entidade que representa um endereço.
 */
@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private String neighborhood;

    /**
     * Construtor padrão.
     */
    public Address() {
    }

    /**
     * Construtor para criar um endereço com o bairro especificado.
     *
     * @param neighborhood O bairro do endereço.
     * @param address      O endereço.
     */
    public Address(String neighborhood, String address) {
        this.address = address;
        this.neighborhood = neighborhood;
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
     * Obtém o ID do endereço.
     *
     * @return O ID do endereço.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do endereço.
     *
     * @param id O ID do endereço a ser definido.
     */
    public void setId(Long id) {
        this.id = id;
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