<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 class="text-center">CART</h2>
	<c:if test="${carts==null}">
		<h5>Khong co san pham trong gio</h5>
	</c:if>

	<c:if test="${carts!=null}">
		<table class="table">
			<tr>
				<th>Ma san pham</th>
				<th>Ten san pham</th>
				<th>Don gia</th>
				<th>So luong</th>

			</tr>
			<c:forEach items="${carts}" var="c">
				<tr id="product${c.productId}">
					<td>${c.productId}</td>
					<td>${c.productName}</td>
					<td>${c.price}</td>
					<td>
						<div class="form-group">
							<input type="number"
								onblur="updateQuanlity(this.value, ${c.productId})"
								value="${c.quanlity}" class="form-control">
						</div>
					</td>
					<td><input type="button"
						onclick="deleteCartItem(${c.productId})" value="Del"
						class="btn btn-danger"></td>

				</tr>
			</c:forEach>
		</table>
		<div>
		<h5>Tong tien hoa don: <span id="amountCart">${cartStats.amount}VND</span></h5>
		</div>
		<input type="button" value="Thanh toan" onclick="pay()" class="btn btn-success">

	</c:if>
</body>
</html>