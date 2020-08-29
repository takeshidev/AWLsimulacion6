<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simulacion 6 - TK</title>
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
		<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
		<script src="https://kit.fontawesome.com/0a0085a95e.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="contenido">
	<h1 class="text-center">Simulación 6</h1>
	<h2 class="text-center">Con luquitas baila el Monito</h2>
	<h3 class="text-center">Reclutador</h3>
	<h4 class="text-center">Ver Postulaciones</h4>
	
<div class="text-center">

<c:forEach items="${ofertas}" var="o">

<table class="table table-hover">
	<thead class="thead-dark">
	<tr>
		<th colspan="2"><c:out value="${o.getTitulo()}"/></th>
	</tr>
	</thead>
	<tr>
		<td><c:out value="${o.getIdreclutador()}"/></td>
		<td>Publicado el <c:out value="${o.getFecha()}"/></td>
		<td>Salario: $<c:out value="${o.getSalario()}"/></td>
	</tr>
	<tr>
		<td colspan="3"><c:out value="${o.getDescripcion()}"/></td>
	</tr>
</table>
<hr width="50%">

</c:forEach>

</div>




	
</div>
</body>