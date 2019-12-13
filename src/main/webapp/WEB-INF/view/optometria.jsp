<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<h3>Optometrias del paciente ${paciente.nombre}</h3>
			</div>


		</div>
		<sec:authorize access="hasAnyRole('GERENTE','ADMIN')">
			<a href="gerente/addoptometria" class="btn btn-primary mb-1 mr-2">Añadir
				optometria</a>
		</sec:authorize>
		<a href="${pageContext.request.contextPath}/"
			class="btn btn-primary mb-1">Volver a pacientes</a>
		<table class="table table-striped">
			<tr>
				<th>Idoptometria</th>
				<th>Fecha</th>
				<th>OD Eje</th>
				<th>OD Cilindro</th>
				<th>OD Esfera</th>
				<th>OI Eje</th>
				<th>OI Cilindro</th>
				<th>OI Esfera</th>
				<sec:authorize access="hasAnyRole('GERENTE','ADMIN')">
					<th>Acciones</th>
				</sec:authorize>
			</tr>

			<c:forEach var="optometria" items="${optometria}">
				<c:url var="linkEditar" value="/gerente/updateoptometria">
					<c:param name="idoptometria" value="${optometria.idoptometria }" />
				</c:url>
				<c:url var="linkBorrar" value="/admin/deleteoptometria">
					<c:param name="idoptometria" value="${optometria.idoptometria }" />
				</c:url>
				<tr>
					<td>${optometria.idoptometria }</td>
					<td>${optometria.fecha }</td>
					<td>${optometria.odeje }</td>
					<td>${optometria.odcilindro }</td>
					<td>${optometria.odesfera }</td>
					<td>${optometria.oieje }</td>
					<td>${optometria.oicilindro }</td>
					<td>${optometria.oiesfera }</td>

					<sec:authorize access="hasAnyRole('GERENTE','ADMIN')">
						<td><sec:authorize access="hasAnyRole('GERENTE','ADMIN')">
								<a href="${linkEditar }" class="btn btn-outline-success btn-sm">Editar</a>
							</sec:authorize> <sec:authorize access="hasRole('ADMIN')">
								<a href="${linkBorrar }"
									onclick="if(!confirm('¿Está seguro?')) return false"
									class="btn btn-outline-danger btn-sm">Borrar</a>
							</sec:authorize></td>
					</sec:authorize>

				</tr>
			</c:forEach>
		</table>
	</div>



</body>
</html>