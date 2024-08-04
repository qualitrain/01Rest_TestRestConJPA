<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Post</title>
</head>
<body>
	<h3>Alta Armadora</h3>
	<form action="./webapi/armadoras" method="post" accept-charset="UTF-8">
		<label for="idclave">clave:</label>
		<input type="text" name="clave" id="idclave"><br>
		<label for="idnombre">nombre:</label>
		<input type="text" name="nombre" id="idnombre"><br>
		<label for="idpais">pais:</label>
		<input type="text" name=pais id="idpais"><br>
		<label for="idnPlantas">n&uacute;mero de plantas:</label>
		<input type="text" name="nplantas" id="idnPlantas"><br>
		<input type="submit" value="enviar">
	</form>
</body>
</html>