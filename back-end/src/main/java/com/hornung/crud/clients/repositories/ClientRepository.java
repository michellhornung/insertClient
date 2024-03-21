package com.hornung.crud.clients.repositories;

import com.hornung.crud.clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface responsável por definir as operações de acesso a dados para a entidade Client.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     * Consulta personalizada para encontrar um cliente pelo número de telefone.
     *
     * @param cellphone O número de telefone a ser pesquisado.
     * @return O cliente encontrado com base no número de telefone fornecido.
     */
    @Query("SELECT c FROM Client c JOIN c.cellphoneList cell WHERE cell.number = :cellphone")
    Client findByCellphone(String cellphone);

    Client findByName(String name);
}
