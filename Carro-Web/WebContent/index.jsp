<%@  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@  page session="true" %>
<% 
   String usuario = request.getParameter("user"); 
   Boolean admin = Boolean.parseBoolean(request.getParameter("admin")); 
   String log = "Log Out"; 
   String url = "./index.jsp";
   String urlLibros = "<a href=\"./pages/Articulos/Libros.jsp\" >";
   String urlGadgets = "<a href=\"./pages/Articulos/Gadgets.jsp\" >";
   String cierre = "</a>";
   String ver = "<li><a href='./pages/UserData/VerDatos.jsp'>Ver Datos</a></li>";
   String add = "";
   

if(admin){
   add = "<li><a href='./pages/Registro/Registro.jsp'>Agregar Usuario</a></li>";
}
 if((usuario == null )){
   usuario = "Invitado";
   log = "Log In";
   url = "./pages/Log/LogIn.jsp";
   ver = "";
   urlLibros = "";
   urlGadgets = "";
   cierre  = "";
} 
%>


<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<title> Programacion Orientada a Objetos</title>
	<meta name="WebShop" content="WebShop,JSP,JAVA">
	<meta name="Everblut" content="everblut.sytes.net">

	<meta name="viewport" content="width=device-width,initial-scale=1">

	<link rel="stylesheet" href="./css/style.css">

</head>
<body>
	<div id="header-container">
		<header class="wrapper">
			<h1 id="title">WebShop</h1>
			<nav>
				<ul>
					<li><a> Hola, <%= usuario %></a></li>
					<% out.print(ver); %>
					<% out.print(add); %>
					<li><a href="<%= url %>"><%= log %></a></li>
				</ul>
			</nav>
		</header>
	</div>
	
	<div id="main" class="wrapper">
		<aside>
			<h3>Version 1.0</h3>
		</aside>
		<article>
			<header>
				<h2>Bienvenido a la Webshop</h2>
				<p>Aqui encontraras la ayuda que necesites para utilizar esta pagina <a target="_blank" href="./pages/Faq/Faq.html">FAQ</a></p>
			</header>
				
			<h3>Zona de Libros</h3>
				<%= urlLibros %>
				<img align="left" src="./images/libros.gif" alt="Zona de libros :)" width="200" height="150"/>
				<%= cierre %>	
				<p align="center">Entra a la zona de libros y checa los ejemplares que tenemos!.
				De todas categorias y autores, no te arrepentiras.<br/><br/><br/><br/>
				</p>
	
			<h3>Zona de Gadgets</h3>
				<%= urlGadgets %>
			    <img align="left" src="./images/gadgets-icon.jpg" alt="Zona de gadgets :)" width="200" height="150"  />
			 	<%= cierre %>
			    <p align="center">Checa los gadgets que tenemos en venta  no pierdas la oportunidad de tener uno.
			    </p><br/><br/><br/><br/><br/><br/>


		</article>
	</div>
	
	<div id="footer-container">
		<footer class="wrapper">
			<h3>WebShop celebra el Buen Fin todos los dias!</h3>
		</footer>
	</div>
</body>
</html>
