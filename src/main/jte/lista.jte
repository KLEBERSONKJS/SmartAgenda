@import com.kjs.SmartAgenda.model.Tarefa
@import java.util.List;
@param List<Tarefa> tarefas

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Tarefas</title>
</head>
<body>
<h1>📋 Tarefas Registradas</h1>

<table border="1" cellpadding="8">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
    </tr>
    </thead>
    <tbody>
    @for(Tarefa tarefa : tarefas)
    <tr>
        <td>${tarefa.getId()}</td>
        <td>${tarefa.getNome()}</td>
        <td>${tarefa.getDescricao()}</td>
    </tr>
    @endfor
    </tbody>
</table>

<br>
<a href="/">🔙 Nova Tarefa</a>
</body>
</html>
