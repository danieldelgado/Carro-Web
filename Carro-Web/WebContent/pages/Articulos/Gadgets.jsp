<%@ 
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import= "beans.ArticuloGadget"
	import= "web.Datos"
	import= "java.util.List"
	import= "web.CarroWeb"
%>

<%
   session = request.getSession();
   String user = session.getAttribute("user").toString();
   CarroWeb carro = CarroWeb.getInstance();
   carro = (CarroWeb)session.getAttribute("carro");
   String ver = "<li><a href='../../fakeindex.jsp'>Volver al inicio</a></li>";
   String car = "<li><a href='../Carro/CarroWeb.jsp'>Ver Carrito</a></li>";
   Datos data = new Datos();
   List<ArticuloGadget> ListadoArticulos = data.consigueGadgets();
   String img = "<img src=\"../../images/carrito.gif\"/><br/>";
   String botonAgregar = "<button type=\"submit\"  >"+img+" Agregar al Carro </button>";
   
%>


<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title> Seccion Gadgets </title>
	<link rel="stylesheet" href="../../css/estiloFormulario.css">

</head>
<body>
<div id="header-container">
		<header class="wrapper">
			<h1 id="title">Gadgets</h1>
			<nav>
				<ul>
					<li> <a>Hola, <%= user %></a></li>
					<% out.print(ver); %>
					<% out.print(car); %>
				</ul>
			</nav>
		</header>
	</div>

<div id="main" class="wrapper">

		<article>
		<header>
				<h2>Estos Gadgets se encuentran disponibles</h2>
			</header>
			<p/>
			<br/>
			<ul>
			<%
				for(ArticuloGadget item : ListadoArticulos){
					out.print("<form method=\"post\" action=\"../../CarroWebServlet\">");
					out.print("<li>");
					 out.print("Nombre: "+item.getNombre());
					 out.print("<br/>");
					 out.print("Precio: "+item.getPrecio());
					 out.print("<br/>");
					 out.print("Estado: "+item.getEstado());
					 out.print("<br/>");
					 out.print("Comentarios: "+item.getComentario());
					 out.print("<input type=\"hidden\" name=\"accion\"  value=\"agregar\" />");
					 out.print("<input type=\"hidden\" name=\"tipo\"  value=\"gadget\" />");
					 out.print("<input type=\"hidden\" name=\"nombre\"  value=\""+item.getNombre()+"\" />");
					 out.print("<input type=\"hidden\" name=\"precio\" value=\""+item.getPrecio()+"\" />");
					 out.print("<input type=\"hidden\" name=\"estado\" value=\""+item.getEstado()+"\" />");
					 out.print("<input type=\"hidden\" name=\"comentario\" value=\""+item.getComentario()+"\" />");
					out.print("</li>");
					out.print("<br/>");
					out.print(botonAgregar);
					out.print("</form>");
				}
				
			%>
			</ul>
			<br/><br/>
		</article>

</div>
</body>
</html>