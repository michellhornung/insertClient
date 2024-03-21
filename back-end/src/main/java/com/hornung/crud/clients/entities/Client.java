package com.hornung.crud.clients.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que representa um cliente.
 */
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_user_cellphone", joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cellphone_id", referencedColumnName = "id"))
    private List<Cellphone> cellphoneList = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Client() {
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
     * Define o nome do cliente.
     *
     * @param name O nome do cliente.
     */
    public void setName(String name) {
        this.name = name;
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
     * Obtém o endereço do cliente.
     *
     * @return O endereço do cliente.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param address O endereço do cliente.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Obtém a lista de números de telefone do cliente.
     *
     * @return A lista de números de telefone do cliente.
     */
    public List<Cellphone> getCellphoneList() {
        return cellphoneList;
    }

    /**
     * Define a lista de números de telefone do cliente.
     *
     * @param cellphoneList A lista de números de telefone do cliente.
     */
    public void setCellphoneList(List<Cellphone> cellphoneList) {
        this.cellphoneList = cellphoneList;
    }
}