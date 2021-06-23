<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <nav class="navbar navbar-expand-lg bg-primary navbar-dark ">
        <a class="navbar-brand me-5 ms-5" href="index.html"><i class="bi bi-bank"></i> BANCO</a>

        <div class="collapse navbar-collapse d-flex" id="navbar">
<%--         		<% if(request.getAttribute("user").equals("cliente")) {	%> --%>
            <ul id="menuCliente" class="navbar-nav ">
                <li class="nav-item mr-2">
                    <a class="nav-link" href="resumen.html">CUENTAS</a>
                </li>
                <li class="nav-item mr-2">
                    <a class="nav-link" href="detalleCliente.html">MIS DATOS</a>
                </li>
                <li class="nav-item mr-2">
                    <a class="nav-link" href="transferencia.html">TRANSFERENCIAS</a>
                </li>
            </ul>
<%--             <% } else {	%> --%>
            <ul id="menuEmpleado" class="navbar-nav">
                <li class="nav-item mr-2">
                    <a class="nav-link" href="listarClientes.html">CLIENTES</a>
                </li>
                <li class="nav-item mr-2">
                    <a class="nav-link" href="listarCuentas.html">CUENTAS</a>
                </li>
            </ul>
<%--             <% } %> --%>
            <form class="form-inline ms-auto me-5" action="login.html">
            	<label class="text-white mx-4">¡Hola ${user}! </label>
                <button class="btn btn-primary my-2 my-sm-0" type="submit">LOGOUT</button>
            </form>
        </div>
    </nav>