<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<%@page import="com.softgraf.entity.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="com.softgraf.repository.AlunoRepository"%>
<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>


<%
	AlunoRepository alunoRepository = new AlunoRepository();
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consulta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

    <div class="table-responsive text-center">



        <h3 class="mt-3">Lista de Alunos</h3>

        <table class="table table-striped table-bordered table-hover align-middle mt-3">
            <thead class="table-primary">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Curso</th>
                    <th>E-mail</th>
                    <th>Data</th>
                    <th>Ação</th>
                </tr>
            </thead>

            <tbody>
				<c:forEach var="aluno" items="${alunoRepository.todos}">
				
	                <tr>
	                    <td>${aluno.id}</td>
	                    <td>${aluno.nome}</td>
	                    <td>${aluno.curso}</td>
	                    
	                    
	                    
	                    <td>
	                    	<c:if test="${not empty aluno.email}">
	                    		<a href="mailto:${aluno.email}">${aluno.email}</a>
	                    	</c:if>
	                    	
	                    	<c:if test="${empty aluno.email}">
	                    		E-mail não informado
	                    	</c:if>
	                    </td>
	                    
	                    
	                    
	                    <td>
	                    	<c:choose>
	                    		<c:when test="${not empty aluno.data}">
	                    			<fmt:parseDate value="${aluno.data}" pattern="yyyy-MM-dd" var="alunoData" type="date"/>
	                    			<fmt:formatDate value="${alunoData}" pattern="dd/MM/yyyy"/>
	                    		</c:when>
	                    	</c:choose>
	                    </td>
	                    
	                    <td>
	                        <a href="excluir?id=${aluno.id}" class="btn btn-warning">Excluir</a>
	                    </td>
	                </tr>

				</c:forEach>
            </tbody>
        </table>
        

        <a href="cadastra.jsp" class="btn btn-primary">Cadastrar</a>
        <a href="excel" class="btn btn-secondary mx-5">Download .xlsx</a>
        
    </div>

</body>
</html>