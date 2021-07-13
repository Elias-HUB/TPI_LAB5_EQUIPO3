<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Cuenta</title>
<jsp:include page="estilos.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/estilo.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/jtable.css" />
</head>

<body>
	<jsp:include page="myNavbar.jsp"></jsp:include>
	<form action="altaCuenta.html" method="post">
		<div class="d-flex justify-content-center" id="">
			<div class="card m-5 p-5 col-6 rounded shadow p-3">
				<h1 class="d-flex justify-content-center">Nueva Cuenta</h1>
				<div class="row">
					<div class="form-group mt-4">
						<label class="control-label" for="txtNombre">Nombre </label> 
						<input class="form-control" name="txtNombre" id="txtNombre" type="text" value="${Cliente.getNombre()} ${Cliente.getApellido()}" readonly>
					</div>
					<div class="form-group mt-4">
						<label class="control-label" for="txtDni">DNI</label>
						<input class="form-control" name="txtDni" id="txtDni" type="number" value="${Cliente.getDni()}" readonly>
					</div>
					
					<div class="form-group mt-4">
						<label class="control-label" for="tipoCuenta">Tipo de cuenta </label>
						<div class="form-control border-0 btn-group" role="group" aria-label="seleccionar tipo de cuenta">
							<input type="radio" class="btn-check" name="btnradio" id="btnCajaPeso" value="Cuenta CA" autocomplete="off">
							<label class="btn btn-outline-primary" for="btnCajaPeso">Caja de ahorro en pesos</label>
							
							<input type="radio" class="btn-check" checked name="btnradio" id="btnCajaDolar" value="Cuenta CD" autocomplete="off">
							<label class="btn btn-outline-primary" for="btnCajaDolar">Caja de ahorro en dólares</label>
						</div>
					</div>

				</div>

						<div class="form-group mt-4 d-flex justify-content-center">
							<button type="button" class="btn btn-primary mx-2" value="Volver" onclick="location.href='listarClientes.html'">Volver</button>
							<button type="submit" id="BtnAgregar" name="BtnAgregar" class="btn btn-success mx-2" value="Guardar">Guardar</button>
						</div>
					</div>
				</div>
	</form>
	<jsp:include page="myFooter.jsp"></jsp:include>
</body>

</html>