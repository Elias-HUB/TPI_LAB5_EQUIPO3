<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalle Cliente</title>
<jsp:include page="estilos.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/estilo.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/jtable.css" />
</head>

<body>
	<jsp:include page="myNavbar.jsp"></jsp:include>

	<div class="d-flex justify-content-center" id="">
		<div class="card m-5 p-5 col-6 rounded shadow p-3">
			<h1 class="d-flex justify-content-center">Detalle Cliente</h1>
			<div class="row">
				<div class="form-group mt-4">
					<label class="control-label" for="txtNombre">Nombre </label> <input
						readonly class="form-control" id="txtNombre" type="text"
						placeholder="" value="${ Cliente.getNombre() }">
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtDni">DNI</label>
					<input readonly class="form-control" id="txtDni" type="text" value="${ Cliente.getDni() }">
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="cliente.sexo">Sexo </label>					
					<c:choose>
    					<c:when test="${Cliente.getSexo().equals('M')}">
    						<input readonly class="form-control" id="txtNombre" type="text"	value="Masculino">
						</c:when>
						<c:otherwise>
							<input readonly class="form-control" id="txtNombre" type="text"	value="Femenino">
						</c:otherwise> 
					</c:choose>				
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtNacionalidad">Nacionalidad</label>
					<input readonly class="form-control" id="txtNacionalidad" type="text" value="${ Cliente.getNacionalidad() }">
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtCalle">Calle</label>
					<input readonly class="form-control" id="txtCalle" type="text" value="${ Cliente.getDomicilio().getDireccion() }">
				</div>
				<div class="form-group mt-4 d-flex justify-content-center">
					<button class="btn btn-primary mx-2" value="Volver" onclick="location.href='listarClientes.html'">Volver</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="myFooter.jsp"></jsp:include>
	<script
		src="${pageContext.request.contextPath}/resources/Js/DataTableMovimientos.js"></script>
</body>

</html>