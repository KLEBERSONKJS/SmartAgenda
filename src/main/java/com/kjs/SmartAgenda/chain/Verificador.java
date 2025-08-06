package com.kjs.SmartAgenda.chain;


import com.kjs.SmartAgenda.model.Tarefa;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Verificador {
    protected Verificador proximo;

    public Verificador definirProximo(Verificador proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public void verificar(Tarefa tarefa) {
        if (condicao(tarefa)) {
            if (proximo != null) {
                proximo.verificar(tarefa);
            } else {
                log.info("Tarefa aprovada e será executada: " + tarefa.getNome());
            }
        } else {
            log.info("Tarefa bloqueada em: " + this.getClass().getSimpleName());
        }
    }

    protected abstract boolean condicao(Tarefa tarefa);
}
