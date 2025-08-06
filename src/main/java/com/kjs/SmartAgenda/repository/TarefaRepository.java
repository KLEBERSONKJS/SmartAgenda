package com.kjs.SmartAgenda.repository;

import com.kjs.SmartAgenda.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
