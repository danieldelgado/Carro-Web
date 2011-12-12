<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page session="true" %>
<jsp:useBean id="beanUser2" class="beans.Usuario" scope="page"/>
<%

	String usr = session.getAttribute("user").toString(); 
	String ver = "<li><a href='../../fakeindex.jsp'>Volver al inicio</a></li>";
	String resul = "";
  	beanUser2 = (beans.Usuario)beanUser2.llenaDatos(request);  
  	session.setAttribute("bean",beanUser2);

  	 if((usr == null )){
  	   usr = "Invitado";
  	 } 
%>


<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title> Envio de datos</title>
	<link rel="stylesheet" href="../../css/estiloFormulario.css">
	
</head>
<body>
<div id="header-container">
		<header class="wrapper">
			<h1 id="title">Envio de Datos</h1>
			<nav>
				<ul>
					<li> <a>Hola, <%= usr %></a></li>
					<% out.print(ver); %>
				</ul>
			</nav>
		</header>
	</div>
	
	<div id="main" class="wrapper">
	<article>
			<header>
		<h3>Desea enviar estos datos? </h3>
			</header>


			<ul>
				<li>Username: <%= beanUser2.getUser()%></li>
				<li>Password: <%= beanUser2.getPassword()%></li>
				<li>Nombre: <%= beanUser2.getNombre()%></li>
				<li>Apellido Paterno:  <%= beanUser2.getApellidoPaterno()%></li>
				<li>Apellido Materno:  <%= beanUser2.getApellidoMaterno()%></li>
				<li>Edad:  <%= beanUser2.getEdad()%></li>
				<li>Correo: <%= beanUser2.getCorreo()%></li>
				<li>Telefono: <%= beanUser2.getTelefono()%></li>	
				<li>Credito Disponible: <%= beanUser2.getCredito()%></li>
				<li>Es admin: <%= beanUser2.getAdmin()%></li>
			</ul>
			<h4>Direccion: </h4>
			<address>
				Calle: <%= request.getParameter("calle")%><br/>	
				Colonia: <%= request.getParameter("colonia")%><br/>	
				Numero: <%= request.getParameter("numero")%><br/>	
				Codigo Postal: <%= request.getParameter("cp")%><br/>	
			</address>

	<input type="button" value="Volver" onclick = "location='./Registro.jsp'" />
	<input type="button" value="Enviar Datos" onclick = "location='../../Registro'"/>

		</article>
	</div>
</body>
</html>