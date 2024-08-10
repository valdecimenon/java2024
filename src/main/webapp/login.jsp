<%@ page language="java" contentType="text;html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// evita que a tela de login seja aberta pelo usuário, quando já logado
	if (session.getAttribute("login") != null){
		response.sendRedirect("index.jsp");
	}

%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

    <div class="container col-3">

        <h3 class="mt-3">Login</h3>
        <form action="index.jsp" method="post">

	        <div class="form-group mt-3">
	            <label>Nome</label>
	            <input type="text" name="nome" class="form-control">
	        </div>
	
	        <div class="form-group mt-3">
	            <label>Senha</label>
	            <input type="password" name="senha" class="form-control">
	        </div>
	
	        <button type="submit" class="btn btn-primary mt-4">Login</button>
        </form>
    </div>

</body>
</html>