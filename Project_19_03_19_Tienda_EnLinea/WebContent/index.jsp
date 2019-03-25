<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login GerTECH</title>
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


	<% Date fechaActual = new java.util.Date(); %>

	<form class="form-signin" id="registro" name="registro" method="post"
		action="S_index">
		
		<%!int contadordevisitas=0; %>
		<h3>Ha visitado esta página: <%=++contadordevisitas %></h3>
		<h3>Madrid  <%= fechaActual.toString() %></h3>
		<%Cookie[] cookies = request.getCookies();
		 
		  String  aux1="";
		  String aux2="";
		  
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("usuario")){
					aux1=cookies[i].getValue();
				}
				if(cookies[i].getName().equals("password")){
					aux2=cookies[i].getValue();
				}
				
				 
			}%>
		
		Usuario: <input type="text" class="form-control" placeholder="user"
			name="id_usuario" id="id_usuario" value ="<%=aux1%>"/><br> 
		Password: <input type="password"
			class="form-control" placeholder="password" name="password"
			id="password" value = "<%=aux2%>" /><br> 
		<div class="checkbox">
			<label><input type="checkbox" name="recordar" value="recordar">Recordar usuario y password</label>
		</div>
			<input class="btn btn-lg btn-primary btn-block" type="submit" name="acceder"
			value="ACCEDER"> 
			<input class="btn btn-lg btn-primary btn-block" type="reset" name="reset"
			value="RESET">
			<h6><a href="registrarse.jsp">Registrarse</a></h6><br>
			<h6>${mensaje}</h6>
			
	</form>
		
</body>
</html>