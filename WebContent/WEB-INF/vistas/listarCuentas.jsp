<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cuentas</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jtable.css" />
    </head>

    <body>
        <jsp:include page="myNavbar.jsp"></jsp:include>


        <div class="m-5 p-5 rounded bg-white" id="">
            <h1>Cuentas</h1>
            <br>
            <table id="example" class="table table-striped table-bordered dt-responsive nowrap pt-1 mt-5"
                cellspacing="0" width="100%">
                <thead>
                    <tr>            	
                        <th style="text-align: center">CBU</th>
                        <th style="text-align: center">Nro Cuenta</th>
                        <th style="text-align: center">Nombre</th>
                        <th style="text-align: center">Tipo de Cuenta</th>
                        <th style="text-align: center">Saldo</th>
                        <th style="text-align: center">Estado</th>
                        <th style="text-align: center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="Cuenta" items="${ Cuenta }">
                	<tr id="Cuenta-${ Cuenta.getId() }">
                		<td>${ Cuenta.getCbu() }</td>
                		<td>${ Cuenta.getNroCuenta() }</td>
                		<td>${ Cuenta.getNombre() }</td>
                		<td>${ Cuenta.getTipoCuenta().getDescripcion() }</td>                		
                		<td>${ Cuenta.getSaldo() }</td>
                		<td>${ Cuenta.getEstado() == true ? "Activo" : "Inactivo"}</td>

                        <td class="text-center" style="width: 190px">
<%--                             <button type="submit" id="" name="BtnModificar" class="btn btn-warning" onclick="location.href='modificarCuenta.html?dni=${Cuenta.getCbu()}'"> --%>
<!--                                 <i class="bi bi-pencil-square" data-toggle="tooltip" data-placement="bottom" -->
<!--                                     title="Modificar Cuenta"></i> -->
<!--                             </button> -->
                            <button type="button" id="" onClick="modalEliminar(${Cuenta.getCbu()})" name="BtnEliminar" class="btn btn-danger">
                                <i class="bi bi-x-circle" data-toggle="tooltip" data-placement="bottom" title="Eliminar Cuenta"></i>
                            </button>
                        </td>
                	</tr>
                </c:forEach>
                </tbody>
            </table>
        </div>


        <jsp:include page="myFooter.jsp"></jsp:include>
        <script	src="${pageContext.request.contextPath}/resources/Js/Funciones.js"></script>
        <script src="${pageContext.request.contextPath}/resources/Js/dataTableCuentas.js"></script>
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
        
            function modalEliminar(CBU) {
            	debugger;
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top',
                    showConfirmButton: false,
                    timer: 6000,
                    timerProgressBar: true,
                    onOpen: (toast) => {
                        toast.addEventListener('mouseenter', Swal.stopTimer)
                        toast.addEventListener('mouseleave', Swal.resumeTimer)
                    }
                });
                Swal.fire({
                    icon: 'warning',
                    title: "¿Desea dar de baja esta Cuenta?",
                    showCancelButton: true,
                    confirmButtonColor: "#c82333",
                    cancelButtonText: "Cancelar",
                    confirmButtonText: "Dar de baja",
                    reverseButtons: true
                }).then((result) => {
                    if (result.value) {
                    	location.replace('eliminarCuenta.html?cbu='+CBU);
                    }
                })
            }
        </script>
    </body>

    </html>