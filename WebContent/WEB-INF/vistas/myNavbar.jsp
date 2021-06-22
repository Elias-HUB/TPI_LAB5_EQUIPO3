<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <nav class="navbar navbar-expand-lg bg-primary navbar-dark ">
        <a class="navbar-brand me-5 ms-5" href="index.html"><i class="bi bi-bank"></i> BANCO</a>

        <div class="collapse navbar-collapse d-flex" id="navbar">
            <ul id="menuCliente" class="navbar-nav ">
                <li class="nav-item mr-2">
                    <a class="nav-link" href="">CUENTAS</a>
                </li>
                <li class="nav-item mr-2">
                    <a class="nav-link" href=>MIS DATOS</a>
                </li>
                <li class="nav-item mr-2">
                    <a class="nav-link" href="">TRANSFERENCIAS</a>
                </li>
            </ul>
            <ul id="menuEmpleado" class="navbar-nav d-none">
                <li class="nav-item dropdown mr-2">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">ACCIONES</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="">CLIENTES</a>
                        <a class="dropdown-item" href="">CUENTAS</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline ms-auto me-5">
            	<label class="text-white mx-4">�Hola El�as! </label>
                <button class="btn btn-primary my-2 my-sm-0" type="submit">LOGOUT</button>
            </form>
        </div>
    </nav>