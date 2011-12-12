<%@ 
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import= "beans.ArticuloGadget"
	import= "beans.Articulo"
	import= "web.Datos"
	import= "java.util.List"
	import= "java.util.ArrayList"
	import= "web.CarroWeb"
%>

<%
   session = request.getSession();
   Boolean  buy = false;
   String user = session.getAttribute("user").toString(); 
   CarroWeb carro = (CarroWeb)session.getAttribute("carro");
   List<Articulo> ListadoArticulos = new ArrayList<Articulo>();
   List<ArticuloGadget> ListadoGadgets = new ArrayList<ArticuloGadget>();
   ListadoArticulos = carro.getListadoLibros();
   ListadoGadgets = carro.getListadoGadgets();
   String ver = "<li><a href='../../fakeindex.jsp'>inicio</a></li>";
   String botonRemover = "<button type=\"submit\"  > Remover del carro </button>";
   String gracias="";
   String volverL = "<li><a href='../Articulos/Libros.jsp' >Libros</a></li>";
   String volverG = "<li><a href='../Articulos/Gadgets.jsp' >Gadgets</a></li>";
   
   try{
   buy = Boolean.parseBoolean(session.getAttribute("buy").toString());
   }catch(Exception e){
	   buy = false;
   }
   if(buy){
	   gracias = "Gracias por su compra :D";
   }
%>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title> Carro De Compras Web </title>
	<link rel="stylesheet" href="../../css/estiloFormulario.css">

</head>
<body>

	<div id="header-container">
		<header class="wrapper">
			<h1 id="title">Carro De Compras</h1>
			<nav>
				<ul>
					<li> <a>Hola, <%= user %></a></li>
					<%= ver %>
					<%= volverL %>
					<%= volverG %>
				</ul>
			</nav>
		</header>
	</div>
	
	<div id="main" class="wrapper">
		<aside>
			<h3>Es Todo?</h3>
			<p>
			  Para terminar su compra<br/>presione este boton.
			</p>
			<%
			out.print("<form method=\"post\" action=\"../../CarroWebServlet\">");
			out.print("<input type=\"hidden\" name=\"accion\"  value=\"completar\" />");
			out.print("<button type=\"submit\"  > Completar compra </button>");
			out.print("</form>");
			out.print(gracias);
			%>
		</aside>
		<article>
			<header>
				<h2>Carro de compras web</h2>
			</header>
			<p/>
			Este es el contenido de tu carro de compras web:<br/>
			<br/>
			<%
			out.print("El precio total de estos articulos es: $"+ carro.getTotal());
			out.print("<form method=\"post\" action=\"../../CarroWebServlet\">");
			out.print("<input type=\"hidden\" name=\"accion\"  value=\"removerTodo\" />");
			out.print("<button type=\"submit\"  > Remover todo del carro </button>");
			out.print("</form>");
			
			for(ArticuloGadget item : ListadoGadgets){
				out.print("<form method=\"post\" action=\"../../CarroWebServlet\">");
				out.print("<li>");
				 out.print("Nombre: "+item.getNombre());
				 out.print("<br/>");
				 out.print("Precio: "+item.getPrecio());
				 out.print("<br/>");
				 out.print("Estado: "+item.getEstado());
				 out.print("<br/>");
				 out.print("Comentarios: "+item.getComentario());
				 out.print("<input type=\"hidden\" name=\"accion\"  value=\"remover\" />");
				 out.print("<input type=\"hidden\" name=\"tipo\"  value=\"gadget\" />");
				 out.print("<input type=\"hidden\" name=\"nombre\"  value=\""+item.getNombre()+"\" />");
				 out.print("<input type=\"hidden\" name=\"precio\" value=\""+item.getPrecio()+"\" />");
				 out.print("<input type=\"hidden\" name=\"estado\" value=\""+item.getEstado()+"\" />");
				 out.print("<input type=\"hidden\" name=\"comentario\" value=\""+item.getComentario()+"\" />");
				out.print("</li>");
				out.print("<br/>");
				out.print(botonRemover);
				out.print("</form>");
			}
				
			for(Articulo item : ListadoArticulos){
				out.print("<form method=\"post\" action=\"../../CarroWebServlet\">");
				out.print("<li>");
				 out.print("Nombre: "+item.getNombre());
				 out.print("<br/>");
				 out.print("Autor: "+item.getAutor());
				 out.print("<br/>");
				 out.print("Precio: "+item.getPrecio());
				 out.print("<br/>");
				 out.print("Estado: "+item.getEstado());
				 out.print("<input type=\"hidden\" name=\"accion\"  value=\"remover\" />");
				 out.print("<input type=\"hidden\" name=\"tipo\"  value=\"libro\" />");
				 out.print("<input type=\"hidden\" name=\"nombre\"  value=\""+item.getNombre()+"\" />");
				 out.print("<input type=\"hidden\" name=\"autor\" value=\""+item.getAutor()+"\" />");
				 out.print("<input type=\"hidden\" name=\"precio\" value=\""+item.getPrecio()+"\" />");
				 out.print("<input type=\"hidden\" name=\"estado\" value=\""+item.getEstado()+"\" />");
				out.print("</li>");
				out.print("<br/>");
				out.print(botonRemover);
				out.print("</form>");
			}
			%>
			<br/><br/><br/>
		</article>
	</div>
	
</body>
</html>