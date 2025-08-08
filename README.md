# SmartAgenda
 Aplicação de Padrões de Projeto com Ênfase em Padrões Comportamentais
# SmartAgenda

Projeto Java Spring Boot que demonstra a aplicação prática de **padrões de projeto comportamentais**, com foco em modularidade, desacoplamento e reutilização de código.

##  Objetivo

O sistema simula uma agenda inteligente que permite o cadastro de tarefas, notificações automáticas e execução de ações programadas.

---

##  Padrões de Projeto Aplicados

### Observer
- **Classe principal:** `TarefaSubject`
- **Observadores:** `LoggerObserver`
- **Uso:** Notificação automática quando uma tarefa é criada.

###  Command
- **Interface:** `Command`
- **Implementação:** `EnviarEmailCommand`
- **Uso:** Cada ação (ex: envio de e-mail) é encapsulada como comando reutilizável e executável.

###  Strategy
- **Interface:** `EstrategiaExecucao`
- **Implementações:** `ExecucaoImediata`, `ExecucaoComConfirmacao`
- **Uso:** Define a forma como uma tarefa será executada.

###  Chain of Responsibility
- **Classe abstrata:** `Verificador`
- **Implementações:** `VerificaDiaUtil`, `VerificaHorarioComercial`
- **Uso:** Permite encadear verificações condicionais antes da execução da tarefa.

---

##  Tecnologias Utilizadas

- Java 21
- Spring Boot
- JTE (Java Template Engine)
- Spring Data JPA
- Banco de dados em memória H2
- Spring Mail (para simular envio de e-mails)

---

## Endpoints

- Cadastrar Tarefa raiz ("/")
- Listar Tarefas ("/tarefas")
##  Como Executar

```bash
    mvn clean install -DskipTests spring-boot:run

