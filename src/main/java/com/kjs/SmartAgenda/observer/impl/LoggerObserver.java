package com.kjs.SmartAgenda.observer.impl;


import com.kjs.SmartAgenda.model.Tarefa;
import com.kjs.SmartAgenda.observer.TarefaObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerObserver implements TarefaObserver {
    @Override
    public void notificar(Tarefa tarefa) {
       log.info("[Logger] Nova tarefa: " + tarefa.getNome());
    }
}
