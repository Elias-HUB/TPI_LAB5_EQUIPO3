<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Modificar Cuenta</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jtable.css" />
    </head>

    <body>
        <jsp:include page="myNavbar.jsp"></jsp:include>

        <div class="m-5 p-5 rounded bg-white" id="">
            <h1 class="d-flex justify-content-center">Modificar Cuenta</h1>
    		<div class="col-6 container d-flex justify-content-center">
            	<div class="row d-flex justify-content-center">
                    <div class="form-group mt-4">
                        <label class="control-label" for="tipoCuenta">Tipo de cuenta </label>
				  	<div class="form-control border-0 btn-group" role="group" aria-label="seleccionar tipo de cuenta">
						<input type="radio" class="btn-check" checked name="btnCaja" id="btnCajaPeso" autocomplete="off">
						<label class="btn btn-outline-primary" for="btnCajaPeso">Caja de ahorro en pesos</label>
						
						<input type="radio" class="btn-check" name="btnCaja" id="btnCajaDolar" autocomplete="off">
						<label class="btn btn-outline-primary" for="btnCajaDolar">Caja de ahorro en d�lares</label>
                     </div>
                     </div>
            		<div class="form-group mt-4">
            			<h1 class="d-flex justify-content-start">Datos del cliente</h1>
            		</div>
            		<div class="form-group mt-4">
                    	<label class="control-label" for="txtNombre">Nombre </label>
                        <input class="form-control" id="txtNombre" type="text" placeholder="" value="Nicol�s Iv�n Ram�rez" disabled="disabled">
                    </div>
                    <div class="form-group mt-4">
                        <label class="control-label" for="txtDni">DNI</label>
                        <input class="form-control" id="txtDni" type="text" value="123456789" disabled="disabled">
                    </div>
                    <div class="form-group mt-4">
                        <label class="control-label" for="cliente.sexo">Sexo </label>
				  	<div class="form-control border-0 btn-group" role="group" aria-label="seleccionar sexo">
						<input type="radio" class="btn-check" name="btnradio" id="btnSexo" autocomplete="off" disabled="disabled">
						<label class="btn btn-outline-primary" for="btnFemenino">Femenino</label>
						
						<input readonly type="radio" class="btn-check" checked name="btnSexo" id="btnMasculino" autocomplete="off" disabled="disabled">
						<label class="btn btn-outline-primary" for="btnMasculino">Masculino</label>
                     </div>
                     </div>
                     <div class="form-group mt-4">
                         <label class="control-label" for="txtNacionalidad">Nacionalidad</label>
                         <input class="form-control" id="txtNacionalidad" type="text" value="Argentino" disabled="disabled">
                     </div>
                     <div class="form-group mt-4">
                         <label class="control-label" for="txtCalle">Calle</label>
                         <input class="form-control" id="txtCalle" type="text" value="Calle Falsa" disabled="disabled">
                     </div>
                     <div class="form-group mt-4">
                         <label class="control-label" for="txtNumeroPuerta">N�mero de Puerta</label>
                         <input class="form-control" id="txtNumeroPuerta" type="text" value="123" disabled="disabled">
                     </div>
                     <div class="form-group mt-4">
                         <label class="control-label" for="txtCodigoPostal">C�digo Postal</label>
                         <input class="form-control" id="txtCodigoPostal" type="text" value="9999" disabled="disabled">                                
                     </div>
                     <div class="form-group mt-4 d-flex justify-content-center">
                         <button class="btn btn-primary mx-2" value="Volver">Volver</button>
                         <button class="btn btn-success mx-2" value="Guardar">Guardar</button>                                
                     </div>
    			</div>
        	</div>
		</div>
        <jsp:include page="myFooter.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath}/resources/Js/DataTableMovimientos.js"></script>
    </body>

    </html>