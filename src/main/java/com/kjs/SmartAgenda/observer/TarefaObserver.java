package com.kjs.SmartAgenda.observer;


import com.kjs.SmartAgenda.model.Tarefa;

public interface TarefaObserver {
    void notificar(Tarefa tarefa);
}
