<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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

<div class="container">
<th><h2>Mi carrito</h2></th>
<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h2>Descripcion</h2></th>
      <th><h2>Precio</h2></th> 
   
      <th><h2>Cantidad</h2></th>
      
      <th><h2>Total</h2></th>
      
   </tr>
   
	<c:forEach var="p" items="${listado_productos_añadidos}">
	<tr>
	 
	  <td><h3>${p.descripcion}</h3></td>
	  <td><h3>${p.precio}</h3></td>
	   
	  <td><h3>${p.cantidad}</h3></td>
	 
	  <td><h3>${p.precio*p.cantidad}</h3></td>
	  
	
	  <c:set var="tot" scope ="request" value="${tot+p.precio*p.cantidad }"/>
	  <td><a href="S_eliminardelcarrito?id_producto=${p.getId_producto()}&cantidad=${p.cantidad}">QUITAR</a></td>
	
	
	
	
	</tr>
	</c:forEach>
	
	<tr>
	
	<th><h2>Total Compra</h2></th>
	<td><h3>${tot}</h3></td>
	</tr>	
	</thead>
	
	</table>
	<br>
	
	<form class="form-signin" id="comprar" name="comprar" method="post"
		action="S_comprar">
		<input class="btn btn-lg btn-primary btn-block" type="submit" name="comprar"
			value="PAGAR"<a href="S_eliminardelcarrito?id_producto=${p.getId_producto()}&cantidad=${p.cantidad}&stock=${p.getStock}"></a>>
	</form>
	<a href="categorias.jsp">SEGUIR COMPRANDO</a><br>

	</div>
</body>
</html>