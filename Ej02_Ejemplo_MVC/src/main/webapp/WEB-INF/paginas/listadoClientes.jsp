<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"        prefix="c"%>	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
	
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Clientes</title>
	
	<!-- Podemos utilizar un CDN -->
	<!-- 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
	-->
	
	<!-- O tener nuestros los recursos alojados en nuestro servidor -->
	<link rel="stylesheet" href="../recursos/css/bootstrap.min.css">
	
</head>
<body>

	<div class="text-center page-header">
	    <h2 class="mt-4 mb-4">Aplicación de gestion de clientes ClientGest 3000</h2>
	</div>  
	
	<div class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <ul class="navbar-nav">
	        <li class="nav-item active">
	            <a class="nav-link" href="#">Clientes</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Facturas</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Empleados</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Salir</a>
	        </li>
	    </ul>
	</div> 	
	
	<div class="text-center mt-4 mb-4">
		<h2>Listado de clientes</h2>
	</div>
	
	<div class="text-center mt-4 mb-4">
		<form method="get" action="formularioClientes">
			<input type="submit" class="btn btn-primary" value="Nuevo"/> 
		</form>
	</div>	
	
	<div class="row">
	    <div class="col-sm-12 offset-sm-0 col-md-8 offset-md-2">
	        
			<table class="table table-hover table-striped">    
			    <thead>
			        <tr>
			            <th>Nombre</th>
			            <th>Dirección</th>
			            <th>Teléfono</th>
			            <th>Correo E.</th>
			            <th>Activo</th>
			        </tr>
			    </thead>
			    <tbody>
					<c:forEach items="${listaClientes}" var="cli">
						<tr>
							<td>
								<c:url var="url" value="seleccionarCliente">
									<c:param name="idCliente" value="${cli.id}"/>
								</c:url>					
								<a href="${url}">${cli.nombre}</a>							
							</td>
							<td>${cli.direccion}</td>
							<td>${cli.telefono}</td>
							<td>${cli.correoE}</td>
							<td>${cli.activo}</td>						
						</tr>					
					</c:forEach>			    
			    </tbody>
			</table> 
	        
	    </div>
	</div>	

</body>
</html>