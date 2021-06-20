<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
	
<%-- <jsp:include page="estilos.jsp"></jsp:include> --%>

</head>
<body>
<%-- 	<jsp:include page="myNavbar.jsp"></jsp:include> --%>
	<div class="container mt-4">
		<h1>Bienvenido Salame</h1>
	</div>
	
<!-- <form action="login.html" method="get"> -->
	<form action="altaCliente.html" method="get">
		<input type="submit" value="Redireccionar a login" name="btnIrLogin">
	</form>
</body>
</html>