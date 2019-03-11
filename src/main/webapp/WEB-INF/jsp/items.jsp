<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>${msg}</div>
<table style="width: 50%">
	<head>
<style>
table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

th, td {
	text-align: center;
}
</style>
	</head>
	<div class="container">
		
		<a class="button" href="/products/${productId}/item"> Add Item</a>

		<c:choose>
			<c:when test="${empty items}">
        No Items found!
    </c:when>
			<c:otherwise>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Product ID</th>
				</tr>
				<c:forEach begin="0" end="${fn:length(items) - 1}" var="index">
					<br />
					<tr>
						<td><c:out value="${items[index].id}" /></td>
						<td><c:out value="${items[index].name}" /></td>
						<td><c:out value="${items[index].description}" /></td>
						<td><c:out value="${items[index].quantity}" /></td>
						<td><c:out value="${items[index].price}" /></td>
						<td><c:out value="${items[index].productId}" /></td>
						<td><a href="/items/<c:out value="${items[index].id}" />">edit</a></td>
						<td><a href="/items/delete/<c:out value="${items[index].id}" />">delete	</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</table>