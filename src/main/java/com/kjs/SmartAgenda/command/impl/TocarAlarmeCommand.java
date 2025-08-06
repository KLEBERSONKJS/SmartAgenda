package com.kjs.SmartAgenda.command.impl;


import com.kjs.SmartAgenda.command.Command;

public class TocarAlarmeCommand implements Command {
    private final String horario;

    public TocarAlarmeCommand(String horario) {
        this.horario = horario;
    }

    @Override
    public void executar() {
        System.out.println("Alarme tocando às " + horario);
    }
}
