<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="frgp.tusi.lab5.model.Usuario"%>
<%@ page import="frgp.tusi.lab5.model.Cliente"%>
<%@ page import="frgp.tusi.lab5.model.Empleado"%>
        		
    <nav class="navbar navbar-expand-lg bg-primary navbar-dark ">
    <h2 class="navbar-brand me-5 ms-5"><i class="bi bi-bank"></i> Banco</h2>
        <div class="collapse navbar-collapse d-flex" id="navbar">
        <% 
				session = request.getSession();
        		Usuario user = (Usuario)session.getAttribute("user");
        		String userNombre = "";
        		if(user.getTipoUsuario().equals("cliente")) {
        		Cliente cliente = (Cliente)session.getAttribute("persona");
        		userNombre = cliente.getNombre() + " " + cliente.getApellido();
        		String dni = cliente.getDni().toString();
        			%>
            <ul id="menuCliente" class="navbar-nav ">
                <li class="nav-item mr-2">
                    <a class="nav-link" href="resumen.html?Val=1">CUENTAS</a>
                </li>
                <li class="nav-item mr-2">
                    <a class="nav-link" href="detalleCliente.html">MIS DATOS</a>
                </li>
                <li class="nav-item mr-2">
                    <a class="nav-link" href="transferencia.html?dni=<%= dni%>">TRANSFERENCIAS</a>
                </li>
            </ul>
            <% } else {	
            	Empleado empleado = (Empleado)session.getAttribute("persona");
            	userNombre = empleado.getNombre() + " " + empleado.getApellido();
            %>
            <ul id="menuEmpleado" class="navbar-nav">
                <li class="nav-item mr-2">
                    <a class="nav-link" href="listarClientes.html">CLIENTES</a>
                </li>
                <li class="nav-item mr-2">
                    <a class="nav-link" href="listarCuentas.html">CUENTAS</a>
                </li>
            </ul>
            <% } %>
            <form class="form-inline ms-auto me-5" action="CerrarSession.html">
            	<label class="text-white mx-4">¡Hola <%=userNombre%>! </label>
                <button class="btn btn-primary my-2 my-sm-0" type="submit">LOGOUT</button>
            </form>
        </div>
    </nav>