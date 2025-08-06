

<!DOCTYPE html>
<html>
<head>
    <title>Nova Tarefa</title>
</head>
<body>
<h1>Nova Tarefa</h1>
<form method="post" action="/nova-tarefa">
    <label>Nome:</label><br>
    <input type="text" name="nome"><br><br>

    <label>Descrição:</label><br>
    <textarea name="descricao"></textarea><br><br>

    <label>E-mail para notificação:</label><br>
    <input type="email" name="email"><br><br>

    <button type="submit">Criar Tarefa</button>
</form>
</body>
</html>
