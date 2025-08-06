package com.kjs.SmartAgenda.strategy.impl;

import com.kjs.SmartAgenda.model.Tarefa;
import com.kjs.SmartAgenda.strategy.EstrategiaExecucao;

public class ExecucaoImediata implements EstrategiaExecucao {
    @Override
    public void executar(Tarefa tarefa) {
        System.out.println("Executando tarefa imediatamente: " + tarefa.getNome());
    }
}
