<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <nav class="navbar navbar-expand-lg bg-primary navbar-dark ">
        <a class="navbar-brand mr-4 ml-4" href="index.html"><i class="bi bi-server"></i> BANCO TU VIEJA</a>

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
            <form class="form-inline ms-auto mr-4">
                <button class="btn btn-primary mr-3 my-2 my-sm-0" type="submit">LOGOUT</button>
            </form>
        </div>
    </nav>