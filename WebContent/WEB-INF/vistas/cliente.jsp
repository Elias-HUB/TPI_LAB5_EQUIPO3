<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Clientes</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jtable.css" />
    </head>

    <body>
        <jsp:include page="myNavbar.jsp"></jsp:include>


        <div class="m-5 px-5 rounded bg-white" id="">
            <h1>Clientes</h1>
            <!-- <div class="container pb-3"> -->
            <form action="altaCliente.html" method="get">
            <div class="justify-content-between mt-3">
                <button type="submit" class="btn btn-primary"><i class="bi bi-person-plus"></i> Nuevo Cliente</button>
            </div>
            </form>
            <!-- </div> -->
            <br>
            <table id="example" class="table table-striped table-bordered dt-responsive nowrap pt-1 mt-5"
                cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th style="text-align: center">Nombre y Apellido</th>
                        <th style="text-align: center">Dni</th>
                        <th style="text-align: center">Domicilio</th>
                        <th style="text-align: center">Estado</th>
                        <th style="text-align: center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
				<c:forEach var="Cliente" items="${ Clientes }">
                    <tr id="Cliente-${ Cliente.getId() }">
                        <td>${ Cliente.getNombre() } ${ Cliente.getApellido() }</td>
                        <td>${ Cliente.getDni() }</td>
                        <td>${ Cliente.getDomicilio().getDireccion() }</td>
                        <td>${Cliente.getEstado() == true ? "Activo" : "Inactivo"}</td>                        
                        <td class="text-center" style="width: 190px">
                        	<button type="submit" id="" name="BtnNuevaCuenta" class="btn btn-info" onclick="location.href='altaCuenta.html?dni=${Cliente.getDni()}'">
                                <i class="bi bi-plus-square" data-toggle="tooltip" data-placement="bottom"
                                    title="Agregar cuenta"></i>
                            </button>
                        	<button type="submit" id="" name="BtnCuentas" class="btn btn-info" onclick="location.href='listarCuentasPorCliente.html?dni=${Cliente.getDni()}'">
                                <i class="bi bi-list-stars" data-toggle="tooltip" data-placement="bottom"
                                    title="Ver cuentas"></i>
                            </button>
                            <button type="submit" id="" name="BtnVer" class="btn btn-info" onclick="location.href='detalleCliente.html?dni=${Cliente.getDni()}'">
                                <i class="bi bi-file-person" data-toggle="tooltip" data-placement="bottom"
                                    title="Ver Cliente"></i>
                            </button>
                            <button type="submit" id="" name="BtnModificar" class="btn btn-warning" onclick="location.href='modificarCliente.html?dni=${Cliente.getDni()}'">
                                <i class="bi bi-pencil-square" data-toggle="tooltip" data-placement="bottom"
                                    title="Modificar Cliente"></i>
                            </button>
                            <button type="button" onClick="modalEliminar(${Cliente.getDni()})" name="BtnEliminar"
                                class="btn btn-danger">
                                <i class="bi bi-x-circle" data-toggle="tooltip" data-placement="bottom"
                                    title="Eliminar Cliente"></i>
                            </button>
                        </td>
                    </tr>                   
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <jsp:include page="myFooter.jsp"></jsp:include>
        <script	src="${pageContext.request.contextPath}/resources/Js/Funciones.js"></script>
        <script src="${pageContext.request.contextPath}/resources/Js/dataTableClientes.js"></script>
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

            function modalEliminar(DNI) {
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
                    title: "¿Desea dar de baja este Cliente?",
                    showCancelButton: true,
                    confirmButtonColor: "#c82333",
                    cancelButtonText: "Cancelar",
                    confirmButtonText: "Dar de baja",
                    reverseButtons: true
                }).then((result) => {
                    if (result.value) {
                    	location.replace('eliminarCliente.html?dni='+DNI);
                    }
                })
            }
        </script>
    </body>

    </html>