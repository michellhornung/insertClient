package com.hornung.crud.clients.services.validations;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Classe que define os pontos de corte comuns para os serviços.
 */
public class CommonsPointcut implements PointcutsDefinition {

    /**
     * Ponto de corte para os métodos dentro da camada de serviço.
     */
    @Pointcut("within(com.hornung.crud.clients.services.*)")
    public void inServiceLayer() {
    }
}
