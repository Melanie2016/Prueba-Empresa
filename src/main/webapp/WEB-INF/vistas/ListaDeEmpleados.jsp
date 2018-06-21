<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">VET Center <span class="glyphicon glyphicon-heart"style="color:orange"></span> </a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#">Perfil</a></li>
      <li><a href="#">Turnos</a></li>
      <li><a href="#">Peluquerias</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
    </ul>
		</div>
	</nav>
	<div class="container">
		<h1>Reserve su turno con solo un click</h1>

		<div class="form-group">
		
			<label for="sel1">Seleccione nombre del veterinario:</label> 
			<select	class="form-control" id="sel1">
				<option>Seleccione un especialista</option>
				<c:forEach items="${empleado}" var="empleado">
					<option>${empleado.nombre}</option>
				</c:forEach>
			</select>
			
		</div>

		<button class="btn btn-lg btn-primary btn-block btn-warning"
			Type="Submit" />
		Buscar Turnos
		</button>
		
		
		
	</div>
	<!-- Placed at the end of the do"src/main/webapp/WEB-INF/vistas/login.jsp"cument so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>