<%-- 
    Document   : shoppingCart
    Created on : Nov 23, 2016, 4:00:52 AM
    Author     : shukyan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<!--       per  href="<c:url value="cart?prodId=${product.prodId}&quantity=1"/>">Add
						To Cart</a>-->
    </head>
    
	<table border="1">
		<thead>
			<tr>
				<th>Quantity</th>
				<th>Description</th>
				<th>Price</th>
				<th>Amount</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${order.items}" var="li">
				<tr>
					<form action="<c:url value="/cart"/>" method="GET">
						<td><input type="text" name="quantity" value="${li.quantity}" />
							<input type="hidden" name="prodId" value="${li.product.prodId}" />
							<br> <input type="submit" value="Update"></td>
					</form>
					<td>123</td>
					<td>${li.product.currency}</td>
					<td>${li.currency}</td>

					<form action="<c:url value="/cart"/>" method="POST" />
					<td><input type="submit" value="Remove Item" /> <input
						type="hidden" name="prodId" value="${li.product.prodId}" /> <input
						type="hidden" name="quantity" value="0" /></td>
					</form>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3"><b>To change the quantity</b>, enter the new
					quantity and click on the Update button.</td>
				<td colspan="2"></td>
			</tr>
		</tbody>
	</table>

	<form action="<c:url value="/index.jsp"/>" method="GET">
		<input type="submit" value="Continue Shopping" />
	</form>
</html>
