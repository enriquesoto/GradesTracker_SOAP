<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style type="text/css">
<%@include file="css/style.css" %>
<c:set var="name" scope="session" value= request.getAttribute("name")}"/>  
</style>
<title>Sistema Académico</title>
</head>
<body>

<div id="wrapper">
	<div id="logo" class="container">
		<h1><a href="http://localhost:8080/GradesTrackerServlet/">SISTEMA ACADéMICO</a></h1>
	</div>
	<div id="menu-wrapper">
		<div id="menu" class="container">
			<ul>
					
<li><a href="http://localhost:8080/GradesTrackerServlet/">Home</a></li>
<li><a href="http://localhost:8080/GradesTrackerServlet/about.jsp"">Respecto al Software</a></li>
<li> 
<a href="http://localhost:8080/GradesTrackerServlet/notasParcialesAction.action?username=20080561" >Mis Notas</a>

</li>
<!-- <li><a href="/grades/home/about">Links</a></li> -->
<li><a href="http://localhost:8080/GradesTrackerServlet/contactanos.jsp">Contáctanos</a></li>
			</ul>
		</div>
	</div>
	<div id="page" class="container">
		<div id="content">
			<div class="post">
				<div></div>
				<h2 class="title">BIENVENIDO</h2>
				<div class="entry">
					holaa <i>${sessionScope.userName}</i>
			
				</div>
	</div>
	<!-- end #page --> 
	
</div>
<div id="footer">
	<p> © 2013 Escuela Profesional de Ingeniería de Sistemas Todos los derechos reservados. Design by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a>.  Photos by <a href="http://fotogrph.com/">Fotogrph</a>.</p></div>
<!-- end #footer -->

</div>
</body>
</html>