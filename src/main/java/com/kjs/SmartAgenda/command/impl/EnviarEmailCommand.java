package com.kjs.SmartAgenda.command.impl;

import com.kjs.SmartAgenda.command.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Slf4j
public class EnviarEmailCommand implements Command {

    private final JavaMailSender mailSender;
    private final String destinatario;
    private final String assunto;
    private final String text;

    public EnviarEmailCommand(JavaMailSender mailSender, String destinatario, String assunto, String text) {
        this.mailSender = mailSender;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.text = text;
    }

    @Override
    public void executar() {
        try {
            SimpleMailMessage mensagem = new SimpleMailMessage();
            mensagem.setTo(destinatario);
            mensagem.setSubject(assunto);
            mensagem.setText(text);
            mailSender.send(mensagem);
            log.info("Enviando e-mail para " + destinatario + ": " + assunto);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
