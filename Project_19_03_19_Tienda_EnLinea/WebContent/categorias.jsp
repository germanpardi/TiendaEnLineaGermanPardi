<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="ISO-8859-1">
<title>Categorias en GerTECH :) </title>
</head>


<style>
    .link { color: #FF0000; } /* CSS link color */
  </style>
</head>
<body>
  <!-- Bootstrap CSS -->
  <div class= "container">
 <h2>Buenos días ${id_usuario}, gracias por comprar en GerTECH :)</h2>
 
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css">
<%@page import= "beans.Categoria" %>
<%@page import= "java.util.Vector" %>
		
<% 	Vector<Categoria> listado_categorias=(Vector)session.getAttribute("listado_categorias");%>
 <table class="table table-striped">
	
  	<thead>
  	<tr>
<c:forEach var="c" items="${listado_categorias}">
	
	 <td><h2><a  href="S_categorias?descripcion=${c.getDescripcion()}">${c.descripcion}</a></h2></td>
	 
	</tr>
</c:forEach>	
</thead>
</table>
</div>	

</body>
</html>