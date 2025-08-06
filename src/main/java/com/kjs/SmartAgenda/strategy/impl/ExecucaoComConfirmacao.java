package com.kjs.SmartAgenda.strategy.impl;

import com.kjs.SmartAgenda.model.Tarefa;
import com.kjs.SmartAgenda.strategy.EstrategiaExecucao;

import java.util.Scanner;

public class ExecucaoComConfirmacao implements EstrategiaExecucao {
    @Override
    public void executar(Tarefa tarefa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja executar a tarefa \"" + tarefa.getNome() + "\"? (s/n): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.println("Tarefa executada com confirmação: " + tarefa.getNome());
        } else {
            System.out.println("Execução cancelada.");
        }
    }
}
