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
		<h1>New Product</h1>
		<form:form method="post" action="/products" modelAttribute="product">
			<form:label path="name">Name:</form:label>
			<form:input path="name"/>
			<form:label path="description">Description:</form:label>
			<form:textarea path="description"/>
			<form:label path="price">Price:</form:label>
			<form:input path="price"/>
			<button type="submit">Create</button>
		</form:form>
		
		<!--BOOTSTRAP-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>