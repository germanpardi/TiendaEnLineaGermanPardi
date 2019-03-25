<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="ISO-8859-1">
<title>Registro GerTECH</title>
</head>
<body>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css">
	<%@page import = "java.util.Date" %>
<body >


	

	<form class="form-signin" id="registro" name="registro" method="post"
		action="S_registro">
		
		
		
		
		Nombre de usuario: <input type="text" class="form-control" placeholder="nombre"
			name="id_usuario" id="id_usuario"  /><br> 
		Contraseña: <input type="password"
			class="form-control" placeholder="contraseña" name="password"
			id="password" /><br> 
		Email: <input type="text"
			class="form-control" placeholder="email" name="email"
			id="email" /><br> 
			<input
			class="btn btn-lg btn-primary btn-block" type="submit" name="crear"
			value="CREAR"> 
			<input class="btn btn-lg btn-primary btn-block" type="reset" name="reset"
			value="RESET">
			<h6>${errores}</h6>
		
</body>
</html>