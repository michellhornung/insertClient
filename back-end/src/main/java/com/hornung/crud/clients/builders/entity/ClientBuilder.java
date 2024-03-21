package com.hornung.crud.clients.builders.entity;

import com.hornung.crud.clients.entities.Address;
import com.hornung.crud.clients.entities.Cellphone;
import com.hornung.crud.clients.entities.Client;

import java.util.List;

/**
 * Builder para criar instâncias de Client.
 */
public class ClientBuilder {

    private Client entity;

    /**
     * Construtor privado para impedir a instanciação direta do builder.
     */
    private ClientBuilder() {
        this.entity = new Client();
    }

    /**
     * Método estático para obter uma instância de ClientBuilder.
     *
     * @return Uma nova instância de ClientBuilder.
     */
    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

    /**
     * Constrói e retorna uma instância de Client.
     *
     * @return A instância de Client construída.
     */
    public Client build() {
        return this.entity;
    }

    /**
     * Define o ID do cliente.
     *
     * @param id O ID do cliente.
     * @return O próprio builder para permitir a construção encadeada.
     */
    public ClientBuilder id(Long id) {
        this.entity.setId(id);
        return this;
    }

    /**
     * Define o nome do cliente.
     *
     * @param name O nome do cliente.
     * @return O próprio builder para permitir a construção encadeada.
     */
    public ClientBuilder name(String name) {
        this.entity.setName(name);
        return this;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param address O endereço do cliente.
     * @return O próprio builder para permitir a construção encadeada.
     */
    public ClientBuilder address(Address address) {
        this.entity.setAddress(address);
        return this;
    }

    /**
     * Define a lista de telefones celulares do cliente.
     *
     * @param cellphones A lista de telefones celulares do cliente.
     * @return O próprio builder para permitir a construção encadeada.
     */
    public ClientBuilder cellphones(List<Cellphone> cellphones) {
        this.entity.setCellphoneList(cellphones);
        return this;
    }
}
