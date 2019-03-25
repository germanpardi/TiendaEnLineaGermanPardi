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
<h2>Tabla de productos</h2>
<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h2>Descripcion</h2></th>
      <th><h2>Precio</h2></th> 
      <th><h2>Stock</h2></th>
   </tr>
   
	<c:forEach var="pc" items="${listado_productos_categoria}"> 
	<tr>
	  <td><h3>${pc.descripcion}</h3></td>
	  <td><h3>${pc.precio}</h3></td>
	  <td><h3>${pc.stock}</h3></td>
	  <td><a href="S_addcarrito?id_producto=${pc.getId_producto()}&descripcion=${pc.getDescripcion()}&precio=${pc.getPrecio()}">AÑADIR AL CARRITO</a></td>
	</tr>
	</c:forEach>
	
	</table><br>
	<a href="carrito.jsp">VER CARRITO</a><br>
	
	<a href="categorias.jsp">IR A CATEGORIAS</a><br>
	</div>
</body>
</html>