<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Tranferir</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jtable.css" />
    </head>

    <body>
        <jsp:include page="myNavbar.jsp"></jsp:include>

        <div class="m-5 p-5 rounded bg-white" id="">
        	<form action="altaCliente.html" method="post">
	            <h1 class="d-flex justify-content-center">Tranferir</h1>
	    		<div class="col-6 container d-flex justify-content-center">
	            	<div class="row d-flex justify-content-center">
	            		
	            		<div class="form-group mt-4">
		            		<h4 class="d-flex justify-content-start">Cuenta de Origen:</h4>
		        	        <label class="control-label" for="tipoCuenta">Seleccione cuenta</label>
			           		<select class="form-control" name="cuentas">
								<c:forEach var="cuenta" items="${ Cuentas }">
									<option value="${ cuenta.getId() }">${ cuenta.geCbu() }</option>
								</c:forEach>
							</select>
		            	</div>	
		            
	            		<div class="form-group mt-4">
	            			<h4 class="d-flex justify-content-start">Cuenta de Destino:</h4>
	                    	<label class="control-label" for="txtDestino">Ingrese CBU o número de cuenta</label>
	                        <input class="form-control" id="txtDestino" type="text" placeholder="" value="222222222">
	                    </div>
	                    <div class="form-group mt-4">
	                        <label class="control-label" for="txtImporte">Importe</label>
	                        <input class="form-control" id="txtImporte" type="text" value="10000">
	                    </div>
	                     <div class="form-group mt-4 d-flex justify-content-center">
	                         <button class="btn btn-primary mx-2" type="button" name="back" onclick="history.back()" value="Volver">Volver</button>
	                         <button type="submit" class="btn btn-success mx-2" value="Guardar">Transferir</button>                                
	                     </div>
	    			</div>
	        	</div>
       		</form>
		</div>
        <jsp:include page="myFooter.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath}/resources/Js/DataTableMovimientos.js"></script>
    </body>

    </html>