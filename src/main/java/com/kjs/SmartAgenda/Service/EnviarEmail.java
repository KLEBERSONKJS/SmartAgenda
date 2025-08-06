package com.kjs.SmartAgenda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmail {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailSimples(String para, String assunto) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(para);
        mensagem.setSubject(assunto);
        mailSender.send(mensagem);
    }
}
