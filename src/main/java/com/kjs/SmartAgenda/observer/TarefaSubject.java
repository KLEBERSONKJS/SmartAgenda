package com.kjs.SmartAgenda.observer;

import com.kjs.SmartAgenda.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaSubject {
    private final List<TarefaObserver> observers = new ArrayList<>();

    public void adicionarObserver(TarefaObserver observer) {
        observers.add(observer);
    }

    public void criarTarefa(Tarefa tarefa) {
        for (TarefaObserver observer : observers) {
            observer.notificar(tarefa);
        }
    }
}
