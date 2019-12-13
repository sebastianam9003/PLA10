<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Optometria</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<div class="float-right">
				Usuario:
				<sec:authentication property="principal.username" />
				<form:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					<button type="submit" class="btn btn-warning">Salir</button>
				</form:form>
			</div>
			<div>
				<h1>Paciente</h1>
				<h3>Añadir optometria</h3>
			</div>
		</div>

		<form:form action="saveoptometria" modelAttribute="optometria" method="post">
			<form:hidden path="idoptometria" />
			<div class="form-group">
				<label for="nombre">Fecha:</label>
				<form:input path="fecha" class="form-control" />
			</div>

			<div class="form-group">
				<label for="nombre">OD Eje:</label>
				<form:input path="odeje" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="nombre">OD Cilindro:</label>
				<form:input path="odcilindro" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="nombre">OD Esfera:</label>
				<form:input path="odesfera" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="nombre">OI Eje:</label>
				<form:input path="oieje" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="nombre">OI Cilindro:</label>
				<form:input path="oicilindro" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="nombre">OI Esfera:</label>
				<form:input path="oiesfera" class="form-control" />
			</div>
			

			<div class="form-group">
				<label for="nombre">Paciente:</label>
				<form:select class="form-control" path="paciente.idpaciente">
					<option value="0">--Selecciona--</option>
					<form:options items="${pacientes}" itemValue="idpaciente"
						itemLabel="name" />
				</form:select>
			</div>
			<input type="submit" value="Guardar" class="btn btn-success" />
			<a href="${pageContext.request.contextPath}/"
				class="btn btn-outline-primary float-right"> Volver a lista de
				pacientes</a>
		</form:form>
	</div>
</body>
</html>