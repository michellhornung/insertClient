package com.hornung.crud.clients.entities;

import jakarta.persistence.*;

/**
 * Entidade que representa um número de telefone celular.
 */
@Entity
@Table(name = "tb_cellphone")
public class Cellphone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    /**
     * Construtor padrão.
     */
    public Cellphone() {
    }

    /**
     * Construtor para criar um número de telefone celular com o número especificado.
     *
     * @param number O número de telefone celular.
     */
    public Cellphone(String number) {
        this.number = number;
    }

    /**
     * Obtém o ID do número de telefone celular.
     *
     * @return O ID do número de telefone celular.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do número de telefone celular.
     *
     * @param id O ID do número de telefone celular.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o número de telefone celular.
     *
     * @return O número de telefone celular.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Define o número de telefone celular.
     *
     * @param number O número de telefone celular.
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
