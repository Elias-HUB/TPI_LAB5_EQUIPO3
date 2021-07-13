<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Cliente</title>
<jsp:include page="estilos.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/estilo.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/jtable.css" />
</head>

<body>
	<jsp:include page="myNavbar.jsp"></jsp:include>
	
<form action="modificarCliente.html?dni=${Cliente.getDni()}" method="post">
	<div class="d-flex justify-content-center" id="">
		<div class="card m-5 p-5 col-6 rounded shadow p-3">
			<h1 class="d-flex justify-content-center">Modificar Cliente</h1>
			<div class="row">
				<div class="form-group mt-4">
					<label class="control-label" for="txtNombre">Nombre </label> 
					<input class="form-control" name="txtNombre" id="txtNombre" type="text" value="${ Cliente.getNombre() }" required>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtApellido">Apellido </label> 
					<input class="form-control" name="txtApellido" id="txtApellido" type="text" value="${ Cliente.getApellido() }" required>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="tboxEstado">Estado</label>
					<select id="tboxEstado" name="tboxEstado" class="form-control">
					<c:choose>
    					<c:when test="${Cliente.getEstado() == true}">							
						<option value="false">Inactivo</option>
						<option value="true" selected="">Activo</option>					
						</c:when>
						<c:otherwise>
							<option value="false"selected="">Inactivo</option>
							<option value="true" >Activo</option>
						</c:otherwise> 
					</c:choose>
					</select>					
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtDni">DNI</label>
					<input class="form-control" name="txtDni" id="txtDni" pattern="[0-9]{1,9}" value="${ Cliente.getDni() }" required>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtDni">Fecha de Nacimiento</label>
					<input type="date" ID="TboxFecha" name="TboxFecha" max="3000-12-31" min="1900-01-01" value="${ Cliente.getFechaNacimiento() }" onblur="return calcularEdad(this.value);" class="form-control">
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="cliente.sexo">Sexo </label>					
					<div class="form-control border-0 btn-group" role="group" aria-label="seleccionar sexo">
					<c:choose>
    					<c:when test="${Cliente.getSexo().equals('M')}">
							<input type="radio" class="btn-check" name="btnradio" id="btnFemenino" autocomplete="off">
							<label class="btn btn-outline-primary" for="btnFemenino">Femenino</label>
							<input readonly type="radio" class="btn-check" checked name="btnradio" id="btnMasculino" autocomplete="off">
							<label class="btn btn-outline-primary" for="btnMasculino">Masculino</label>
						</c:when>
						<c:otherwise>
							<input type="radio" class="btn-check" checked name="btnradio"id="btnFemenino" autocomplete="off">
							<label class="btn btn-outline-primary" for="btnFemenino">Femenino</label>
							<input readonly type="radio" class="btn-check" name="btnradio" id="btnMasculino" autocomplete="off">
							<label class="btn btn-outline-primary" for="btnMasculino">Masculino</label>
						</c:otherwise> 
					</c:choose>
					</div>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtCalle">Calle</label> 
					<input class="form-control" name="txtCalle"  id="txtCalle" type="text" value="${ Cliente.getDomicilio().getDireccion() }" required>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtLocalidad">Localidad</label> 
					<input class="form-control" name="txtLocalidad"  id="txtLocalidad" type="text" value="${ Cliente.getDomicilio().getLocalidad() }" required>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtProvincia">Provincia</label> 
					<select id="txtProvincia" name="txtProvincia"
						class="form-select">
						<c:forEach var="Provincia" items="${ Provincias }">
							<c:choose>
    							<c:when test="${Provincia.getId().equals(Cliente.getProvincia().getId())}">
    								<option value="${ Provincia.getId() }" selected>${ Provincia.getNombre() }</option>
    							</c:when>
								<c:otherwise>
									<option value="${ Provincia.getId() }">${ Provincia.getNombre() }</option>
								</c:otherwise> 
							</c:choose>    					
    					</c:forEach>
					</select>
				</div>
				<div class="form-group mt-4">
					<label class="control-label" for="txtNacionalidad">Nacionalidad</label>
					<select id="TboxNacionalidad" name="TboxNacionalidad"
						class="form-select">
						<c:forEach var="Nacion" items="${ Nacionalidades }">
							<c:choose>
    							<c:when test="${Nacion.getId().equals(Cliente.getNacionalidad().getId())}">
    								<option value="${ Nacion.getId() }" selected>${ Nacion.getNombre() }</option>
    							</c:when>
								<c:otherwise>
									<option value="${ Nacion.getId() }">${ Nacion.getNombre() }</option>
								</c:otherwise>
							</c:choose>
    					</c:forEach>
    				</select>
				</div>
				<div class="form-group mt-4 d-flex justify-content-center">
					<button type="button" class="btn btn-primary mx-2" value="Volver" onclick="location.href='listarClientes.html'">Volver</button>
					<button type="submit" id="BtnAgregar" name="BtnAgregar" class="btn btn-success mx-2" value="Guardar">Guardar</button>
				</div>
			</div>
		</div>
	</div>
</form>
	<jsp:include page="myFooter.jsp"></jsp:include>
		<script	src="${pageContext.request.contextPath}/resources/Js/Funciones.js"></script>
	<script type="text/javascript">
	function calcularEdad(fecha_nacimiento) {
        console.log(fecha_nacimiento);
        var hoy = new Date();
        var cumpleanos = new Date(fecha_nacimiento);
        var edad = hoy.getFullYear() - cumpleanos.getFullYear();
        var m = hoy.getMonth() - cumpleanos.getMonth();
        if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
            edad--;
        }
        if (edad >= 18) {
            return true;
        } else {
            mostrarToast("Solo se permiten personas mayor a 18 años.", 'error');
            document.getElementById("TboxFecha").value = null;
            return false;
        }
    }
	</script>
</body>

</html>