<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Movimientos</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jtable.css" />
    </head>

    <body>
        <jsp:include page="myNavbar.jsp"></jsp:include>


        <div class="m-5 p-5 rounded bg-white" id="">
            <!-- <div class="container pb-3"> -->
            <div class="card rounded shadow p-4">
            
            <h2 class="my-3">Cuenta</h2>
            <div class="row d-flex justify-content-center">
                <div class="form-group col-md-1">
                    <label class="control-label">Cuenta</label>
                    <form action="resumen.html?Val=2" method="post">
	                    <select id="selectCuenta" name="selectCuenta" class="form-select">
							<c:forEach var="LCuenta" items="${ Cuentas }">
								<c:choose>
	    							<c:when test="${LCuenta.getCbu().equals(Cuenta.getCbu())}">
	    								<option value="${ LCuenta.getCbu() }" selected>${ LCuenta.getNroCuenta() }</option>
	    							</c:when>
									<c:otherwise>
										<option value="${ LCuenta.getCbu() }">${ LCuenta.getNroCuenta() }</option>
									</c:otherwise>
								</c:choose>
								
							</c:forEach>
	                    </select>
                    	<button type="submit" id="BtnConsultar" name="BtnConsultar" class="btn btn-success m-2" value="Consultar">Consultar</button>
                    </form>
                </div>

                <div class="form-group col-md-3">
                    <label Class="control-label">CBU</label>
                    <input id="TboxCBUCuenta" name="TboxCBUCuenta" Class="form-control" value="${ Cuenta.getCbu() }"
                        readonly>
                </div>

                <div class="form-group col-md-3">
                    <label Class="control-label">Nombre</label>
                    <input id="TboxNombreCuenta" name="TboxNombreCuenta" Class="form-control" value="${ Cliente.getNombre() } ${ Cliente.getApellido() }"
                        readonly>
                </div>

                <div class="form-group col-md-2">
                    <label Class="control-label">Tipo de cuenta</label>
                    <input id="TboxTipoCuenta" name="TboxTipoCuenta" Class="form-control"
                        value="${ Cuenta.getTipoCuenta().getDescripcion() }" readonly>
                </div>

                <div class="form-group col-md-2">
                    <label Class="control-label">Saldo</label>
                    <input id="TboxSaldoCuenta" name="TboxSaldoCuenta" Class="form-control" value="${ Cuenta.getSaldo() }" readonly>
                </div>

                <div class="form-group col-md-1">
                    <label Class="control-label">Estado</label>
                    <input id="TboxEstadoCuenta" name="TboxEstadoCuenta" Class="form-control" value="${ Cuenta.getEstado() }" readonly>
                </div>
            </div>
            </div>
            <!-- </div> -->
            <br>
            <div class="card rounded shadow p-4">
            
            <h2 class="my-3">Movimientos</h2>
            <table id="example" class="table table-striped table-bordered dt-responsive nowrap pt-1 "
                cellspacing="0" width="100%" style="font-size: small;">
                <thead>
                    <tr>
                        <th style="text-align: center">Tipo Movimiento</th>
                        <th style="text-align: center">Detalle</th>
                        <th style="text-align: center">Importe</th>
                        <th style="text-align: center">Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="Movimiento" items="${ Movimientos }">
                    <tr>
                		<td>${ Movimiento.getTipoMovimiento().getDescripcion() }</td>
                		<td>${ Movimiento.getDetalle() }</td>
                		<td>$ ${ Movimiento.getImporte() }</td>
                		<td>${ Movimiento.getEstado() == true ? "Activo" : "Inactivo"}</td>
                	</tr>
                </c:forEach>                    
                </tbody>
            </table>
        </div>
        </div>


        <jsp:include page="myFooter.jsp"></jsp:include>
                <script src="${pageContext.request.contextPath}/resources/Js/DataTableMovimientos.js"></script>
        <script	src="${pageContext.request.contextPath}/resources/Js/Funciones.js"></script>
        <script type="text/javascript">        
    	<%
    	 session = request.getSession();
   		 if(session.getAttribute("success") != null) { 	 	
 		String success = session.getAttribute("success").toString();
 		session.setAttribute("success",null);
 		%>mostrarToast("<%=success%>", 'success');<%    		
 	  }
 	 
 	 if(session.getAttribute("error") != null) {  	 	
  		String error = session.getAttribute("error").toString();
  		session.setAttribute("error",null);
  		%>mostrarToast("<%=error%>", 'error');<%    		
  	  }
    	%>

        </script>
    </body>

    </html>