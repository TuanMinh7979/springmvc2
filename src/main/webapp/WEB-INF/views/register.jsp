<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/register" var="action"></c:url>

<h1 class="text-center text-danger">DANG KY</h1>
<c:if test="${errMsg != null}">
	<div class="alert alert-danger">${errMsg}</div>
</c:if>
<form:form action="${action}" method="post" modelAttribute="user">
	<div class="form-group">
		<label>Username</label>
		<form:input type="text" id="username" path="username"
			cssClass="form-control" />
	</div>
	<div class="form-group">
		<label>Password</label>
		<form:input type="password" id="password" path="password"
			cssClass="form-control" />

	</div>
	<div class="form-group">
		<label>Confirm Password</label>
		<form:input type="password" id="password" path="confirmPassword"
			cssClass="form-control" />

	</div>
	<div class="form-group">
		<label>First name</label>
		<form:input type="text" id="firstname" path="firstName"
			cssClass="form-control" />

	</div>
	<div class="form-group">
		<label>Last name</label>
		<form:input type="text" id="lastname" path="lastName"
			cssClass="form-control" />
	</div>
	<div class="form-group">
		<label>Email</label>
		<form:input type="text" id="email" path="email"
			cssClass="form-control" />
	</div>
	<div class="form-group">
		<input type="submit" value="LOGIN" />
	</div>




</form:form>
