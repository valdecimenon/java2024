<!-- JSP = Java Server Pages -->

<%@ page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charSet=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastra</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

    <div class="container col-3">

        <h3 class="mt-3">Cadastra aluno</h3>

        <form action="salvar" method="POST">

            <div class="form-group mt-3">
                <label>Nome</label>
                <input type="text" class="form-control" name="nome" required>
            </div>

            <div class="form-group mt-3">
                <label>Curso</label>
                <select name="curso" class="form-select">
                    <option value="java" selected>Java</option>
                    <option value="javavascript">Javascript</option>
                    <option value="python">Python</option>
                </select>
            </div>

            <div class="form-group mt-3">
                <label>E-mail</label>
                <input type="email" name="email" class="form-control">
            </div>

            <div class="form-group mt-3">
                <label>Data</label>
                <input type="date" name="data" value="<%= LocalDate.now() %>"  class="form-control">
            </div>

            <button type="submit" class="btn btn-primary mt-4">Salvar</button>
            <a href="" class="btn btn-primary mt-4">Consultar</a>

        </form>

    </div>
    
</body>
</html>