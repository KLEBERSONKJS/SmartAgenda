package com.kjs.SmartAgenda.chain;

import com.kjs.SmartAgenda.model.Tarefa;

import java.time.LocalTime;

public class VerificaHorarioComercial extends Verificador {
    @Override
    protected boolean condicao(Tarefa tarefa) {
        LocalTime agora = LocalTime.now();
        return agora.isAfter(LocalTime.of(8, 0)) && agora.isBefore(LocalTime.of(18, 0));
    }
}
