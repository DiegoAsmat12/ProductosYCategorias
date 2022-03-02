<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> <!--Unicamente para update-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!--BOOTSTRAP-->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/styles.css">
	</head>
	<body>
		<h1><c:out value="${category.getName()}"></c:out></h1>
		<ul>
			<c:forEach var="product" items="${category.getProducts()}">
				<c:out value="${product.getName()}"></c:out>
			</c:forEach>
		</ul>
		
		<c:if test="${productos.size()>0}">
			<form:form method="post" action="/relacionar">
				<input type="hidden" name="category_id" value="${category.getId()}">
				<label>Add product:</label>
				<select name="product_id">
					<c:forEach var="product" items="${productos}">
						<option value="${product.getId()}"><c:out value="${product.getName()}"></c:out></option>
					</c:forEach>
				</select>
				<button type="submit">Agregar</button>
			</form:form>
		</c:if>
		
		<!--BOOTSTRAP-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>