<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page session="true" %>
<jsp:useBean id="beanUser" class="beans.Usuario" scope="page"/>
<%
	String user = session.getAttribute("user").toString(); 
	String ver = "<li><a href='../../fakeindex.jsp'>Volver al inicio</a></li>";
	String resul = "";
	beanUser = (beans.Usuario)beanUser.llenaDatos(session.getAttribute("bean"));
	 if((user == null )){
	  	   user = "Invitado";
	  	 } 
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="chrome=1" />
 <style>
 <jsp:include page="../../css/estiloFormulario.css"/>
 </style>
	</head>
	<body>
	<div id="header-container">
		<header class="wrapper">
			<h1 id="title">Registro</h1>
			<nav>
				<ul>
					<li> <a>Hola, <%= user %></a></li>
					<% out.print(ver); %>
				</ul>
			</nav>
		</header>
	</div>
	<div id="main" class="wrapper">
	  <article>
			<header>
		<h3>Porfavor ingrese los siguientes datos</h3>
			</header>
		
		
<form  action="./envioDatos.jsp" method="post"> 
	
		<label for="usuario">Nombre de Usuario: </label> 
		<input type="text" name="usuario" required placeholder="Nombre de Usuario" value="<jsp:getProperty name="beanUser" property="user" />"/>
		
		<label for="password">Password: </label> 
		<input type="password" name="password" required placeholder="Password" value="<jsp:getProperty name="beanUser" property="password" />"/>
		
		<label for="nombre">Nombre: </label> 
		<input type="text" name="nombre" required placeholder="Nombre" value="<jsp:getProperty name="beanUser" property="nombre" />"/>
		
		<label for="apellidoPaterno">Apellido Paterno: </label> 
		<input type="text" name="apellidoPaterno" required placeholder="Apellido Paterno" value="<jsp:getProperty name="beanUser" property="apellidoPaterno" />"/>
		
		<label for="apellidoMaterno">Apellido Materno: </label> 
		<input type="text" name="apellidoMaterno" required placeholder="Apellido Materno" value="<jsp:getProperty name="beanUser" property="apellidoMaterno" />"/>
		
		<label for="edad">Edad: </label> 
		<input type="number" name="edad" required placeholder="Edad" value="<jsp:getProperty name="beanUser" property="edad" />"/>
		
		<label for="email">Email:</label> 
		<input type="email" name="correo" required placeholder="email@example.com" value="<jsp:getProperty name="beanUser" property="correo" />"/>
		
		<label for="telefono">Telefono:</label> 
		<input type="text" name="telefono" required placeholder="18723059" value="<jsp:getProperty name="beanUser" property="telefono" />"/>
		
		<label for="direccion">Direccion: </label>
		
		<label for="calle">Calle:</label> 
		<input type="text" name="calle" required placeholder="Calle donde reside" value="<jsp:getProperty name="beanUser" property="calle" />"/>
		
		<label for="colonia">Colonia:</label> 
		<input type="text" name="colonia" required placeholder="Colonia" value="<jsp:getProperty name="beanUser" property="colonia" />" />
		
		<label for="cp">Codigo Postal:</label> 
		<input type="text" name="cp" required placeholder="" value="<jsp:getProperty name="beanUser" property="cp" />"/>
		
		<label for="numero">Numero:</label> 
		<input type="text" name="numero" required placeholder="#123" value="<jsp:getProperty name="beanUser" property="numero" />"/>
		
		<label for="credito">Credito inicial:</label> 
		<input type="number" name="credito" required placeholder="500" value="<jsp:getProperty name="beanUser" property="credito" />"/>
	
		<label for="permiso">Nombrar Admin?</label>
		<input type="checkbox" name="admin" value="true" value="<jsp:getProperty name="beanUser" property="admin" />"/>
	
		<input type="submit" value="Continuar" />
		<input type="reset" value="Reiniciar" />	
</form>

		</article>
	</div>
	</body>
</html>
