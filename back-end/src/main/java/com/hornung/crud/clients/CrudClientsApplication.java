package com.hornung.crud.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot para CRUD de clientes.
 */
@SpringBootApplication
public class CrudClientsApplication {

    /**
     * Método de inicialização da aplicação Spring Boot.
     *
     * @param args Argumentos de linha de comando (opcional).
     */
    public static void main(String[] args) {
        SpringApplication.run(CrudClientsApplication.class, args);
    }
}