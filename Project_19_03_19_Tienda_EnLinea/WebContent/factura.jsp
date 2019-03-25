<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="ISO-8859-1">
<title>Productos en GerTECH :)</title>
</head>
<body>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css">
<%@page import= "beans.Categoria" %>
<%@page import= "java.util.Vector" %>
<%@page import= "beans.Producto" %>
<%@page import= "beans.Producto_Cantidad" %>
<%Producto_Cantidad pc = new Producto_Cantidad();%>
<div class="container">
<h2>He aquí tu factura ${id_usuario}</h2>
<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h2>Numero de Factura</h2></th>
      <th><h2>Usuario</h2></th> 
      
	  <td><h3>${id_factura}</h3></td>	
	  <td><h3>${id_usuario}</h3></td>
	 </tr> 
      
   
   
	<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h2>Numero de Factura</h2></th>
      <th><h2>Posición</h2></th> 
      <th><h2>Descripción</h2></th>
      <th><h2>Precio</h2></th>
      <th><h2>Cantidad</h2></th>
   </tr>
   
	<c:forEach var="pf" items="${posiciones_factura}"> 
	<tr>
	  <td><h3>${pf.id_factura}</h3></td>	
	  <td><h3>${pf.pos_factura}</h3></td>
	 </tr> 
	  <c:forEach var="pc" items="${listado_productos_categoria}"> 
	<tr>
	  <td><h3>${pc.descripcion}</h3></td>
	  <td><h3>${pc.precio}</h3></td>
	</tr>  
	</c:forEach>
	<tr>
	  <td><h3>${pf.cantidad}</h3></td>
	  
	</tr>
	</c:forEach>
	
	
	</table><br>
	<a href="carrito.jsp">VER CARRITO</a><br>
	
	<a href="categorias.jsp">IR A CATEGORIAS</a><br>
	</div>
</body>
</html>