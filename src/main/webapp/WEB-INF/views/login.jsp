<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/login" var="action"></c:url>
<c:if test="${param.error!=null}">
	<div class="alert alert-danger">Loi dang nhap</div>
</c:if>
<c:if test="${param.accessDenied!=null}">
	<div class="alert alert-danger">Khong co quyen truy cap</div>
</c:if>

<h1 class="text-center text-danger">DANG NHAP</h1>
<form action="${action}" method="post">
	<div class="form-group">
		<label>Username</label> <input type="text" name="username" />
	</div>
	<div class="form-group">
		<label>Password</label> <input type="text" name="password" />
	</div>
	<div class="form-group">
		<input type="submit" value="LOGIN" />
	</div>




</form>