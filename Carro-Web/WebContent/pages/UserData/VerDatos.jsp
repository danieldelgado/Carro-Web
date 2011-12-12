<%@ 
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import= "beans.Usuario"
	import= "web.Datos"
%>

<%
   session = request.getSession();
   String user = session.getAttribute("user").toString(); 
   String ver = "<li><a href='../../fakeindex.jsp'>Volver al inicio</a></li>";
   String resul = "";
   Datos data = new Datos();
   beans.Usuario ObjUsuario = data.consigueDatosUsuario(user);
   String credito = Float.valueOf(ObjUsuario.getCredito()).toString();
   
%>
<%
 if(ObjUsuario.getAdmin()){
	 resul = "<li> Eres administrador </li>";
 }
 if((user == null )){
   user = "Invitado";
} %>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title> Datos de el cliente</title>
	<link rel="stylesheet" href="../../css/estiloFormulario.css">

</head>
<body>

	<div id="header-container">
		<header class="wrapper">
			<h1 id="title">Datos</h1>
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
				<h2>Datos de el usuario</h2>
			</header>
			<p/>
			Estos son tus datos:<br/>
			<br/>
			
			<ul>
				<li>Username: <%=ObjUsuario.getUser() %></li>
				<li>Nombre:  <%=ObjUsuario.getNombre() %></li>
				<li>Apellido Paterno:  <%=ObjUsuario.getApellidoPaterno() %></li>
				<li>Apellido Materno:  <%=ObjUsuario.getApellidoMaterno() %></li>
				<li>Edad:  <%=ObjUsuario.getEdad() %></li>
				<li>Correo: <%=ObjUsuario.getCorreo() %></li>
				<li>Telefono: <%=ObjUsuario.getTelefono() %></li>	
				<li>Credito Disponible: <%=credito %></li>
				<% out.print(resul); %>
			</ul>
			<h4>Direccion: </h4>
			<address>
				Calle: <%=ObjUsuario.getCalle() %><br/>	
				Colonia: <%=ObjUsuario.getColonia() %><br/>	
				Numero: <%=ObjUsuario.getNumero() %><br/>	
				Codigo Postal: <%=ObjUsuario.getCp() %><br/>	
			</address>
	<br/><br/><br/>
		</article>
	</div>
	
</body>
</html>