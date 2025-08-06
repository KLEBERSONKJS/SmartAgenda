package com.kjs.SmartAgenda.command;

import java.util.ArrayList;
import java.util.List;

public class ExecutorDeTarefas {
    private final List<Command> filaDeComandos = new ArrayList<>();

    public void agendarComando(Command comando) {
        filaDeComandos.add(comando);
    }

    public void executarTodos() {
        for (Command comando : filaDeComandos) {
            comando.executar();
        }
        filaDeComandos.clear();
    }
}
