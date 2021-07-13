<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="frgp.tusi.lab5.model.Usuario"%>
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
					<label class="control-label" for="txtApellido">Apellido </label> 
					<input class="form-control" name="txtApellido" id="txtApellido" type="text" value="${ Cliente.getApellido() }" readonly>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtDni">DNI</label>
					<input readonly class="form-control" id="txtDni" type="text" value="${ Cliente.getDni() }" readonly>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtDni">Fecha de Nacimiento</label>
					<input type="date" ID="TboxFecha" name="TboxFecha" max="3000-12-31" min="1900-01-01" value="${ Cliente.getFechaNacimiento() }" class="form-control" readonly>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="cliente.sexo">Sexo </label>					
					<div class="form-control border-0 btn-group" role="group" aria-label="seleccionar sexo">
					<c:choose>
    					<c:when test="${Cliente.getSexo().equals('M')}">
    						<input readonly class="form-control" id="txtNombre" type="text"	value="Masculino">
						</c:when>
						<c:otherwise>
							<input readonly class="form-control" id="txtNombre" type="text"	value="Femenino">
						</c:otherwise> 
					</c:choose>
					</div>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtNacionalidad">Nacionalidad</label>
					<input readonly class="form-control" id="txtNacionalidad" type="text" value="${ Cliente.getNacionalidad().getNombre() }" readonly>
				</div>
				<h4 class="d-flex mt-5 justify-content-left">Domicilio</h4>
				<div class="form-group mt-4">
					<label class="control-label" for="txtCalle">Calle y Número</label> 
					<input class="form-control" name="txtCalle"  id="txtCalle" type="text" value="${ Cliente.getDomicilio().getDireccion() }" readonly>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtLocalidad">Localidad</label> 
					<input class="form-control" name="txtLocalidad"  id="txtLocalidad" type="text" value="${ Cliente.getDomicilio().getLocalidad() }" readonly>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtProvincia">Provincia</label> 
					<input class="form-control" name="txtProvincia"  id="txtProvincia" type="text" value="${ Cliente.getProvincia().getNombre() }" readonly>
				</div>

				<div class="form-group mt-4 d-flex justify-content-center">
				<% 	
					session = request.getSession();
	        		Usuario user = (Usuario)session.getAttribute("user");
	        		if(user.getTipoUsuario().equals("cliente")) {
	        			%>
						<button class="btn btn-primary mx-2" value="Volver" onclick="location.href='resumen.html?Val=1'">Volver</button>
						<% 
	        		} else {	
	        			%>
						<button class="btn btn-primary mx-2" value="Volver" onclick="location.href='listarClientes.html'">Volver</button>
						<% 
	        		}
	        		%>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="myFooter.jsp"></jsp:include>
</body>

</html>