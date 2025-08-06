package com.kjs.SmartAgenda.controller;

import com.kjs.SmartAgenda.chain.VerificaDiaUtil;
import com.kjs.SmartAgenda.chain.VerificaHorarioComercial;
import com.kjs.SmartAgenda.chain.Verificador;
import com.kjs.SmartAgenda.command.Command;
import com.kjs.SmartAgenda.command.ExecutorDeTarefas;
import com.kjs.SmartAgenda.command.impl.EnviarEmailCommand;
import com.kjs.SmartAgenda.model.Tarefa;
import com.kjs.SmartAgenda.observer.TarefaObserver;
import com.kjs.SmartAgenda.observer.TarefaSubject;
import com.kjs.SmartAgenda.observer.impl.LoggerObserver;
import com.kjs.SmartAgenda.repository.TarefaRepository;
import com.kjs.SmartAgenda.strategy.ExecutorEstrategico;
import com.kjs.SmartAgenda.strategy.impl.ExecucaoImediata;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class TarefaController {

    private final TarefaSubject subject = new TarefaSubject();
    private final ExecutorDeTarefas executorDeTarefas = new ExecutorDeTarefas();
    private final ExecutorEstrategico executorEstrategico = new ExecutorEstrategico();

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private JavaMailSender mailSender;

    public TarefaController() {
        subject.adicionarObserver(new LoggerObserver());
        executorEstrategico.setEstrategia(new ExecucaoImediata());
    }

    @GetMapping("/")
    public String index() {
        return "formulario";
    }
    @PostMapping("/nova-tarefa")
    public String criarTarefa(@RequestParam String nome,
                              @RequestParam String descricao,
                              @RequestParam String email,
                              Model model) {

        Tarefa tarefa = new Tarefa(nome, descricao);
        tarefaRepository.save(tarefa);

        subject.criarTarefa(tarefa);

        Verificador verificador = new VerificaDiaUtil();
        verificador.definirProximo(new VerificaHorarioComercial());
        verificador.verificar(tarefa);

        Command comando = new EnviarEmailCommand(mailSender, email, "Nova tarefa: " + tarefa.getNome(), tarefa.getDescricao());
        executorDeTarefas.agendarComando(comando);
        executorDeTarefas.executarTodos();

        executorEstrategico.executar(tarefa);

        model.addAttribute("mensagem", "Tarefa criada com sucesso!");
        return "sucesso";
    }

    @GetMapping("/tarefas")
    public String listarTarefas(Model model) {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        model.addAttribute("tarefas", tarefas);
        return "lista";
    }
}

