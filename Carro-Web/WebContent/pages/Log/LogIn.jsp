<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page info="Jsp que maneja el inicio de sesion de los usuarios" %>


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
			<h1 id="title">Bienvenido</h1>
		</header>
	</div>

<div id="main" class="wrapper">

		<article>
	
	<form  method="post" action="../../Verificador">
	
		<label for="usuario">Nombre de Usuario: </label> 
		<input type="text" name="usuario" required placeholder="Nombre de Usuario" />
		
		<label for="password">Password: </label> 
		<input type="password" name="password" required placeholder="Password" />
		
		<input type="submit" value="Ok!" />
		<input type="reset" value="Reiniciar" />
	</form>
	
</article>
</div>
</body>
</html>