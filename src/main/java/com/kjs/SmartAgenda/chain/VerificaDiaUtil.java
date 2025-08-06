package com.kjs.SmartAgenda.chain;


import com.kjs.SmartAgenda.model.Tarefa;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VerificaDiaUtil extends Verificador {
    @Override
    protected boolean condicao(Tarefa tarefa) {
        DayOfWeek dia = LocalDate.now().getDayOfWeek();
        return dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY;
    }
}
