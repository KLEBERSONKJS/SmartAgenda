package com.kjs.SmartAgenda.strategy;

import com.kjs.SmartAgenda.model.Tarefa;

public class ExecutorEstrategico {
    private EstrategiaExecucao estrategia;

    public void setEstrategia(EstrategiaExecucao estrategia) {
        this.estrategia = estrategia;
    }

    public void executar(Tarefa tarefa) {
        if (estrategia != null) {
            estrategia.executar(tarefa);
        } else {
            System.out.println("Nenhuma estratégia definida.");
        }
    }
}
