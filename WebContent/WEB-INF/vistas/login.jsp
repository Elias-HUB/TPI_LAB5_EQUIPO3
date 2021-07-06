<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar sesión</title>
<jsp:include page="estilos.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/login.css" />
</head>

<body>
	<form action="inicioSessionUsuario.html" method="post">
		<div class="wrapper mt-5">
			<div id="formContent">
				<%-- <input type="image" src="${pageContext.request.contextPath}/resources/images/dni1.jpeg" alt="">
                        --%>
				<h1 class="mr-4">
					<i class="bi bi-bank"></i> Banco
				</h1>
				<!-- Login -->
				<div class="mb-3 px-3">
					<input type="text" name="user" id="user" class="form-control mt-3"
						placeholder="Usuario" required> <input type="password"
						name="pass" id="pass" class="form-control mt-3" autocomplete="off"
						placeholder="Contraseña" required>
				</div>
				<button class="btn btn-primary mb-3">Iniciar Sesión</button>
			</div>
		</div>
	</form>
	<jsp:include page="myFooter.jsp"></jsp:include>

	<script
		src="${pageContext.request.contextPath}/resources/Js/Funciones.js"></script>
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