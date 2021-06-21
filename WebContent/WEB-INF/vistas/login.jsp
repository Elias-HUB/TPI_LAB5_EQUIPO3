<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Iniciar sesión</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" />
    </head>

    <body>
        <form action="inicioSessionUsuario.html" method="get">
            <div class="wrapper mt-5">
                <div id="formContent">
<%--                     <input type="image" src="${pageContext.request.contextPath}/resources/images/dni1.jpeg" alt=""> --%>
                    <h1 class="mr-4"><i class="bi bi-bank"></i> Banco</h1>
                    <!-- Login -->
                    <div class="mb-3 px-3">
                        <input type="text" class="form-control mt-3" placeholder="Usuario" required>
                        <input type="password" class="form-control mt-3" autocomplete="off" placeholder="Contraseña"
                            required>
                    </div>
                    <button class="btn btn-primary mb-3">Iniciar Sesión</button>
                </div>
            </div>
        </form>
        <jsp:include page="myFooter.jsp"></jsp:include>
    </body>

    </html>