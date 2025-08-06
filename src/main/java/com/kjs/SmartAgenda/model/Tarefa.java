package com.kjs.SmartAgenda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    public Tarefa(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }


    public Tarefa() {
    }
}
