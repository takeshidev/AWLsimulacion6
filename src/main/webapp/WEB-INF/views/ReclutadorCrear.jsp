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
	<h3 class="text-center">Reclutadores</h3>
	<h4 class="text-center">Registrar Reclutador</h4>
<div class="text-center">
<form action="ReclutadorCrear" method="post">
<table class="table">
	<tr>
		<td>Titulo: <br>
		<input type="text" name="titulo"> </td>
	</tr>
	<tr>
		<td>Razon Social: <br>
		<input type="text" name="razonsocial"> </td>
	</tr>
	<tr>
		<td>Rut: <br>
		<input type="text" name="rut"> </td>
	</tr>
	<tr>
		<td>Email: <br>
		<input type="email" name="email"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="Agregar" class="btn btn-danger"/></td>
	</tr>
	
</table>
</form>

</div>




	
</div>
</body>